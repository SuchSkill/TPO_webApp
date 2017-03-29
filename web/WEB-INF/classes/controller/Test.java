package controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Test extends HttpServlet {

    static String loadMsg = "The class loaded " + new Date();
    String createMsg = "\nThe servlet created  " + new Date();
    String initMsg;
    String config1Msg = "\nInside the constructor the ServletConfig ",
            config2Msg = "\nInside the method init the ServletConfig ";

    public Test() {
        ServletConfig conf = getServletConfig();
        if (conf == null)
            config1Msg += "does not exist,\n" +
                    "so we cannot access the context and the initial parameters";
        else config1Msg +=  " exists !!??";
    }

    public void init() {
        initMsg  = "\nServlet initialized " + new Date();
        ServletConfig conf = getServletConfig();
        if (conf == null) config2Msg +=  "does not exist !!??";
        else {
            config2Msg += "exists.\nWe may access the context" +
                    " and the initial parameters\n";

            // Getting the context and accessing it
            ServletContext context1 = conf.getServletContext();
            // the below call is equivalent to getConfig().getServletContext()
            ServletContext context2 = getServletContext();
            String name = context2.getServletContextName();
        }
    }

    PrintWriter out;

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        out = resp.getWriter();
        out.println(loadMsg);
        out.println(createMsg);
        out.println(config1Msg);
        out.println(config2Msg);
        out.println("handling the request by the method service " + new Date());

        // If we redefine the method service()
        // we will be forced to call super.service(...)
        // to pass the request for handling
        // by specific methods:  doGet, doPost, etc.

        super.service(req, resp);
        out.close();
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {

        out.println("\nThe method doGet called " + new Date());
        out.close();
    }
}