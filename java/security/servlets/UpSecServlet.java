package security.servlets;

import security.bd.UpdateInfoBD;
import com.fasterxml.jackson.databind.ObjectMapper;
import security.entities.Security;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Редактировать информацию о ценной бумаге*/
@WebServlet("/UpSecServlet")
public class UpSecServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Получаем значение 
        String jsonString = "";
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jsonString += line;
        }
        ObjectMapper mapper = new ObjectMapper();
        Security sec = mapper.readValue(jsonString, Security.class);
        UpdateInfoBD update = new UpdateInfoBD();
        PrintWriter out = response.getWriter();
        out.println(sec);
        try {
            update.updateSecurity(sec);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpSecServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
