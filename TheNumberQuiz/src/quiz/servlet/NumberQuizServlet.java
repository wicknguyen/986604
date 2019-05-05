package quiz.servlet;

import quiz.model.Quiz;

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
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        PrintWriter out = response.getWriter();
        if (quiz.hasNextQuestion()) {
            out.print(generateNextQuestion(quiz));
        } else {
            out.print(getResult(quiz));
            quiz.preventResubmit();
        }

    }

    private String generateNextQuestion(Quiz quiz) {
        StringBuilder sb = new StringBuilder("<form method='POST'><h1>The Number Quiz</h1>");
        sb.append("<p> Your current score is " + quiz.getScore() + ".</p>");
        sb.append("<p> Guess the next number in the sequence.</p>");
        sb.append(quiz.getNextQuestion());
        sb.append("<p> Your answer: <input type='text' name='answer' /></p>");
        sb.append("<p><input type='submit' value='Submit' /></form>");
        return sb.toString();
    }

    private String getResult(Quiz quiz) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>The Number Quiz</h1>");
        sb.append("<p>Your current score is " + quiz.getScore() + "</p>");
        sb.append("<p>You have completed the Number Quiz, with a score of " + quiz.getScore() + " out of " + quiz.totalQuestion() + ".</p>");
        sb.append("<form method='POST'><input type='submit' name='reset' value='Do Quiz Again' /></form>");
        return sb.toString();
    }
}
