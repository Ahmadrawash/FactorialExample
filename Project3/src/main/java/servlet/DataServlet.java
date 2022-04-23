package servlet;


import DAOs.UsersDAO;
import ORM.MyJDBC;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.FileLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;



public class DataServlet extends HttpServlet {
     static FileLogger FLogger;

     public DataServlet()
     {
         System.out.println("Constructor of DataServlet");
         String filePath=  "C:\\Users\\ahmed\\IdeaProjects\\Project3\\Logs";
         File f = new File(filePath);
         try {
             if (!f.exists())
                 f.createNewFile();
             FLogger = FileLogger.getFileLogger(filePath);
         }
         catch (Exception e) {
             System.out.println("Exception: "+ e.getMessage());
             }
         }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoPost");

        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {

            //System.out.println("result: "+ MyJDBC.CreateTable());
            //if (10 == 10) return;

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = req.getInputStream();

        UsersDAO dao = mapper.readValue(req.getInputStream(), UsersDAO.class);
        System.out.println("attempting to add user ID:"  + dao.getID() + ",Firstname" + dao.getFirstName() + ", LastName: " + dao.getLastName() + ", password" + dao.getPassword() + ", email" + dao.getEmail());

        boolean result = MyJDBC.AddUser(dao.getFirstName(), dao.getLastName(),dao.getPassword(), dao.getEmail()); //create pojo
        if (result)
        {
            System.out.println("new user has been added to db and datastore. user info is as follows: " +
                    "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName() + ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());
            resp.getWriter().println("new user has been added to db and datastore. user info is as follows: " +
                    "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName() + ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());

            resp.setStatus(202);
         }
        else
        {
            System.out.println("new user has NOT been added. user info is as follows: " +
                    "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName() + ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());
            resp.getWriter().println("new user has NOT been added. user info is as follows: " +
                    "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName() + ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());

            resp.setStatus(202);
        }

        }
        catch (Exception exc)
        {
            System.out.println("Exception: " + exc.getMessage());
            LogToFile(exc);
        }
    }

    //update data
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoPut");
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = req.getInputStream();

        UsersDAO dao = mapper.readValue(req.getInputStream(), UsersDAO.class);
        System.out.println("attempting to update user ID:"  + dao.getID().intValue() + " ,FirstName: " + dao.getFirstName() + ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());

        try
        {

            boolean result = MyJDBC.UpdateUser(dao.getID(), dao.getFirstName(), dao.getLastName(), dao.getPassword(), dao.getEmail());
            if (result) {
                System.out.println("user has been udpated. user info is as follows: " +
                        "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName()+ ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());
                resp.getWriter().println("user has been udpated. user info is as follows: " +
                        "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName()+ ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());
            }
            else
            {
                System.out.println("couldn't udpate the  user. user info is as follows: " +
                        "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName()+ ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());
                resp.getWriter().println("couldn't udpated the  user. user info is as follows: " +
                        "    Id: " + dao.getID() + " FirstName: " + dao.getFirstName()+ ", LastName: " + dao.getLastName() + ", password: " + dao.getPassword() + ", email: " + dao.getEmail());
            }
            resp.setStatus(202);

        }
        catch (Exception exc)
        {
            System.out.println("Exception: " + exc.getMessage());
            LogToFile(exc);
        }

    }

    //delete data
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoDelete");
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = req.getInputStream();

        MyClass2<Integer> id = mapper.readValue(req.getInputStream(), MyClass2.class);

        try {

            boolean result = MyJDBC.DeleteUser(id.getValue());
            if (result){
                resp.getWriter().println("The following user with id: " + id.getValue() + " has been deleted from the database");
            }
            else
                resp.getWriter().println("unsuccessfully attempt to delete The following user with id: " +  id.getValue() );
            resp.setStatus(202);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            LogToFile(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoGet");
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = req.getInputStream();

        //******** MyJDBC ************
        try {
            MyClass2<Integer> id = mapper.readValue(req.getInputStream(), MyClass2.class);

            String userData = "";

            if (id.getValue() == 0) //get all users
            {
                userData = MyJDBC.GetAllUsers();
            }
            else
            {
                userData = MyJDBC.GetOneUser(id.getValue().toString());

            }
            resp.getWriter().println(userData);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            LogToFile(e);
        }
        resp.setStatus(202);
    }

    public String DisplayObjectAsJSON(UsersDAO u)
    {
        String JSON = "";
          try
          {
              if (u == null)
              {
                  System.out.println("objct is null. can't be displayed");
                  return "";
              }
              JSON = JSON + "{\n";
              JSON = JSON + "\t\"id\":" + u.getID().intValue() + ",\n\t\"first name\":\"" + u.getFirstName() + ",\n\t\"last name\":\"" + u.getLastName() + "\",\n\t\"password\":\"" + u.getPassword() + "\",\n\t\"email\":\"" + u.getEmail() + "\"\n";
              JSON = JSON + "  },\n";
          }
          catch (Exception Exc)
          {
              System.out.println("Exception: " + Exc);
              LogToFile(Exc);
          }
        return JSON;
    }

    public String DisplayAllAsJSON(List<UsersDAO> usersDAOList)
    {
        String JSON = "";

        try
        {
            JSON = JSON + "[\n";
            Iterator<UsersDAO> it = usersDAOList.iterator();
            while (it.hasNext())
            {
                UsersDAO u = it.next();
                JSON = JSON + "{\n";
                JSON = JSON + "\t\"id\":" + u.getID().intValue() + ",\n\t\"first name\":\"" + u.getFirstName() + ",\n\t\"last name\":\"" + u.getLastName() + "\",\n\t\"password\":\"" + u.getPassword() + "\",\n\t\"email\":\"" + u.getEmail() + "\"\n";
                JSON = JSON + "  },\n";
            }
            JSON = JSON + "]";


        }
        catch(Exception Exc)
        {
            System.out.println("Exception: " + Exc.getMessage());
            LogToFile(Exc);
        }
        return JSON;
    }

    public void LogToFile(Exception e)
    {
        try {
            if (e != null)
                FLogger.log(e);
        }
        catch(Exception exc2)
        {
            System.out.println("Exception while logging (LogToFile): " + exc2.getMessage());
            //exc2.printStackTrace();
        }
    }
}
