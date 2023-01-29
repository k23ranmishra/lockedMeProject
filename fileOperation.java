import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class fileOperation {

	public static String fileFound= "false";
	 
	static void fileOperationProcess(String fileOperationSelection){
	
		fileOperation fileOperationObj = new fileOperation();
		
		    String fileOperationselected=fileOperationSelection;
		  
			switch( fileOperationselected  ) {
		
			case "2":
			  
			  fileOperationObj.listAllFiles();				  
		    
			  break;
		  case "3":
			  
			  fileOperationObj.addFile();
			  
		    break;
		  
		  case "4":
			  fileOperationObj.deleteFile();
			  
			    break;
		  case "5":
			  
			  fileOperationObj.searchFile();
			    break;
			  	 
		  default:
		    // code block
		}
	
		  
	  }

	  void listAllFiles(){
		  
		  System.out.println(" 2. List all files\n. ");
		  
		  System.out.println("\n********** Below files are found in current directory ************\n");
		  
		  File curDir = new File(".");
		  
		  File[] filesList = curDir.listFiles();
	        for(File f : filesList){
	            if(f.isDirectory())
	                System.out.println(f.getName());
	            if(f.isFile()){
	                System.out.println(f.getName());
	            }
	        }
		 

			  System.out.println("\n**************************************************************\n");
			  
	  }

	  void addFile(){
		  
		  System.out.println(" 3. Add a file\n . ");
		  
		  System.out.println("Write name of the file to be created ");
		  
		  String input;
          		  
		  Scanner addFileNameScanner = new Scanner(System.in);  
			
	      String addFileName = addFileNameScanner.nextLine();
			
	      File curDir = new File(".");
		  
		  File tmp = new File(curDir, addFileName);
		  try{
		  tmp.createNewFile();
		  System.out.println("File is created successfully");
		  }
		  catch( Exception e){
			  
			  System.out.println(e.getLocalizedMessage());
		  }

	      System.out.println("Write content of the file.. type exit to complete your content ");
	      
	      StringBuilder sb = new StringBuilder();
		  
		  try (Scanner addFileContentScanner = new Scanner(System.in)) {
	             while (!(input = addFileContentScanner.nextLine()).equals("exit")) {
	                sb.append(input);
	            }
	    
	             try (BufferedWriter writer = new BufferedWriter(new FileWriter(tmp))) {
	                 writer.append(input);
	             }
	             catch(Exception e){
	            	 System.out.println("Error occured while writing to file.  "+e.getMessage());
	             }
	            
	            
		  }
		  
		  
		
		  
		  	  }
	  
	  void deleteFile(){
		  
		  System.out.println(" 4. Delete a file\n. ");
		  
		  Scanner scan = new Scanner(System.in);
	        
		  System.out.println("Enter the file to be deleted.. " );
	        
		  String fileNameToSearch = scan.next();	  
		  
		  	  
		  findFile(fileNameToSearch,new File("."));  
		  
		  if (fileFound.indexOf("false") >=0 )
	        	System.out.println("File is not found");
		  else
		  {
			  System.out.println("File is  found");
		  
			  try  
			  {         
			  File f= new File(fileNameToSearch);         
			  if(f.delete())                       
			  {  
			  System.out.println(f.getName() + "File is successfully deleted");     
			  }  
			  else  
			  {  
			  System.out.println("deletion failed");  
			  }  
			  }  
			  catch(Exception e)  
			  {  
			  e.printStackTrace();  
			  }  

			  
			  
			  
		  }
		  
		  		  
		  
	  }
	  
	  void searchFile(){
		  
		  System.out.println(" 5. Search a file\n.  ");
		  
		  Scanner scan = new Scanner(System.in);
	        
		  System.out.println("Enter the file to be searched.. " );
	        
		  String fileNameToSearch = scan.next();	  
		  
		  	  
		  findFile(fileNameToSearch,new File("."));  
		  
		  if (fileFound.indexOf("false") >=0 )
	        	System.out.println("File is not found");
		  else
			  System.out.println("File is  found");
		  
		  
		  
	}
	  
	  
	  public void findFile(String name,File file)
	    {
		  
		  	  
		    File[] list = file.listFiles();
	       
	        if(list!=null)
	         for (File fil : list)
	        {
	            if (fil.isDirectory())
	            {
	                findFile(name,fil);
	            }
	            else if (name.equalsIgnoreCase(fil.getName()))
	            {
	                System.out.println(fil.getParentFile());
	                System.out.println("File is found at"+ fil.getAbsolutePath());
	                fileFound = "true";
	            }
	            
	            
	        }
	        
	                 
	    }	  
	  
}

