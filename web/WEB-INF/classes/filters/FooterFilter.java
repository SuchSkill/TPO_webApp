package filters;

import controller.StringResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FooterFilter implements Filter{

    public void init(FilterConfig p0) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException,ServletException {

        Locale locale = req.getLocale();
        StringResponseWrapper newResp = new StringResponseWrapper(
                (HttpServletResponse) resp
        );
        chain.doFilter(req, newResp);
        StringWriter sw = newResp.getStringWriter();

        // Uzyskujemy treść wygenrowanej odpowiedzi
        String cont = sw.toString();

        // Teraz możemy zrobić cokolwiek z odpowiedzią
        // tu tylko dopiszemy do niej "stopkę"

        // Bierzemy strumień oryginalnej odpowiedzi
        PrintWriter out = resp.getWriter();

        // Przepisujemy otrzymaną odpowiedź
        out.println(cont);

        // Dopisujemy stopkę
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.MEDIUM,
                locale);

        out.println("<hr><div id=\"time\">" + df.format(new Date()) + "</div>");
        out.close();
    }

    public void destroy() {
    }
}