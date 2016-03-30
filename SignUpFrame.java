//Importing libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;

/*
	Class Name: SignUpFrame
	Author: 		Hansen,Wang
	Class: 		ICS4U
	School:		A.Y.Jackson
	Description: this is a class that display the sign up frame which is trigered by the button signup
*/

class SignUpFrame extends JFrame implements ActionListener
{ 
   private JLabel label;
   private JLabel userLabel;
   private JLabel fnLabel;
   private JLabel lnLabel;
   private JLabel pwLabel;
   private JLabel spwLabel;
   private JLabel mLabel;
   private JLabel picture;
	
   private JButton button1;
   private JButton button2;

   private JTextField fnText;
   private JTextField lnText;
   private JTextField userText;
   private JTextField mText;

   private JPasswordField pwText;
   private JPasswordField spwText;
   
   private Icon icon = new ImageIcon("picture/money.jpg");

   public static void main(String args[])
   {
      new SignUpFrame();
   }

   public SignUpFrame()
   {
      super("Sign up"); 
      setLayout(null); 
      setUndecorated(true);
      getContentPane().setBackground(new Color(11,150,255));
      setSize(240,480);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);
      
      //first line display: welcome to use our system
      label = new JLabel("Welcome to use our system",JLabel.CENTER);
      label.setToolTipText("Please sign in");
   	
      //the label that shows "username"
      userLabel = new JLabel("Username:");
      userLabel.setToolTipText("Enter user name");
      //the textfield that allows user to input the username
      userText = new JTextField("",20);
      //the label that shows "first name"
      fnLabel = new JLabel("First name:");
      fnLabel.setToolTipText("Enter your first name");
      //the textfield that allows user to input the first name
      fnText = new JTextField("",20);
      //the label that shows "last name"
      lnLabel = new JLabel("Last name:");
      lnLabel.setToolTipText("Enter your last name");
      //the textfield that allows user to input the last name
      lnText = new JTextField("",20); 
      //the label showing "password"
      pwLabel = new JLabel("Password:");
      pwLabel.setToolTipText("Enter your password for log in"); 
      //the textfield that allows user to input the password
      pwText = new JPasswordField("",20);  
      //the label showing "secure password"
      spwLabel = new JLabel("Secure Password:");
      spwLabel.setToolTipText("The password for trading");
      //the textfield that allows the user to input secure password
      spwText = new JPasswordField("",20);
      //the label showing "money to start with"
      mLabel = new JLabel("Money to start with(A Number):");
      mLabel.setToolTipText("Number Only");
      //the textfield that allows user to input money to start with
      mText = new JTextField("",20);
      //button confirm
      button1 = new JButton("Confirm");
      button1.addActionListener(this);
      //button cancel
      button2 = new JButton("Cancel");
      button2.addActionListener(this); 
      //the picture at the bottom 	      
      picture = new JLabel("Picture");
      picture.setIcon(icon);
      picture.setSize(200,110);   
      
      //add all the component
      add(label);
      label.setBounds(20,10,200,20);
      add(userLabel);
      userLabel.setBounds(20,35,200,20);
      add(userText);
      userText.setBounds(20,60,200,20);
      add(fnLabel);
      fnLabel.setBounds(120,85,100,20);
      add(fnText);
      fnText.setBounds(120,110,100,20);  
      add(lnLabel);
      lnLabel.setBounds(20,85,100,20);
      add(lnText);
      lnText.setBounds(20,110,90,20);
      add(pwLabel);
      pwLabel.setBounds(20,135,200,20);  
      add(pwText);
      pwText.setBounds(20,160,200,20);  
      add(spwLabel);
      spwLabel.setBounds(20,185,200,20);  
      add(spwText);
      spwText.setBounds(20,210,200,20);
      add(mLabel);
      mLabel.setBounds(20,235,200,20);
      add(mText);
      mText.setBounds(20,260,200,20);
      add(button1);
      button1.setBounds(30,300,80,30); 
      add(button2);
      button2.setBounds(120,300,80,30);  
      add(picture);
      picture.setBounds(20,350,200,110);
   }

//when button is clicked
   public void actionPerformed(ActionEvent e)
   {
      JButton button = (JButton)e.getSource();
      if(button == button1)
      {
         if(userText.getText().length() == 0 || fnText.getText().length() == 0 || lnText.getText().length() == 0 || pwText.getPassword().length == 0 || spwText.getPassword().length == 0)
         {
            JOptionPane.showMessageDialog(null,"Username,First name,Last name,Password or Secure password cannot be empty ","Warning", JOptionPane.WARNING_MESSAGE);
         }
         else
            if(pwText.getText().equals(spwText.getText()))
            {
               JOptionPane.showMessageDialog(null, "Password and Secure Password cannot be the same!","Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(!SignUpFrame.isNum(mText.getText()))
            {
               JOptionPane.showMessageDialog(null, "Input a valid number for money to start with!","What are you, crazy!", JOptionPane.WARNING_MESSAGE);
            }
            else 
            {
               if(addNewUser())
               {
                  JOptionPane.showMessageDialog(null, "File created successfully!","Welcome, new user!", JOptionPane.WARNING_MESSAGE);
                  dispose();
               }
               else
                  JOptionPane.showMessageDialog(null, "Username already exists!","Sorry, you have to try again!", JOptionPane.WARNING_MESSAGE);
            }
      }
      if(button == button2)
      {
         dispose();
      }
   }
	
   public static boolean isNum(String s)
   {
      for (int i=s.length(); --i>=0;)
      {    
         if (!Character.isDigit(s.charAt(i)))
         { 
            return false; 
         } 
      } 
      return true; 
   }

   private boolean addNewUser()
   {
      boolean addComplete = false;
      User temp = User.loadUser(userText.getText());			
      if(temp.getUsername() == "")
      {
         User newUser = new User(userText.getText(), lnText.getText(), fnText.getText(), pwText.getText(), spwText.getText(), Double.parseDouble(mText.getText()));
         newUser.saveUser();
         addComplete = true;
      }
      else
         addComplete = false;
      return addComplete;
   }
}