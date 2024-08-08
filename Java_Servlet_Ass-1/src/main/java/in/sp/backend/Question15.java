//cmd
//curl -X POST -H "Content-Type: application/xml" --data "<root><child>value</child></root>" http://localhost:8080/Java_Servlet_Ass-1/processXml

package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@WebServlet("/processXml")
public class Question15 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type to XML
        response.setContentType("application/xml");
        
        try {
            // Parse the XML request body
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(request.getInputStream());
            Element root = document.getDocumentElement();
            
            // Extract root element name
            String rootElementName = root.getNodeName();
            
            // Generate response XML
            PrintWriter out = response.getWriter();
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<response>");
            out.println("<message>Received XML with root element: " + rootElementName + "</message>");
            out.println("</response>");
            
        } catch (Exception e) {
            throw new ServletException("Error processing XML", e);
        }
    }
}


