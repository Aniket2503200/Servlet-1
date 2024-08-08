package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testListener")
public class Question12 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Add an attribute to the servlet context
        getServletContext().setAttribute("testAttribute", "testValue");

        // Remove an attribute from the servlet context
        getServletContext().removeAttribute("testAttribute");

        // Replace an attribute in the servlet context
        getServletContext().setAttribute("testAttribute", "newValue");

        resp.getWriter().write("Attributes have been modified. Check the logs.");
    }
}
