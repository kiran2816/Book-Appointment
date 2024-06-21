import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionToDB {
   
    public static void main(String[] args){
     ConnectionToDB obj = new ConnectionToDB();
    obj.createDatabase();
     obj.createTable(); 
   //     obj.insertData();
      // obj.readData();
    }

    public void createDatabase(){
       try{
   
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/","root", "Admin@2816");
          Statement stm = con.createStatement();
          String query = "create database project";
          stm.execute(query);
          System.out.println("Database created sucsessfully.");

       }
       catch(Exception e){
        e.printStackTrace();
       }
    }

    public void createTable(){
      try{
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project","root","Admin@2816");
         Statement stm = con.createStatement();
         String query = "create table patient (email varchar(200) PRIMARY  KEY, name varchar(50),age varchar(10),address varchar(200), mobile varchar(10), password varchar(20))";
         stm.execute(query);
         System.out.println("Tabel created Sucssesfully.");
         con.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
    }

    public void insertData(){
      try{
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project","root","Admin@2816");
         String query = "INSERT into patient (email,name,lname,mobile,password) VALUES(?,?,?,?,?,?)";
         PreparedStatement pstm = con.prepareStatement(query);
         Registration obj = new Registration();
                      String email = obj.emailidfield.getText();
                      String name = obj.namefield.getText();
                      String age = obj.agefield.getText();
                      String address = obj.addressarea.getText();
                      String mobile = obj.mobilefield.getText();
                      String password = new  String(obj.passwordfield.getPassword());
         pstm.setString(1,email);
         pstm.setString(2,name);
         pstm.setString(3,age);
         pstm.setString(3,address);
         pstm.setString(4,mobile);
         pstm.setString(5,password);

         pstm.execute();
         System.out.println("Data inserted");
         con.close();

      }
      catch(Exception e){
         e.printStackTrace();
      }
    }
    public void readData(){
      try{
         String str = "kiran@gmail";
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project","root","Admin@2816");
         String query = "SELECT * FROM patient WHERE email = ?";
         PreparedStatement stm = con.prepareStatement(query);
         stm.setString(1, str);
         
         ResultSet rs = stm.executeQuery();

         while(rs.next()){
            System.out.println("email = "+ rs.getString(1));
            System.out.println("name = "+ rs.getString(2));
            System.out.println("age = "+ rs.getString(3));
            System.out.println("address = "+ rs.getString(4));
            System.out.println("mobile = "+ rs.getString(5));
            System.out.println("password = "+ rs.getString(6));
         }
         System.out.println("Read completed");
      }
      catch(SQLException e){
         e.printStackTrace();
      }
    }
}
