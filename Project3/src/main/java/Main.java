import ORM.MyJDBC;
import utils.FileLogger;

public class Main {
    static FileLogger FileLog;
    public static void main(String args[])
    {
        try
        {
            FileLog = FileLogger.getFileLogger();
            //MyJDBC.CreateTable();
            MyJDBC.AddUser("Kim","Kim", "111","Kim@revature.net");
            MyJDBC.AddUser("Sam","Sam", "111","Sam@revature.net");
            MyJDBC.AddUser("Roy","Roy", "222","Roy@revature.net");
            MyJDBC.UpdateUser(2, "Roy", "Roy", "0000", "Roy@gmail.com");
            MyJDBC.DeleteUser(3);
            System.out.println(MyJDBC.GetOneUser("2"));
            System.out.println(MyJDBC.GetAllUsers());
            System.out.println("done");
        }
        catch(Exception exc)
        {
            FileLog.log(exc);
        }
    }
}
