package augustobellinaso.showdomilhao.connection;

import augustobellinaso.showdomilhao.util.LogUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL_CONNECTION = "jdbc:sqlite:src/main/resources/augustobellinaso/showdomilhao/data/show_milhao.db";

    private static Connection connection;

    private ConnectionFactory() {

    }

    static {
        conectar();
    }

    private static void conectar() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL_CONNECTION);
                connection.setAutoCommit(false);

            }
        } catch (Exception e) {
            LogUtil.getLogger(ConnectionFactory.class).error(e.getCause().toString());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
