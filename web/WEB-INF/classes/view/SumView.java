package view;

import model.SumResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Eugene on 29-Mar-17.
 */
public class SumView extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        SumResult model = (SumResult) session.getAttribute("model");
        if (model.isOkay()) {
            PrintWriter out = resp.getWriter();
            out.println(model.getResult());
            System.out.println("result in view " + model.getResult());
        }else
        {
            PrintWriter out = resp.getWriter();
            out.println("invalid");
            System.out.println("result in view invalid");
        }

    }
}
