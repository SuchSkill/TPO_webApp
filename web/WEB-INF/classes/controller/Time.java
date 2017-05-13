package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "Time", urlPatterns = {"/time"})
public class Time extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Locale locale = req.getLocale();

        PrintWriter out = resp.getWriter();
        System.out.println("TIMEEE");

        // Dopisujemy stopkę
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.MEDIUM,
                locale);

        out.println(df.format(new Date()));
        out.close();
    }

}
