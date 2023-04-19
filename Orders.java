import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
# coded by Sarah Dziobak
class Orders {

  private static String text;

  public static void orders() throws FileNotFoundException {
        class Menu{
          public String name;
          public double price;
        }
        Scanner scnr = new Scanner(System.in);
  
        Path fileName2 = Path.of("OrdersWriteFile.txt");
        
        
        Menu[] items={new Menu(), new Menu(), new Menu()};
        items[0].name="Chicken Tacos";
        items[0].price=3.00;
        items[1].name="Beef Tacos";
        items[1].price=3.00;
        items[2].name="Pepsi";
        items[2].price=1.00;
        DecimalFormat df= new DecimalFormat("0.00");
        double subTotal=0;
        double total=0;
        int numChic=0;
        int numBeef=0;
        int numPepsi=0;
        int numItems=0;
        double tax=0;
        double taxes=0.10;
        double numFinal=0;
        int select =0;
        double valtax5=0;
        double valtax10=0;
        double valtax15=0;
        double valtax20=0;
        double tax5=0.05;
        double tax10=0.10;
        double tax15=0.15;
        double tax20=0.20;
        double numFin5=0;
        double numFin10=0;
        double numFin15=0;
        double numFin20=0;
        String totalOrder;
        
        
        
        
        for (int i=0; i< items.length; i++){
          System.out.println((i+1)+") "+ items[i].name+" $"+ items[i].price);
        }
        System.out.println("0) Finish your order");
        System.out.println("Enter if you would like menu item 1 2 or 3:");
        do {
          //while loop here
          select=scnr.nextInt();
          int j=0;
          while (j==0){
            
            if (select>3 || select<0){
              System.out.println("No choice available. Please make a selection");
            }
            else if (select==1){
              subTotal=items[0].price;
              ++numChic;
              ++ numItems;
              total=total+subTotal;
              System.out.println("Would you like to add to your order? Enter 1 2 or 3 if you want more. Enter 0 to finish your order. "); 
              System.out.println(numChic + " Chicken Tacos");
            }
            else if (select==2){
              subTotal=items[1].price;
              ++numBeef;
              ++ numItems;
              total=total+subTotal;
              System.out.println("Would you like to add to your order? Enter 1 2 or 3 if you want more. Enter 0 to finish your order. "); 
              System.out.println(numBeef + "Beef Tacos");
              
            }
            else if (select==3)  {
              subTotal=items[2].price;
              ++numPepsi;
              ++ numItems;
              total=total+subTotal;
              System.out.println("Would you like to add to your order? Enter 1 2 or 3 if you want more. Enter 0 to finish your order. "); 
              System.out.println(numPepsi + "Pepsi");
              
              
            }
            
            System.out.println("This is your order: ");
            break ;
          }
         
          
          //big statment that displays what the customer orders ex: 0 beef 0 chicken 0 pepsi is the defult display :)
          totalOrder = numChic + " chicken tacos " + numBeef + " beef tacos " + numPepsi + " pepsis";
          System.out.println(totalOrder);
          try {
            Files.writeString(fileName2, numChic + " chicken tacos " + numBeef + " beef tacos " + numPepsi + " pepsis");
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          //break;
        }
        while(select !=0);{
          
          
          tax=(total*taxes);
          numFinal=total+tax;
          
          valtax5=(total*tax5);
          valtax10=(total*tax10);
          valtax15=(total*tax15);
          valtax20=(total*tax20);
          
          numFin5= total+ valtax5 + tax;
          numFin10= total+ valtax10 + tax;
          numFin15= total+ valtax15 + tax;
          numFin20= total+ valtax20 + tax;
          
          
                System.out.println("Order: " + numItems + " items");
                System.out.println("Subtotal: $" + (df.format(total)));
                System.out.println("Subtotal with Tax(10%): $" + (df.format(numFinal)));
                
                
                System.out.println("Total with 5% tip: $" + (df.format(numFin5)));
                System.out.println("Total with 10% tip: $" + (df.format(numFin10)));
                System.out.println("Total with 15% tip: $" + (df.format(numFin15)));
                System.out.println("Total with 20% tip: $" + (df.format(numFin20)));
                
                
                
                System.out.println("Thank you. Please come again soon!");
          }
          //create new window
          JFrame outFrame = new JFrame("Java Talking Tacos Order");
          outFrame.setLayout(new FlowLayout());
          outFrame.setSize(500, 250);
          outFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          //create text to read order back to customer in new window
          JLabel totalOrderDisplay = new JLabel("Total Order");     
          totalOrderDisplay.setText("Order taken: " + totalOrder);
          totalOrderDisplay.setHorizontalAlignment(JLabel.LEFT);
          totalOrderDisplay.setVerticalAlignment(JLabel.BOTTOM);

          //label for number of items
          JLabel numIntemsLabel = new JLabel("Number Items");     
          numIntemsLabel.setText("Number of items ordered: " + numItems);
          numIntemsLabel.setHorizontalAlignment(JLabel.LEFT);
          numIntemsLabel.setVerticalAlignment(JLabel.BOTTOM);

          //label for subTotal
          JLabel  subtotLabel = new JLabel("SubTotal");     
          subtotLabel.setText("Subtotal: $" + (df.format(total)));
          subtotLabel.setHorizontalAlignment(JLabel.LEFT);
          subtotLabel.setVerticalAlignment(JLabel.BOTTOM);
          
          //Label for subtotal with tax
          JLabel subTotTaxLabel = new JLabel("subtotal with tax");
          subTotTaxLabel.setText("Subtotal With Tax: $" + (df.format(total)));
          subTotTaxLabel.setHorizontalAlignment(JLabel.LEFT);
          subTotTaxLabel.setVerticalAlignment(JLabel.BOTTOM);
          
          //Label for totals with tip %5
          JLabel totWithTip5Label = new JLabel("Total with Tips");
          totWithTip5Label.setText("Total with 5% tip: $" + (df.format(numFin5)));
          totWithTip5Label.setHorizontalAlignment(JLabel.LEFT);
          totWithTip5Label.setVerticalAlignment(JLabel.BOTTOM);     

          //Lavel for total with tip 10%
          JLabel totWithTip10Label = new JLabel("Total with Tips");
          totWithTip10Label.setText("Total with 10% tip: $" + (df.format(numFin10)));
          totWithTip10Label.setHorizontalAlignment(JLabel.LEFT);
          totWithTip10Label.setVerticalAlignment(JLabel.BOTTOM);


          //Label for toatl with tip 15%
          JLabel totWithTip15Label = new JLabel("Total with Tips");
          totWithTip15Label.setText("Total with 15% tip: $" + (df.format(numFin15)));
          totWithTip15Label.setHorizontalAlignment(JLabel.LEFT);
          totWithTip15Label.setVerticalAlignment(JLabel.BOTTOM);

          //lable for total with tip %20
          JLabel totWithTip20Label = new JLabel("Total with Tips");
          totWithTip20Label.setText("Total with 20% tip: $" + (df.format(numFin20)));
          totWithTip20Label.setHorizontalAlignment(JLabel.LEFT);
          totWithTip20Label.setVerticalAlignment(JLabel.BOTTOM);

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

          //add to grid!
          JPanel controlPanel = new JPanel();
          controlPanel.setLayout(new GridLayout(10,1));

          //add to control panel to make veritcal
          controlPanel.add(totalOrderDisplay);
          controlPanel.add(numIntemsLabel);
          controlPanel.add(subtotLabel);
          controlPanel.add(subTotTaxLabel);
          controlPanel.add(totWithTip5Label);
          controlPanel.add(totWithTip10Label);
          controlPanel.add(totWithTip15Label);
          controlPanel.add(totWithTip20Label);

          //ADD to window and make visable
          outFrame.add(controlPanel);
          outFrame.add(okButton);
          outFrame.setVisible(true); 

  }
 
}
