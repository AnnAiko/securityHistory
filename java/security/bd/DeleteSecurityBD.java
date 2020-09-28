package security.bd;

import bd.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Удалить данные из базы данных*/
public class DeleteSecurityBD {

    /*Метод для удаления заметки*/
    public void delSecurity(int id) throws ClassNotFoundException, SQLException {
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        String SQL = "DELETE FROM listSecurity WHERE id =? ";
        PreparedStatement pS = connection.prepareStatement(SQL);
        pS.setInt(1, id);
        pS.executeUpdate();
        pS.close();
        connection.close();
    }
}
