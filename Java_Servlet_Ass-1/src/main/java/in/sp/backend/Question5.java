package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

@WebServlet("/contextData")
public class Question5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        // Setting an attribute in the servlet context
        ServletContext context = getServletContext();
        context.setAttribute("appMessage", "Welcome to the Application!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the servlet context
        ServletContext context = getServletContext();

        // Retrieve an attribute from the servlet context
        String appMessage = (String) context.getAttribute("appMessage");

        out.println("<html><body>");
        out.println("<h1>Servlet Context Data</h1>");
        if (appMessage != null) {
            out.println("<p>App Message: " + appMessage + "</p>");
        } else {
            out.println("<p>No message found in context.</p>");
        }

        // Provide a form to update the context attribute
        out.println("<form action='contextData' method='post'>");
        out.println("<label for='newMessage'>Set New Message:</label>");
        out.println("<input type='text' id='newMessage' name='newMessage'>");
        out.println("<input type='submit' value='Update Message'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the new message from the request
        String newMessage = request.getParameter("newMessage");

        // Update the servlet context attribute
        if (newMessage != null && !newMessage.isEmpty()) {
            ServletContext context = getServletContext();
            context.setAttribute("appMessage", newMessage);

            out.println("<html><body>");
            out.println("<h1>Servlet Context Data Updated</h1>");
            out.println("<p>New Message: " + newMessage + "</p>");
            out.println("<a href='contextData'>Back</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>Message cannot be empty.</p>");
            out.println("<a href='contextData'>Back</a>");
            out.println("</body></html>");
        }
    }
}
