/*
	Author: 		Mark Wang
	Class: 		ICS4U
	Description: this is an class stimulator that helps user to manipulate stock
*/

import java.util.*;
import java.io.*;
import java.lang.*; 
import java.util.ArrayList;

//Company class
class Company {
	protected String companyName;
	
	public String getCompanyName() {
		return companyName;
	}
	
	public Company(String companyName) {
		this.companyName = companyName;
	}
}


// stock class, extends from company class contains information of each pieces of stock and the way to manipulate them
class Stock extends Company {
	private int stockCode;              //unique code for each company¡¯s stock
	private double updatedPercentage;   //change of stock¡¯s price in a day
	private boolean trend;	            //current trend of a stock, incline or decline
	private static int tradeDays;       //how many days of trading has been done 
   private int stockQty;               //quantities of stock has been bought , differ based on the owner of the stock
   private double stockPrice;          //the price of stock currently
	private double locationX;           //x-coordinate of the stock reflected on the line graph that shows the trend of stock 
	private double locationY;           //y-coordinate of the stock reflected on the line graph that shows the trend of stock 

   //accessors
	public int getStockCode() {
		return stockCode;
	}
	
	public boolean getTrend() {
		return trend;
	}
	
	public static int getTradeDays() {
		return tradeDays;
	}
   
   public int getStockQty() {
      return stockQty;
   }
   
   public double getStockPrice() {
      return stockPrice;
	}
	
	public double getUpdatedPercentage() {
		return updatedPercentage;
	}
	
	public double getX() {
		return locationX;
	}
	
	public double getY() {
		return locationY;
	}
	
   // mutators
	public void setX(double x) {
		locationX = x;
	}
	
	public void setY(double y) {
		locationY = y;
	}
	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}
   
   public void setStockQty(int stockQty) {
      this.stockQty = stockQty;
   }
   
   public void setStockPrice(double stockPrice) {
      this.stockPrice = stockPrice;
   }
	
	public void setTrend(boolean trend) {
		this.trend = trend;
	}
	
	public void setUpdatedPercentage(double updatedPercentage) {
		this.updatedPercentage = updatedPercentage;
	}
	
	public void setTrendDays (int tradeDays) {
		this.tradeDays = tradeDays;
	}
	

   //constructor
   public Stock(String companyName, int stockCode, double stockPrice) {
      super(companyName);
      this.stockCode = stockCode;
      this.stockPrice = stockPrice;
      this.stockQty = 0;
      this.updatedPercentage = 0;
      this.tradeDays = 0;
      this.trend = true;
      this.locationX = 0;
      this.locationY = 150;
   }
	
   //initialize the number of days of trading when the trading of each stock starts in the first day
	public void initializeTradeDays() {
		this.tradeDays = 0;
	}
	
   //randomly determine the trend of a piece of stock in a day and update this value to the field of trend
	public void generateTrend() {
		int upOrDown;
		upOrDown = (int)(1 + Math.random()*2);
		if (upOrDown == 1) {
			this.trend = true;
		} else {
			this.trend = false;
		}
	}
	
   //based on the trend of the stock, randomly generate the change of stock price in percentage and return the value
	public double generatePercent() {
		double point;
		point = Math.random()/10;
		if (this.trend == true) {
			return point;
		} else {
			return -point;
		}
	}
	
   // based on the percent generated, update the field of updatedPercentage
	public void updatePercent(double point) {
		this.updatedPercentage = point;
      
	}
   
   //  calculate the new price of one stock in a new days based on the updatedPercentage 
   public void updatePrice(double percent) {
      this.stockPrice *= 1+percent;
   }
   
   //record the numbers of days of trading
   public static void addTradeDays() {
      try {
         BufferedReader in = new BufferedReader(new FileReader("trade days"));
         tradeDays = Integer.parseInt(in.readLine());
      } catch(IOException iox) {
         System.out.println("error");
      }
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter("trade days"));
         tradeDays++;
         out.write(Integer.toString(tradeDays));
         out.close();
      } catch(IOException iox) {
         System.out.println("error");
      }
   }
   
   //set locationX and locationY to the initial position of the line graph on the mainframe.       
   public void initializePixel() {
		this.locationX = 0;
		this.locationY = 150;
   }
	
   //
	public void updateLocation() {
		this.locationX = 20 * this.tradeDays;
		if (this.updatedPercentage < 0) {
			this.locationY += this.updatedPercentage*150;
		} else {
			this.locationY  -= this.updatedPercentage*150;
		}
	}
			
   //update the values of locationX and locationY after a day of trading
	public void recordHistory () {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(this.companyName+".txt",true));
         out.write(Double.toString(stockPrice));
         out.newLine();
         out.write(Double.toString(locationX));
         out.newLine();
         out.write(Double.toString(locationY));
         out.newLine();
		}	catch (IOException iox) {
			System.out.println("Error1");
		}
	}
	/*
	public double[] findNumber() {
		double []list = new double[this.tradeDays];
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.companyName+".txt"));
			for (int i = 0; i < this.tradeDays; i++) {
				in.readLine();
				list[i] = Double.parseDouble(in.readLine());
			}
			in.close();
		} catch(IOException iox) {
			System.out.println("error");
		}
		return list;
	}
	
	public double findHighest() {
		double []list = this.findNumber();
		double currentLargest = list[0];
		for (int i = 0; i < list.length-2; i++) {
			if (list[i] < list[i+1]) {
				double temp = list[i];
				list[i] = list[i+1];
				list[i+1] = temp;
			}
		}
		return list[list.length-1];
	}
	
	public double findLowest() {
		double []list = this.findNumber();
		double currentLargest = list[0];
		for (int i = 0; i < list.length-2; i++) {
			if (list[i] > list[i+1]) {
				double temp = list[i];
				list[i] = list[i+1];
				list[i+1] = temp;
			}
		}
		return list[list.length-1];
	}	
	*/		
				
		
		
		
			
			
		
		
}

// User class that is associated to Stock, it contains a list of stock that allows user to manipulate them
class UserStock {
   Stock stockList[] = new Stock[5];                           //a list of stock owned by an user
	double purchase;                                            //total amount of money has been used to purchase 
   double withdrawal;                                          //total amount of money has withdrawn from the stock market
   double invested[] = new double[5];                          //amount of money for each piece of stock
   static Stock[] defaultStockList = new Stock[5];             //a list of all stocks of all company
	ArrayList<String> tradeTrend = new ArrayList<String>();     //after a day of trading, record the newest trend of a stock bought by an user
	ArrayList<Integer> tradeQty = new ArrayList<Integer>();     //after a day of trading, record the newest trend of a stock bought by an user
	ArrayList<String> stockName = new ArrayList<String>();      //after a day of trading, record the trading company
	
   //add info for each stock from the file Company Information
   public static void loadStockList() {
      try {
         BufferedReader in = new BufferedReader(new FileReader("Company Information.txt"));
         for (int i = 0; i < 5; i++) {
            defaultStockList[i]  = new Stock(in.readLine(), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()));
         }
         in.close();
     } catch (IOException iox) {
         System.out.println("error");
     }
   }
   
   //record newest info of each stock to the file Company Information, override
   public static void saveStockList() {
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter("Company Information.txt",false));
         for (int i = 0; i < 5; i++) {
            out.write(defaultStockList[i].companyName);
            out.newLine();
            out.write(Integer.toString(defaultStockList[i].getStockCode()));
            out.newLine();
            out.write(Double.toString(defaultStockList[i].getStockPrice()));
            out.newLine();
         }
         out.close();
      } catch (IOException iox) {
         System.out.println("Error");
      }
   }
   
   //update the information of stock in the default stock list after a day of trading
   public static void updateStock() {
      for (int i = 0; i < 5; i++) {
         defaultStockList[i].generateTrend();
         defaultStockList[i].updatePercent(defaultStockList[i].generatePercent());
         defaultStockList[i].updatePrice(defaultStockList[i].getUpdatedPercentage());
      }
   }
   
   //synchronize user¡¯s stock list with the default stock list
   public void updateMyStock() {
     for (int i = 0; i < 5; i++) {
         if (this.stockList[i] != null) {
            this.stockList[i].setTrend(defaultStockList[i].getTrend());
            this.stockList[i].setUpdatedPercentage(defaultStockList[i].getUpdatedPercentage());
            this.stockList[i].setStockPrice(defaultStockList[i].getStockPrice());
         }
     }
   }
// 
//    public int findIndex(int code) {
//       int index = -1;
//       for (int i = 0; i < this.stockList.length; i++) {
//          if (this.stockList[i] != null) {
//             if (this.stockList[i].getStockCode() == code) {
//                index = i;
//             }
//          }
//       }
//       return index;
//    }
      
   //reset or initialize the value of purchase and withdrawal          
   public void initializeAmount() {
      this.purchase = 0;
      this.withdrawal = 0;
   }
   
   //reset or initialize the array of value of the amount invested for each stock
   public void initializeInvestment() {
      for (int i= 1; i < 5; i++) {
         this.invested[i] = 0;
      }
   }
   
   //inside of buyStock, if the stock being bought has never been bought by the user before, add it to user¡¯s stock list
   public void addStockToList(int index) {
      this.stockList[index] = defaultStockList[index];
   }
   
   //take in the quantity user wants to buy and the stock¡¯s index in the user¡¯s stock list, consume amount of balance and buy stock 
   public void buyStock(int qty, int index) {
      if (this.stockList[index] != null) {
         this.stockList[index].setStockQty(qty);
      } else {
         this.addStockToList(index);
         this.stockList[index].setStockQty(this.stockList[index].getStockQty() + qty);
      }
      this.purchase += qty * stockList[index].getStockPrice();
      this.invested[index] += qty * stockList[index].getStockPrice();
      this.addTradeHistory(index,this.stockList[index].getTrend(),qty);
         
   }
   
   //inside of sellStock, if the stock being sold has 0 piece of stock left, remove it from user¡¯s stock list
   public void removeStockFromList(int index) {
      this.stockList[index] = null;
   }
   
   //take in the quantity user wants to want and the stock¡¯s index in the user¡¯s stock list, return amount of balance and sell stock 
   public void sellStock(int qty, int index) {
      if (this.stockList[index].getStockQty() <= qty) {
         this.removeStockFromList(index);
      } else {
         this.stockList[index].setStockQty(this.stockList[index].getStockQty() - qty);
      }
      this.withdrawal += qty * stockList[index].getStockPrice();
      this.addTradeHistory(index,this.stockList[index].getTrend(),qty);
   }
   
   //return a new stock list that has the same content default stock list but different order, rank from highest price to lowest
  	public static Stock[] rankStock() {
		Stock[] arrangedList = defaultStockList;
		for (int i = 1; i < 5; i++) {
			Stock temp = arrangedList[i];
			for (int j = i-1; j >= 0; j--) {
				if (arrangedList[j].getStockPrice() < temp.getStockPrice()) {
					arrangedList[j+1] = arrangedList[j];
					arrangedList[j] = temp;
				}
				
			}
		}
		return arrangedList;
	}
	
   //return a 2d array that contains the company name, current trend and change of percentage of the stocks  in stock list returned by rankStock
	public static String[][] listStock() {
		String [][]info = new String[5][3];
		Stock []list = rankStock();
		for (int i = 0; i < 5; i++) {
			info[i][0] = list[i].getCompanyName();
			info[i][1] = Boolean.toString(list[i].getTrend());
			info[i][2] = Double.toString(list[i].getUpdatedPercentage());
		}
      return info;
	}
	
   //convert all the information of defaultStockList to string
   public static String[] allToString() {
      String []displayForm = new String[5];
      String [][]form = listStock();
      for(int i = 0; i < 5; i++) {
          displayForm[i] = form[i][0]+"\t"+form[i][1]+" "+form[i][2];
      }
      return displayForm;
   }
   
   
   // takes in the stock index and the quantity and return the amount of money required to buy certain amount of stock
   public double calculate(int qty, int index) {
      return qty * this.stockList[index].getStockPrice();
   }
      
      
	
   //everytime a series of trade is done, add it to the arraylist that record trading history
	public void addTradeHistory(int index, boolean upOrDown, int qty) {
		this.stockName.add(this.stockList[index].getCompanyName());
		this.tradeQty.add(this.stockList[index].getStockQty());
		if (upOrDown == true) {
			this.tradeTrend.add("incline");
		} else {
			this.tradeTrend.add("decline");
		}
	}
   
   //return an arraylist of string information that tells user¡¯s stock information
   public ArrayList<String> myStockToString() {
      ArrayList<String> al = new ArrayList<String>();
      for (int i = 0; i < this.stockName.size(); i++) {
         al.add(this.stockName.get(i)+"\t"+this.tradeTrend.get(i)+" "+Integer.toString(this.tradeQty.get(i)));
      }
      return al;
  }
  
  
	
	

   
}    
         
 
 
 // a method that create an stock user to test the functionalities
 public class StockTester {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      // create an instance of userStock
      UserStock us = new UserStock();
      //prompt user to enter their choice
      System.out.println("Enter your choice");
      System.out.println("1)Review the stock list");
      System.out.println("2)review my stock");
      System.out.println("3)buy stock");
      System.out.println("4)sell stock");
      System.out.println("0)Exit");   
      //initialize variables  
      int choice = sc.nextInt();
      int index, qty;
      double x1 = 0;
      double x2 = 0;
      double y1 = 0;
      double y2 = 0;
      // load info for the user
      UserStock.loadStockList();
      us.stockList[0] = UserStock.defaultStockList[0];
      us.stockList[1] = UserStock.defaultStockList[1];
      us.stockList[2] = UserStock.defaultStockList[2];
      us.stockList[3] = UserStock.defaultStockList[3];
      us.stockList[4] = UserStock.defaultStockList[4];   
      //other initialization   
      for (int i = 0; i < 5; i++) {
         UserStock.defaultStockList[i].initializePixel();
      }
      Stock.addTradeDays();
      us.updateMyStock();     
      do {        
         switch(choice) {
            // review the information of all stock
            case 1:
               String []s = UserStock.allToString();
               for (int i = 0; i < 5; i++) {
                  System.out.println(s[i]);
               }
               //find the current coordinate location on the graph of mainfram
               System.out.println("Enter the index");
               index = sc.nextInt();
               if ((UserStock.defaultStockList[index].getX() == 0) && (UserStock.defaultStockList[index].getX() == 150)) {
                  x1 = UserStock.defaultStockList[index].getX();
                  y1 = UserStock.defaultStockList[index].getY();
                  UserStock.defaultStockList[index].updateLocation();
                  x2 = UserStock.defaultStockList[index].getX();
                  y2 = UserStock.defaultStockList[index].getY();
               } else {
                  x1 = x2;
                  y1 = y2;
                  UserStock.defaultStockList[index].updateLocation();
                  x2 = UserStock.defaultStockList[index].getX();
                  y2 = UserStock.defaultStockList[index].getY();
               }
               System.out.println("X-coordinate of initial position on the graph"+x1);
               System.out.println("Y-coordinate of initial position on the graph"+y1);
               System.out.println("X-coordinate of final position on the graph"+x2);
               System.out.println("Y-coordinate of final position on the graph"+y2);
               break;
            // review user's stock info
            case 2:
               ArrayList<String> myStock = us.myStockToString();
               for (int i = 0; i < myStock.size(); i++) {
                  System.out.println(myStock.get(i));
               }
               // find coordinate of certain stock
               System.out.println("Enter the index");
               index = sc.nextInt();
               if (UserStock.defaultStockList[index].getX() == 0 && UserStock.defaultStockList[index].getX() == 150) {
                  x1 = UserStock.defaultStockList[index].getX();
                  y1 = UserStock.defaultStockList[index].getY();
                  UserStock.defaultStockList[index].updateLocation();
                  x2 = UserStock.defaultStockList[index].getX();
                  y2 = UserStock.defaultStockList[index].getY();
               } else {
                  x1 = x2;
                  y1 = y2;
                  UserStock.defaultStockList[index].updateLocation();
                  x2 = UserStock.defaultStockList[index].getX();
                  y2 = UserStock.defaultStockList[index].getY();
               }
               System.out.println("X-coordinate of initial position on the graph"+x1);
               System.out.println("Y-coordinate of initial position on the graph"+y1);
               System.out.println("X-coordinate of final position on the graph"+x2);
               System.out.println("Y-coordinate of final position on the graph"+y2);
               break;
            // buy stock
            case 3:
               System.out.println("Enter the stock Quantity");
               qty = sc.nextInt();
               System.out.println("Enter the index");
               index = sc.nextInt();
               us.buyStock(qty,index);
               System.out.println("total investment:"+us.invested[index]); 
               System.out.println("Stock worth:"+us.calculate(qty,index));
               System.out.println("Stock owned:"+us.stockList[index].getStockQty());
               break;
            // sell stock
            case 4:
               System.out.println("Enter the stock Quantity");
               qty = sc.nextInt();
               System.out.println("Enter the index");
               index = sc.nextInt();
               us.sellStock(qty,index);
               System.out.println("Stock worth:"+us.calculate(qty,index));
               System.out.println("Stock owned:"+us.stockList[index].getStockQty()); 
               break;
            // quit, update the stock's information(a new day comes)
            case 0:
               UserStock.updateStock();
               for(int i = 0; i < 5; i++) {
                  UserStock.defaultStockList[i].recordHistory();
               }
               
               
               break;
            default:
               System.out.println("Invalid input");
               break;
         }
         
         if (choice != 0) {
            System.out.println("Enter your choice");
            choice = sc.nextInt();
        }
       } while(choice != 0);
     }
   }                 
      