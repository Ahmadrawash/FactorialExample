import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//persistence and jdbc layer

public class MyJDBC {

    private static Connection conn;
    private static String PropertiesPath = "src/main/resources/db.properties";
    private boolean initialized = false;
    private MyJDBC() {
    }
    public void SetPropertiesPath(String Path, boolean Safe)
    {
        if (Safe)
        {
            File F = new File(PropertiesPath);
            F = F.getAbsoluteFile(); //get absolute path of the properties file
            PropertiesPath = F.getAbsolutePath(); //assign it as the new properties file path
        }
        else
            PropertiesPath = Path;
    }



    public static String GetOneUser(String id) throws SQLException, Exception {
        InitializeConnect();
        String output ="";
        try {
            if (isNumber(id)) {
                {
                    try {
                        PreparedStatement stmt = null;
                        String SQL = "SELECT * FROM UsersAccounts WHERE Id = ?";
                        stmt = conn.prepareStatement(SQL);
                        stmt.setInt(1, Integer.parseInt(id));
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                            output += "{\n";
                            output += "\t\"id\":" + rs.getInt("ID") + ",\n" +
                                      "\t\"name\":\"" + rs.getString("Name") + "\",\n" +
                                      "\t\"password\":\"" + rs.getString("Password") + "\",\n" +
                                      "\t\"email\":\"" + rs.getString("Email") + "\"\n";
                            output += "  },\n";
                        }
                        else
                            System.out.println("no more rows to display");
                    } catch (SQLException exc) {
                        exc.printStackTrace();
                        throw new SQLException(exc.getMessage());
                    }
                }
            } else
                throw new Exception("exception: invalid input type. you must enter a number for Album Id");
        }
        catch(SQLException exc)
            {
                exc.printStackTrace();
                throw new SQLException(exc.getMessage());
            }
         catch (Exception exc2)
          {
            exc2.printStackTrace();
            throw new SQLException(exc2.getMessage());
          }
        System.out.println("User info is\n: " + output);
        return output;
        }

    private static boolean isNumber(String num)
    {
        return num.chars().anyMatch(Character::isDigit);
    }

   public static boolean AddUser(String Name, String Password, String Email) throws SQLException, Exception
   {
       InitializeConnect();

       try
       {
           String SQL = "INSERT INTO UsersAccounts(Name, Password, Email) VALUES (?, ?, ?)";
           PreparedStatement stmt = conn.prepareStatement(SQL);
           stmt.setString(1, Name);
           stmt.setString(2, Password);
           stmt.setString(3, Email);
           int result = stmt.executeUpdate();
           if (result >= 1)
           {
               System.out.println("record have added successfully to Users Table");
           }
           else
           {
               System.out.println("record haven't been added");
               return false;
           }
       }
       catch(Exception exc)
       {
           System.out.println("Exception: " + exc.getMessage());
           exc.printStackTrace();
           return false;
       }
       return true;
   }

   public static String GetAllUsers() throws SQLException, Exception
   {
       InitializeConnect();
       String output = "";
       try
       {
           String SQL = "SELECT * FROM UsersAccounts";
           PreparedStatement stmt = conn.prepareStatement(SQL);
           ResultSet rs  = stmt.executeQuery();
           output = "[\n";
           while (rs.next())
           {
               output += "  {\n";
               output += "\t\"id\":" + rs.getInt( "ID") + ",\n" +
                         "\t\"name\":\"" + rs.getString("Name") + "\",\n" +
                         "\t\"password\":\"" + rs.getString("Password") + "\",\n" +
                         "\t\"email\":\"" + rs.getString("Email") + "\"\n";
               output += "  },\n";
           }
           output += "]";
           System.out.println("All Users' info is\n: " + output);
       }
       catch(Exception exc)
       {
           System.out.println("Exception: " + exc.getMessage());
           exc.printStackTrace();
           return "Exception: " + exc.getMessage() + " no rows has been returned or another exception occurred" ;
       }
       return output;
   }

    public static boolean UpdateUser(int id, String Name, String Password, String Email) throws SQLException, Exception
    {
        InitializeConnect();

        try
        {
            String SQL = "UPDATE UsersAccounts SET Name = ?, Password = ?, Email = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1, Name);
            stmt.setString(2, Password);
            stmt.setString(3, Email);
            stmt.setInt(4, id);
            int rs  = stmt.executeUpdate();
            if (rs >= 1)
            {
                System.out.println("record have been updated successfully to Users Table");
                return true;
            }
            else
            {
                System.out.println("record haven't been updated");
                return false;
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception: " + exc.getMessage());
            exc.printStackTrace();
            return false;
        }
    }

    public static boolean DeleteUser(int id) throws SQLException, Exception
    {
        InitializeConnect();

        boolean returned = false;
        try
        {
            String SQL = "DELETE FROM UsersAccounts WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, id);
            int rs  = stmt.executeUpdate();
            if (rs >= 1)
            {
                System.out.println("record have been deleted successfully to Users Table");
                return  true;
            }
            else
            {
                System.out.println("record haven't been deleted");
                return false;
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception: " + exc.getMessage());
            exc.printStackTrace();
            return false;
        }
    }


    private  static void InitializeConnect() throws SQLException, IOException {
        try
        {
            File F = new File(PropertiesPath);
            F = F.getAbsoluteFile(); //get absolute path of the properties file
            PropertiesPath = F.getAbsolutePath(); //assign it as the new properties file path
            conn = ConnectionManager.GetConnection(PropertiesPath);

        }
        catch (Exception Exc)
        {
            System.out.println("Exception: " + Exc.getMessage());
            Exc.printStackTrace();
        }
    }




}
