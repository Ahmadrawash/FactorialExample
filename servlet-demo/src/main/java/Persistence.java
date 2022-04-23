public class Persistence {
    public static int counter =0;
    public static void Operation()
    {
        try {
            MyJDBC.DisplayData();
            MyJDBC.AddUser("User" + (counter++), "Password" + (counter), "Email@email.com");
            MyJDBC.Getuser(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
