import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;


public class Main {
    private static void createAndShowGUI() {
        //window visual
        JFrame jFrame = new JFrame("Java Talking Tacos");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(400, 260);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //place an order boder and intilazation of button
        JButton orderButton = new JButton("Place an Order");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Orders.orders();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        });
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        orderButton.setBorder(border);
        orderButton.setPreferredSize(new Dimension(150, 100));
        
        //BUTTON SETUP
        orderButton.setText("Place an Order");
        //orderButton.setBackground(Color.);
        orderButton.setHorizontalAlignment(JButton.CENTER);
        orderButton.setVerticalAlignment(JButton.CENTER); 
        
        
        //Employee button border and intilization
        JButton employeeButton = new JButton("Employee");
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Admin.admin();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        Border employeeBorder = BorderFactory.createLineBorder(Color.BLACK);
        employeeButton.setBorder(employeeBorder);
        employeeButton.setPreferredSize(new Dimension(80, 25));
        
        //BUTTON SETUP     
        employeeButton.setText("Employee");
        employeeButton.setHorizontalAlignment(JButton.CENTER);
        employeeButton.setVerticalAlignment(JButton.CENTER);
        
        
        //add label that tells user to use termial
        JLabel notice = new JLabel("After Clicking\n please procced to Terminal.");     
        notice.setText("After Clicking please procced to Terminal.");
        notice.setHorizontalAlignment(JLabel.LEFT);
        notice.setVerticalAlignment(JLabel.BOTTOM);

        //make grid to orginize better
        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //controlPanel.setLayout(new GridLayout(5,1));
    
        //MAKE IT VISABLE and set postion
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridx = 0;
        c.insets = new Insets(0,0,0,0);
        controlPanel.add(orderButton, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5,10,0,10);
        controlPanel.add(employeeButton, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10,0,0,0);
        controlPanel.add(notice, c);

        jFrame.add(controlPanel);
        jFrame.setVisible(true);
        
    
    }
    
    public static void main(String[] args) {
        createAndShowGUI();
        
    }
    
}
