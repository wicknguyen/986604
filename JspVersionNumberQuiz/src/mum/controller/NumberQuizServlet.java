package mum.controller;

import mum.model.AgeValidator;
import mum.model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NumberQuizServlet")
public class NumberQuizServlet extends HttpServlet {

    private static final String QUIZ_ATTR_NAME = "quiz";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("reset") != null && !request.getParameter("reset").isEmpty()) {
            session.removeAttribute(QUIZ_ATTR_NAME);
        }


        Object sessionAttribute = session.getAttribute(QUIZ_ATTR_NAME);

        response.setContentType("text/html");
        Quiz quiz = null;
        if (sessionAttribute == null) {
            quiz = new Quiz();
        } else {
            String answer = request.getParameter("answer");
            quiz = (Quiz) sessionAttribute;
            quiz.checkAnswer(answer);
        }
        session.setAttribute(QUIZ_ATTR_NAME, quiz);

        if (quiz.hasNextQuestion()) {
            RequestDispatcher view = request.getRequestDispatcher("quiz.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request, response);
        }
    }
}
