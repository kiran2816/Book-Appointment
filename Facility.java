import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Facility {
    public static void main(String[] args) {
        Facility obj = new Facility();
    }

    Facility() {
        JFrame frame = new JFrame("Responsbility We serve");
        frame.setLayout(null);

        frame.setSize(650, 10000);
       
        // adding label
        JLabel info = new JLabel("Types of Healthcare Facilities Where ");
        JLabel info1 = new JLabel("Medical Professionals Provide Care");
        info.setBounds(10, 25, 600, 30);
        info1.setBounds(10, 50, 600, 30);
        info.setFont(new Font(null, Font.BOLD, 18));
        info1.setFont(new Font(null, Font.BOLD, 18));
        frame.add(info1);
        frame.add(info);

        // Ambulance
        JLabel ambulancelabel = new JLabel("1. Ambulatory surgical centers");
        ambulancelabel.setBounds(5, 85, 600, 20);
        ambulancelabel.setFont(new Font(null, Font.BOLD, 16));
        ambulancelabel.setForeground(Color.RED);
        frame.add(ambulancelabel);
        String ambulancestr = "<HTML> Ambulatory surgical centers, also called outpatient surgical facilities, allow patients to receive certain surgical procedures outside a hospital environment. These environments often offer surgeries at a lower cost than hospitals while also reducing the risk of exposure to infection—since patients are there for surgery, not to recover from sickness and disease.\r\n"
                + //
                "Ambulatory surgical centers don’t provide diagnostic services or clinic hours. Instead, they take patients who have been referred for surgery by a hospital or physician—they’re designed to be “all business” when it comes to surgical care.</HTML>";

        JLabel ambulance = new JLabel(ambulancestr);
        ambulance.setBounds(5, 105, 600, 100);
        frame.add(ambulance);

        // blood bank
        JLabel bloodlabel = new JLabel("2. Blood banks");
        bloodlabel.setBounds(5, 215, 600, 20);
        bloodlabel.setFont(new Font(null, Font.BOLD, 16));
        bloodlabel.setForeground(Color.RED);
        frame.add(bloodlabel);

        JLabel blood = new JLabel(
                "<HTML>Blood banks allow donors to donate blood and platelets while also storing and sorting blood into components that can be used most effectively by patients.\r\n"
                        + //
                        "\r\n" + //
                        "“Red blood cells carry oxygen, platelets help the blood clot and plasma has specific proteins that allows proper regulation of coagulation and healing,” writes the American Society of Hematology. Sometimes patients need these particular components specifically, and sometimes they just need lots of blood. </HTML>");

        blood.setBounds(5, 230, 600, 100);
        frame.add(blood);

        // Clinics and medical
        JLabel cliniclabel = new JLabel("3. Clinics and medical offices");
        cliniclabel.setBounds(5, 330, 600, 20);
        cliniclabel.setFont(new Font(null, Font.BOLD, 16));
        cliniclabel.setForeground(Color.RED);
        frame.add(cliniclabel);

        JLabel clinic = new JLabel(
                "<HTML> The definition of a clinic is “a facility for diagnosis and treatment of outpatients.” There are many healthcare facilities that fit that definition across a wide variety of treatment specialties.\r\n"
                        + //
                        "\r\n" + //
                        "Many people go to a clinic for routine doctor’s appointments and checkups. These healthcare facilities can be a physician’s private practice, a group practice setting or a corporately owned clinic that may be connected to a larger healthcare system or hospital.\r\n"
                        + //
                        "\r\n" + //
                        "Clinics cover a lot of ground in healthcare. For example, you could visit a dental clinic to have a toothache investigated.</HTML>");
        clinic.setBounds(5, 350, 600, 100);
        frame.add(clinic);

        // Diabetic center
        JLabel diabeticlabel = new JLabel("4.  Diabetes education centers");
        diabeticlabel.setBounds(5, 460, 600, 20);
        diabeticlabel.setFont(new Font(null, Font.BOLD, 16));
        diabeticlabel.setForeground(Color.RED);
        frame.add(diabeticlabel);

        JLabel diabetic = new JLabel(
                "<HTML>Diabetes is a very serious illness in the United States. Over 30 million people have diabetes and many of them don’t know it, reports the Centers for Disease Control (CDC). Additionally, over a third of the national population is highly at risk for diabetes, in a condition called prediabetes.\r\n"
                        + //
                        "\r\n" + //
                        "Patients with diabetes need to manage the disease and typically make lifestyle adjustments to keep it from becoming life-threatening. Since diabetes is so widespread, diabetes education centers rose up to help patients manage their disease and to help people at risk for diabetes to avoid it, if possible. </HTML>");

        diabetic.setBounds(5, 480, 600, 100);
        frame.add(diabetic);

        // Birth center
        JLabel birthlabel = new JLabel("5.  Birth centers");
        birthlabel.setBounds(5, 590, 600, 20);
        birthlabel.setFont(new Font(null, Font.BOLD, 16));
        birthlabel.setForeground(Color.RED);
        frame.add(birthlabel);

        JLabel birth = new JLabel(
                "<HTML> A birth center is a healthcare facility for childbirth that focuses on the midwifery model, according to the American Association of Birth Centers. They aim to create a birth environment that feels more comfortable to the mother and allows for a cost-effective, family-inclusive birth.\r\n"
                        + //
                        "\r\n" + //
                        "Birth centers are not typically equipped with the same contingency equipment and staff as a hospital, such as surgeons in case of a C-section or a neonatal intensive care unit. As a result, birth centers accommodate only healthy pregnancies without any known risk or complication factors. </HTML>");

        birth.setBounds(5, 610, 600, 100);
        frame.add(birth);

        // dialysis center
        JLabel dialysislabel = new JLabel("6. Dialysis Centers");
        dialysislabel.setBounds(5, 720, 600, 20);
        dialysislabel.setFont(new Font(null, Font.BOLD, 16));
        dialysislabel.setForeground(Color.RED);
        frame.add(dialysislabel);

        JLabel dialysis = new JLabel(
                "<html> Patients with kidney disease often need regular treatments of dialysis. Dialysis is a process that filters and cleans the blood artificially—the work functioning kidneys normally take on. About 14 percent of Americans have chronic kidney disease. When kidneys aren’t able to filter the blood the way they are supposed to, patients might need dialysis as often as three times a week to avoid serious complications. With such high demand, dialysis facilities rose up to meet patient needs and avoid undue strain on hospitals.</Html>");
        dialysis.setBounds(5, 740, 600, 100);
        frame.add(dialysis);

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

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
