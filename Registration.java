import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.SQLIntegrityConstraintViolationException;
public class Registration implements ActionListener {

    JLabel movinglabel;
    JTextField namefield;
    JTextField agefield;
    JTextField mobilefield;
    JTextField emailidfield;
    JTextField dobfield;
    JTextField addharfield;
    JTextArea addressarea;
    JPasswordField passwordfield;
    JPasswordField repassfield;
    Border border2;
    String[] lines = { 
      "*TRETMENTS*", "Viral fever","Diabetes","Nephrology", "Urology","Gastroenterology", "& Hepatology","Cancer (Oncology)","Orthopaedics"};
    Timer timer;
    int y;

    //creating password class object
    Password objpass = new Password();

    public static void main(String[] args){

      JOptionPane.showMessageDialog(null,"If you are new here kindly Register \n        other wise go for Login");
         Registration obj = new Registration();
 

    }
    JRadioButton malebutton;
    JRadioButton femalebutton;
    Registration(){
        // Registration frame
        JFrame frame = new JFrame(" New patient Registration Page");
        Border border = BorderFactory.createLineBorder(Color.GRAY,4,true);
        border2 = BorderFactory.createLineBorder(Color.RED,1,true);

        frame.setSize(400,550);
       
        frame.setLocationRelativeTo(null);
       // frame.setVisible(true);

       // back button
       JButton back = new JButton("<--");
       back.setBounds(0,10,50,15);
        back.setBackground(Color.WHITE);
       frame.add(back);

      back.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new HomePage();
              frame.dispose();
          }
      });

        //creating moving paragrpha
        movinglabel = new JLabel();
       // scrollingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(movinglabel);

       // y = 0; // Initial Y position y=20
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y--;
                if (y < -20 * lines.length) { // Reset position when all lines are out of frame
                    y = 0;
                }
                updateText();
            }
        });
        timer.start();

        // adding background Image
        ImageIcon img = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Registration.png");

        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,400,500);
        frame.add(background);


        frame.setLayout(null);
        
        // Adding Name label 
        JLabel namelabel = new JLabel("Name");
        namelabel.setBounds(40,20,100,20);
        background.add(namelabel);

        //text field
        namefield = new JTextField();
        namefield.setBounds(120,20,100,20);
        background.add(namefield);

       // Adding age label
       JLabel agelabel = new JLabel("Age");
       agelabel.setBounds(40,60,100,20);
       background.add(agelabel);

       //text field
       agefield = new JTextField();
       agefield.setBounds(120,60,100,20);
       background.add(agefield);


       // adding label for male/female
       JLabel malelabel = new JLabel("Male");
       malelabel.setBounds(40,100,50,20);
       JLabel femalelabel = new JLabel("Female");
       femalelabel.setBounds(40,140,50,20);

       background.add(malelabel);
       background.add(femalelabel);
       
       
       //JRadioButton for male/female
        malebutton = new JRadioButton();
        femalebutton = new JRadioButton();
       malebutton.setBounds(120,100,20,20);
       femalebutton.setBounds(120,140,20,20);

       background.add(malebutton);
       background.add(femalebutton);

       malebutton.addActionListener(this);
       femalebutton.addActionListener(this);
       

       // Adding mobile number label
       JLabel mobilelabel = new JLabel("Mobile No");
       mobilelabel.setBounds(40,180,100,20);
       background.add(mobilelabel);

       // text field
       mobilefield = new JTextField();
       mobilefield.setBounds(120,180,100,20);
       background.add(mobilefield);

       // Addig emailid
       JLabel emailidlabel = new JLabel("Email Id");
       emailidlabel.setBounds(40,220,100,20);
       background.add(emailidlabel);

       // text field
       emailidfield = new JTextField();
       emailidfield.setBounds(120,220,100,20);
       background.add(emailidfield);

       // adding date of birth
       JLabel dob = new JLabel("D.O.B.");
       dob.setBounds(40,260,100,20);
       background.add(dob);

       //adding field for dob
       dobfield = new JTextField();
       dobfield.setBounds(120,260,100,20);
       background.add(dobfield);

       // Adding Adharcard number
       JLabel addharlabel = new JLabel("Addhar No");
       addharlabel.setBounds(40,300,100,20);
       background.add(addharlabel);

       // text field
       addharfield = new JTextField();
       addharfield.setBounds(120,300,100,20);
       background.add(addharfield);

       //adderss label
       JLabel addresslabel = new JLabel("Address");
       addresslabel.setBounds(40,340,100,20);
       background.add(addresslabel);

       // text Area address
       addressarea = new JTextArea();
       addressarea.setBounds(120,340,100,50);
       background.add(addressarea);

       addressarea.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_DOWN){
            passwordfield.requestFocus();
          }
          if(e.getKeyCode() == KeyEvent.VK_UP){
            addharfield.requestFocus();
          }
        }
      });

       //password label
       JLabel passwordlabel = new JLabel("Password");
       passwordlabel.setBounds(40,400,100,20);
       background.add(passwordlabel);
              //passwordfield
              passwordfield = new JPasswordField();
              passwordfield.setBounds(120,400,100,20);
             

              // re enter password
              JLabel repasslabel = new JLabel("Confirm Password");
              repasslabel.setBounds(5,430,130,20);
              background.add(repasslabel);

              // Re Enter passwordfield
               repassfield = new JPasswordField();
              repassfield.setBounds(120,430,100,20);
              
              //Hide and Show password
              JToggleButton show1 = new JToggleButton("Show");
              show1.setBounds(220,430,60,19);
              show1.setFont(new Font(null,Font.BOLD,9));
              background.add(show1);

              JTextField show1field = new JTextField();
             show1field.setBounds(120,430,100,20);
             show1field.setVisible(false);
              
       

               JToggleButton show = new JToggleButton("Show");
             show.setBounds(220,400,60,19);
             show.setFont(new Font(null,Font.BOLD,9));
             background.add(show);

             JTextField showfield = new JTextField();
             showfield.setBounds(120,400,100,20);
             showfield.setVisible(false);
             

             show.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e){
                if(show.isSelected()){
                  show.setText("Hide");
                  show.setFont(new Font(null,Font.BOLD,10));
                  passwordfield.setVisible(false);
                  showfield.setText(new String(passwordfield.getPassword()));
                  showfield.setVisible(true);
                }
                else {
                  show.setText("Show");
                  show.setFont(new Font(null,Font.BOLD,9));
                  showfield.setVisible(false);
                  passwordfield.setText(showfield.getText());
                  passwordfield.setVisible(true);
               }
              }
             });

             show1.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e){
                if(show1.isSelected()){
                  show1.setText("Hide");
                  show1.setFont(new Font(null,Font.BOLD,9));
                  repassfield.setVisible(false);
                  show1field.setText(new String(repassfield.getPassword()));
                  show1field.setVisible(true);
                }
                else {
                  show1.setText("Show");
                  show1.setFont(new Font(null,Font.BOLD,9));
                  show1field.setVisible(false);
                  repassfield.setText(show1field.getText());
                  repassfield.setVisible(true);
               }
              }
             });
             background.add(showfield);
             background.add(passwordfield);
             background.add(show1field);
             background.add(repassfield);
             
               
              // adding button and adding image to submit button
              JButton submitbutton = new JButton("SUBMIT");
              submitbutton.setBounds(30,470,100,30);
              submitbutton.setFont(new Font(null,Font.BOLD,14));
              submitbutton.setForeground(Color.BLACK);
              submitbutton.setBackground(Color.WHITE);
              submitbutton.setBorder(border);
              background.add(submitbutton);
       
              
       
              //creating clear button
              JButton clear = new JButton("CLEAR");
              clear.setBounds(150,470,100,30);
              clear.setFont(new Font(null,Font.BOLD,14));
              clear.setForeground(Color.BLACK);
              clear.setBackground(Color.WHITE);
              clear.setBorder(border);
              background.add(clear);
       
              clear.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e){
                 new Registration();
               }
              });

          


        //moving to next textfield by pressing enter
        namefield.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
                  agefield.requestFocus();
              }
          }
      });

  
      agefield.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER){
            mobilefield.requestFocus();
          }
          if(e.getKeyCode() == KeyEvent.VK_UP){
            namefield.requestFocus();
          }
          
        }
      });

      mobilefield.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER){
            emailidfield.requestFocus();
          }
          if(e.getKeyCode() == KeyEvent.VK_UP){
            agefield.requestFocus();
          }
        }
      });

      emailidfield.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent ae){
          if(ae.getKeyCode() == KeyEvent.VK_ENTER || ae.getKeyCode() == KeyEvent.VK_DOWN){
            dobfield.requestFocus();
          }
          if(ae.getKeyCode() == KeyEvent.VK_UP){
            mobilefield.requestFocus();
          }
        }
      });

      dobfield.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN){
            addharfield.requestFocus();
          }
          if(e.getKeyCode() == KeyEvent.VK_UP){
            emailidfield.requestFocus();
          }
        }
      });


      addharfield.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN){
            addressarea.requestFocus();
          }
          if(e.getKeyCode() == KeyEvent.VK_UP){
            dobfield.requestFocus();
          }
        }
      });

      passwordfield.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_UP){
            addressarea.requestFocus();
          }
          if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN){
            repassfield.requestFocus();
          }
        }
      });

      repassfield.addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
          if(e.getKeyCode() == KeyEvent.VK_UP){
            passwordfield.requestFocus();
          }
        }
      });
       
              // Calling to login page if field are filled And password full fill criteria
              submitbutton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e){
                 
                  if(!ifValid()){
                    JOptionPane.showMessageDialog(frame, "Sorry you can not move forward" +'\n'+ "Patient need to filled every information");
                    }
                  if(!objpass.password(new String(passwordfield.getPassword()))){
                      JOptionPane.showMessageDialog(frame, "Password length should be minimum 8 And it must contains \n 1 Digit, 1 lowercase, 1 uppercase and special character");
                    }
                    if(!ifValid1()){
                      JOptionPane.showMessageDialog(frame,"Passowrd and confirm password does not match");
                    }
                  if(objpass.password(new String(passwordfield.getPassword())) && ifValid() && ifValid1()){
                      JOptionPane.showMessageDialog(frame,"Your password is strong");
                     
                      try{

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project","root","Admin@2816");
                        PreparedStatement pstm = con.prepareStatement("INSERT INTO patient (email,name,age,address,mobile,password) VALUES(?,?,?,?,?,?)");
                        String email = emailidfield.getText();
                        String name = namefield.getText();
                        String age = agefield.getText();
                        String address = addressarea.getText();
                        String mobile = mobilefield.getText();
                        String password = new String(passwordfield.getPassword());

                        pstm.setString(1, email);
                        pstm.setString(2,name);
                        pstm.setString(3,age);
                        pstm.setString(4,address);
                        pstm.setString(5,mobile);
                        pstm.setString(6,password);

                        pstm.execute();
                        System.out.println("Data inserted sucsessfully.");
                        con.close();
                        
                      }
                      catch(Exception e1){
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(frame,"ID already exists");
                      }
                      new ProgressBar();
                      frame.dispose();
                    }
               }
              });


         frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    private void updateText() {
      StringBuilder textBuilder = new StringBuilder();
      int startIndex = Math.max(0, -y / 20);
      int endIndex = Math.min(lines.length, startIndex+5);
      for (int i = startIndex; i < endIndex; i++) {
          textBuilder.append(lines[i]);
          textBuilder.append("<br>"); // Add line break for HTML rendering
      }
      movinglabel.setText("<html>" + textBuilder.toString() + "</html>");
      movinglabel.setBounds(250, y-50, 280, 500); // Adjust label bounds
  }

    // @Override
    public void actionPerformed(ActionEvent e) {
        if(malebutton.isSelected()){
            malebutton.setSelected(true);
            femalebutton.setSelected(false);
        }
  
    }
    
      boolean ifValid(){
        //String[] str = {namefield.getText(),agefield.getText(),mobilefield.getText(),emailidfield.getText(),addharfield.getText(),addressarea.getText()};        
        JTextField[] str = {namefield,agefield,mobilefield,emailidfield,dobfield,addharfield};        
        int n = 0;
        for(int i=0; i<str.length; i++){
          String s = str[i].getText();
          if(s.isEmpty()){ 
            str[i].setBorder(border2);
            n++;
          }
          if(addressarea.getText().isEmpty()){
            addressarea.setBorder(border2);
            n++;
          }
          
        }   

          if(n>0){
            return false;
          }

        return true;
      }

      boolean ifValid1(){
        if(new String(passwordfield.getPassword()).equals(new String(repassfield.getPassword()))){
         return true;
        }
        return false;
      }


}