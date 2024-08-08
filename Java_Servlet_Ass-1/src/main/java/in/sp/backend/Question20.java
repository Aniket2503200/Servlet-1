package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class Question20 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from request
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        // Create User object
        User user = new User(name, age);

        // Set User object in request scope
        request.setAttribute("user", user);

        // Forward to result.jsp
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
