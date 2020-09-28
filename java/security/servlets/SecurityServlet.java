package security.servlets;

import bd.ConnectionBD;
import com.fasterxml.jackson.databind.ObjectMapper;
import security.entities.Security;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.bd.SelectSecurityBD;

/*Отобразить список ценных бумаг*/
@WebServlet("/SecurityServlet")
public class SecurityServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Security> listSec = new ArrayList<Security>();

        int page = Integer.parseInt(request.getParameter("page"));
        SelectSecurityBD selectInfo = new SelectSecurityBD();
        try {
            listSec = selectInfo.getListSecurity(page);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(listSec);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonString);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectSecurityBD selectInfo = new SelectSecurityBD();
        try {
            int count = selectInfo.getCountRow(connection);
            PrintWriter out = response.getWriter();
            out.println(count);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
