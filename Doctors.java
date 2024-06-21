import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Doctors {
    public static void main(String[] args){
        Doctors obj = new Doctors();
        
    }

    Doctors(){
        JFrame frame = new JFrame("Doctors Information");
        frame.setLayout(null);
        frame.setSize(600,6000);

        JLabel info = new JLabel("Click on Image to know more");
        info.setBounds(50,0,250,20);
        info.setForeground(Color.RED);
        info.setFont(new Font(null,Font.BOLD,16));
        frame.add(info);

        // back button
        JButton back = new JButton("<--");
        back.setBounds(0,10,50,15);
         back.setBackground(Color.WHITE);
        frame.add(back);

       back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new HomePage();
               frame.setVisible(false);
           }
       });

        // adding image for Dr kiran
        ImageIcon kiranimg = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Dr kiranmore.jpg");
        JButton kiranbutton = new JButton(kiranimg);
        kiranbutton.setBounds(0,30,150,100);
        frame.add(kiranbutton);

        JLabel kiranlabel = new JLabel(" Dr kiran more (Hepatology)");
        kiranlabel.setBounds(160,30,300,20);
        kiranlabel.setFont(new Font(null,Font.BOLD,16));

        String kiranstr = "<html>education :-<BR> MBBS, MD, DNB (Gastro), Fellow in Hepatology & Liver Transplanation <BR> language :-<BR> English, Gujarati, Hindi, Marathi </html>";
        
        JLabel kiranlabel2 = new JLabel(kiranstr);
        kiranlabel2.setBounds(160,35,400,100);
    
        frame.getContentPane().add(kiranlabel);
        frame.getContentPane().add(kiranlabel2);

        //adding action listner to kiran more
        kiranbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(kiranbutton.isVisible()){
                    JOptionPane.showMessageDialog(frame,"He has 28 years of experience in him field. \n he has done him MBBS and MD (General Medicine) from King Edward \n Memorial Hospital and Seth Gordhandas Sunderdas Medical College,\n Mumbai (1985 and 1989 respectively) and DNB (Gastroenterology) \n from King Edward Memorial Hospital, Mumbai (1992). Some of the services \n and specializations she provides are Ulcerative Colitis, Hepatitis A, B, C and E, \n Budd Chiari Syndrome, Wilson Disease, Gaucher disease, Portal Hypertension and Liver Transplantation.");
                }
            }
        });


        // adding image to Dr Balraj Pasula
        ImageIcon balrajimg = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Dr balrajpasula.jpg");
        JButton balrajbutton = new JButton(balrajimg);
        balrajbutton.setBounds(0,140,150,100);
        frame.add(balrajbutton);

        JLabel balrajlabel = new JLabel(" Dr Balraj pasula (Pulmonology)");
        balrajlabel.setBounds(160,140,400,20);
        balrajlabel.setFont(new Font(null,Font.BOLD,16));

        String balrajstr = "<html>education <BR> MBBS, MD(Respiratory) <BR> language <BR> English, Hindi<BR> Comfortable with lambadi </html>";
        
        JLabel balrajlabel2 = new JLabel(balrajstr);
        balrajlabel2.setBounds(160,150,400,100);
    
        frame.add(balrajlabel);
        frame.add(balrajlabel2);

        //adding action listeb=ner to balraj pasula
        balrajbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1){
                if(balrajbutton.isVisible()){
                    JOptionPane.showMessageDialog(frame,"With 17 years of experience in diagnosing and treating a \n wide range of respiratory conditions, Dr balraj pasula is one \n of the best pulmonologists in Mumbai. He specialises in diagnosing \nand treating a wide range of respiratory conditions, including seasonal \nAllergies, tuberculosis, fibrosis, Obstructive Sleep Apnea, Chronic Obstructive Pulmonary Disease,\n Asthma, Lung Cancer, Chest Pain, Sleep Disorders and Chronic Pulmonary Disease.\nAs an experienced pulmonologist in Mumbai, Dr balraj uses advanced\n diagnostic techniques such as pulmonary function tests, bronchoscopy, and biopsy\n to identify the root cause of the patient's illness.");
                }
            }
        });

        // adding image to Dr shiwang sharma
        ImageIcon shiwangimg = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Dr shiwangsharma.jpg");
        JButton shiwangbutton = new JButton(shiwangimg);
        shiwangbutton.setBounds(0,250,150,100);
        frame.add(shiwangbutton);

        JLabel shiwanglabel = new JLabel(" Dr Shiwang sharma (Paediatrics)");
        shiwanglabel.setBounds(160,250,400,20);
        shiwanglabel.setFont(new Font(null,Font.BOLD,16));

        String shiwangstr = "<html>education <BR> MBBS, DNB (Paed), FNB (Pead Crit care), MNAMS <BR> language <BR> English, Hindi, Marathi </html>";
        
        JLabel shiwanglabel2 = new JLabel(shiwangstr);
        shiwanglabel2.setBounds(160,260,400,100);
    
        frame.add(shiwanglabel);
        frame.add(shiwanglabel2);

        shiwangbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent d){
                if(shiwangbutton.isVisible()){
                    JOptionPane.showMessageDialog(frame,"Dr shiwang sharma is an experienced paediatrician in Mumbai, with\n over 15 years of experience specialising in growth & development \nevaluation/management, newborn jaundice, chickenpox treatment, and bronchial asthma treatment.\n He has established himself as one of the best paediatricians in Mumbai.\r\n" + //
                                                
                                                "Dr shiwang specialisations include a wide range of conditions that affect children from\n birth up to their teenage years. His expertise covers common \nchildhood illnesses such as chickenpox and bronchial asthma to more\n complex developmental and growth issues. Parents should not hesitate to consult\n Dr shiwang for any concerns related to their child's health." );
                }
            }
        });

        // adding image to Dr santkumar yadav
        ImageIcon kumarimg = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Dr santkumaryadav.jpg");
        JButton kumarbutton = new JButton(kumarimg);
        kumarbutton.setBounds(0,360,150,100);
        frame.add(kumarbutton);

        JLabel kumarlabel = new JLabel(" Dr Santkumar yadav (Ophthalmology)");
        kumarlabel.setBounds(160,360,400,20);
        kumarlabel.setFont(new Font(null,Font.BOLD,16));

        String kumarstr = "<html>education <BR> MBBS, DNB , Fellow in Corneal Transplant surg., Refractive Surg. & Ocular Surface diseases <BR> language <BR> English, Bengali, Hindi, Marathi </html>";
        
        JLabel kumarlabel2 = new JLabel(kumarstr);
        kumarlabel2.setBounds(160,370,400,100);
    
        frame.add(kumarlabel);
        frame.add(kumarlabel2);

        //adding action listener to santkuamr yadav
        kumarbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(kumarbutton.isVisible()){
                    JOptionPane.showMessageDialog(frame,"Dr. santkumar is one of the best ophthalmologists in Mumbai, with extensive \nexperience in providing comprehensive medical assistance. He holds immense knowledge \nfor offering high-quality eye care services to patients.\n His diverse portfolio has allowed him to identify and assist \nin treating severe eye disorders like glaucoma, cataract, age-related disorders, refractive errors,\n eye infections, dry eyes, colour blindness, amblyopia and diabetic retinopathy.");
                }   
            }
        });

        // adding image to Dr prakash kharat
        ImageIcon prakashimg = new ImageIcon("C:\\Users\\pawar\\OneDrive\\Desktop\\Dr prakashkharat.jpg");
        JButton prakashbutton = new JButton(prakashimg);
        prakashbutton.setBounds(0,470,150,100);
        frame.add(prakashbutton);

        JLabel  prakashlabel = new JLabel(" Dr Praksh kharat (Paediatric Endocrinology)");
        prakashlabel.setBounds(160,470,400,20);
        prakashlabel.setFont(new Font(null,Font.BOLD,16));

        String prakashstr = "<html>education <BR> MBBS,MD, PDCCVisiting Fellow RCPCH <BR> language <BR> English, Gujarati, Hindi, Kannada </html>";
        
        JLabel prakashlabel2 = new JLabel(prakashstr);
        prakashlabel2.setBounds(160,470,400,100);
    
        frame.add(prakashlabel);
        frame.add(prakashlabel2);

        //adding action listener to praksh kharat
        prakashbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(prakashbutton.isVisible()){
                    JOptionPane.showMessageDialog(frame,"Dr. prakash: Experienced Paediatric Endocrinologist in Airoli, Apmc-Market-Vashi,\n Belapur, Bonkode, Cbd-Belapur, Chawadi-Naka, Juinagar, Kharghar, Kopar-Khairane, Lodhivali, Mumbai.\r\n" + //
                                                
                                                "Dr. Abhishek Kulkarni a highly regarded Paediatric Endocrinologist with 10+ years of experience,\n practices at Apollo Hospitals CBD Belapur in Mumbai. Dr. Abhishek Kulkarni has completed his MD,\n PDCCVisiting Fellow RCPCH. He offers a wide range of services to address various conditions: \nCongenital Glucose Galactose Malabsorption, Precocious puberty, Congenital adrenal hyperplasia, \nFamilial Glucocorticoid Deficiency, Endocrinology Children.");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
