package in.sp.backend;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forwardRequest")
public class Question6 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set an attribute to the request
        request.setAttribute("message", "Hello from ForwardingServlet!");

        // Forward the request to a JSP page
        request.getRequestDispatcher("/forwarded.jsp").forward(request, response);
    }
}
