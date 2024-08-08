package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exception")
public class Question10 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Simulate an exception
            int result = 10 / 0; // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            // Handle exception and display custom error message
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Custom Error Page</h1>");
            response.getWriter().println("<p>An error occurred: " + e.getMessage() + "</p>");
            response.getWriter().println("</body></html>");
        }
    }
}
