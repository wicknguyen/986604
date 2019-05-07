package mum.controller;

import mum.model.AgeValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AgeValidatorServlet")
public class AgeValidatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String age = request.getParameter("age");
        AgeValidator validator = new AgeValidator(age);
        String validateMsg = validator.validateAge();
        if (validateMsg != null) {
            request.setAttribute("errorMsg", validateMsg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            request.getSession().setAttribute("age", age);
            response.sendRedirect("quiz");
        }
    }
}
