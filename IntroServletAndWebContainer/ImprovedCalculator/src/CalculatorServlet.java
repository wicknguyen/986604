import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstSumInputName = "sum1";
        String secondSumInputName = "sum2";
        Integer firstSumNum = extractAndConvertParam(request, firstSumInputName);
        Integer secondSumNum = extractAndConvertParam(request, secondSumInputName);

        String firstMultiplyInputName = "mul1";
        String secondMultiplyInputName = "mul2";
        Integer firstMulNum = extractAndConvertParam(request, firstMultiplyInputName);
        Integer secondMulNum = extractAndConvertParam(request, secondMultiplyInputName);


        StringBuilder sb = new StringBuilder("<form action='doCalculate' method='post'>");
        buildForm(firstSumNum, secondSumNum, sb, firstSumInputName, secondSumInputName, "+");
        buildForm(firstMulNum, secondMulNum, sb, firstMultiplyInputName, secondMultiplyInputName, "*");
        sb.append("<br><input type='submit' value='Submit'/></form>");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(sb.toString());
    }

    private void buildForm(Integer firstNum, Integer secondNum, StringBuilder sb, String firstInputName,
                           String secondInputName, String action) {
        sb.append("<div>");
        sb.append("<input type='text' size='10' name='" + firstInputName +"'");
        if(firstNum != null) {
            sb.append("value='" + firstNum + "'");
        }
        sb.append("/> " + action +" <input type='text' size='10' name='" + secondInputName + "'");
        if (secondNum != null) {
           sb.append("value='" + secondNum + "'");
        }
        sb.append("'/>=<input type='text' size='10' name='" + action + "'");
        if (firstNum!= null && secondNum != null) {
           sb.append("value='" + ("+".equals(action) ? (firstNum + secondNum) : (firstNum * secondNum)) + "'");
        }
        sb.append("</div>");
    }

    private Integer extractAndConvertParam(HttpServletRequest request, String sum1) {
        try {
            return Integer.valueOf(request.getParameter(sum1));
        } catch (NumberFormatException e) {
            // do nothing
        }
        return null;
    }

}
