package security.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.bd.DeleteSecurityBD;

/*Удалить информацию о ценной бумаге*/
@WebServlet("/DelSecServlet")
public class DelSecServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        DeleteSecurityBD delete = new DeleteSecurityBD();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            delete.delSecurity(id);
            request.setAttribute("message", "Запись была успешно удалена");
            request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
