package hartigehap.inkoop.datastorage;

import java.sql.*;

/**
 *
 * @author ppthgast
 */
public class DatabaseConnection {
    
    /**
     * Location of the database driver.
     */
    private final String url = "jdbc:mysql://localhost/";
    
    /**
     * Database name.
     */
    private final String dbName = "dehartigehap";
    
    /**
     * Username of the database.
     */
    private final String dbUser = "root";
    
    /**
     * Password of the database user.
     */
    private final String dbPw = "";

    /**
     * 
     */
    private Connection connection;

    /**
     * 
     */
    private Statement statement;

    /**
     * Instantie new DatabaseConnection.
     */
    public DatabaseConnection() {
        connection = null;
        statement = null;
    }

    /**
     * Open a new database connection.
     * 
     * @return boolean
     */
    public boolean openConnection() {
        boolean result = false;

        if (connection == null) {
            try {
                // Try to create a connection with the library database
                connection = DriverManager.getConnection(url + dbName, dbUser, dbPw);

                if (connection != null) {
                    statement = connection.createStatement();
                }

                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        } else {
            // A connection was already initalized.
            result = true;
        }

        return result;
    }

    /**
     * Check if database connection is open.
     * 
     * @return boolean
     */
    public boolean connectionIsOpen() {
        boolean open = false;

        if (connection != null && statement != null) {
            try {
                open = !connection.isClosed() && !statement.isClosed();
            } catch (SQLException e) {
                System.out.println(e);
                open = false;
            }
        }
        // Else, at least one the connection or statement fields is null, so
        // no valid connection.

        return open;
    }

    /**
     * Close the database connectoion.
     */
    public void closeConnection() {
        try {
            statement.close();

            // Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Execute a select statement.
     * 
     * @param query String
     * @return 
     */
    public ResultSet executeSQLSelectStatement(String query) {
        ResultSet resultset = null;

        // First, check whether a some query was passed and the connection with
        // the database.
        if (query != null && connectionIsOpen()) {
            // Then, if succeeded, execute the query.
            try {
                resultset = statement.executeQuery(query);
            } catch (SQLException e) {
                System.out.println(e);
                resultset = null;
            }
        }

        return resultset;
    }

    /**
     * Execute an insert statement.
     * 
     * @param query
     * @return 
     */
    public boolean executeInsertStatement(String query) {
        boolean result = false;

        if (query != null && connectionIsOpen()) {
            try {
                statement.execute(query);
                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        }

        return result;
    }

    /**
     * Execute an update statement.
     * 
     * @param query
     * @return 
     */
    public boolean executeUpdateStatement(String query) {

        boolean result = false;

        if (query != null && connectionIsOpen()) {
            try {
                statement.executeUpdate(query);
                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        }
        return result;
    }

    /**
     * Execute a delete statement.
     * 
     * @param query
     * @return 
     */
    public boolean executeSQLDeleteStatement(String query) {
        boolean result = false;

        // First, check whether a some query was passed and the connection with
        // the database.
        if (query != null && connectionIsOpen()) {
            // Then, if succeeded, execute the query.
            try {
                statement.executeUpdate(query);
                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        }

        return result;
    }
}
