package listeners;

import javax.servlet.*;

public class ContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent p0) {
//        ServletContext context = p0.getServletContext();
//        context.setAttribute("Liczba", new Integer(1));
        System.out.println("init context");
    }

    public void contextDestroyed(ServletContextEvent p0) {
        System.out.println("destroy context");
    }
}