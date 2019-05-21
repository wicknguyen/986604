package mum.dict;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "OnlineDictionary")
public class DictServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            DbConnection.openConnection();

            String lookup = request.getParameter("lookup");

            if (lookup == null || lookup.isEmpty()) {
                return;
            }

            String searchEq = "select * from entries where lower(word) = '" + lookup.trim().toLowerCase() + "'";
            ResultSet rs = DbConnection.statement.executeQuery(searchEq);

            JSONArray result = extractJsonArray(rs);
            if (result.isEmpty()) {
                String searchLike = "select * from entries where word like '%" + lookup.trim().toLowerCase() + "%'";
                rs = DbConnection.statement.executeQuery(searchLike);
                result = extractJsonArray(rs);
            }
            response.getWriter().print(result.toJSONString());
            DbConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONArray extractJsonArray(ResultSet rs) throws SQLException {
        JSONArray result = new JSONArray();
        while (rs.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("word", rs.getString("word"));
            jsonObject.put("wordtype", rs.getString("wordtype"));
            jsonObject.put("definition", rs.getString("definition"));
            result.add(jsonObject);
        }
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
