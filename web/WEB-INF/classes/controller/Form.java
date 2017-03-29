package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class Form extends HttpServlet {

    public void service(HttpServletRequest req,
                      HttpServletResponse resp)
            throws ServletException, IOException
    {

        PrintWriter out = resp.getWriter();
        out.println("Sum parameters from get:");
        Enumeration pnams = req.getParameterNames();
        int sum = 0;
        while (pnams.hasMoreElements()) {
            String name = (String) pnams.nextElement();
            String value = req.getParameter(name);
            try {
                sum += Integer.parseInt(value);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                out.println("Not an Integer");
            }
            out.println(name + " = "  + value);
        }
        out.println("<p>123</p>");
        out.println("Sum = " + sum);


        out.close();
    }

}
