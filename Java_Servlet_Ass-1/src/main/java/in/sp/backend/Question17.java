package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/FormValidationServlet")
public class Question17 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        
        // Validate form data
        StringBuilder errorMessages = new StringBuilder();
        boolean hasErrors = false;

        if (name == null || name.trim().isEmpty()) {
            errorMessages.append("Name is required.<br>");
            hasErrors = true;
        }

        if (email == null || email.trim().isEmpty()) {
            errorMessages.append("Email is required.<br>");
            hasErrors = true;
        } else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errorMessages.append("Invalid email format.<br>");
            hasErrors = true;
        }

        int age = -1;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 0) {
                errorMessages.append("Age must be a positive number.<br>");
                hasErrors = true;
            }
        } catch (NumberFormatException e) {
            errorMessages.append("Age must be a number.<br>");
            hasErrors = true;
        }

        // Display error messages or process data
        if (hasErrors) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3>Form Validation Errors:</h3>");
            response.getWriter().println(errorMessages.toString());
            response.getWriter().println("<a href=\"form.html\">Go back</a>");
            response.getWriter().println("</body></html>");
        } else {
            // Process the data (e.g., save to database, etc.)
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3>Form submitted successfully!</h3>");
            response.getWriter().println("<p>Name: " + name + "</p>");
            response.getWriter().println("<p>Email: " + email + "</p>");
            response.getWriter().println("<p>Age: " + age + "</p>");
            response.getWriter().println("</body></html>");
        }
    }
}
