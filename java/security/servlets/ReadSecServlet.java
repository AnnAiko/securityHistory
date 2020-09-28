package security.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import security.entities.Security;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.bd.SelectSecurityBD;

/*Показать информацию о ценной бумаге*/
@WebServlet("/ReadSecServlet")
public class ReadSecServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Security security = new Security();
        SelectSecurityBD selectInfo = new SelectSecurityBD();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            security = selectInfo.getInfoSecurity(id);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(security);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonString);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
