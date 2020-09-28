package security.bd;

import bd.ConnectionBD;
import security.entities.Security;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Обновить данные в базы данных*/
public class UpdateInfoBD {

    /*Обновить запись Security*/
    public void updateSecurity(Security sec) throws ClassNotFoundException, SQLException {
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectSecurityBD select = new SelectSecurityBD();
        InsertSecurityBD insert = new InsertSecurityBD();
        String secid = sec.getSecid();
        int idS = select.getIdSecid(connection, secid);
        if (idS == 0) {
            insert.setSecid(connection, secid);
            idS = select.getIdSecid(connection, secid);
        }
        String boardid = sec.getBoardid();
        int idB = select.getBoardid(connection, boardid);
        if (idB == 0) {
            insert.setBoardid(connection, boardid);
            idB = select.getBoardid(connection, boardid);
        }

        Security security = new Security();
        String SQL = "UPDATE listSecurity SET idSecid = ?, regnumber=?, "
                + "nameSecurity=?, emitenttitle=?, PrimaryBoardid=?  "
                + "WHERE id = ?";
        PreparedStatement pS = connection.prepareStatement(SQL);
        pS.setInt(1, idS);
        pS.setString(2, sec.getRegnumber());
        pS.setString(3, sec.getName());
        pS.setString(4, sec.getEmitent());
        pS.setInt(5, idB);
        pS.setInt(6, sec.getId());
        pS.executeUpdate();
        pS.close();
        connection.close();
    }
}
