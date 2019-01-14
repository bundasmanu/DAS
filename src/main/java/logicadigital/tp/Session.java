/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Armando
 */
public class Session {

    public static Connection conn;
    //private static UnitOfWork unit;
    private CRUDUtilizador utilizadorBD;

    public Session() {

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            Class.forName("org.h2.Driver");
            conn = DriverManager.
                    getConnection("jdbc:h2:~/test", "sa", ""); //user:sa pass:""
            //Statement statement = conn.createStatement();
            //statement.setQueryTimeout(30);
        }

        return conn;
    }

    public void fechaConexao() throws SQLException {
        if (this.conn.isClosed() == true) {
            return;
        }
        this.conn.close();
    }

    public CRUDUtilizador getUtilizdorOperacaoCRUD() {

        if (this.utilizadorBD == null) {
            return this.utilizadorBD = new CRUDUtilizador();
        }

        return utilizadorBD;
    }

}
