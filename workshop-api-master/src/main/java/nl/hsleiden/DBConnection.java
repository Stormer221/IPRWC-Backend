package nl.hsleiden;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Nick Hoogervorst
 */
public class DBConnection {
    private static final String LOGGER_TEXT = "Just a stack trace, nothing to worry about";
    private static Connection conn;
    private static Properties prop = getProperties();
    private static String url = prop.getProperty("url");
    private static String username = prop.getProperty("user");
    private static String password = prop.getProperty("password");

    private DBConnection() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection createConnection() {
        if (conn != null) {
            Logger.getRootLogger().info("DBConnection: Connection " + conn.toString() + " already established");
        } else {
            try {
                //Get a connection
                conn = DriverManager.getConnection(url, username, password);
                Logger.getRootLogger().info("DBConnection: created new connection: " + conn.toString());
            } catch (Exception e) {
                Logger.getRootLogger().info(LOGGER_TEXT, e);
            }
        }
        return conn;
    }

    public static void shutdown(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                Logger.getRootLogger().info("DBConnection: " + conn.toString() + " is disconnected");
                DBConnection.conn = null;
            } catch (SQLException e) {
                Logger.getRootLogger().info("Sql error " + e.getErrorCode());
            }
        } else {
            Logger.getRootLogger().info("DBConnection: no connection to close");
        }
    }

    private static Properties getProperties() {
        Properties prop = null;
        String resourceName = "config/config.properties";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = classLoader.getResourceAsStream(resourceName)) {
            prop = new Properties();
            prop.load(Objects.requireNonNull(resourceStream));
        } catch (IOException e) {
            Logger.getRootLogger().info(LOGGER_TEXT, e);
        }
        return prop;
    }
}
