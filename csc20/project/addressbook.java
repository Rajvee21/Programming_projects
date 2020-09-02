//In this assignment, you are to design a Java program called address book to maintain a binary file of contacts. 
//A contact record in the file should include the following information:
 // First Name, a string of characters
 // Last Name, a string of characters
 // Email address, a string of characters
 // Address, a string of characters
 // Phone number, a string of characters
//Your program should allow it’s user to do the following:
//1. Create an address book. 2. Add contacts  3. Search contacts (optional)  4. Sort contacts (optional)  5. View/Delete contact  6. Load contacts  7. Backup contacts 




import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.event.*;


public class addressbook extends JFrame implements ActionListener {
	
   static JPanel bottom, sub, sub2, card1, card2, card3, card4, card5, card6, card7, card8;
   static JLabel label2b;
   static JTextField contactname, contactname2, contactname3, numContacts, lastName, address_lbl, searchStr, firstName, emailadd, phnumber;
   static JTable table, abTable;
   static Container contentPane;
   static CardLayout contentPaneLayout = new CardLayout();
   static ActionListener AL = new addressbook();
   static JScrollPane scrollPane = new JScrollPane();   
   static int contactCount, labNumber, studentCurrent, currentS;
   static String CN;     //to get the input info from designated TextField
   static JRadioButton rb1 = new JRadioButton("By First Name", true);     //put in true to initialize it
   static JRadioButton rb2 = new JRadioButton("By Last Name");
   static JButton brb4 = new JButton(" Top Menu");
   static JButton brb5 = new JButton(" Top Menu");
   static JButton brb6 = new JButton(" Top Menu");
   static JButton brb7 = new JButton(" Top Menu");
   static JButton brbSearch = new JButton("Search");
   static JButton newAddress = new JButton (" Create a New Address Book");
   static JButton loadContacts = new JButton (" Load Contacts");
   static JButton addNew = new JButton (" Add New Contacts");
   static JButton searchContact = new JButton (" Search Contacts");
   static JButton sortContacts = new JButton (" Sort Contacts");
   static JButton viewDelete = new JButton (" View/Delete Contacts");
   static JButton Backup = new JButton (" Backup Contacts");
   static JButton Exit = new JButton (" Exit");
   static JButton create = new JButton("Create");
   static JButton cancel = new JButton("Cancel");
   static JButton cancel2 = new JButton("Cancel");
   static JButton cancel3 = new JButton("Cancel");
   static JButton load = new JButton("Load");
   static JButton load2 = new JButton("Load");
   static JButton sort = new JButton("Sort Contacts");
   static JButton saveAdd = new JButton("Save new Contact");
   static JButton deleteSelect = new JButton("Delete Selected");
   static address[] contactA = new address[100];
   static String[][] rowData = new String[100][100]; 
   static String[] colName = new String[] 
      {"First Name", "Last Name", "Email Address", "Address", "Phone Number"};   
   static String[] cbxYear = new String[] { "Freshman", "Sophomore", "Junior", "Senior", "Graduate" };
   static String[] cbxGender = new String[] { "Male", "Female" };
   static FileOutputStream fos;  
   static ObjectOutputStream oos;   
   static ObjectInputStream ois;
   
   public static void main(String[] args) throws IOException {
	   
      //miain frame
      JFrame frm = new JFrame("Address Book");
      contentPane = frm.getContentPane();
      contentPane.setLayout(contentPaneLayout);
      
      JLabel label = new JLabel("<html><font size = 5><b>Use The Buttons Below To Manage Contacts</b></html>", JLabel.CENTER);
      JLabel label1 = new JLabel("User Name: ", JLabel.CENTER);
      contactname = new JTextField(15);
      contactname.setEditable(false);
      JLabel label2 = new JLabel("Number of contacts: ", JLabel.CENTER);
      numContacts = new JTextField(10);
      numContacts.setEditable(false);
      card1 = new JPanel(new BorderLayout());
      card1.add(label, BorderLayout.NORTH);
      JPanel sub = new JPanel(new FlowLayout());
      sub.add(label1);
      sub.add(contactname);
      sub.add(label2);
      sub.add(numContacts);
      card1.add(sub, BorderLayout.CENTER);
      bottom = new JPanel(new GridLayout(2, 4));
      bottom.add(newAddress);
      bottom.add(loadContacts);
      bottom.add(addNew);
      bottom.add(searchContact);
      bottom.add(sortContacts);
      bottom.add(viewDelete);
      bottom.add(Backup);
      bottom.add(Exit);
      
      card1.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(card1, "Card 1");
      
      //action listeners of buttons
      newAddress.addActionListener(AL);
      loadContacts.addActionListener(AL);
      addNew.addActionListener(AL);
      searchContact.addActionListener(AL);
      sortContacts.addActionListener(AL);
      viewDelete.addActionListener(AL);
      Backup.addActionListener(AL);
      Exit.addActionListener(AL);
      //END OF CARD 1
      
      //BEGINNING OF CARD2
      label = new JLabel("<html><font size = 5><b>Create a New Address Book</b></html>", JLabel.CENTER);
      label1 = new JLabel("User Name: ", JLabel.CENTER); 
      contactname2 = new JTextField(15);
      card2 = new JPanel(new BorderLayout());
      card2.add(label, BorderLayout.NORTH);
      sub = new JPanel(new FlowLayout());
      sub.add(label1);
      sub.add(contactname2);
      card2.add(sub, BorderLayout.CENTER); 
      bottom = new JPanel(new FlowLayout());
      create.setBounds(2,2,50,25);
      cancel.setBounds(2,2,50,25);
      bottom.add(create);
      bottom.add(cancel);
      card2.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(card2, "Card 2");
      create.addActionListener(AL);
      cancel.addActionListener(AL);
      //END OF CARD 2
            
      //BEGINNING OF CARD3
      label = new JLabel("<html><font size = 5><b>Load Contacts From a File</b></html>", JLabel.CENTER);
      label1 = new JLabel("User Name: ", JLabel.CENTER);
      contactname3 = new JTextField(15);
      card3 = new JPanel(new BorderLayout());
      card3.add(label, BorderLayout.NORTH);
      sub = new JPanel(new FlowLayout());
      sub.add(label1);
      sub.add(contactname3);
      card3.add(sub, BorderLayout.CENTER);
      bottom = new JPanel(new FlowLayout());
      load.setBounds(2,2,50,25);
      cancel2.setBounds(2,2,50,25);
      bottom.add(load);
      bottom.add(cancel2);
      card3.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(card3, "Card 3");
      cancel2.addActionListener(AL);
      load.addActionListener(AL);
      //END OF CARD 3
      
      //START OF CARD4
      label = new JLabel("<html><font size = 5><b>Enter Contact Information</b></html>", JLabel.CENTER);
      label1 = new JLabel("First Name: ", JLabel.RIGHT);
      firstName = new JTextField(15);    
      label2 = new JLabel("Last Name: ", JLabel.RIGHT);
      lastName = new JTextField(15);      
      JLabel label3 = new JLabel("Email Address: ", JLabel.RIGHT);  
      emailadd = new JTextField(15); 
      JLabel label4 = new JLabel("Address: ", JLabel.RIGHT);
      address_lbl = new JTextField(15);
      JLabel label5 = new JLabel("Phone Number: ", JLabel.RIGHT);
      phnumber = new JTextField(15);
      card4 = new JPanel(new BorderLayout());
      card4.add(label, BorderLayout.NORTH);
      sub = new JPanel();
      sub = new JPanel(new GridLayout(5, 2));
      sub.add(label1);
      sub.add(firstName);
      firstName.setHorizontalAlignment(JTextField.LEFT);
      sub.add(label2);
      sub.add(lastName);
      lastName.setHorizontalAlignment(JTextField.LEFT);
      sub.add(label3);
      sub.add(emailadd);
      emailadd.setHorizontalAlignment(JTextField.LEFT);      
      sub.add(label4);
      sub.add(address_lbl);
      address_lbl.setHorizontalAlignment(JTextField.LEFT);
      sub.add(label5);
      sub.add(phnumber);
      phnumber.setHorizontalAlignment(JTextField.LEFT);      
      //card4.add(new JComboBox(cbxGender));
      //card4.add(new JComboBox(cbxYear));
      card4.add(sub, BorderLayout.CENTER); 
      bottom = new JPanel(new FlowLayout());
      saveAdd.setBounds(2,2,50,25);
      brb4.setBounds(2,2,50,25);
      bottom.add(saveAdd);
      bottom.add(brb4);
      card4.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(card4, "Card 4");
      brb4.addActionListener(AL);
      saveAdd.addActionListener(AL);
      //END OF CARD4
      
      //BEGINNING OF CARD5
      label = new JLabel("<html><font size = 5><b>Search Contacts by First Name or Last Name</b></html>", JLabel.CENTER);
      JLabel label2a = new JLabel("Search String: ", JLabel.CENTER);
      searchStr = new JTextField(10);
      card5 = new JPanel(new GridLayout(0,1));
      card5.add(label);
      sub = new JPanel(new FlowLayout());
      table = new JTable(rowData, colName);
      table.setPreferredScrollableViewportSize(new Dimension(800, 80));
      table.setFillsViewportHeight(true);
      card5.add(scrollPane, BorderLayout.SOUTH);   
      
      sub.add(searchStr);
      card5.add(sub);
      bottom = new JPanel(new FlowLayout());
      //set size of buttons
      brb5.setBounds(2,2,50,25);
      brbSearch.setBounds(1,1,50,25);
      bottom.add(label2a);
      
      bottom.add(searchStr);
      
      bottom.add(brbSearch);
      bottom.add(brb5);

      card5.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(card5, "Card 5");
      brb5.addActionListener(AL);
      brbSearch.addActionListener(AL);
      searchStr.addActionListener(AL);
      //END OF CARD 5
      
      //BEGINNING OF CARD 6

      card6 = new JPanel(new GridLayout(0,1));
      label = new JLabel("<html><font size = 5>Sort Contacts By:</html>", JLabel.CENTER);
      card6.add(label);
      
      ButtonGroup bg1 = new ButtonGroup();
      bg1.add(rb1);
      bg1.add(rb2);
      
      Box verticalBox = Box.createVerticalBox();
      verticalBox.add(rb1);
      verticalBox.add(rb2);
      card6.add(verticalBox, BorderLayout.WEST);      

      bottom = new JPanel(new FlowLayout());
      sort.setBounds(1,2,50,25);
      brb6.setBounds(2,2,50,25);
      
      bottom.add(sort);
      bottom.add(brb6);
      card6.add(bottom, BorderLayout.PAGE_END);    
      contentPane.add(card6, "Card 6");
      brb6.addActionListener(AL);
      sort.addActionListener(AL);
      //END OF CARD 6
      
      //BEGINNING OF CARD7
      label = new JLabel("<html><font size = 4><b>Contact List</b></html>", JLabel.CENTER);      
      card7 = new JPanel(new BorderLayout());
      card7.add(label, BorderLayout.NORTH);
      sub = new JPanel(new FlowLayout());
      table = new JTable(rowData, colName);
      table.setPreferredScrollableViewportSize(new Dimension(800, 80));
      table.setFillsViewportHeight(true);
      card7.add(scrollPane, BorderLayout.CENTER); 
      bottom = new JPanel(new FlowLayout());
      deleteSelect.setBounds(2,2,50,25);
      brb7.setBounds(2,2,50,25);
      bottom.add(deleteSelect);
      bottom.add(brb7);
      card7.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(card7, "Card 7");
      brb7.addActionListener(AL);
      deleteSelect.addActionListener(AL);
      //END OF CARD 7
      
      Backup.addActionListener(AL);
      
      frm.pack();
      frm.setSize(900,300);
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setVisible(true);
      
   }
   
      public void actionPerformed(ActionEvent e) {
    	  
         Object source = e.getSource();
         
         if (source == create) {
        	 
            CN = contactname2.getText();
            contactCount = 0;
            contactname.setText(CN);
            numContacts.setText("" + contactCount);
            contentPaneLayout.show(contentPane, "Card 1");
            
         }
         
         if (source == cancel) contentPaneLayout.show(contentPane, "Card 1");
         if (source == cancel2) contentPaneLayout.show(contentPane, "Card 1");
         if (source == cancel3) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb4) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb5) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb6) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb7) contentPaneLayout.show(contentPane, "Card 1");
         if (source == newAddress) contentPaneLayout.show(contentPane, "Card 2");
         if (source == loadContacts) contentPaneLayout.show(contentPane, "Card 3");
         
         if (source == load) {
        	 
            address St;
            
            try {
            	
               CN = contactname3.getText();
               System.out.println("contactname3 is " + CN);
               contactCount = 0;
               
               //reading a file
               ois = new ObjectInputStream(new FileInputStream(CN));
               
               while (true) {
            	   
                  St = (address)ois.readObject();
                  System.out.println("\n");
                  System.out.println("Contact's First Name: " + St.firstName);
                  System.out.println("Contact's Last Name: " + St.NameS); 
                  System.out.println("Contact's Email Address: " + St.emailaddS);
                  System.out.println("Contact's Address: " + St.address_lblC);
                  System.out.println("Contact's Phone Number: " + St.phnumberS);
                  contactA[contactCount] = St;
                  contactCount++;
                  
               }
               
            } 
            
            catch (EOFException ey) {
            } 
            
            catch (Exception ex) { 
            	
               ex.printStackTrace();
               
            }
            contactname.setText(CN);
            numContacts.setText("" + contactCount);
            contentPaneLayout.show(contentPane, "Card 1");
         }
         
         if (source == addNew) contentPaneLayout.show(contentPane, "Card 4");
         
         if (source == saveAdd) {
        	 
            address temp = new address();
            temp.firstName = firstName.getText();
            temp.NameS = lastName.getText();
            temp.emailaddS = emailadd.getText();
            temp.address_lblC = address_lbl.getText();
            temp.phnumberS = phnumber.getText();
            contactA[contactCount] = temp;
            contactCount++;
            firstName.setText("");
            lastName.setText("");
            emailadd.setText("");
            address_lbl.setText("");
            phnumber.setText("");
            numContacts.setText("" + contactCount);
            
         }
         
         if (source == brbSearch) {
            //int index = -1;
            String searchString = searchStr.getText();
            System.out.println(searchString);
            StringBuilder sb=new StringBuilder();  
            for(int i=0; i<contactCount;i++) {
            
        	      if(contactA[i].firstName.equalsIgnoreCase(searchString)|| contactA[i].NameS.equalsIgnoreCase(searchString)){
                  sb.append("Name: "+ contactA[i].firstName + " " + contactA[i].NameS + "\n");
                  sb.append("Email Address: " + contactA[i].emailaddS + "\n");
                  sb.append("Address: " + contactA[i].address_lblC + "\n");
                  sb.append("Phone Number: " + contactA[i].phnumberS);
               // Did try but have to check it with God of Java
                  JOptionPane.showMessageDialog(null, sb.toString() /*contactA[i].firstName*/ /*contactA[i].NameS, contactA[i].emailaddS, contactA[i].address_lblC, contactA[i].phnumberS*/);
               }
            }
            
         }
         
         
         if (source == searchContact)  contentPaneLayout.show(contentPane, "Card 5");
         if (source == sortContacts) contentPaneLayout.show(contentPane, "Card 6");
         
         if(source == sort) {
            if (rb1.isSelected()) {
               for(int i=0;i<contactCount;i++) {
                  for (int j = i+1; j<contactCount; j++) {
                     if(contactA[i].firstName.compareTo(contactA[j].firstName)>0) {
                         address temp = contactA[i];
                         contactA[i] = contactA[j];
                         contactA[j] = temp;
                     }
                  }
               }
            }
            if (rb2.isSelected()) {
               for(int i=0;i<contactCount;i++) {
                     for (int j = i+1; j<contactCount; j++) {
                        if(contactA[i].NameS.compareTo(contactA[j].NameS)>0) {
                            address temp = contactA[i];
                            contactA[i] = contactA[j];
                            contactA[j] = temp;
                        }
                     }
                  }

               }
         }
         
         if (source == viewDelete) {
        	 
            rowData = new String[contactCount][15];
            
            for (int i = 0; i < contactCount; i++) {
            	
               rowData[i][0] = contactA[i].firstName + "";
               rowData[i][1] = contactA[i].NameS + "";
               rowData[i][2] = contactA[i].emailaddS + "";
               rowData[i][3] = contactA[i].address_lblC + "";
               rowData[i][4] = contactA[i].phnumberS + "";
               
            }
            
            abTable = new JTable(rowData, colName);
            JScrollPane tmp = new JScrollPane(abTable);
            scrollPane.setViewport(tmp.getViewport());
            contentPaneLayout.show(contentPane, "Card 7");
            
         }
         if (source == deleteSelect) {
        	 
            int del = abTable.getSelectedRow();
            
            for (int k = del; k < contactCount - 1; ++k) 
               contactA[k] = contactA[k+1];
            contactCount--;
            rowData = new String[contactCount][15];
            
            for (int i = 0; i < contactCount; i++) {
            	
               rowData[i][0] = contactA[i].firstName + "";
               rowData[i][1] = contactA[i].NameS + "";
               rowData[i][2] = contactA[i].emailaddS + "";
               rowData[i][3] = contactA[i].address_lblC + "";
               rowData[i][4] = contactA[i].phnumberS + "";
               
            }
            numContacts.setText("" + contactCount);
            abTable = new JTable(rowData, colName);
            JScrollPane tmp = new JScrollPane(abTable);
            scrollPane.setViewport(tmp.getViewport());
            contentPaneLayout.show(contentPane, "Card 7");
         }
         if (source == Backup) { 
        	 
            //CN = contactname3.getText();
            System.out.println("contactname is " + CN);
            
            if (CN.equals("")) System.exit(0);
            else {
                
               try {
            	   
               //create new file
               contactCount = rowData.length;
               
               //a file of objects can not be opened for append
               fos = new FileOutputStream(CN);
               oos = new ObjectOutputStream(fos);
               
               //write something in file
               for (int i = 0; i < contactCount; i++)
                  oos.writeObject(contactA[i]);

               oos.close();
               } 
               catch (Exception ex) {
                  ex.printStackTrace();
               }
            }
         }
         if (source == Exit) 
        	 System.exit(0); 
      }
} 

class address implements Serializable { 

	String NameS, firstName, emailaddS, address_lblC, phnumberS;
	int Year, Gender,Lab1, Lab2, Lab3, Lab4, Lab5, Lab6, Lab7, Lab8, Lab9, Lab10; 
	
}

