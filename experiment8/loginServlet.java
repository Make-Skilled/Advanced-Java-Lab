import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class loginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        if (pass.equals("admin123")) {
            // --- 1. Cookie based
            Cookie ck = new Cookie("username", uname);
            response.addCookie(ck);

            // --- 2. HttpSession based
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);

            // --- 3. URL Rewriting
            response.sendRedirect("welcome.jsp?user=" + uname);
        } else {
            out.println("Invalid credentials!");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }
}
