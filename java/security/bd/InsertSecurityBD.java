package security.bd;

import bd.ConnectionBD;
import security.entities.Security;
import security.entities.SecurityDocument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.postgresql.util.PSQLException;

/*Добавить данные в базы данных*/
public class InsertSecurityBD {

    /*Добавить secid*/
    public void setSecid(Connection connection, String secid) throws ClassNotFoundException, SQLException {
        try {
            String SQLInserSecid = "INSERT INTO secids (secid) VALUES (? )";
            PreparedStatement pInserSecid = connection.prepareStatement(SQLInserSecid);
            pInserSecid.setString(1, secid);
            pInserSecid.executeUpdate();
            pInserSecid.close();
        } catch (PSQLException e) {
            e.printStackTrace();
        }

    }

    /*Добавить boardid*/
    public void setBoardid(Connection connection, String boardid) throws ClassNotFoundException, SQLException {

        try {
            String SQLInserBoardid = "INSERT INTO boardids (boardid) VALUES (? )";
            PreparedStatement pInserBoardid = connection.prepareStatement(SQLInserBoardid);
            pInserBoardid.setString(1, boardid);
            pInserBoardid.executeUpdate();
            pInserBoardid.close();
        } catch (PSQLException e) {
            e.printStackTrace();
        }
    }

    /*Добавить запись ценной бумаги из  xml*/
    public void setSecurity(SecurityDocument doc) throws ClassNotFoundException, SQLException { // 
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectSecurityBD select = new SelectSecurityBD();
        int len = doc.getData().getSecurities().getList().size();
        for (int i = 0; i < len; i++) {
            try {
                String secid = doc.getData().getSecurities().getElement(i).getSecid();
                int idS = select.getIdSecid(connection, secid);
                if (idS == 0) {
                    setSecid(connection, secid);
                    idS = select.getIdSecid(connection, secid);
                }
                String boardid = doc.getData().getSecurities().getElement(i).getBoardid();
                int idB = select.getBoardid(connection, boardid);
                if (idB == 0) {
                    setBoardid(connection, boardid);
                    idB = select.getBoardid(connection, boardid);
                }
                String SQL = "INSERT INTO listSecurity (id, idSecid, Regnumber,"
                        + " NameSecurity, EmitentTitle, PrimaryBoardid) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, doc.getData().getSecurities().getElement(i).getId());
                preparedStatement.setInt(2, idS);
                preparedStatement.setString(3, doc.getData().getSecurities().getElement(i).getRegnumber());
                preparedStatement.setString(4, doc.getData().getSecurities().getElement(i).getName());
                preparedStatement.setString(5, doc.getData().getSecurities().getElement(i).getEmitent());
                preparedStatement.setInt(6, idB);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (PSQLException e) {
                e.printStackTrace();
            }
        }
        connection.close();
    }

    /*Добавить запись ценной бумаги из  xml*/
    public void setSecurityJson(Security sec) throws ClassNotFoundException, SQLException { // 
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectSecurityBD select = new SelectSecurityBD();

        try {
            String secid = sec.getSecid();
            int idS = select.getIdSecid(connection, secid);
            if (idS == 0) {
                setSecid(connection, secid);
                idS = select.getIdSecid(connection, secid);
            }
            String boardid = sec.getBoardid();
            int idB = select.getBoardid(connection, boardid);
            if (idB == 0) {
                setBoardid(connection, boardid);
                idB = select.getBoardid(connection, boardid);
            }
            String SQL = "INSERT INTO listSecurity (idSecid, Regnumber,"
                    + " NameSecurity, EmitentTitle, PrimaryBoardid) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idS);
            preparedStatement.setString(2, sec.getRegnumber());
            preparedStatement.setString(3, sec.getName());
            preparedStatement.setString(4, sec.getEmitent());
            preparedStatement.setInt(5, idB);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (PSQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }
}
