import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class DonorLogin {
    public  JPanel panel1 = new JPanel(null);
    public  JTextField username = new JTextField();
    public  JButton loginButton = new JButton("Login");
    private JPasswordField password = new JPasswordField();

    public DonorLogin() {
    	
    	panel1.setSize(new Dimension(400,300));
    	username.setPreferredSize(new Dimension(200,30));
    	password.setPreferredSize(new Dimension(200,30));
        loginButton.setPreferredSize(new Dimension(150,50));
        panel1.add(username);
        panel1.add(password);
        panel1.add(loginButton);
    	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	String email = username.getText();
            	String pwd = password.getText();
            	boolean test = false;
            	for (Donor d : Login.donors) {
            		if(d.getEmail().equals(email)) {
            			if(d.getPassword().equals(pwd)) {
            				test=true;
            				Login.index=Login.donors.indexOf(d);
            				break;
            			}
            		}
            	}
            	if(!test) {
            		Donor newOne = new Donor(email, pwd);
            		Login.donors.add(newOne);
            		Login.index=Login.donors.indexOf(newOne);
            	}
            	
            	//System.out.println("Welcome!");
            	//System.out.println(Login.donors.toString());
            	JFrame frame = new JFrame("DonorSite");
                frame.setContentPane(new DonorSite().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        username.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                String usrName=username.getText();
            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {

            }
        });
        password.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                String usrName=password.getText();
            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {

            }
        });
    }
}
