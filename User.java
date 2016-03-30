   import java.util.*;
   import java.io.*;

    class User
   {
      // user's general info
      private String username;
      private String firstname;
      private String lastname;
      private String loginpass;
      private String password;
      private double balance;
      //private UserStock us;
   	
      // constructor 1
       public User(String username, String lastname, String firstname, String loginpass, String password, double balance)
      {	
         this.username = username;
         this.firstname = firstname;
         this.lastname = lastname;
         this.loginpass = loginpass;
         this.password = password;
         this.balance = balance;
         //this.us = new UserStock();
      }
      
      //default constructor
       public User()
      {
         username = "";
         firstname = "";
         lastname = "";
         loginpass = "";
         password = "";
         balance = 0.0;
      }
      
      // accessor
       public String getUsername()
      {
         return username;
      }
   
       public void setUsername(String username)
      {
         this.username = username;
      }
   
       public String getFirstname()
      {
         return firstname;
      }
   
       public void setFirstname(String firstname)
      {
         this.firstname = firstname;
      }
   
       public String getLastname()
      {
         return lastname;
      }
      
      //mutator
       public void setLastname(String lastname)
      {
         this.lastname = lastname;
      }
   
       public String getLoginpass()
      {
         return loginpass;
      }
   
       public void setLoginpass(String loginpass)
      {
         this.loginpass = loginpass;
      }
   
       public String getPassword()
      {
         return password;
      }
   
       public void setPassword(String password)
      {
         this.password = password;
      }
   
       public double getBalance()
      {
         return balance;
      }
   
       public void setBalance(double balance)
      {
         this.balance = balance;
      }
      
      //set the user¡¯s balance to 0
       public void resetBalance()
      {
         balance = 0.0;
      }
      
      //add certain amount of balance to user¡¯s account
       public void addBalance(double amount)
      {
         balance = balance + amount;
      }
   
      //deduct certain amount of balance when a user buys stock
       public void deductBalance(double amount)
      {
         balance = balance - amount;
      }
   
       
      //save user¡¯s information to a file temporarily
       public void saveUser() {
      
         try {
            BufferedWriter out = new BufferedWriter(new FileWriter("User.txt",true));
            out.write(this.firstname+this.lastname);
            out.newLine();
            out.close();
         }	
             catch (IOException iox) {
               System.out.println("error");
            }
      
         try {
            BufferedWriter out = new BufferedWriter(new FileWriter("userInfo/"+this.username+".txt"));
            out.write(this.username);
            out.newLine();
            out.write(this.firstname);
            out.newLine();
            out.write(this.lastname);
            out.newLine();
            out.write(this.loginpass);
            out.newLine();
            out.write(this.password);
            out.newLine();
            out.write(Double.toString(this.balance));
            out.newLine();
            out.write("");
            out.newLine();
            out.close();
         }	
             catch (IOException iox) {
               System.out.println("error");
            }
      }
   
      //load user¡¯s information from a file
       public static User loadUser(String using) {
		 	User temp = new User();
         try {
            BufferedReader in = new BufferedReader(new FileReader("userInfo/"+using+".txt"));
            temp.username = in.readLine();
            temp.firstname = in.readLine();
            temp.lastname = in.readLine();
            temp.loginpass = in.readLine();
            temp.password = in.readLine();
            temp.balance = Double.parseDouble(in.readLine());
            in.close();
				System.out.println("Load complete");
         } 
             catch (IOException iox) {
               System.out.println("Cant find the user");
            }
				return temp;
      }
   	
   	
   }
	
    class usertest
   {
       public static void main(String[] args)
      {
         Scanner sc = new Scanner(System.in);
        //  String username, last, first, pass, spass;
//          double money;
//          System.out.println("Enter username: ");
//          username = sc.nextLine();
//          System.out.println("Enter your last name: ");
//          last = sc.nextLine();
//          System.out.println("Enter your first name: ");
//          first = sc.nextLine();
//          System.out.println("Enter your password: ");
//          pass = sc.nextLine();
//          System.out.println("Enter your spass: ");
//          spass = sc.nextLine();
//          System.out.println("Enter your balance to start with: ");
//          money = sc.nextDouble();
//       	
//          User u1 = new User(username, last, first, pass, spass, money);
//          u1.saveUser();
			
			System.out.println("load a user: ");
			String s = sc.nextLine();
			User loadone = User.loadUser(s);
      }
   }