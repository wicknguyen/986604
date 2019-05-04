import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer firstSumNum = null;
        Integer secondSumNum = null;
        Integer firstMulNum = null;
        Integer secondMulNum = null;
        try {
            firstSumNum = Integer.valueOf(request.getParameter("sum1"));
            secondSumNum = Integer.valueOf(request.getParameter("sum2"));
        } catch (NumberFormatException e) {
            // do nothing
        }

        try {
            firstMulNum = Integer.valueOf(request.getParameter("mul1"));
            secondMulNum = Integer.valueOf(request.getParameter("mul2"));
        } catch (NumberFormatException e) {
            // do nothing
        }

        PrintWriter out = response.getWriter();

        if(firstSumNum != null && secondSumNum != null) {
             out.print("<p>" + firstSumNum + " + " + secondSumNum + " = " + (firstSumNum + secondSumNum) + "</p>");
         }

        if(firstMulNum != null && secondMulNum != null) {
             out.print("<p>" + firstMulNum + " * " + secondMulNum + " = " + (firstMulNum * secondMulNum) + "</p>");
         }
    }

}
