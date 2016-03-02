import java.sql.*;

public class CycleTest {
  public static void main(String[] args)
    throws SQLException, ClassNotFoundException {
    
    // Load the JDBC driver
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Driver loaded");


    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:odbc:CycleBusiness");
    System.out.println("Database connected");


    // Create a statement
    Statement stmt = connection.createStatement();

	String myString = "select FirstName, LastName from Employee where RStatus = 'Single'";
		System.out.println(myString);
    // Select the columns from the Student table
    ResultSet rset = stmt.executeQuery(myString);


    // Iterate through the result and print the student names
    while (rset.next())
      System.out.println(rset.getString(1) + " " + rset.getString(2));

    // close the connection
    connection.close();
  }
}