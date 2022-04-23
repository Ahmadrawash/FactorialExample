public class TestMain {
    public static void main(String ...args) {
        //Test below
        /*
        //Test out create function
        */

        //        Repository<TestClass> testClassRepository = new Repository<>(new TestClass());
        Repository<UsersDAO> testClassRepository = new Repository<UsersDAO>(new UsersDAO());

        for (Column c : testClassRepository.getTable().getColumns()) {
            System.out.println(c.getFieldName());
        }

        //Create TestClass object to attempt storing
        //TestClass testClass = new TestClass(1, "Brian");
        //UsersDAO user = new UsersDAO(0, "Sami", "Sami", "Sami@revature.net");

        //testClassRepository.create(user);

        UsersDAO user2 = new UsersDAO(25, "Danial Brian", "Danial", "Danial@revatue.net");

        testClassRepository.Update(user2);


    }
}
