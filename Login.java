import java.util.Random;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class Login {

    Appointment appointmentobj;
    String loginemail;
    JFrame loginframe;
    JTextField emailfield;
    JPasswordField passwordfield;
    JLabel movinglabel;
    Timer timer;
    int x = 400; // Initial X coordinate of the label
    String repassword;
    String emailstr;
    String passwordstr;
    JButton otpbutton;
    JTextField otpfield;
    JFrame updateframe;
    JFrame otpframe;
    int otpnumber;

    public static void main(String[] args) {
        Login obj = new Login();
    }

    Login() {
        loginframe = new JFrame("Login page");
        Border b = BorderFactory.createLineBorder(Color.pink, 4, true);

        loginframe.setLayout(null);
        loginframe.setSize(400, 500);

        // adding image to login frame
        ImageIcon img = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Homepage.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 400, 500);
        loginframe.add(background);

        // login label
        movinglabel = new JLabel("For book appointment please enter your valid details");
        movinglabel.setBounds(10, 50, 500, 30);
        movinglabel.setFont(new Font(null, Font.BOLD, 16));

        movinglabel.setForeground(Color.BLACK);
        background.add(movinglabel);

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == timer) {
                    // Update the X coordinate
                    x -= 1; // Change this value to adjust the speed
                    movinglabel.setLocation(x, 20);

                    // If the label reaches the left end, reset its position to the right end
                    if (x == -400) {
                        x = 400; // Assuming frame width is 500
                    }
                }
            }
        });
        timer.start();

        // email ID label
        JLabel emailidlabel = new JLabel("Email ID :-");
        emailidlabel.setBounds(10, 150, 100, 20);
        emailidlabel.setFont(new Font(null, Font.BOLD, 14));
        background.add(emailidlabel);

        // adding textfield for emailid
        emailfield = new JTextField();
        emailfield.setBounds(100, 150, 150, 20);
        background.add(emailfield);

        loginemail = emailfield.getText();

        // emailstr = emailfield.getText();

        // adding label for password
        JLabel passwordlabel = new JLabel("Password :-");
        passwordlabel.setBounds(10, 180, 100, 20);
        passwordlabel.setFont(new Font(null, Font.BOLD, 14));
        background.add(passwordlabel);

        // adding passwordfield for password
        passwordfield = new JPasswordField();
        passwordfield.setBounds(100, 180, 150, 20);
        background.add(passwordfield);

        repassword = new String(passwordfield.getPassword());

        // moving to next textfield by pressing enter
        emailfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordfield.requestFocus();
                }
            }
        });

        passwordfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    emailfield.requestFocus();
                }
            }
        });

        JButton forget = new JButton("Forget password");
        forget.setBounds(100, 200, 100, 20);
        forget.setFont(new Font(null, Font.BOLD, 8));
        forget.setBackground(Color.WHITE);
        background.add(forget);

        forget.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginframe.dispose();

                otpframe = new JFrame("Security");
                otpframe.setSize(300, 300);

                // back button
                JButton back = new JButton("<--");
                back.setBounds(0, 10, 50, 15);
                back.setBackground(Color.WHITE);
                otpframe.add(back);

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new Login();
                    }
                });

                JLabel otplabel = new JLabel("Enter OTP here below");
                otplabel.setBounds(75, 50, 150, 30);
                otpframe.add(otplabel);

                otpfield = new JTextField();
                otpfield.setBounds(75, 80, 100, 20);
                otpframe.add(otpfield);

                JButton okbutton = new JButton("OK");
                okbutton.setFont(new Font(null, Font.BOLD, 7));
                okbutton.setBounds(175, 80, 50, 19);
                otpframe.add(okbutton);

                otpbutton = new JButton("Get OTP");
                otpbutton.setFont(new Font(null, Font.BOLD, 7));
                otpbutton.setBounds(75, 110, 70, 20);
                otpframe.add(otpbutton);

                otpbutton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (otpbutton.isVisible() && otpbutton.getParent().isVisible()) {
                            Random random = new Random();
                            otpnumber = random.nextInt(9000) + 1000;
                            JOptionPane.showMessageDialog(null,
                                    "Your One-Time-Password for \n change password is : " + otpnumber);
                        }
                        // System.out.println(otpfield.getText());
                        System.out.println(otpnumber);

                        okbutton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (ifMatched()) {
                                    otpframe.dispose();
                                    updateframe = new JFrame("Change password");
                                    updateframe.setLayout(null);
                                    updateframe.setSize(300, 300);

                                    JLabel repassword = new JLabel("Enter new password");
                                    repassword.setBounds(10, 50, 150, 20);
                                    updateframe.add(repassword);

                                    JPasswordField repassword2 = new JPasswordField();
                                    repassword2.setBounds(130, 50, 100, 20);
                                    updateframe.add(repassword2);

                                    JLabel repassword3 = new JLabel("Confirm password");
                                    repassword3.setBounds(10, 80, 150, 20);
                                    updateframe.add(repassword3);

                                    JPasswordField repassword4 = new JPasswordField();
                                    repassword4.setBounds(130, 80, 100, 20);
                                    updateframe.add(repassword4);

                                    repassword2.addKeyListener(new KeyAdapter() {
                                        public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                                repassword4.requestFocus();
                                            }
                                        }
                                    });
                                    repassword4.addKeyListener(new KeyAdapter() {
                                        public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                                repassword2.requestFocus();
                                            }
                                        }
                                    });

                                    // Hide and Show password
                                    JToggleButton show1 = new JToggleButton("Show");
                                    show1.setBounds(230, 50, 60, 19);
                                    show1.setFont(new Font(null, Font.BOLD, 9));
                                    updateframe.add(show1);

                                    JTextField show1field = new JTextField();
                                    show1field.setBounds(130, 50, 100, 20);
                                    show1field.setVisible(false);

                                    JToggleButton show = new JToggleButton("Show");
                                    show.setBounds(230, 80, 60, 19);
                                    show.setFont(new Font(null, Font.BOLD, 9));
                                    updateframe.add(show);

                                    JTextField showfield = new JTextField();
                                    showfield.setBounds(130, 80, 100, 20);
                                    showfield.setVisible(false);

                                    show.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            if (show.isSelected()) {
                                                show.setText("Hide");
                                                show.setFont(new Font(null, Font.BOLD, 10));
                                                repassword4.setVisible(false);
                                                showfield.setText(new String(repassword4.getPassword()));
                                                showfield.setVisible(true);
                                            } else {
                                                show.setText("Show");
                                                show.setFont(new Font(null, Font.BOLD, 9));
                                                showfield.setVisible(false);
                                                repassword4.setText(showfield.getText());
                                                repassword4.setVisible(true);
                                            }
                                        }
                                    });

                                    show1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            if (show1.isSelected()) {
                                                show1.setText("Hide");
                                                show1.setFont(new Font(null, Font.BOLD, 9));
                                                repassword2.setVisible(false);
                                                show1field.setText(new String(repassword2.getPassword()));
                                                show1field.setVisible(true);
                                            } else {
                                                show1.setText("Show");
                                                show1.setFont(new Font(null, Font.BOLD, 9));
                                                show1field.setVisible(false);
                                                repassword2.setText(show1field.getText());
                                                repassword2.setVisible(true);
                                            }
                                        }
                                    });
                                    updateframe.add(showfield);
                                    updateframe.add(show1field);

                                    passwordstr = new String(repassword2.getPassword());
                                    // String repasswordstr = new String(repassword4.getPassword());

                                    JButton confirm = new JButton("Confirm");
                                    confirm.setBounds(130, 100, 70, 20);
                                    confirm.setFont(new Font(null, Font.BOLD, 7));
                                    updateframe.add(confirm);

                                    confirm.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            Password passwordobj = new Password();
                                            String passwordstr = new String(repassword2.getPassword());
                                            String loginemail = emailfield.getText();
                                            String repasswordstr = new String(repassword4.getPassword());
                                            if (e.getSource() == confirm && passwordstr.equals(repasswordstr)
                                                    && passwordobj.password(passwordstr)) {
                                                try {
                                                    Connection con = DriverManager.getConnection(
                                                            "jdbc:mysql://localhost:3308/project", "root",
                                                            "Admin@2816");
                                                    PreparedStatement pstm = con.prepareStatement(
                                                            "update patient set password = ? where email = ?");
                                                    pstm.setString(1, passwordstr);
                                                    pstm.setString(2, loginemail);

                                                    int count = pstm.executeUpdate();
                                                    if (count > 0) {
                                                        JOptionPane.showMessageDialog(null,
                                                                "Password changed sucssesfully!!!");
                                                        System.out.println("DONE");
                                                        new Login();
                                                        updateframe.dispose();
                                                    }
                                                } catch (Exception e1) {
                                                    e1.printStackTrace();
                                                }
                                            }
                                            if (!passwordobj.password(passwordstr)) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Password length should be minimum 8 And it must contains \n 1 Digit, 1 lowercase, 1 uppercase and special character");
                                            }
                                            if (!passwordstr.equals(repasswordstr)) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Password does not match to reEnter password");
                                            }

                                            System.out.println("Email must required");

                                        }
                                    });

                                    // back button
                                    JButton back = new JButton("<--");
                                    back.setBounds(0, 10, 50, 15);
                                    back.setBackground(Color.WHITE);
                                    updateframe.add(back);

                                    back.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            new Login();
                                        }
                                    });

                                    updateframe.setLocationRelativeTo(null);
                                    updateframe.setVisible(true);

                                }

                            }
                        });
                    }
                });

                otpframe.setLocationRelativeTo(null);
                otpframe.setLayout(null);
                otpframe.setVisible(true);

            }

        });

        // back button
        JButton back = new JButton("<--");
        back.setBounds(0, 10, 50, 15);
        back.setBackground(Color.WHITE);
        background.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HomePage();
            }
        });

        // adding login button
        JButton loginbutton = new JButton("Login");
        loginbutton.setBounds(130, 230, 100, 30);
        loginbutton.setFont(new Font(null, Font.BOLD, 16));
        loginbutton.setForeground(Color.BLACK);
        loginbutton.setBackground(Color.WHITE);
        loginbutton.setBorder(b);
        background.add(loginbutton);

        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                String password = "";

                try {

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root",
                            "Admin@2816");
                    String emailstr = emailfield.getText();
                    PreparedStatement stm = con.prepareStatement("SELECT password FROM patient WHERE email=?");
                    stm.setString(1, emailstr);

                    ResultSet rs = stm.executeQuery();
                    while (rs.next()) {

                        password = rs.getString(1);
                        // System.out.println(password);

                    }

                    if (password.equals(new String(passwordfield.getPassword()))) {
                        new Appointment();
                        Appointment.emailstr = emailstr;
                        loginframe.dispose();
                    } else {
                        JOptionPane.showMessageDialog(loginframe,
                                "OOPs It`s seems you enter  wrong information \n kindly provide valid email & password ");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        loginframe.setLocationRelativeTo(null);
        loginframe.setVisible(true);
        loginframe.setDefaultCloseOperation(loginframe.EXIT_ON_CLOSE);
    }

    private boolean ifValid() {
        String str = emailfield.getText();
        String str1 = passwordfield.getText();
        return str.isEmpty() && str1.isEmpty();
    }

    boolean ifMatched() {
        if (String.valueOf(otpnumber).equals(otpfield.getText())) {
            JOptionPane.showMessageDialog(otpframe, "OTP is matched");
            return true;
        }
        if (!String.valueOf(otpnumber).equals(otpfield.getText())) {
            JOptionPane.showMessageDialog(otpframe, "OTP does not matched");
            // return false;
        }

        return false;
    }

    // public void actionPerformed(ActionEvent ae){
    // new HomePage();
    // }
}