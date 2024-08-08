package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/manageSession")
public class Question4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        if (username != null && !username.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            out.println("<html><body>");
            out.println("<h1>Session Set</h1>");
            out.println("<p>Username: " + username + " has been set in the session.</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>Username cannot be empty.</p>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html><body>");
        out.println("<h1>Session Information</h1>");

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<p>Username in session: " + username + "</p>");
        } else {
            out.println("<p>No session or username found.</p>");
        }

        out.println("</body></html>");
    }
}
