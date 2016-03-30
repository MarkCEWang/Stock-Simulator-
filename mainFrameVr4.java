   import javax.swing.*;
   import javax.swing.event.*;
   import java.awt.*;
   import java.awt.event.*; 
   import java.applet.*;
   import java.io.*;
   import java.util.*;

/*
	Class Name: mainFrameVr4
	Author: 		Hansen,Wang
	Class: 		ICS4U
	School:		A.Y.Jackson
	Description: this is a class that display the main frame when a user logged in sucessfully
*/
    public class mainFrameVr4 extends JFrame implements ActionListener,ListSelectionListener
   {
		//randomly generate news and the picture related to the specific news   
      News n = new News();		
      String s = n.newsSelect();
		String p = n.newsPicture();
   
		//two arraylist that store the locations of the coordinates
      ArrayList X = new ArrayList();
      ArrayList Y = new ArrayList();
   
		//all the stocks
      String allStocks[] = {"Car Company","Computer Company","Fast Food Company","Grocery Store Company","Banking Company"};
   
  		//create a user    
		private User user;
      private JList list = new JList(allStocks);
   
      private JPanel input = new JPanel();
      private JPanel output1 = new JPanel();
   
  		//setting panel    
		 class Setting extends JPanel
      {
          public Setting()
         {
            super();
            setBackground(Color.WHITE);
            setBounds(500,0,295,300);
         }
      }
   
   	//draw stock lines
       class output1forStocks extends JPanel 
      {
          public output1forStocks()
         {
            setSize(500,300);
            setBackground(Color.BLACK);
            setBounds(0,0,500,300);
         }
          public void paint(Graphics g) 
         {
            super.paint(g);
            ((Graphics2D)g).setStroke(new BasicStroke(3.0f));
            g.setColor(Color.RED);
            g.drawLine(0, 150, 500, 150);
            ((Graphics2D)g).setStroke(new BasicStroke(1.0f));
            g.drawLine(0, 50, 500, 50);			
            g.drawLine(0, 100, 500, 100);
            g.drawLine(0, 200, 500, 200);
            g.drawLine(0, 250, 500, 250);
            ((Graphics2D)g).setStroke(new BasicStroke(2.0f));
            g.setColor(Color.WHITE);
            for(int i=0; i<X.size()-1; i++)
               g.drawLine((int)X.get(i),(int)Y.get(i),(int)X.get(i+1),(int)Y.get(i+1));
         }         
      }
   	
		//creat all the componets that needs to be display
      private output1forStocks output1Stocks = new output1forStocks();
      private JPanel output2forNews = new JPanel();
      private JPanel output2forSetting = new JPanel();
      private JPanel news1 = new JPanel();
      private JPanel news2 = new JPanel();
   	
		//the scorllpane is used to display the list of news
      private JScrollPane output2 = new JScrollPane();
   
		//all the labels that are required for the program
      private JLabel newsPicture = new JLabel();
      private JLabel outputBg = new JLabel();
      private JLabel newsBg = new JLabel("Breaking news");
      private JLabel op2fornewsL =new JLabel();
      private JLabel set1 = new JLabel("Setting");
      private JLabel set2 = new JLabel("Input money into your account");
    
	 	//all the buttons in the program
      private JButton myStock = new JButton("My Stocks");
      private JButton allStock = new JButton("All Stocks");
      private JButton Trade = new JButton("Trade");
      private JButton newsButton = new JButton("News");
      private JButton setting = new JButton("Setting");
      private JButton logout = new JButton("Log out");  
      private JButton confirm = new JButton("Confirm");
      private JButton reset = new JButton("RESET EVERTHING");
      private JButton delete = new JButton("DELETE ACCOUNT");
   
		//all the pictures need for the main frame
      private Icon newsIcon = new ImageIcon("picture/newsIcon.jpg");
      private Icon nbgIcon = new ImageIcon("picture/newsBackground.jpg");
      private Icon op2fornews = new ImageIcon("picture/op2fornews.gif");
      private Icon bgIcon = new ImageIcon("picture/picture1.JPG");
   
      private JTextArea info;//The textArea that display "Welcome Mr.XXX\n   Your Balance: $ XXX\n   Your Stock:  XXX\n   You have earned: $ XXX");
      private JTextArea textAreaOutput = new JTextArea(s); 
      private JTextArea output2News = new JTextArea(s); 
   
      private JTextField moneyInput = new JTextField();
   
       public mainFrameVr4(User temp)  // constructor
      {
         super("Welcome");
         int SecW = Toolkit.getDefaultToolkit().getScreenSize().width; // the width of screen
         int SecH = Toolkit.getDefaultToolkit().getScreenSize().height; // the height of screen
         setLocation((SecW-800)/2,(SecH-495)/2);// set the frame in the middle of the screen
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(800, 495);
         setResizable(false);      
         setVisible(true);
      
         user = temp;
         renewUserInfo();   	
      
         outputBg.setIcon(bgIcon);
         op2fornewsL.setIcon(op2fornews);
      
         output1.setBounds(0,0,500,300);
         output1.setLayout(new GridLayout());
         output1.add(outputBg);
      
         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setFont(new Font("Microsoft Yahei",Font.PLAIN,25)); 
         list.addListSelectionListener(this);
      
         output2.setBackground(Color.WHITE);
         output2.setBounds(500,0,295,300);
         output2.setViewportView(list);
      
         output2News.setSize(300,100);
         output2News.setEditable(false);
         output2News.setLineWrap(true);
         output2News.setBackground(Color.BLUE);
         output2News.setFont(new Font("Microsoft Yahei",Font.PLAIN,20));
      
         output2forNews.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
         output2forNews.setBounds(500,0,300,300);
         output2forNews.setBackground(new Color(166,166,166));
         output2forNews.add(op2fornewsL);
         output2forNews.add(output2News);
      
         output2forSetting.setBounds(500,0,300,300);
         output2forSetting.setBackground(Color.YELLOW);
         output2forSetting.setLayout(null);
         output2forSetting.add(set1);
         set1.setBounds(118,10,100,30);
         set1.setFont(new Font("Microsoft Yahei",Font.PLAIN,20));
         output2forSetting.add(set2);
         set2.setBounds(35,50,250,30);
         set2.setFont(new Font("Microsoft Yahei",Font.PLAIN,15));
         output2forSetting.add(moneyInput);
         moneyInput.setBounds(50,90,200,30);
         output2forSetting.add(confirm);
         confirm.setBounds(100,130,100,30);
         confirm.addActionListener(this);
         output2forSetting.add(reset);
         reset.setBounds(75,200,150,30);
         reset.addActionListener(this);    
         output2forSetting.add(delete);
         delete.setBounds(75,240,150,30);
         delete.addActionListener(this);   	
      
         textAreaOutput.setBounds(190,310,600,55);
         textAreaOutput.setSelectedTextColor(Color.RED);
         textAreaOutput.setLineWrap(true);
         textAreaOutput.setEditable(false);
         textAreaOutput.setBackground(Color.BLACK);
         textAreaOutput.setOpaque(false);
         textAreaOutput.setFont(new Font("Arial",Font.PLAIN,15)); //news output need adjust
         textAreaOutput.setForeground(Color.WHITE);
      
         news1.setBounds(0,300,180,55);
         news1.setBackground(Color.BLACK);
         news1.setLayout(new GridLayout(1,1,0,0));
         news1.add(newsPicture);
      
         newsBg.setIcon(nbgIcon);
      
         news2.setBounds(180,300,620,55);
         news2.setBackground(Color.BLACK);
         news2.setLayout(new GridLayout(1,1,0,0));   
         news2.add(newsBg);
      
         newsPicture.setIcon(newsIcon);
         newsPicture.setBounds(0,0,800,300);
      
         input.setSize(800,140);
         input.setBounds(0,395,800,140);
         input.setBackground(Color.GREEN);
         input.setLayout(null);
      
         info.setSize(250,100);
         info.setBounds(50,375,250,90);
         info.setBackground(Color.GREEN);
         info.setEditable(false);
         info.setFont(new Font("Microsoft Yahei",Font.BOLD,13));
      
         myStock.setBounds(300,370,120,35);
         allStock.setBounds(450,370,120,35);
         Trade.setBounds(600,370,120,35);
         newsButton.setBounds(300,417,120,35);
         setting.setBounds(450,417,120,35);
         logout.setBounds(600,417,120,35);
      
         input.add(info);
         input.add(myStock);
         myStock.addActionListener(this);
         input.add(allStock);
         allStock.addActionListener(this);
         input.add(Trade);
         Trade.addActionListener(this);
         input.add(newsButton);
         newsButton.addActionListener(this);
         input.add(setting);
         setting.addActionListener(this);
         input.add(logout);
         logout.addActionListener(this);
      
         add(textAreaOutput);
         add(output2forNews);
         add(output2forSetting);
         add(output1Stocks);
         add(output1);
         add(output2);
         add(news1);
         add(news2);
         add(input);
      
         output1Stocks.setVisible(false);
         output2forSetting.setVisible(false);
         output2forNews.setVisible(false);
      
         System.out.println("Now it is time for String to fly");
      //StringFly();
      //renewNews();
         addCoordinates(0,150);
         addCoordinates(20,100);
         addCoordinates(40,110);
         addCoordinates(60,90);
         addCoordinates(80,170);
         addCoordinates(100,160);
         addCoordinates(120,135);
         addCoordinates(140,120);
         addCoordinates(160,80);
         
			for(int i=0; i<6; i++)
            System.out.println(X.get(i)+" "+Y.get(i));
         System.out.println("Now String finished flying");
			
      }
   
   	//when news button is clicked, it display different pictures    
		 public void setPicture(String str)
      {
         bgIcon = new ImageIcon(str);
			outputBg.setIcon(bgIcon);
      }
   
		//when news button is clicked, it display different pictures
		public void renewPicture()
		{
			p = n.newsPicture();
			setPicture(p);
		}
		
		//add coordinates to the arraylist
       public void addCoordinates(int x1, int y1)
      {
         X.add(x1);
         Y.add(y1);
      }
   	
		//renew news
       public void renewNews()
      {
      //News nt = new News();		
      //   for(;;)
        // {
            s = n.newsSelect();
            output2News.setText(s);
            System.out.println("Renew News");
				renewPicture();
         //    try
//             {
//                Thread.sleep(50);
//             }
//                 catch(InterruptedException e)
//                {
//                   System.out.println("Sleep wrong");
//                }
            textAreaOutput.setText(s);
        // }
      }
   
		//renew user info
       public void renewUserInfo()
      {
         info = new JTextArea("Welcome Mr."+user.getLastname()+"\n   Your Balance: $ "+user.getBalance()+"\n   Your Stock:  XXX\n   You have earned: $ XXX");
      }
   
		//a method that allows a string moving 
       public void StringFly()
      {
         while(true)
         {
            System.out.println("Running loop");      
            for(int i=190; i<=800; i++)
            {
               try
               {
                  Thread.sleep(50);
               }
                   catch(InterruptedException e)
                  {
                     System.out.println("Sleep wrong");
                  }
               textAreaOutput.setBounds(i,310,400,55);
            }
         }
      }
   
		//read from user stock
       public void readUserStocks()
      {
      //file
         String tempStocks[] = {"user","user1"};
         list = new JList(tempStocks);
         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setFont(new Font("Microsoft Yahei",Font.PLAIN,25)); 
         list.addListSelectionListener(this);
      }
   
		//get all the stocks
       public void readAllStocks()
      {
         list = new JList(allStocks);
         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setFont(new Font("Microsoft Yahei",Font.PLAIN,25)); 
         list.addListSelectionListener(this);
      }
   
		//when the button is clicked
       public void actionPerformed(ActionEvent e)
      {
         JButton button = (JButton)e.getSource();
         if(button == myStock)
         {        
				output1Stocks.setVisible(true);
            output1.setVisible(false);
            output2.setVisible(true);
            output2forSetting.setVisible(false);
            output2forNews.setVisible(false);
            readUserStocks();
            output2.setViewportView(list);
         }
         else if(button == allStock)
         {        
				output1Stocks.setVisible(true);
            output1.setVisible(false);
            output2.setVisible(true);
            output2forSetting.setVisible(false);
            output2forNews.setVisible(false);
            readAllStocks();
            output2.setViewportView(list);
         }
         else if(button == newsButton)
         {
    			renewNews();        
				setPicture(p);
				System.out.println(p);
				output1Stocks.setVisible(false);
            output1.setVisible(true);
            output2.setVisible(false);
            output2forSetting.setVisible(false);
            output2forNews.setVisible(true);
         }
         else if(button == Trade)
         {      
            setPicture("picture/picture1.JPG");
            output1Stocks.setVisible(false);
            output1.setVisible(true);
            new TradeFrameVr2(user);
         }
         else if(button == setting)
         {
    			setPicture("picture/picture1.JPG");        
				output1Stocks.setVisible(false);
            output1.setVisible(true);
            output2.setVisible(false);
            output2forSetting.setVisible(true);
            output2forNews.setVisible(false);
         }
         else if(button == confirm)
         {
            if( moneyInput.getText().length() == 0 || !SignUpFrame.isNum(moneyInput.getText()) )        
               JOptionPane.showMessageDialog(null,"Invalid money input ","Warning", JOptionPane.WARNING_MESSAGE);
            else
            {
               System.out.println("confirm is clicked");
               user.addBalance(Double.parseDouble(moneyInput.getText()));
            }
            renewUserInfo();
         }
         else if(button == reset)
         {
            int check = JOptionPane.showConfirmDialog(this, "Are you sure you want to reset everything\nYour balance will be set to 0", "Confirm",JOptionPane.YES_NO_OPTION);
            if(check == JOptionPane.YES_OPTION)
            {
            //reset method        
            }
         }
         else if(button == delete)
         {
            int check = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the account", "Confirm",JOptionPane.YES_NO_OPTION);
            if(check == JOptionPane.YES_OPTION)
            {
            //delete method        
            }
         }
         else if(button == logout)
         {        
				int check = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out", "Confirm",JOptionPane.YES_NO_OPTION);
            if(check == JOptionPane.YES_OPTION)
            {
               dispose();
               new LogInFrame();
            }
         }
      }
   
		//load the stock coordinates
       public void loadStock(String name)
      {
         X.clear();
         Y.clear();
         String temp;
         addCoordinates(0,150);
         try 
         {
            BufferedReader in = new BufferedReader(new FileReader("stockInfo/"+name+".txt"));
            while((temp=in.readLine())!=null)
            {
               X.add(Integer.parseInt(temp));
               Y.add(Integer.parseInt(in.readLine()));
            }
            in.close();
            System.out.println("Load complete");
         } 
             catch (IOException iox) 
            {
               System.out.println("Cant find the stock");
            }
         for(int i=0; i<6; i++)
            System.out.println(X.get(i)+" "+Y.get(i));
         output1Stocks.repaint();
      }
   
   	//when the stock is clicked
       public void valueChanged(ListSelectionEvent e)
      {
         String selection = (String)((JList)e.getSource()).getSelectedValue();
         if(list.getValueIsAdjusting()==true)
         {
            output1Stocks.setVisible(true);
            output1.setVisible(false);
            output2.setVisible(true);
            output2forSetting.setVisible(false);
            output2forNews.setVisible(false);
         
            String []companyInfo = {"Car Company","Computer Company","Fast Food Company","Grocery Store Company","Banking Company"};         
            if(selection.equals("Car Company"))
            {
               loadStock("Car Company");
               System.out.println("Car company been selected");
            }
            else if(selection.equals("Computer Company"))
            {
               loadStock("Computer Company");
            }
            else if(selection.equals("Fast Food Company"))
            {
               loadStock("Fast Food Company");
            }
            else if(selection.equals("Grocery Store Company"))
            {      
            }
            else if(selection.equals("Banking Company"))
            {
            }
         }
      }
   
       public static void main(String[] args)
      {
         User a = new User();    
         new mainFrameVr4(a);
      //new mainFrameTEST().StringFly();
      }
   }