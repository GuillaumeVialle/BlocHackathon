import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeedsSite {
    public JPanel panel1 = new JPanel();
    public JLabel label1 = new JLabel("Misc.");
    public JLabel label2 = new JLabel("Groceries");
    public JLabel label3 = new JLabel("Bank");
    public JLabel label4 = new JLabel("Gas/Gas-Station");
    public JLabel label5 = new JLabel("Clothing Store");
    public JLabel label6 = new JLabel("Lodging");
    public JLabel label7 = new JLabel("Pharmacy");
    public JLabel label8 = new JLabel("Urgency");

    public JTextField textField1 = new JTextField();
    public JTextField textField2 = new JTextField();
    public JTextField textField3 = new JTextField();
    public JTextField textField4 = new JTextField();
    public JTextField textField5 = new JTextField();
    public JTextField textField6 = new JTextField();
    public JTextField textField7 = new JTextField();  
    public JTextField textField8 = new JTextField();  
    
    public JButton submitButton = new JButton("Submit");

    public NeedsSite() {
        panel1.setSize(new Dimension(400,300));
        textField1.setPreferredSize(new Dimension(200,30));
        textField2.setPreferredSize(new Dimension(200,30));
        textField3.setPreferredSize(new Dimension(200,30));
        textField4.setPreferredSize(new Dimension(200,30));
        textField5.setPreferredSize(new Dimension(200,30));
        textField6.setPreferredSize(new Dimension(200,30));
        textField7.setPreferredSize(new Dimension(200,30));
        textField8.setPreferredSize(new Dimension(200,30));
        submitButton.setPreferredSize(new Dimension(150,50));;

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(textField2);
        panel1.add(label3);
        panel1.add(textField3);
        panel1.add(label4);
        panel1.add(textField4);
        panel1.add(label5);
        panel1.add(textField5);
        panel1.add(label6);
        panel1.add(textField6);
        panel1.add(label7);
        panel1.add(textField7);
        panel1.add(label8);
        panel1.add(textField8);
        panel1.add(submitButton);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            
            	int amt = Integer.parseInt(textField1.getText());
            	Login.recievers.get(Login.index).updateNeed(0, amt);
            	amt = Integer.parseInt(textField2.getText());
            	Login.recievers.get(Login.index).updateNeed(1, amt);
            	amt = Integer.parseInt(textField3.getText());
            	Login.recievers.get(Login.index).updateNeed(2, amt);
            	amt = Integer.parseInt(textField4.getText());
            	Login.recievers.get(Login.index).updateNeed(3, amt);
            	amt = Integer.parseInt(textField5.getText());
            	Login.recievers.get(Login.index).updateNeed(4, amt);
            	amt = Integer.parseInt(textField6.getText());
            	Login.recievers.get(Login.index).updateNeed(5, amt);
            	amt = Integer.parseInt(textField7.getText());
            	Login.recievers.get(Login.index).updateNeed(6, amt);
            	amt = Integer.parseInt(textField8.getText());
            	Login.recievers.get(Login.index).setUrgency(amt);
            	
                JFrame frame = new JFrame("RecSite");
                frame.setContentPane(new RecSite().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
