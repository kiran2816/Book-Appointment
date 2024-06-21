import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CasePaper {
    
    String email;
    String name;
    String age;
    String address;
    String mobile;

    public static void main(String[] args){
       CasePaper obj1 = new CasePaper();
    }

    CasePaper(){
        try{          
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project","root","Admin@2816");
            
             String emailstr = "kiran@gmail";
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM patient WHERE email = ?");
            pstm.setString(1,emailstr);

            ResultSet rs =  pstm.executeQuery();

            while(rs.next()){
                 email = rs.getString(1);
                 name =  rs.getString(2);
                 age = rs.getString(3);
                 address = rs.getString(4);
                 mobile = rs.getString(5);

                 System.out.println(email);
                 System.out.println(name);
                 System.out.println(age);
                 System.out.println(address);
                 System.out.println(mobile);
                 
            }
             
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
