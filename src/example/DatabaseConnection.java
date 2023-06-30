package example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Private constructor to prevent direct instantiation

        //initialize the database connection here
        connection = createConnection();
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            // Create a new instance if it doesn't exist
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection(){

        return connection;
    }
    private Connection createConnection() {
        // Implementation to create and return a database connection
        // This can include setting up the connection parameters, credentials, etc.
        // Example:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "myuser";
            String password = "mypassword";
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}//end of DatabaseConnection class


//NOTES

/*
In the above code, the DatabaseConnection class is implemented as a singleton. The private constructor ensures that it cannot be instantiated directly from outside the class. The getInstance() method is used to get the single instance of the DatabaseConnection class. This method creates a new instance if it doesn't exist already and returns the existing instance if it does.

By using the singleton pattern, multiple parts of the application can access the same DatabaseConnection instance by calling getInstance() and then retrieve the Connection object using the getConnection() method. This way, the application can maintain a single database connection throughout its execution, avoiding the overhead of creating multiple connections and ensuring consistency in database operations.
 */

////////////////////////////////////////////////////////
/*
The import statement import java.sql.Connection; is used to include the Connection class from the java.sql package in your Java code. The Connection class is part of the Java Database Connectivity (JDBC) API, which provides a set of interfaces and classes for connecting to and interacting with relational databases.

The Connection class represents a connection to a specific database and provides methods for executing SQL statements, managing transactions, and retrieving metadata about the database. It is used to establish a connection to a database server, create statements, execute queries, and perform other database-related operations.

By importing java.sql.Connection, you can use the Connection class and its associated methods in your code without having to specify the full package name (java.sql.Connection) every time you reference it.

Here's an example of how you can use the Connection class to establish a database connection:

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseExample {
    public static void main(String[] args) {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Perform database operations using the connection

            // Close the connection when done
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
In this example, the Connection class is imported so that we can use it to establish a connection to a MySQL database using the DriverManager.getConnection() method.
 */

