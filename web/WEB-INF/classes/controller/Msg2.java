package controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class Msg2 extends HttpServlet {

    private ServletContext context;
    private PrintWriter out;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        out = resp.getWriter();
        out.println("The document generated by the servlet " +
                this.getClass().getName()+ ".class");
        out.println("-------------------------------------------------------");

        // The URL of the request
        String requestURL = req.getRequestURL().toString();
        out.println("RequestURL: " + requestURL);

        // Get the context
        context = this.getServletContext();

        // Get information concerning the server
        out.println("\nServer info\n" + context.getServerInfo() );

        // What is the application name (specified in the <display-name>)?
        out.println("\nApplication name: " + context.getServletContextName() );

        // Path information
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();

        // Physical paths associated with URLs
        out.println("\nPaths");
        msg("ContextPath", contextPath);
        msg("ServletPath", servletPath);

        // Resources (HTML, JPG)
        msg("The file Bye.html", "Bye.html");
        msg("The file os2.jpg", "images/os2.jpg");

        // The list of application resources
        out.println("\nThe list of application resources");
        listResources("/");

        // Carry out some I/O operations on the resources
        InputStream in = context.getResourceAsStream("/WEB-INF/web.xml");
        BufferedReader br = new BufferedReader( new InputStreamReader(in));
        out.println("\nThe first line of the file web.xml");
        out.println(br.readLine());
        br.close();

        // What is the working directory of the servlet?
        File dir = new File(".");
        out.println("\nThe working directory of the servlet: " + dir.getAbsolutePath());

        out.close();
    }

    // Lists application resources
    private void listResources(String path)  {
        if (path == null) return;
        Set res = context.getResourcePaths(path);
        for (Iterator iter = res.iterator(); iter.hasNext(); ) {
            String resItem = (String) iter.next();
            if (resItem.endsWith("/"))
                listResources(resItem);
            else out.println(resItem);
        }
    }

    private void msg(String info, String path) {
        out.println("------------------------------------------");
        out.println(info);
        String realPath = context.getRealPath(path);
        out.println("Virtual: " + path);
        out.println("Real   : " + realPath);
    }

}