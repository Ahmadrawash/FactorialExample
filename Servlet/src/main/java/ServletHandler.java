import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletHandler extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("done");
        resp.getWriter().print("done");
        resp.setStatus(202);
        resp.getWriter().print("Pong (TestResponse): Got response!");
        System.out.println("executing doGet of PingServlet (TestResponse)");

    }

}
