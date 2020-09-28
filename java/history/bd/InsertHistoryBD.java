package history.bd;

import bd.ConnectionBD;
import history.entitiens.HistoryDocument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.postgresql.util.PSQLException;
import security.bd.InsertSecurityBD;
import security.bd.SelectSecurityBD;

/**
 *
 * @author User
 */
public class InsertHistoryBD {

    /*Добавить запись истории из  xml*/
    public void setHistory(HistoryDocument doc) throws ClassNotFoundException, SQLException { // 
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectSecurityBD select = new SelectSecurityBD();
        InsertSecurityBD insert = new InsertSecurityBD();
        int len = doc.getElemnt().getHistories().getList().size();

        for (int i = 0; i < len; i++) {
            try {
                String secid = doc.getElemnt().getHistories().getElement(i).getSecid();
                int idS = select.getIdSecid(connection, secid);
                if (idS == 0) {
                    insert.setSecid(connection, secid);
                    idS = select.getIdSecid(connection, secid);
                }
                String boardid = doc.getElemnt().getHistories().getElement(i).getBoardid();
                int idB = select.getBoardid(connection, boardid);
                if (idB == 0) {
                    insert.setBoardid(connection, boardid);
                    idB = select.getBoardid(connection, boardid);
                }
                String SQL = "INSERT INTO histories (idSecid, idBoardid, "
                        + "tradedate, Numtrades, OpenHis, CloseHis, Low, High) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, idS);
                preparedStatement.setInt(2, idB);
                /*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//dd/MM/yyyy
                java.sql.Date sqlDate = null;
                try {
                    Date apptDay = (Date) dateFormat.parse(doc.getElemnt().getHistories().getElement(i).getTradedate());
                    sqlDate = new java.sql.Date(apptDay.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/
                preparedStatement.setString(3, doc.getElemnt().getHistories().getElement(i).getTradedate());
                preparedStatement.setInt(4, Integer.parseInt(doc.getElemnt().getHistories().getElement(i).getNumtrades()));
                preparedStatement.setString(5, doc.getElemnt().getHistories().getElement(i).getOpen());
                preparedStatement.setString(6, doc.getElemnt().getHistories().getElement(i).getClose());
                preparedStatement.setString(7, doc.getElemnt().getHistories().getElement(i).getLow());
                preparedStatement.setString(8, doc.getElemnt().getHistories().getElement(i).getHigh());
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (PSQLException e) {
                e.printStackTrace();
            }
        }
        connection.close();
    }
}
