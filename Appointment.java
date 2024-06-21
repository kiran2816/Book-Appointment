import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.LineBorder;

public class Appointment implements ActionListener {
    // private static final int EXIST_ON_CLOSE = 0;
    static String emailstr;
    static Login loginobj;
    static String name;
    static String age;
    static String mobile;
    static String address;
    static int number;
    static String timeslot;
    static JTextField datefield;
    static Appointment classObj;
    JTextField namefield;
    JTextField emailfield;
    JFrame frame;
    private JLabel scrollingLabel;
    private Timer timer;
    private String[] lines = {
            "*SPECIAL CARE*",
            "Affordable Medicines at 50% lower",
            "cost are available at out",
            "inhouse Generic medicine Store.",
            " ",
            "AFFORDABLE OPD CHARGES",
            "OPD charges are INR 300",
            "for well KnownDoctors and INR",
            "150 for Followup within a Month.",
            "State of the art equipment ",
            "combined with modern technologies .",
            "Quality healthcare Services backed by",
            "highly qualified doctors and specialists."
    };
    int y = 0;

    public static void main(String[] ars) {
        Appointment classObj = new Appointment();
    }

    Appointment() {
        frame = new JFrame("Book Appointment");
        frame.setSize(500, 550);

        // setting border color to white for every button
        Border border = BorderFactory.createLineBorder(Color.GRAY, 4, true);
        Border b = BorderFactory.createLineBorder(Color.RED, 1, true);

        // creating moving paragrpha
        scrollingLabel = new JLabel();
        // scrollingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(scrollingLabel);

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

        // adding image to background
        ImageIcon img = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Appointment.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 500, 550);
        frame.add(background);

        // adding Heading
        JLabel heading = new JLabel("Skip the waiting room");
        JLabel heading1 = new JLabel("Consult with a doctor.");
        heading.setBounds(10, 10, 400, 50);
        heading1.setBounds(10, 40, 400, 50);
        heading.setFont(new Font(null, Font.BOLD, 22));
        heading1.setFont(new Font(null, Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        heading1.setForeground(Color.BLACK);
        background.add(heading);
        background.add(heading1);

        // //adding label for name
        // JLabel namelabel = new JLabel("Name (full)");
        // namelabel.setBounds(10,100,100,20);
        // // lastdatelabel.setFont(new Font(null,Font.BOLD, 14));
        // background.add(namelabel);

        // adding Department label;
        JLabel departlabel = new JLabel("Which department would you like");
        departlabel.setBounds(10, 100, 250, 20);
        background.add(departlabel);

        JLabel departlabel2 = new JLabel("to get appointment");
        departlabel2.setBounds(10, 120, 120, 20);
        background.add(departlabel2);

        // adding textfield for department
        JTextField departfield = new JTextField();
        departfield.setBounds(130, 120, 100, 20);
        background.add(departfield);

        // text field for procedure
        JLabel procedurelabel = new JLabel("Which procedure do you want");
        procedurelabel.setBounds(10, 150, 200, 20);
        background.add(procedurelabel);

        // text field for procedure
        JLabel procedurelabel2 = new JLabel("to make appointment for");
        procedurelabel2.setBounds(10, 170, 150, 20);
        background.add(procedurelabel2);

        // adding Jcombobox for procedure
        String[] procedure = { "Medical Examination", "Doctor Check", "Result Analysis", "Check-up" };
        JComboBox procedurebox = new JComboBox<>(procedure);
        procedurebox.setBounds(10, 190, 150, 20);
        background.add(procedurebox);

        // adding label to problem
        JLabel problemlabel = new JLabel("Problem");
        problemlabel.setBounds(10, 230, 100, 20);
        // problemlabel.setFont(new Font(null,Font.BOLD, 14));
        background.add(problemlabel);

        // adding textfield to problem
        JTextField problemfield = new JTextField();
        problemfield.setBounds(100, 230, 100, 20);
        background.add(problemfield);

        // adding label for blood group type
        JLabel bloodlabel = new JLabel("Blood group type");
        bloodlabel.setBounds(10, 260, 100, 20);
        background.add(bloodlabel);

        // adding blood group JComboBox
        String[] blood = { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" };
        JComboBox bloodgroupbox = new JComboBox<>(blood);
        bloodgroupbox.setBounds(120, 260, 80, 20);
        background.add(bloodgroupbox);

        // adding date label
        JLabel datelabel = new JLabel("Date (D/M/YY)");
        datelabel.setBounds(10, 290, 100, 20);
        background.add(datelabel);

        // adding field for date
        datefield = new JTextField();
        datefield.setBounds(100, 290, 100, 20);
        background.add(datefield);

        // adding label for choose time text
        JLabel timelabel = new JLabel("Select time slot");
        timelabel.setBounds(10, 320, 200, 20);
        timelabel.setFont(new Font(null, Font.BOLD, 16));
        timelabel.setForeground(Color.BLACK);
        background.add(timelabel);

        // adding button for time slot
        JButton slotbutton1 = new JButton();
        JButton slotbutton2 = new JButton();
        JButton slotbutton3 = new JButton();
        JButton slotbutton4 = new JButton();
        JButton slotbutton5 = new JButton();
        JButton slotbutton6 = new JButton();

        slotbutton1.setBounds(5, 350, 100, 20);
        slotbutton2.setBounds(105, 350, 100, 20);
        slotbutton3.setBounds(5, 375, 100, 20);
        slotbutton4.setBounds(105, 375, 100, 20);
        slotbutton5.setBounds(5, 400, 100, 20);
        slotbutton6.setBounds(105, 400, 100, 20);

        slotbutton1.setText("10 to 10:30");
        slotbutton2.setText("10:30 to 11");
        slotbutton3.setText("11 to 11:30");
        slotbutton4.setText("11:30 to 12");
        slotbutton5.setText("12 to 12:30");
        slotbutton6.setText("12:30 to 01");

        background.add(slotbutton1);
        background.add(slotbutton2);
        background.add(slotbutton3);
        background.add(slotbutton4);
        background.add(slotbutton5);
        background.add(slotbutton6);

        slotbutton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotbutton1.setBorder(b);

                slotbutton2.setBorder(border);
                slotbutton3.setBorder(border);
                slotbutton4.setBorder(border);
                slotbutton5.setBorder(border);
                slotbutton6.setBorder(border);

                timeslot = "10 to 10:30 AM";
                // System.out.println(timeslot);

            }
        });

        slotbutton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotbutton2.setBorder(b);

                slotbutton1.setBorder(border);
                slotbutton3.setBorder(border);
                slotbutton4.setBorder(border);
                slotbutton5.setBorder(border);
                slotbutton6.setBorder(border);

                timeslot = "10:30 to 11 AM";
                System.out.println(timeslot);
            }
        });

        slotbutton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotbutton3.setBorder(b);

                slotbutton1.setBorder(border);
                slotbutton2.setBorder(border);
                slotbutton4.setBorder(border);
                slotbutton5.setBorder(border);
                slotbutton6.setBorder(border);

                timeslot = "11 to 11:30 AM";
                System.out.println(timeslot);
            }
        });

        slotbutton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotbutton4.setBorder(b);

                slotbutton1.setBorder(border);
                slotbutton2.setBorder(border);
                slotbutton3.setBorder(border);
                slotbutton5.setBorder(border);
                slotbutton6.setBorder(border);

                timeslot = "11:30 to 12 AM";
                System.out.println(timeslot);
            }
        });

        slotbutton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotbutton5.setBorder(b);

                slotbutton1.setBorder(border);
                slotbutton2.setBorder(border);
                slotbutton4.setBorder(border);
                slotbutton3.setBorder(border);
                slotbutton6.setBorder(border);

                timeslot = "12 to 12:30 AM";
                System.out.println(timeslot);
            }
        });

        slotbutton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotbutton6.setBorder(b);

                slotbutton1.setBorder(border);
                slotbutton2.setBorder(border);
                slotbutton4.setBorder(border);
                slotbutton5.setBorder(border);
                slotbutton3.setBorder(border);

                timeslot = "12:30 to 01 AM";
                System.out.println(timeslot);
            }
        });

        // move to next field by enter
        departfield.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    procedurebox.requestFocus();
                }
            }
        });

        procedurebox.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    problemfield.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    departfield.requestFocus();
                }
            }
        });

        problemfield.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    bloodgroupbox.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    procedurebox.requestFocus();
                }
            }
        });

        bloodgroupbox.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    datefield.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    problemfield.requestFocus();
                }
            }
        });

        datefield.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    bloodgroupbox.requestFocus();
                }
            }
        });

        // creating button for generating appointment
        JButton appointbutton = new JButton("Generate appointment");
        appointbutton.setBounds(40, 430, 180, 30);
        appointbutton.setForeground(Color.WHITE);
        appointbutton.setBackground(Color.DARK_GRAY);
        appointbutton.setBorder(border);
        background.add(appointbutton);

        appointbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (appointbutton.isVisible()) {
                    Random random = new Random();
                    number = random.nextInt(200);
                    try {

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root",
                                "Admin@2816");

                        // String emailstr = classObj.emailfield.getText(); //"kiran@gmail";
                        PreparedStatement pstm = con.prepareStatement("SELECT * FROM patient WHERE email = ?");
                        pstm.setString(1, emailstr);

                        ResultSet rs = pstm.executeQuery();

                        while (rs.next()) {
                            String email = rs.getString(1);
                            name = rs.getString(2);
                            age = rs.getString(3);
                            address = rs.getString(4);
                            mobile = rs.getString(5);

                            // System.out.println(email);
                            // System.out.println(name);
                            // System.out.println(age);
                            // System.out.println(address);
                            // System.out.println(mobile);
                        }
                        JFrame frame1 = new JFrame("CasePaper");
                        frame1.setSize(500, 650);

                    
                        // back button
                        JButton back = new JButton("<--");
                        back.setBounds(0, 10, 50, 15);
                        back.setBackground(Color.WHITE);
                        frame1.add(back);

                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                new Appointment();
                                frame1.dispose();
                            }
                        });


                        JLabel hospitallabel = new JLabel("Yashodha");
                        hospitallabel.setBounds(300, 50, 300, 50);
                        hospitallabel.setFont(new Font(null, Font.BOLD, 20));
                        frame1.add(hospitallabel);

                        JLabel photolabel = new JLabel(
                                new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Case paper.png"));
                        photolabel.setBounds(195, 50, 100, 70);
                        frame1.add(photolabel);

                        JLabel photolabel2 = new JLabel("Certified with NABH & QCI");
                        photolabel2.setBounds(10, 70, 200, 30);
                        frame1.add(photolabel2);

                        JLabel hospitalabel = new JLabel("SUPER SPECIALITY HOSPITAL");
                        hospitalabel.setBounds(300, 85, 300, 30);
                        frame1.add(hospitalabel);

                        JLabel line = new JLabel(
                                "-----------------------------------------------------------------------------------------");
                        line.setBounds(50, 125, 450, 10);
                        frame1.add(line);

                        JLabel opdlabel = new JLabel("OPD REGISTRATION");
                        opdlabel.setBounds(160, 135, 300, 20);
                        frame1.add(opdlabel);

                        JLabel line2 = new JLabel(
                                "-----------------------------------------------------------------------------------------");
                        line2.setBounds(50, 150, 450, 10);
                        frame1.add(line2);

                        JLabel uhidno = new JLabel("UHID No. : 54162/2023-2024");
                        uhidno.setBounds(20, 160, 200, 20);
                        frame1.add(uhidno);

                        JLabel namelabel = new JLabel("Patient name  : ");
                        namelabel.setBounds(20, 180, 100, 20);
                        frame1.add(namelabel);

                        JLabel name1 = new JLabel(name);
                        name1.setBounds(120, 180, 100, 20);
                        frame1.add(name1);

                        JLabel agelabel = new JLabel("Age  :  ");
                        agelabel.setBounds(20, 200, 100, 20);
                        frame1.add(agelabel);

                        JLabel age1 = new JLabel(age);
                        age1.setBounds(120, 200, 100, 20);
                        frame1.add(age1);

                        JLabel mobilelabel = new JLabel("Mobile No.  :  ");
                        mobilelabel.setBounds(20, 220, 100, 20);
                        frame1.add(mobilelabel);

                        JLabel mobile1 = new JLabel(mobile);
                        mobile1.setBounds(120, 220, 100, 20);
                        frame1.add(mobile1);

                        JLabel addresslabel = new JLabel("Address  : ");
                        addresslabel.setBounds(20, 240, 100, 20);
                        frame1.add(addresslabel);

                        JLabel address1 = new JLabel(address);
                        address1.setBounds(120, 240, 100, 20);
                        frame1.add(address1);

                        JLabel visitlabel = new JLabel("Visit date  : ");
                        visitlabel.setBounds(20, 260, 100, 20);
                        frame1.add(visitlabel);

                        JLabel visitlabel2 = new JLabel(Appointment.datefield.getText());
                        visitlabel2.setBounds(120, 260, 100, 20);
                        frame1.add(visitlabel2);

                        JLabel timelabel = new JLabel("Visit Time  :");
                        timelabel.setBounds(20, 280, 100, 20);
                        frame1.add(timelabel);

                        JLabel timelabel1 = new JLabel(Appointment.timeslot);
                        timelabel1.setBounds(120, 280, 100, 20);
                        frame1.add(timelabel1);

                        JLabel departlabel = new JLabel("Department   :  ");
                        departlabel.setBounds(20, 300, 100, 20);
                        frame1.add(departlabel);

                        JLabel departlabel1 = new JLabel(departfield.getText());
                        departlabel1.setBounds(120, 300, 100, 20);
                        frame1.add(departlabel1);

                        JLabel typelabel = new JLabel("Patient type  :     General");
                        typelabel.setBounds(20, 320, 200, 20);
                        frame1.add(typelabel);

                        JLabel feeslabel = new JLabel("Registration Fees  :     10");
                        feeslabel.setBounds(20, 340, 200, 20);
                        frame1.add(feeslabel);

                        JLabel tokenlabel = new JLabel("Token No.   :");
                        tokenlabel.setBounds(20, 360, 100, 20);
                        frame1.add(tokenlabel);

                        JLabel tokenlabel2 = new JLabel(String.valueOf(Appointment.number));
                        tokenlabel2.setBounds(120, 360, 100, 20);
                        frame1.add(tokenlabel2);

                        JLabel line3 = new JLabel(
                                "-----------------------------------------------------------------------------------------");
                        line3.setBounds(50, 390, 450, 10);
                        frame1.add(line3);

                        JLabel pagelabel = new JLabel("page 1 of 1");
                        pagelabel.setBounds(410, 590, 100, 20);
                        pagelabel.setFont(new Font(null, Font.BOLD, 10));
                        frame1.add(pagelabel);

                        frame1.setLayout(null);
                        frame1.setVisible(true);
                        frame1.setLocationRelativeTo(null);
                        frame1.setDefaultCloseOperation(frame1.DISPOSE_ON_CLOSE);

                    }

                    catch (SQLException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "You enter something wrong \n please check.");
                    }

                    JOptionPane.showMessageDialog(frame, "Visit agin");

                }
            }
        });

        // creating logout button
        JButton logout = new JButton("Logout / Exit");
        logout.setBounds(40, 470, 100, 30);
        // logout.setFont(new Font(null,Font.BOLD,14));
        logout.setForeground(Color.white);
        logout.setBackground(Color.DARK_GRAY);

        logout.setBorder(border);

        background.add(logout);

        logout.addActionListener(this);

        // back button
        JButton back = new JButton("<--");
        back.setBounds(0, 10, 50, 15);
        back.setBackground(Color.WHITE);
        frame.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                frame.dispose();
            }
        });

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    private void updateText() {
        StringBuilder textBuilder = new StringBuilder();
        int startIndex = Math.max(0, -y / 20);
        int endIndex = Math.min(lines.length, startIndex + 5);
        for (int i = startIndex; i < endIndex; i++) {
            textBuilder.append(lines[i]);
            textBuilder.append("<br>"); // Add line break for HTML rendering
        }
        scrollingLabel.setText("<html>" + textBuilder.toString() + "</html>");
        scrollingLabel.setBounds(250, y - 50, 280, 500); // Adjust label bounds
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new HomePage();
        frame.dispose();
    }

}
