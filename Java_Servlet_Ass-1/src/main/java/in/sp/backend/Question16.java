package in.sp.backend;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class Question16 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DOWNLOAD_DIR = "uploads"; // Directory where files are stored

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("file");
        if (fileName == null || fileName.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "File name must be provided");
            return;
        }

        java.nio.file.Path filePath = Paths.get(getServletContext().getRealPath("") + DOWNLOAD_DIR, fileName);
        if (Files.notExists(filePath)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }

        // Set response content type based on file type (could be enhanced for different file types)
        response.setContentType(Files.probeContentType(filePath));
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // Write file to response output stream
        try (InputStream inputStream = Files.newInputStream(filePath);
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[4096]; // Increased buffer size for better performance
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "File download error: " + e.getMessage());
        }
    }
}
