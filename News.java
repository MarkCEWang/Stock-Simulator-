 //Importing libraries
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
Name: Chengli Yang
Class: ICS4U
School: A. Y. Jackson Secondary School
Date: June 2, 2015
Description: This is the News class, it contains methods to choose
and read random news articles and picking the visuals that represents that news
*/

class News {
 
 //Initializing instance fields
 
 //This variable is static so the both method newsSelect and companyIndex can determinethe index of the news selected
   public static int companyIndex = -1;
   public int newsIndex = -1;
   private int lastCompanyIndex = -1;
   private int lastNewsIndex = -1;
   
 //Creating variable that determines if a positive or negative news is selected
 //This variable is static so both the method newsSelect and isPositive can use this variable to determine if the news is positive
   static int newsSelect;

   public String newsSelect() {
   
   //Making the newsPositive variable a random number of 0 or 1
      do {
         newsSelect = (int)(Math.random() * 2);
      } while (newsSelect != 0 && newsSelect != 1);
   
   //Depending on the value of newsPositive, runs the method that selects a news
      String s = "";
   
      if(newsSelect == 1) {
         s = randomPositiveNews();
      } 
      else if (newsSelect == 0) {
         s = randomNegativeNews();
      }
      
      return s;
   }

//randomNegativeNews
//Selects a random negative news and reads it from the news files, it then returns this news
   public String randomNegativeNews() {
    
    //Return variable
      String news = "";
    
      do {
      //Creating random company index
         companyIndex = (int)(Math.random() * 5);
      } while (companyIndex < 0 || companyIndex > 4);	//Checking to make sure companyIndex does not equal to 5
         
      //Storing the last company index
      lastCompanyIndex = companyIndex;
   	
   
      //Creating random news index
      do {
         newsIndex = (int)(Math.random() * 10 + 10);
      } while(companyIndex == lastCompanyIndex && newsIndex == lastNewsIndex || newsIndex < 10 || newsIndex > 19);  //Checking to make sure newsIndex does not equal to 10
       
   	//Storing the last newsIndex
      lastNewsIndex = newsIndex;
   	
   	//Creatint temporay field for readLine()
      String tempIndex;
   	
   	//Car company news
      if (companyIndex == 0) {
         try {
            File f0 = new File("newsdoc/CarCompanyNews.rtf");
            FileReader fr0 = new FileReader(f0);
            BufferedReader br0 = new BufferedReader(fr0);
            //Finding news index
            do {
               tempIndex = br0.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br0.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Computer company news
      if (companyIndex == 1) {
         try {
            File f1 = new File("newsdoc/ComputerCompanyNews.rtf");
            FileReader fr1 = new FileReader(f1);
            BufferedReader br1 = new BufferedReader(fr1);
            //Finding news index
            do {
               tempIndex = br1.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br1.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Fast food company news
      if (companyIndex == 2) {
         try {
            File f2 = new File("newsdoc/FastFoodCompanyNews.rtf");
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);
            //Finding news index
            do {
               tempIndex = br2.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br2.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Grocery store company news
      if (companyIndex == 3) {
         try {
            File f3 = new File("newsdoc/GroceryStoreCompanyNews.rtf");
            FileReader fr3 = new FileReader(f3);
            BufferedReader br3 = new BufferedReader(fr3);
            //Finding news index
            do {
               tempIndex = br3.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br3.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Banking company news
      if (companyIndex == 4) {
         try {
            File f4 = new File("newsdoc/BankCompanyNews.rtf");
            FileReader fr4 = new FileReader(f4);
            BufferedReader br4 = new BufferedReader(fr4);
             //Finding news index            
            do {
               tempIndex = br4.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br4.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Return statement
      return news;
   }
   
	
//randomPositiveNews
//Selects a random negative news and reads it from the news files, it then returns this news
   public String randomPositiveNews() {
    
    //Return variable
      String news = "";
    
      do {
      //Creating random company index
         companyIndex = (int)(Math.random() * 5);
      } while (companyIndex < 0 || companyIndex > 4);	//Checking to make sure companyIndex does not equal to 5
      //Storing the last company index
      lastCompanyIndex = companyIndex;
   	
      //Creating random news index
      do {
         newsIndex = (int)(Math.random() * 10);
      } while(companyIndex == lastCompanyIndex && newsIndex == lastNewsIndex || newsIndex < 0 || newsIndex > 9);  //Checking to make sure newsIndex does not equal to 10
       
   	//Storing the last newsIndex
      lastNewsIndex = newsIndex;
   	
   	//Creating temporay field for readLine()
      String tempIndex = "";
   	
   	//Car company news
      if (companyIndex == 0) {
         try {
            File f0 = new File("newsdoc/CarCompanyNews.rtf");
            FileReader fr0 = new FileReader(f0);
            BufferedReader br0 = new BufferedReader(fr0);
               //Finding news index
            do {
               tempIndex = br0.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br0.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Computer company news
      if (companyIndex == 1) {
         try {
            File f1 = new File("newsdoc/ComputerCompanyNews.rtf");
            FileReader fr1 = new FileReader(f1);
            BufferedReader br1 = new BufferedReader(fr1);
               //Finding news index
            do {
               tempIndex = br1.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br1.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Fast food company news
      if (companyIndex == 2) {
         try {
            File f2 = new File("newsdoc/FastFoodCompanyNews.rtf");
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);
            //Finding news index
            do {
               tempIndex = br2.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br2.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Grocery store company news
      if (companyIndex == 3) {
         try {
            File f3 = new File("newsdoc/GroceryStoreCompanyNews.rtf");
            FileReader fr3 = new FileReader(f3);
            BufferedReader br3 = new BufferedReader(fr3);
            //Finding news index
            do {
               tempIndex = br3.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br3.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Banking company news
      if (companyIndex == 4) {
         try {
            File f4 = new File("newsdoc/BankCompanyNews.rtf");
            FileReader fr4 = new FileReader(f4);
            BufferedReader br4 = new BufferedReader(fr4);
               //Finding news index
            do {
               tempIndex = br4.readLine();
            } while(!tempIndex.equals(String.valueOf(newsIndex)));
            news = br4.readLine();
         } 
         catch(IOException iox) {
            System.out.println("Error");
         }
      }
      
   	//Return statement
      return news;
   }

//resetNews
//Resets the fields to the their initial values
   public void resetNews() {
      companyIndex = -1;
      newsIndex = -1;
      lastCompanyIndex = -1;
      lastNewsIndex = -1;
   }
   
   //isPositive
   //Determines if the last news generated is a positive news or not
   //Returns true if positive, returns false is negative
   public boolean isPositive() {
      boolean pos = false;
      if (newsSelect == 0) {
         pos = true;
      } 
      else if (newsSelect == 1) {
         pos = false;
      }
      return pos;
   }
   
   //companyIndex
   //Determines the company index of the news selected
   //0 = Car Company, 1 = Computer Company, 2 = Fast Food Company, 3 = Grocery Store Company, 4 = Bank Company
   public int companyIndex() {
   return companyIndex;
   }

//NewsPicture
//Returns the picture file name as a String according to the news dialogue randomly selected
   public String newsPicture() {
   
   //Creating field that represents the image name of the news
      String image = "";
      
   //Setting the image field to be the picture saved in the file according to the news that was randomly selected
      if (companyIndex == 0 && newsIndex == 0) {
         image = "gifPictures/Company0News0.gif";
      } 
      else if (companyIndex == 0 && newsIndex == 1) {
         image = "gifPictures/Company0News1.gif";
      }
      else if (companyIndex == 0 && newsIndex == 2) {
         image = "gifPictures/Company0News2.gif";
      }
      else if (companyIndex == 0 && newsIndex == 3) {
         image = "gifPictures/Company0News3.gif";         
      }
      else if (companyIndex == 0 && newsIndex == 4) {
         image = "gifPictures/Company0News4.gif";
      }
      else if (companyIndex == 0 && newsIndex == 5) {
         image = "gifPictures/Company0News5.gif";
      }
      else if (companyIndex == 0 && newsIndex == 6) {
         image = "gifPictures/Company0News6.gif";
      }
      else if (companyIndex == 0 && newsIndex == 7) {
         image = "gifPictures/Company0News7.gif";
      }
      else if (companyIndex == 0 && newsIndex == 8) {
         image = "gifPictures/Company0News8.gif";
      }
      else if (companyIndex == 0 && newsIndex == 9) {
         image = "gifPictures/Company0News9.gif";
      }
      else if (companyIndex == 0 && newsIndex == 10) {
         image = "gifPictures/Company0News10.gif";
      }
      else if (companyIndex == 0 && newsIndex == 11) {
         image = "gifPictures/Company0News11.gif";
      }
      else if (companyIndex == 0 && newsIndex == 12) {
         image = "gifPictures/Company0News12.gif";
      }
      else if (companyIndex == 0 && newsIndex == 13) {
         image = "gifPictures/Company0News13.gif";
      }
      else if (companyIndex == 0 && newsIndex == 14) {
         image = "gifPictures/Company0News14.gif";
      }
      else if (companyIndex == 0 && newsIndex == 15) {
         image = "gifPictures/Company0News15.gif";
      }
      else if (companyIndex == 0 && newsIndex == 16) {
         image = "gifPictures/Company0News16.gif";
      }
      else if (companyIndex == 0 && newsIndex == 17) {
         image = "gifPictures/Company0News17.gif";
      }
      else if (companyIndex == 0 && newsIndex == 18) {
         image = "gifPictures/Company0News18.gif";
      }
      else if (companyIndex == 0 && newsIndex == 19) {
         image = "gifPictures/Company0News19.gif";
      }
      else if (companyIndex == 1 && newsIndex == 0) {
         image = "gifPictures/Company1News0.gif";
      } 
      else if (companyIndex == 1 && newsIndex == 1) {
         image = "gifPictures/Company1News1.gif";
      }
      else if (companyIndex == 1 && newsIndex == 2) {
         image = "gifPictures/Company1News2.gif";
      }
      else if (companyIndex == 1 && newsIndex == 3) {
         image = "gifPictures/Company1News3.gif";
      }
      else if (companyIndex == 1 && newsIndex == 4) {
         image = "gifPictures/Company1News4.gif";
      }
      else if (companyIndex == 1 && newsIndex == 5) {
         image = "gifPictures/Company1News5.gif";
      }
      else if (companyIndex == 1 && newsIndex == 6) {
         image = "gifPictures/Company1News6.gif";
      }
      else if (companyIndex == 1 && newsIndex == 7) {
         image = "gifPictures/Company1News7.gif";
      }
      else if (companyIndex == 1 && newsIndex == 8) {
         image = "gifPictures/Company1News8.gif";
      }
      else if (companyIndex == 1 && newsIndex == 9) {
         image = "gifPictures/Company1News9.gif";
      }
      else if (companyIndex == 1 && newsIndex == 10) {
         image = "gifPictures/Company1News10.gif";
      }
      else if (companyIndex == 1 && newsIndex == 11) {
         image = "gifPictures/Company1News11.gif";
      }
      else if (companyIndex == 1 && newsIndex == 12) {
         image = "gifPictures/Company1News12.gif";
      }
      else if (companyIndex == 1 && newsIndex == 13) {
         image = "gifPictures/Company1News13.gif";
      }
      else if (companyIndex == 1 && newsIndex == 14) {
         image = "gifPictures/Company1News14.gif";
      }
      else if (companyIndex == 1 && newsIndex == 15) {
         image = "gifPictures/Company1News15.gif";
      }
      else if (companyIndex == 1 && newsIndex == 16) {
         image = "gifPictures/Company1News16.gif";
      }
      else if (companyIndex == 1 && newsIndex == 17) {
         image = "gifPictures/Company1News17.gif";
      }
      else if (companyIndex == 1 && newsIndex == 18) {
         image = "gifPictures/Company1News18.gif";
      }
      else if (companyIndex == 1 && newsIndex == 19) {
         image = "gifPictures/Company1News19.gif";
      }
      else if (companyIndex == 2 && newsIndex == 0) {
         image = "gifPictures/Company2News0.gif";
      } 
      else if (companyIndex == 2 && newsIndex == 1) {
         image = "gifPictures/Company2News1.gif";
      }
      else if (companyIndex == 2 && newsIndex == 2) {
         image = "gifPictures/Company2News2.gif";
      }
      else if (companyIndex == 2 && newsIndex == 3) {
         image = "gifPictures/Company2News3.gif";
      }
      else if (companyIndex == 2 && newsIndex == 4) {
         image = "gifPictures/Company2News4.gif";
      }
      else if (companyIndex == 2 && newsIndex == 5) {
         image = "gifPictures/Company2News5.gif";
      }
      else if (companyIndex == 2 && newsIndex == 6) {
         image = "gifPictures/Company2News6.gif";
      }
      else if (companyIndex == 2 && newsIndex == 7) {
         image = "gifPictures/Company2News7.gif";
      }
      else if (companyIndex == 2 && newsIndex == 8) {
         image = "gifPictures/Company2News8.gif";
      }
      else if (companyIndex == 2 && newsIndex == 9) {
         image = "gifPictures/Company2News9.gif";
      }
      else if (companyIndex == 2 && newsIndex == 10) {
         image = "gifPictures/Company2News10.gif";
      }
      else if (companyIndex == 2 && newsIndex == 11) {
         image = "gifPictures/Company2News11.gif";
      }
      else if (companyIndex == 2 && newsIndex == 12) {
         image = "gifPictures/Company2News12.gif";
      }
      else if (companyIndex == 2 && newsIndex == 13) {
         image = "gifPictures/Company2News13.gif";
      }
      else if (companyIndex == 2 && newsIndex == 14) {
         image = "gifPictures/Company2News14.gif";
      }
      else if (companyIndex == 2 && newsIndex == 15) {
         image = "gifPictures/Company2News15.gif";
      }
      else if (companyIndex == 2 && newsIndex == 16) {
         image = "gifPictures/Company2News16.gif";
      }
      else if (companyIndex == 2 && newsIndex == 17) {
         image = "gifPictures/Company2News17.gif";
      }
      else if (companyIndex == 2 && newsIndex == 18) {
         image = "gifPictures/Company2News18.gif";
      }
      else if (companyIndex == 2 && newsIndex == 19) {
         image = "gifPictures/Company2News19.gif";
      }
      else if (companyIndex == 3 && newsIndex == 0) {
         image = "gifPictures/Company3News0.gif";
      } 
      else if (companyIndex == 3 && newsIndex == 1) {
         image = "gifPictures/Company3News1.gif";
      }
      else if (companyIndex == 3 && newsIndex == 2) {
         image = "gifPictures/Company3News2.gif";
      }
      else if (companyIndex == 3 && newsIndex == 3) {
         image = "gifPictures/Company3News3.gif";
      }
      else if (companyIndex == 3 && newsIndex == 4) {
         image = "gifPictures/Company3News4.gif";
      }
      else if (companyIndex == 3 && newsIndex == 5) {
         image = "gifPictures/Company3News5.gif";
      }
      else if (companyIndex == 3 && newsIndex == 6) {
         image = "gifPictures/Company3News6.gif";
      }
      else if (companyIndex == 3 && newsIndex == 7) {
         image = "gifPictures/Company3News7.gif";
      }
      else if (companyIndex == 3 && newsIndex == 8) {
         image = "gifPictures/Company3News8.gif";
      }
      else if (companyIndex == 3 && newsIndex == 9) {
         image = "gifPictures/Company3News9.gif";
      }
      else if (companyIndex == 3 && newsIndex == 10) {
         image = "gifPictures/Company3News10.gif";
      }
      else if (companyIndex == 3 && newsIndex == 11) {
         image = "gifPictures/Company3News11.gif";
      }
      else if (companyIndex == 3 && newsIndex == 12) {
         image = "gifPictures/Company3News12.gif";
      }
      else if (companyIndex == 3 && newsIndex == 13) {
         image = "gifPictures/Company3News13.gif";
      }
      else if (companyIndex == 3 && newsIndex == 14) {
         image = "gifPictures/Company3News14.gif";
      }
      else if (companyIndex == 3 && newsIndex == 15) {
         image = "gifPictures/Company3News15.gif";
      }
      else if (companyIndex == 3 && newsIndex == 16) {
         image = "gifPictures/Company3News16.gif";
      }
      else if (companyIndex == 3 && newsIndex == 17) {
         image = "gifPictures/Company3News17.gif";
      }
      else if (companyIndex == 3 && newsIndex == 18) {
         image = "gifPictures/Company3News18.gif";
      }
      else if (companyIndex == 3 && newsIndex == 19) {
         image = "gifPictures/Company3News19.gif";
      }
      else if (companyIndex == 4 && newsIndex == 0) {
         image = "gifPictures/Company4News0.gif";
      } 
      else if (companyIndex == 4 && newsIndex == 1) {
         image = "gifPictures/Company4News1.gif";
      }
      else if (companyIndex == 4 && newsIndex == 2) {
         image = "gifPictures/Company4News2.gif";
      }
      else if (companyIndex == 4 && newsIndex == 3) {
         image = "gifPictures/Company4News3.gif";
      }
      else if (companyIndex == 4 && newsIndex == 4) {
         image = "gifPictures/Company4News4.gif";
      }
      else if (companyIndex == 4 && newsIndex == 5) {
         image = "gifPictures/Company4News5.gif";
      }
      else if (companyIndex == 4 && newsIndex == 6) {
         image = "gifPictures/Company4News6.gif";
      }
      else if (companyIndex == 4 && newsIndex == 7) {
         image = "gifPictures/Company4News7.gif";
      }
      else if (companyIndex == 4 && newsIndex == 8) {
         image = "gifPictures/Company4News8.gif";
      }
      else if (companyIndex == 4 && newsIndex == 9) {
         image = "gifPictures/Company4News9.gif";
      }
      else if (companyIndex == 4 && newsIndex == 10) {
         image = "gifPictures/Company4News10.gif";
      }
      else if (companyIndex == 4 && newsIndex == 11) {
         image = "gifPictures/Company4News11.gif";
      }
      else if (companyIndex == 4 && newsIndex == 12) {
         image = "gifPictures/Company4New12.gif";
      }
      else if (companyIndex == 4 && newsIndex == 13) {
         image = "gifPictures/Company4News13.gif";
      }
      else if (companyIndex == 4 && newsIndex == 14) {
         image = "gifPictures/Company4News14.gif";
      }
      else if (companyIndex == 4 && newsIndex == 15) {
         image = "gifPictures/Company4News15.gif";
      }
      else if (companyIndex == 4 && newsIndex == 16) {
         image = "gifPictures/Company4News16.gif";
      }
      else if (companyIndex == 4 && newsIndex == 17) {
         image = "gifPictures/Company4News17.gif";
      }
      else if (companyIndex == 4 && newsIndex == 18) {
         image = "gifPictures/Company4News18.gif";
      }
      else if (companyIndex == 4 && newsIndex == 19) {
         image = "gifPictures/Company4News19.gif";
      }
    
    //Return statement     
      return image;
   }
}
