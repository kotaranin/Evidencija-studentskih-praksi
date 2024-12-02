package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Konekcija {

    private static Konekcija instanca;
    private Connection connection;

    private Konekcija() {
        String url = "jdbc:mysql://localhost/evidencija_studentskih_praksi";
        String user = "root";
        String pass = "root";

        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konekcija getInstanca() {
        if (instanca == null) {
            instanca = new Konekcija();
        }
        return instanca;
    }

    public Connection getConnection() {
        return connection;
    }

}
