package servlets;

import bd.SecurityHistory;
import bd.SelectBD;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowSecurityHistory")
public class ShowSecurityHistory extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SecurityHistory> listSec = new ArrayList<SecurityHistory>();

        int sort = Integer.parseInt(request.getParameter("sort"));
        String filter = request.getParameter("filter");
        String date = request.getParameter("filter");
        String sql = "";
        switch (sort) {
            case 1:
                sql = "secids.secid";
                break;
            case 2:
                sql = "listSecurity.regnumber";
                break;
            case 3:
                sql = "listSecurity.namesecurity";
                break;
            default:
                sql = "secids.secid";

        }
        SelectBD select = new SelectBD();
        try {
            listSec = select.getListSecurityHistory(sql, filter, date);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(listSec);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonString);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
