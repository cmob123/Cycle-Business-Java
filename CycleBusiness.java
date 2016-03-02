////////////////////////////////////////////////////////////////////////////
// Name: Chris O'Brien
// CS 113
// Purpose: Create and maintain a database of employees at a fictional motorcycle dealership. 
//          Uses SQL commands to interface with the database.
////////////////////////////////////////////////////////////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CycleBusiness extends JFrame {
  
  private static CycleBusiness frame;
  
  Connection connection;
  
  private JTabbedPane tabbedPane = new JTabbedPane();
  private JPanel[] fields = new JPanel[5];
  private JPanel[] buttons = new JPanel[5];
  private JButton[] bFind = new JButton[5];
  private JButton[] bAdd = new JButton[5];
  private JButton[] bDelete = new JButton[5];
  private JButton[] bUpdate = new JButton[5];
  private JButton[] bClear = new JButton[5];

  
  // EMPLOYEE
  private JPanel employee = new JPanel();
  private JLabel lID = new JLabel("Employee ID:");
  private JTextField tID = new JTextField(4);
  private JLabel lFirstName = new JLabel("First Name:");
  private JTextField tFirstName = new JTextField(4);
  private JLabel lLastName = new JLabel("Last Name:");
  private JTextField tLastName = new JTextField(4);
  private JLabel lExpertise = new JLabel("Expertise:");
  private JTextField tExpertise = new JTextField(4);
  private JLabel lYearHired = new JLabel("Year Hired:");
  private JTextField tYearHired = new JTextField(4);
  private JLabel lSupervisor = new JLabel("Supervisor:");
  private JTextField tSupervisor = new JTextField(4);
  private JLabel lPhoneNumber = new JLabel("Phone #:");
  private JTextField tPhoneNumber = new JTextField(4);
  private JLabel lEmail = new JLabel("Email Address:");
  private JTextField tEmail = new JTextField(4);  
  private JLabel lRelationStatus = new JLabel("Relationship Status:");
  private JTextField tRelationStatus = new JTextField(4);
  
  // INVOICE
  private JPanel invoice = new JPanel();
  private JLabel lID2 = new JLabel("Employee ID:");
  private JTextField tID2 = new JTextField(4);
  private JLabel lCustomerID = new JLabel("Customer ID:");
  private JTextField tCustomerID = new JTextField(4);
  private JLabel lInvDate = new JLabel("Date of Invoice");
  private JTextField tInvDate = new JTextField(4);
  private JLabel lTotal = new JLabel("Total:");
  private JTextField tTotal = new JTextField(4);
  
  // CUSTOMER
  private JPanel customer = new JPanel();
  private JLabel lCID = new JLabel("Customer ID:");
  private JTextField tCID = new JTextField(4);
  private JLabel lName = new JLabel("Name:");
  private JTextField tName = new JTextField(4);
  private JLabel lCreditRating = new JLabel("Credit Rating:");
  private JTextField tCreditRating = new JTextField(4);
  private JLabel lPhone = new JLabel("Phone #:");
  private JTextField tPhone = new JTextField(4);
  private JLabel lAddress = new JLabel("Address:");
  private JTextField tAddress = new JTextField(4);
  private JLabel lCity = new JLabel("City:");
  private JTextField tCity = new JTextField(4);
  private JLabel lState = new JLabel("State:");
  private JTextField tState = new JTextField(4);
  private JLabel lZipCode = new JLabel("Zip Code");
  private JTextField tZipCode = new JTextField(4);  
 
  // MOTOCUST
  private JPanel motoCust = new JPanel();
  private JLabel lCID2 = new JLabel("Customer ID:");
  private JTextField tCID2 = new JTextField(4);
  private JLabel lMID = new JLabel("MotorCycle ID:");
  private JTextField tMID = new JTextField(4);  
  
  // MOTORCYCLE
  private JPanel motorcycle = new JPanel();
  private JLabel lMID2 = new JLabel("MotorCycle ID:");
  private JTextField tMID2 = new JTextField(4);
  private JLabel lDescription = new JLabel("Description:");
  private JTextField tDescription = new JTextField(4);
  private JLabel lManufacturer= new JLabel("Customer ID:");
  private JTextField tManufacturer = new JTextField(4);
  private JLabel lMSRP = new JLabel("MSRP");
  private JTextField tMSRP = new JTextField(4);
  private JLabel lCategory = new JLabel("Category");
  private JTextField tCategory = new JTextField(4);
   
  public CycleBusiness(){
  
    for(int i=0; i<5; i++){
        fields[i] = new JPanel();
        buttons[i] = new JPanel();
        bFind[i] = new JButton("Find");
        bAdd[i] = new JButton("Add");
        bDelete[i] = new JButton("Delete");
        bUpdate[i] = new JButton("Update");
        bClear[i] = new JButton("Clear");        
    }

    // EMPLOYEE
    fields[0].setLayout(new GridLayout(9, 2));
	 fields[0].add(lID);
	 fields[0].add(tID);
	 fields[0].add(lFirstName);
	 fields[0].add(tFirstName);
	 fields[0].add(lLastName);
	 fields[0].add(tLastName);
	 fields[0].add(lExpertise);
	 fields[0].add(tExpertise);     
	 fields[0].add(lYearHired);
	 fields[0].add(tYearHired);
	 fields[0].add(lSupervisor);
	 fields[0].add(tSupervisor);
	 fields[0].add(lPhoneNumber);
	 fields[0].add(tPhoneNumber);
	 fields[0].add(lEmail);
    fields[0].add(tEmail);
	 fields[0].add(lRelationStatus);
    fields[0].add(tRelationStatus);
    buttons[0].add(bFind[0]);
    buttons[0].add(bAdd[0]);
    buttons[0].add(bDelete[0]);
    buttons[0].add(bUpdate[0]);
    buttons[0].add(bClear[0]);
    employee.setLayout(new BorderLayout());
    employee.add(fields[0], BorderLayout.CENTER);
    employee.add(buttons[0], BorderLayout.SOUTH);
	 
    // INVOICE
    fields[1].setLayout(new GridLayout(4, 2));
	 fields[1].add(lID2);
	 fields[1].add(tID2);
	 fields[1].add(lCustomerID);
	 fields[1].add(tCustomerID);
	 fields[1].add(lInvDate);
	 fields[1].add(tInvDate);
	 fields[1].add(lTotal);
	 fields[1].add(tTotal); 
    buttons[1].add(bFind[1]);
    buttons[1].add(bAdd[1]);
    buttons[1].add(bDelete[1]);
    buttons[1].add(bUpdate[1]);
    buttons[1].add(bClear[1]);
    invoice.setLayout(new BorderLayout());
    invoice.add(fields[1], BorderLayout.CENTER);
    invoice.add(buttons[1], BorderLayout.SOUTH);    
	 
    // CUSTOMER
    fields[2].setLayout(new GridLayout(8, 2));
	 fields[2].add(lCID);
	 fields[2].add(tCID);
	 fields[2].add(lName);
	 fields[2].add(tName);
	 fields[2].add(lCreditRating);
	 fields[2].add(tCreditRating);     
	 fields[2].add(lPhone);
	 fields[2].add(tPhone);
	 fields[2].add(lAddress);
	 fields[2].add(tAddress);
	 fields[2].add(lCity);
	 fields[2].add(tCity);
	 fields[2].add(lState);
    fields[2].add(tState);
	 fields[2].add(lZipCode);
	 fields[2].add(tZipCode);
    buttons[2].add(bFind[2]);
    buttons[2].add(bAdd[2]);
    buttons[2].add(bDelete[2]);
    buttons[2].add(bUpdate[2]);
    buttons[2].add(bClear[2]);
    customer.setLayout(new BorderLayout());
    customer.add(fields[2], BorderLayout.CENTER);
    customer.add(buttons[2], BorderLayout.SOUTH);    	
    
    // MOTOCUST
    fields[3].setLayout(new GridLayout(2, 2));
    fields[3].add(lCID);
	 fields[3].add(tCID);
	 fields[3].add(lMID);
	 fields[3].add(tMID);
    buttons[3].add(bFind[3]);
    buttons[3].add(bAdd[3]);
    buttons[3].add(bDelete[3]);
    buttons[3].add(bUpdate[3]);
    buttons[3].add(bClear[3]);
    motoCust.setLayout(new BorderLayout());
    motoCust.add(fields[3], BorderLayout.CENTER);
    motoCust.add(buttons[3], BorderLayout.SOUTH);    
    
    // MOTORCYCLE
    fields[4].setLayout(new GridLayout(5, 2));
	 fields[4].add(lMID2);
	 fields[4].add(tMID2);
	 fields[4].add(lDescription);
	 fields[4].add(tDescription);
	 fields[4].add(lManufacturer);
	 fields[4].add(tManufacturer);
	 fields[4].add(lMSRP);
	 fields[4].add(tMSRP);  
	 fields[4].add(lCategory);  
	 fields[4].add(tCategory);  
    buttons[4].add(bFind[4]);
    buttons[4].add(bAdd[4]);
    buttons[4].add(bDelete[4]);
    buttons[4].add(bUpdate[4]);
    buttons[4].add(bClear[4]);
    motorcycle.setLayout(new BorderLayout());
    motorcycle.add(fields[4], BorderLayout.CENTER);
    motorcycle.add(buttons[4], BorderLayout.SOUTH);    

    // add tabs
	 tabbedPane.addTab("Employee", employee);
	 tabbedPane.addTab("Invoice", invoice);
	 tabbedPane.addTab("Customer", customer);
    tabbedPane.addTab("MotoCust", motoCust);
    tabbedPane.addTab("Motorcycle", motorcycle);
	 this.add(tabbedPane);
    
    // LISTENERS FOR EMPLOYEE
	 bFind[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		  // Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bFind[0]");
		  }
		  
        System.out.println("Driver loaded");


        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
  
		  int id = Integer.parseInt(tID.getText());
		  System.out.println(id);
		  String query = "select * from Employee where employeeID = " + id;
        System.out.println(query);
        // Create a statement
        Statement stmt = connection.createStatement();		  
        ResultSet rset = stmt.executeQuery(query);
		  while(rset.next()){
		     tFirstName.setText(rset.getString(2));
			  tLastName.setText(rset.getString(3));
			  tExpertise.setText(rset.getString(4));
			  tYearHired.setText(rset.getString(5));
			  tSupervisor.setText(rset.getString(6));
			  tPhoneNumber.setText(rset.getString(7));
			  tEmail.setText(rset.getString(8));
			  tRelationStatus.setText(rset.getString(9));
		  }
		  
        // close the connection
        connection.close();
		 }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bFind[0]" + ex);}  
	   }
	 });
    
	 bAdd[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		// Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bAdd[0] " + ex);
		  }
        System.out.println("Driver loaded");

        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
		  int id = Integer.parseInt(tID.getText());
        String rows = "EmployeeID, FirstName, LastName, Expertise, YearHired, Supervisor, PhoneNumber, Email, RStatus";
        String values = "" + id + "tFirstName.getText(), tLastName.getText(), tExpertise.getText(), tYearHired.getText(), tSupervisor.getText(), tPhoneNumber.getText(), tEmail.getText(), tRelationStatus.getText()";
        String add = "insert into employee (" + rows + ") values (" + values + ")";
        Statement stmt = connection.createStatement();		  
        stmt.execute(add);
        // close the connection
        connection.close();
		  System.out.println("Connection closed");
       }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bAdd[0] " + ex);} 
		}
    });           
    
	 bDelete[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		// Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bDelete[0] " + ex);
		  }
		  String[] queries = new String[8];
        System.out.println("Driver loaded");

        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
		  int id = Integer.parseInt(tID.getText());
        String delete = "delete * from Employee where EmployeeID = " + id;
        Statement stmt = connection.createStatement();		  
        stmt.execute(delete);        
        // close the connection
        connection.close();
		  System.out.println("Connection closed");
       }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bDelete[0] " + ex);} 
		}
    });            
    
	 bUpdate[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		// Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bUpdate[0] " + ex);
		  }
		  String[] queries = new String[8];
        System.out.println("Driver loaded");

        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
		  int id = Integer.parseInt(tID.getText());
		  System.out.println(id);
        String update = "update Employee set FirstName = '" + tFirstName.getText() + "', LastName = '" + tLastName.getText() + "', Expertise = '" 
                        + tExpertise.getText() + "', YearHired = '" + tYearHired.getText() + "', Supervisor = '" + tSupervisor.getText() + "', PhoneNumber = '" 
                        + tPhoneNumber.getText() + "', Email = '" + tEmail.getText() + "', RStatus = '" + tRelationStatus.getText() + "' where employeeID = " + id;
          // Create a statement
          Statement stmt = connection.createStatement();		  
          stmt.executeUpdate(update);
		  //} // end loop
        // close the connection
        connection.close();
		  System.out.println("Connection closed");
       }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bUpdate[0] " + ex);} 
		}
    });
	 
	 bClear[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		tID.setText("");
      tFirstName.setText("");
  	   tLastName.setText("");
		tExpertise.setText("");
		tYearHired.setText("");
		tSupervisor.setText("");
		tPhoneNumber.setText("");
		tEmail.setText("");
		tRelationStatus.setText("");		
		}
    });
    // LISTENERS FOR INVOICE
    
    
    // LISTENERS FOR CUSTOMER
	 bFind[1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		  // Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bFind[1]");
		  }
		  
        System.out.println("Driver loaded");


        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
  
		  int id = Integer.parseInt(tCID.getText());
		  System.out.println(id);
		  String query = "select * from Customer where CustomerID = " + id;
        System.out.println(query);
        // Create a statement
        Statement stmt = connection.createStatement();		  
        ResultSet rset = stmt.executeQuery(query);
		  while(rset.next()){
		     tName.setText(rset.getString(2));
			  tCreditRating.setText(rset.getString(3));
			  tPhone.setText(rset.getString(4));
			  tAddress.setText(rset.getString(5));
			  tCity.setText(rset.getString(6));
			  tState.setText(rset.getString(7));
			  tZipCode.setText(rset.getString(8));
		  }
		  
        // close the connection
        connection.close();
		 }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bFind[1]" + ex);}  
	   }
	 });
    
	 bAdd[1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		// Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bAdd[1] " + ex);
		  }
        System.out.println("Driver loaded");

        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
		  int id = Integer.parseInt(tCID.getText());
        String rows = "CustomerID, Name, CreditRating, Phone, Address, City, State, ZipCode";
        String values = "" + id + "tName.getText(), tCreditRating.getText(), tPhone.getText(), tAddress.getText(), tCity.getText(), tState.getText(), tZipCode.getText()";
        String add = "insert into Customer (" + rows + ") values (" + values + ")";
        Statement stmt = connection.createStatement();		  
        stmt.execute(add);
        // close the connection
        connection.close();
		  System.out.println("Connection closed");
       }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bAdd[1] " + ex);} 
		}
    });           
    
	 bDelete[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		// Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bDelete[0] " + ex);
		  }
		  String[] queries = new String[8];
        System.out.println("Driver loaded");

        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
		  int id = Integer.parseInt(tID.getText());
        String delete = "delete * from Employee where EmployeeID = " + id;
        Statement stmt = connection.createStatement();		  
        stmt.execute(delete);        
        // close the connection
        connection.close();
		  System.out.println("Connection closed");
       }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bDelete[0] " + ex);} 
		}
    });            
    
	 bUpdate[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		// Load the JDBC driver
		  try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		  catch(ClassNotFoundException ex){
		  System.out.println("ClassNotFoundException in bUpdate[0] " + ex);
		  }
		  String[] queries = new String[8];
        System.out.println("Driver loaded");

        // Establish a connection
		 try{
        connection = DriverManager.getConnection("jdbc:odbc:CycleBusiness");
          System.out.println("Database connected");  
		  int id = Integer.parseInt(tID.getText());
		  System.out.println(id);
        String update = "update Employee set FirstName = '" + tFirstName.getText() + "', LastName = '" + tLastName.getText() + "', Expertise = '" 
                        + tExpertise.getText() + "', YearHired = '" + tYearHired.getText() + "', Supervisor = '" + tSupervisor.getText() + "', PhoneNumber = '" 
                        + tPhoneNumber.getText() + "', Email = '" + tEmail.getText() + "', RStatus = '" + tRelationStatus.getText() + "' where employeeID = " + id;
        // Create a statement
        Statement stmt = connection.createStatement();		  
        stmt.executeUpdate(update);
        // close the connection
        connection.close();
		  System.out.println("Connection closed");
       }
		 catch(SQLException ex)
		 {System.out.println("SQL Error in bUpdate[0] " + ex);} 
		}
    });
	 
	 bClear[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
		tID.setText("");
      tFirstName.setText("");
  	   tLastName.setText("");
		tExpertise.setText("");
		tYearHired.setText("");
		tSupervisor.setText("");
		tPhoneNumber.setText("");
		tEmail.setText("");
		tRelationStatus.setText("");		
		}
    });

  } // end CycleBusiness constructor

  // start main method
  public static void main(String[] args) {
    frame = new CycleBusiness();
    frame.setTitle("Cycle Business");
    //frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setResizable(true);
    frame.setVisible(true);
  } // end main

} // end CycleBusiness