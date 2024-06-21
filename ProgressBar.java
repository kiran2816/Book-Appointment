import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ProgressBar implements ActionListener {
    
    int i =0;
    JFrame frame;
    JProgressBar bar;
    JLabel ilabel;
    public static void main(String[] argd){
        ProgressBar obj = new ProgressBar();
    }
    ProgressBar(){
        frame = new JFrame();

        JLabel label = new JLabel("Please Wait.....");
        label.setBounds(80,80,120,20);
        label.setFont(new Font(null,Font.BOLD,16));     
        frame.add(label);


        bar = new JProgressBar(0,100);
        bar.setBounds(80,110,150,10);
        bar.setValue(100);
        frame.add(bar);

        ilabel = new JLabel();
        ilabel.setBounds(140,125,30,20);
        frame.add(ilabel);

        Timer timer = new Timer(100, this);
        timer.start();

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setSize(300,300);
        frame.setVisible(true);       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(i == 100){
        new Login();
        frame.dispose();
       }
        i++;
        bar.setValue(i);
        ilabel.setText(i+"%");
    }
    
}
