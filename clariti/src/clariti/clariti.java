package clariti;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class clariti {
      
      // getting input from users
      public void getInputs() throws Exception {
    	  
    	  Scanner sc= new Scanner(System.in);   
  		  String var;//System.in is a standard input stream  
  		  
  		  do {
  			System.out.print("Enter Department : ");  
		    String Department= sc.nextLine();
		    System.out.print("Enter Category : ");  
		    String Category= sc.nextLine(); 
  			System.out.print("Enter Subcategory : ");  
  		    String Subcategory= sc.nextLine();
  			System.out.print("Enter type : ");  
  		    String type= sc.nextLine();
  			
  			calculate_fee(Department, Category, Subcategory, type);
  			
  			System.out.print("WOULD YOU LIKE TO CALCULATE AGAIN (Y/N) : ");
  			var= sc.nextLine();
  			if(!var.equalsIgnoreCase("Y")) {
  				System.out.print("Thanks");
  			    }
  		   }while(var.equalsIgnoreCase("Y"));
      }
      
      // getting surcharge based on departments
      public double getSurcharge(String department) {
    	  double surcharge = 0;
    	  if(department.equalsIgnoreCase("Marketing")) {
  			surcharge = 0.10;
  		  } if(department.equalsIgnoreCase("Sales")) {
  			surcharge = 0.15;
  		  }if(department.equalsIgnoreCase("Development")) {
  			surcharge = 0.20;
  		  }if(department.equalsIgnoreCase("Operations")) {
  			surcharge = 0.15;
  		  }if(department.equalsIgnoreCase("Support")) {
  			surcharge = 0.05;
  		  }
  		return surcharge;
      }
      
      public int calculate_fee(String department, String category, String subCategory, String type) throws Exception{
  		
  		String filename = "csvfile/raw_fees.csv";
  		File file =  new File(filename);
  		
  		double fees = 0;
  		double subtotal = 0;
  		int  total = 0;
  		double sum = 0;
  			Scanner inputStream = new Scanner(file);
  			while(inputStream.hasNext()) {
  				String data = inputStream.nextLine();
  				String[] values = data.split(",");
  				if(values[3].equalsIgnoreCase(department) && values[4].equalsIgnoreCase(category) &&
  					values[5].equalsIgnoreCase(subCategory) && values[6].equalsIgnoreCase(type)) {
  					
  				    double quantity = Double.parseDouble(values[7]);
  					double price = Double.parseDouble(values[8]);
  					fees = quantity * price;
  				} 
  			   sum += fees;
  			}
  			subtotal = sum + (getSurcharge(department) * sum);
  			total = (int)(subtotal);
  			System.out.println("The total "+type+" fees for "+subCategory+" subcategory within the "+category+" "
  					+ "Category of the "+department+" department is : "+total);
  			inputStream.close();
  			return total;
  	    }
	 
      // main method
     public static void main(String[] args) throws Exception {
  		clariti obj = new clariti();
		obj.getInputs();
	   }
}
