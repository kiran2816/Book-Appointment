import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class HomePage implements ActionListener {
    JFrame firstframe;
    JButton loginbutton;
    JLabel infolabel;
    Timer timer;
    int x =400;
    public static void main(String[] args){
    HomePage classObj = new HomePage();
    }

    HomePage(){
        firstframe = new JFrame("Home Page");
        

        Border border = BorderFactory.createLineBorder(Color.GRAY, 4,true);

        // adding background image
        ImageIcon img = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Login.jpg");
        JLabel background = new JLabel(img);
        background.setBounds(0,0,400,500);
        firstframe.add(background);

        // creating label for showing information
        infolabel = new JLabel("Kindly Register if your new here otherwise go for login");
        infolabel.setBounds(30,60,500,30);
        
        //colouring to info label
        infolabel.setForeground(Color.BLACK);
        background.add(infolabel);        
        infolabel.setFont(new Font(null,Font.BOLD,16));


        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == timer) {
                    // Update the X coordinate
                    x -= 1; // Change this value to adjust the speed
                    infolabel.setLocation(x, 20);
        
                    // If the label reaches the left end, reset its position to the right end
                    if (x == -400) {
                        x = 350; // Assuming frame width is 500
                    }
                }
            }
        });
        timer.start();        
        

        // creating jbutton for loging
        loginbutton = new JButton("Login");
        loginbutton.setBounds(150,100,90,30);
        loginbutton.setFont(new Font("null",Font.BOLD,14));
        loginbutton.setBackground(Color.WHITE);
        loginbutton.setForeground(Color.BLACK);
        loginbutton.setBorder(border);
        background.add(loginbutton);

        // calling login frame
        loginbutton.addActionListener(this);

        //creating jbutton for register
        JButton registerbutton = new JButton("Register");
        registerbutton.setBounds(150,150,90,30);
        registerbutton.setFont(new Font(null,Font.BOLD,14));
        registerbutton.setBackground(Color.WHITE);
        registerbutton.setForeground(Color.BLACK);
        registerbutton.setBorder(border);
        background.add(registerbutton);

        //calling register frame
        registerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registration();
                firstframe.dispose();
            }
        });

        // doctors info
        JButton doctors = new JButton("Doctor");
        doctors.setBounds(150,200,90,30);
        doctors.setFont(new Font(null,Font.BOLD,14));
        doctors.setBackground(Color.WHITE);
        doctors.setForeground(Color.BLACK);
        doctors.setBorder(border);
        background.add(doctors);


        //calling doctors page by clicking doctors button
        doctors.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            if(doctors.isVisible()){
                new Doctors();
                firstframe.dispose();
            }
           } 
        });

        // adding facility button 
        JButton facility = new JButton("Facility");
        facility.setBounds(150,250,90,30);
        facility.setFont(new Font(null,Font.BOLD,14));
        facility.setForeground(Color.BLACK);
        facility.setBackground(Color.WHITE);
        facility.setBorder(border);
        background.add(facility);

        facility.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(facility.isVisible()){
                    new Facility();
                    firstframe.dispose();
                }
            }
        });


        firstframe.setSize(400,500);
        firstframe.setLayout(null);
        firstframe.setLocationRelativeTo(null);
        firstframe.setVisible(true);
        firstframe.setDefaultCloseOperation(firstframe.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login();
        firstframe.dispose();
    }
      
}
