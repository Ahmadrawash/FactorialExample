import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//singleton model

class ConnectionManager {

    //private static String URL = "jdbc:mariadb://testingdb.cljn76gwtmyk.us-east-2.rds.amazonaws.com";
    //private static String username = "admin";
    //private static String password = "12345678";
    //private static int port = 3306;
    //private static String db = "testingdb";
    private static Connection connection = null;

    private ConnectionManager() {}


    public  static Connection GetConnection(String Path) throws IOException, SQLException {
        if (connection == null)
            connection = connect(Path);
        return connection;
    }

    private  static Connection connect(String Path) throws IOException, SQLException {
        /*
        jdbc:mariadb://<hostname>:<port>/<databaseName>?user=<username>&password=<password>
        This is the string we need to use to connect to our database. We will build this string with each of the
        variables filled out and qualified.
         */

        Properties props = new Properties();
        //System.out.println("working directory is: "+ System.getProperty("user.dir"));
        //System.out.println("full path is: \n" + System.getProperty("user.dir") + "\\src/main/resources/db.properties");
        //System.out.println("Properties File Path: " + Path);
        //System.out.println("Properties File exist: " + new File(Path).exists());

        //FileReader fr = new FileReader("src/main/resources/db.properties");
        //FileReader fr = new FileReader("src/main/resources/db.properties");
        //C:\Users\ahmed\IdeaProjects\JDBC\src\main\resources\db.properties
        FileReader fr = new FileReader(Path);;

        ClassLoader cl = ConnectionManager.class.getClassLoader();
        try (InputStream stream = cl.getResourceAsStream("db.properties")) {
            //BufferedInputStream bis = new BufferedInputStream(new FileInputStream("db.properties"));//worked before but later caused an exception
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Path));
            props.load(bis);
        }
        catch(Exception exc)
        {
            System.out.println("exc.getMessage()");
            exc.printStackTrace();
        }

        //props.load(fr); //doesn't work when exported as jar the properties file is not found

        String connectionString = "jdbc:mariadb://" + props.getProperty("hostname") + ":" +
                props.getProperty("port") + "/" +
                props.getProperty("dbname") + "?user=" +
                props.getProperty("username") + "&password=" +
                props.getProperty("password");

        System.out.println(connectionString);
        connection = DriverManager.getConnection(connectionString);

        return connection;
    }


}


// connStr = "jdbc:sqlite:C:\\Users\\ahmed\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";

