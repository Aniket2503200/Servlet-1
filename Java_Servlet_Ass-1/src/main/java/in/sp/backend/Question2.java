package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displayParams")
public class Question2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        out.println("<html><body>");
        out.println("<h1>Received Parameters</h1>");
        out.println("<ul>");

        if (name != null && !name.isEmpty()) {
            out.println("<li>Name: " + name + "</li>");
        } else {
            out.println("<li>Name: Not provided</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }
}
