package in.sp.backend;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mainServlet")
public class Question7 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Include content from another servlet or JSP
        request.getRequestDispatcher("/includedContent").include(request, response);
        
        // Add additional content after the included content
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Main Servlet</h1>");
        response.getWriter().println("<p>This is content from MainServlet after inclusion.</p>");
        response.getWriter().println("</body></html>");
    }
}
