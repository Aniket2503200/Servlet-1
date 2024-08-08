package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookieHandler")
public class Question9 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        
        if ("set".equalsIgnoreCase(action)) {
            // Setting a cookie
            Cookie cookie = new Cookie("username", "JohnDoe");
            cookie.setMaxAge(60 * 60); // Set cookie to expire in 1 hour
            response.addCookie(cookie);
            out.println("<html><body>");
            out.println("<h2>Cookie has been set!</h2>");
            out.println("<a href='cookieHandler?action=get'>Get Cookie</a>");
            out.println("</body></html>");
        } else if ("get".equalsIgnoreCase(action)) {
            // Retrieving cookies
            Cookie[] cookies = request.getCookies();
            out.println("<html><body>");
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        out.println("<h2>Cookie Value:</h2>");
                        out.println("<p><strong>Username:</strong> " + cookie.getValue() + "</p>");
                        break;
                    }
                }
            } else {
                out.println("<p>No cookies found.</p>");
            }
            out.println("<a href='cookieHandler?action=delete'>Delete Cookie</a>");
            out.println("</body></html>");
        } else if ("delete".equalsIgnoreCase(action)) {
            // Deleting a cookie
            Cookie cookie = new Cookie("username", "");
            cookie.setMaxAge(0); // Expire immediately
            response.addCookie(cookie);
            out.println("<html><body>");
            out.println("<h2>Cookie has been deleted!</h2>");
            out.println("<a href='cookieHandler?action=get'>Get Cookie</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Invalid action. Use ?action=set, ?action=get, or ?action=delete.</h2>");
            out.println("</body></html>");
        }
    }
}
