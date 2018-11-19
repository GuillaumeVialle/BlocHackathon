import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

public class Login {
	public static ArrayList<Donor> donors;
	public static ArrayList<Reciever> recievers;
	public static int index;
    public  JButton donorButton = new JButton("Donor");
    public  JButton recipientButton = new JButton("Receipient");
    public  JPanel panel1 = new JPanel(null);

    public Login() {
        donorButton.setPreferredSize(new Dimension(150, 50));
        recipientButton.setPreferredSize(new Dimension(150, 50));
        panel1.setPreferredSize(new Dimension(400,80));
        panel1.setLayout(new FlowLayout());
        panel1.add(donorButton);
        panel1.add(recipientButton);
        
        donorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("DonorLogin");
                frame.setContentPane(new DonorLogin().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true); 
            }
        });
        recipientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("RecLogin");
                frame.setContentPane(new RecLogin().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
    	Donor d1 = new Donor("danvan4477@gmail.com", "1");
        Donor d2 = new Donor("Joe", "Youn", "joeyoun@gmail.com");
        Donor d3 = new Donor("Julie", "Robb", "julierobb@gmail.com");

        Reciever r1 = new Reciever("Ion", "Martin", "ionmartins@gmail.com");
        Reciever r2 = new Reciever("Bronf", "Man", "bronfman@gmail.com");
        Reciever r3 = new Reciever("Jane", "Sommers", "janesommers@gmail.com");

        donors = new ArrayList<Donor>();
        recievers = new ArrayList<Reciever>();

        donors.add(0, d1);
        donors.add(1, d2);
        donors.add(2, d3);
        recievers.add(0, r1);
        recievers.add(1, r2);
        recievers.add(2, r3);

        r1.setDefaultNeeds();
        r2.setDefaultNeeds();
        r3.setDefaultNeeds();
    	
    	JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
