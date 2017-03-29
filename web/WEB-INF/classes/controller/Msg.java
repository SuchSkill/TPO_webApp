package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Msg extends HttpServlet {

    // HTML document prolog and properties of the <body> tag
    private String prolog =
            "<html><title>Example</title>" +
                    "<body background=\"images/os2.jpg\" text=\"antiquewhite\"" +
                    "link=\"white\" vlink=\"white\">";

    // Closing tags
    private String epilog = "</body></html>";


    // Handler for the GET request

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set the content type and the character set

        response.setContentType("text/html; charset=ISO-8859-2");

        // The output stream for writing the HTML data.
        // PrintWriter enables using print() and println()

        PrintWriter out = response.getWriter();


        out.println(prolog);  // write down the prolog

        // write down the page content
        out.println("<h1>The HTML document<br>generated by a servlet</h1>");
        out.println("<br><br><a href=\"Bye.html\">Bye</a>");

        // write down the closing tags
        out.println(epilog);
        out.close();
    }

}
