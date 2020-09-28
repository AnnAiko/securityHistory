package security.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import security.entities.Security;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.bd.InsertSecurityBD;

/*Добавить информацию о ценной бумаге*/
@WebServlet("/CreateSecServlet")
public class CreateSecServlet extends HttpServlet {

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
        String Spattern = "[a-zA-Z]*\\p{Punct}*";
        Pattern pattern = Pattern.compile(Spattern);

        Matcher matcher = pattern.matcher(sec.getName());
        PrintWriter out = response.getWriter();
        if (matcher.find()) {
            out.println("Error in the field 'name'");
        } else {
            InsertSecurityBD insert = new InsertSecurityBD();
            //out.println("В");
            try {
                insert.setSecurityJson(sec);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UpSecServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
