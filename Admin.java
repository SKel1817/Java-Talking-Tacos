import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Admin {
    public static void admin() throws IOException {
        //declare statment to make scnr statments work
        Scanner scnr = new Scanner(System.in); 
        String name;
        int placeHolder;
        int username;
        int password;
        String clockIn;
        String clockOut;
        //create file for clocking in and out
        Path fileName = Path.of("employeeHours.txt");

        //array for employees make it able to add and remove by manager?
        int num = 4;
        String [] employee = new String[num];
        employee[0] = "Sarah";
        employee[1] = "Valerie";
        employee[2] = "Tony";
        employee[3] = "Jessica";

        //get username and password
        System.out.print("Please Enter username:");
        username = scnr.nextInt();
        System.out.print("\nPlease enter password:");
        password = scnr.nextInt();
        
        if(username == 1 && password == 4321){
            //get the name of employee
            System.out.println("Please select the numer your name is assoicated with");
            for (int i = 0; i < employee.length; ++i){
                System.out.println((i+1) + ". " + employee[i]);
            }
            placeHolder = scnr.nextInt();
            name = employee[placeHolder - 1];
            
            //making an indent
            System.out.println("\n\n\n");
            //clocking in or out?
            System.out.println("Hello, " + name + " are you... (enter the number)");
            System.out.println("1. Clock-in\n2. Clock-out");
            placeHolder = scnr.nextInt();
            
            //clocking in
            if(placeHolder == 1){
                System.out.println("Please enter the current Time");
                clockIn = scnr.next();
                System.out.print("Clocking In");
                
                //writing to file
                String clockInStatment = name + " Clocked in at " + clockIn;
                Files.writeString(fileName, clockInStatment);

                //create new window
                JFrame outFrame = new JFrame("Java Talking Tacos Employee Hours");
                outFrame.setLayout(new FlowLayout());
                outFrame.setSize(500, 160);
                outFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //create text to read clocking in/out statment
                JLabel confirmationDisplay = new JLabel("Clocking In");     
                confirmationDisplay.setText(clockInStatment);
                confirmationDisplay.setHorizontalAlignment(JLabel.LEFT);
                confirmationDisplay.setVerticalAlignment(JLabel.BOTTOM);
                

                //button to get rid of window
                JButton okButton = new JButton("OK");  
                    okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        outFrame.dispose();   
                    }
                });
                //boder of button
                Border border = BorderFactory.createLineBorder(Color.BLACK);
                okButton.setBorder(border);
                okButton.setPreferredSize(new Dimension(50, 25));
                
                //BUTTON SETUP
                okButton.setText("Ok");
                okButton.setHorizontalAlignment(JButton.CENTER);
                okButton.setVerticalAlignment(JButton.CENTER);

                //ADD to window and make visable
                outFrame.add(confirmationDisplay);
                outFrame.add(okButton);
                outFrame.setVisible(true); 
                
            }
            //clock out
            else if (placeHolder == 2){
                System.out.println("Please enter the current Time");
                clockOut= scnr.next();
                System.out.print("Clocking out");
                String clockingOutStatment = name + " Clocked out at " + clockOut;
                //write to file
                Files.writeString(fileName, clockingOutStatment);

                //create new window
                JFrame outFrame = new JFrame("Java Talking Tacos Employee Hours");
                outFrame.setLayout(new FlowLayout());
                outFrame.setSize(500, 160);
                outFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //create text to read clocking in/out statment
                JLabel confirmationDisplay = new JLabel("Clocking In");     
                confirmationDisplay.setText(clockingOutStatment);
                confirmationDisplay.setHorizontalAlignment(JLabel.LEFT);
                confirmationDisplay.setVerticalAlignment(JLabel.BOTTOM);
                

                //button to get rid of window
                JButton okButton = new JButton("OK");  
                    okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        outFrame.dispose();   
                    }
                });
                //boder of button
                Border border = BorderFactory.createLineBorder(Color.BLACK);
                okButton.setBorder(border);
                okButton.setPreferredSize(new Dimension(50, 25));
                
                //BUTTON SETUP
                okButton.setText("Ok");
                okButton.setHorizontalAlignment(JButton.CENTER);
                okButton.setVerticalAlignment(JButton.CENTER);

                //ADD to window and make visable
                outFrame.add(confirmationDisplay);
                outFrame.add(okButton);
                outFrame.setVisible(true); 

                
            }
            //back out to main
            else {
                System.out.print("Invalid");
            }
        }
        
        else if(username == 2 && password == 4321){
            //manger choices
            System.out.println("Hello Manger, Select the number of the option you'd like to do");
            System.out.println("1. View employee hours\n2. View orders\n");
            placeHolder = scnr.nextInt();
            //view employee hours
            if(placeHolder == 1){
                System.out.println("Viewing employee hours");

                //read file 
                String file_content = Files.readString(fileName);
                System.out.println(file_content);
                
            }
            
            //edit employee hours
            else if (placeHolder == 2){
                
                System.out.println("Viewing past orders:");
                //create and read file
                Path fileName2 = Path.of("OrdersWriteFile.txt");
                String file_content2 = Files.readString(fileName2);
                System.out.println(file_content2);
            
            }
        }
        else {
            System.out.print("Failure, wrong username or password");
        }
    }

    
}