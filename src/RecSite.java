import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Object;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Container;

import javax.swing.filechooser.*;
import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class RecSite {
    public JButton uploadStatementButton = new JButton("Upload Statement");
    public  JButton updateNeedsButton = new JButton("Update");
    public  JPanel panel1 = new JPanel(null);
    public  JButton logoutButton = new JButton("Logout");

    public RecSite() {
        
        uploadStatementButton.setPreferredSize(new Dimension(150, 50));
        updateNeedsButton.setPreferredSize(new Dimension(150, 50));
        logoutButton.setPreferredSize(new Dimension(150, 50));
        panel1.setPreferredSize(new Dimension(500,80));
        panel1.setLayout(new FlowLayout());
        panel1.add(updateNeedsButton);
        panel1.add(uploadStatementButton);
        panel1.add(logoutButton);
        
        uploadStatementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooseFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                chooseFile.setDialogTitle("Choose a file.");
                chooseFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                String file;
                int returnValue = chooseFile.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    if (chooseFile.getSelectedFile().isFile()) {
                        System.out.println("You selected the file: " + chooseFile.getSelectedFile());
                        file = "" + chooseFile.getSelectedFile();
                        ArrayList<Transaction> transactions = new ArrayList<>();
                        PDFParser parse = new PDFParser(file);
                		transactions = parse.getTransactions();
                		MainFrame.addCategory(transactions);
                		ArrayList<Category> tester = new ArrayList<Category>();
                		tester = MainFrame.getReport(transactions);
                		Login.recievers.get(Login.index).setReport(tester);
                		System.out.println("Testone");
                    }
                }
                
            }
            
        });

        updateNeedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new NeedsSite();
                JFrame frame = new JFrame("NeedsSite");
                frame.setContentPane(new NeedsSite().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new Login();
                JFrame frame = new JFrame("Login");
                frame.setContentPane(new Login().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}
