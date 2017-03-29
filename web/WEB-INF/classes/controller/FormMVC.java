package controller;

import logic.BusinessLogic;
import model.SumResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Eugene on 29-Mar-17.
 */
public class FormMVC extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Integer> args = new ArrayList<>();
        parseArgs(req, args);

        BusinessLogic businessLogic = new BusinessLogic();
        SumResult resultModel = businessLogic.calculate(args);

        if (resultModel != null) {
            req.getSession().setAttribute("model",resultModel);
            RequestDispatcher rd = req.getRequestDispatcher("/sumresult");
            rd.forward(req, resp);
        }else{
            throw new IllegalArgumentException();
        }



    }

    private void parseArgs(HttpServletRequest req, List<Integer> args) {
        Enumeration pnams = req.getParameterNames();
        while (pnams.hasMoreElements()) {
            String name = (String) pnams.nextElement();
            String value = req.getParameter(name);
            try {
                args.add(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new IllegalArgumentException();
            }

        }
    }

}
