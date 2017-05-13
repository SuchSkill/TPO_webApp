package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class RequestListener implements ServletRequestListener {




    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest servletRequest = (HttpServletRequest) servletRequestEvent.getServletRequest();

        Enumeration<String> headerNames = servletRequest.getServletContext().getAttributeNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            System.out.println("Header Name - " + headerName + ", Value - " + servletRequest.getHeader(headerName));
        }
        System.out.println("init request");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.out.println("destroy request");

    }
}