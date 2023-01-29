import java.util.Scanner;  // Import the Scanner class

public class welcomeInit {
	
	public static String menuOption = "0" ;
	
	public static String fileOperationOption = "0";
	

	public static void main (String args[]) {
		
		System.out.println("**********************************************************************************\n");
		
		System.out.println("\t\t Welcome to LockedMe\t\t\t\t\t\n");
		
		System.out.println("Application name : LockedMeDemo V1.0 \t  \t Developer : Ranjeet Mishra    \n");
		
		System.out.println("***********************************************************************************\n");
		
		
		Scanner menuSelectionScanner = new Scanner(System.in);  
		
		System.out.println("To select Menu, please press 1 . To exit, please press anything else \n");

	    String menuSelectionOption = menuSelectionScanner.nextLine();
	    
	    if ( menuSelectionOption.indexOf("1") >=0 ) {
	    	
	    	menuList menuListObj =  new menuList();
	    	
	    	fileOperation fileOperationObj = new fileOperation();
	    	
	    	menuListObj.displayMenu();
	    	
	    	fileOperationSelection();
	    	
	    	fileOperationObj.fileOperationProcess( fileOperationOption );
	    			
	    	
	    }
	    else 
	    {
	    	System.out.println("exiting from the program. you didn't select to proceed\n");
	    }
	    
	    		
	}
	
	  static void fileOperationSelection(){
		 
		 System.out.println(" Select your option to proceed");

			Scanner fileOperationSelectionScanner = new Scanner(System.in);  
			
			String fileOperationSelected = fileOperationSelectionScanner.nextLine();
			
			if (fileOperationSelected.indexOf("2")>=0 ||
				fileOperationSelected.indexOf("3")>=0 ||
				fileOperationSelected.indexOf("4")>=0 ||
				fileOperationSelected.indexOf("5")>=0 ) {
			
					fileOperationOption = fileOperationSelected;
            }
			else
			{
				fileOperationOption = "0";
			}
				

	 }
	  
}

