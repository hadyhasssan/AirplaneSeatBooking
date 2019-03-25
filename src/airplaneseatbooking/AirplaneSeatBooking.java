package airplaneseatbooking;
import java.util.*;// IMPORTED JAVA LIBRARIES.
import java.io.*;
public class AirplaneSeatBooking { //PRIMARY CLASS.
    
//*************Developed By Hady Hussain Batool @all rights reserved,*******************\\

   static final int SEATING_CAPACITY = 12;  // MAX SEATING DECLARED AS GLOBAL CONSTANT.
    public static void main(String[] args) throws FileNotFoundException { // MAIN FUNCTION
        String [] airplane = new String[SEATING_CAPACITY]; // STRING ARRAY CREATED TO HOLD THE SEATING.
        Scanner input = new Scanner (System.in); // Scanner obj created to get user input.
        seating(airplane); // CALLING THE FUNCION SEATING.
        
        String options = "";
        String Exit = "";
        
        while (!options.equals("Q")){
            System.out.println("Developed By Hady Hussain Batool @all rigts reserved");    
        System.out.print("\n\t\t>>>>Main Menu<<<<\t\t\n"
                + "Enter 'V' to View Seating Area.\n"
                + "Enter 'E' to View Available Seats.\n"
                + "Enter 'A' to Add New Passenger.\n"
                + "Enter 'D' to Delete Passenger from their Seat.\n"
                + "Enter 'F' to Conduct a Name Search.\n"
                + "Evter 'S' to Save the Data on a External File.\n"
                + "Enter 'L' to Load Data From a External File.\n"
                + "Enter 'O' to Organise passengers Names Alphabetically.\n"
                + "Enter 'Q' to Exit the Program.\n"
                +"\n"
                +"Please Select an Option: ");
        
        options=input.nextLine(); // SAVE USERS INPUT
        
        if(options.equalsIgnoreCase("V")){ // View  All Seats.
            SeatingArea(airplane); 
        }
        else if (options.equalsIgnoreCase("E")){ // Only View Unoccupied seats.
            AvailableSeats(airplane);
        }
        else if (options.equalsIgnoreCase("A")){ // Add New Passenger.
            InsertNewPassenger(airplane);
        }
        else if (options.equalsIgnoreCase("D")){ // Delete A Passenger. 
            DeletePassengers(airplane);
        }
        else if (options.equalsIgnoreCase("F")){ // Search A passenger by Name.
            NameSearch(airplane);
        }
        else if (options.equalsIgnoreCase("S")){ // Store Data On External File.
            StoreData(airplane);
        }
        else if (options.equalsIgnoreCase("l")) { // import Data From External File.
            ImportData(airplane);
        }
        else if(options.equalsIgnoreCase("O")){ // Sort Passenger Alphabetically
            BubbleSort(airplane);
        }
        else if (options.equalsIgnoreCase("Q")){ // Exit Program
            System.out.println("Are you Sure you want to Exit ? Y/N");
            Exit = input.nextLine();
            if(Exit.equalsIgnoreCase("Y")){
                System.out.println("<<<<<<<<Exiting From the Program>>>>>>>");
                break;
            }
            else{
                System.out.println("Operation Cancled!!");
            }
        }
        else{
            System.out.println("Invalid Input");
        }
        
        
        }
    }
    
    public static void seating(String[] airplane ){ // FUNTION TO START THE ARRAY
        airplane[0] = "Pilot";
        
        for (int x = 1; x<SEATING_CAPACITY; x++)
            airplane[x] = "AVAILABLE";
        System.out.println("\t\t\tAirplane Seat Booking Syatem");
        
        
    }
    
    public static void SeatingArea(String[] airplane){ // FUNCTION TO VIEW ALL THE SEATS.
        for(int x=0; x<SEATING_CAPACITY; x++){
            
            System.out.println("Seat " + x +" >>>>> " + airplane[x]);
        }
    }
    
    public static void AvailableSeats(String[] airplane){ // FUNCITION TO SEE ALL UNOCUUPIED SEATS.
        
        for(int x=0; x<SEATING_CAPACITY; x++){
            if(airplane[x].equals("AVAILABLE"))
                System.out.println("Seat " + x + " is Currently Available.");   
        }
        
    
    }
    
    public static void InsertNewPassenger (String[] airplane){  // INSERT A NEW PASSENGER ON REQUESTED SEAT. 
        Scanner input = new Scanner(System.in);
        String PassName= "";
        int SeatNum;
        
        do{
            System.out.println("Please Enter the Seat Number you like to Book from [1-11]: ");
            SeatNum = input.nextInt();
            
            if(SeatNum == 0 || SeatNum >= SEATING_CAPACITY){
                System.out.println("ERROR!! Please Enter the Correcr Seat Number: ");
                SeatNum=input.nextInt();
        }
      }
        while(SeatNum <= 0);
        while(SeatNum > 0 && SeatNum < SEATING_CAPACITY){
            if(airplane[SeatNum].equals("AVAILABLE")|| airplane[SeatNum].equals("available")){
                System.out.println("Please Enter The Name of Passenger " + SeatNum + ": ");
                String Passenger=input.nextLine();
                do{
                    if (PassName.equals("AVAILABLE")){
                        System.out.println("ERROR! Not a valid Name, Please reenter: ");
                    }
                    PassName = input.nextLine();
                }
                while(PassName.equals("AVAILABLE"));
                airplane[SeatNum] = PassName;
                System.out.println("The Seat Number " +SeatNum + " is Booked for " +PassName);
                break;
            }
            else
            {
                System.out.println("ERROR!! This Seat is already Occupied, Please try a different Seat Number: ");
            }
                do{
                    System.out.println("Please Enter the Seat Number you like to Book from [1-11]: ");
                    SeatNum=input.nextInt();
                }
                while(SeatNum<=0);
                
        }   
    }
    
    
    public static void DeletePassengers(String[] airplane){ // Function for Deleting a passenger.
            Scanner input = new Scanner(System.in);
            String PassName = "";
            System.out.println("Plese Enter the Name of Passenger you wish to Delete: ");
            PassName = input.nextLine();
            if (PassName.equals("Pilot") || PassName.equals("pilot")){
                System.out.println("ERROR!! THIS SEAT IS RESERVED FOR PILOT CANNOT DELETE.");
            }
            else{
                
                if (PassName.equals("AVAILABLE") || (PassName.equals("available")) || PassName.equals("Available"))
                {
                    System.out.println("ERROR!! Cannot Delete An Empty Seat"); 
                }
                else{
                    boolean found = false;
                    int SeatNum = 0;
                    for(int x =1; x<airplane.length; x++){
                        if((PassName).equals(airplane[x])){
                            found = true;
                            SeatNum = x;
                        }
                    }
                    if(found){
                        System.out.println(PassName+" id bokked on seat "+ SeatNum +".");
                        System.out.println("Are you Sure you want to Delete this Passenger? Y/N ");
                        String reply = "";
                        reply=input.nextLine();
                        
                        if (reply.equals("Y") || reply.equals("y")){
                            airplane[SeatNum] = "AVAILABLE";
                            System.out.println("Done!! Passenger Deleted Successfully.");
                            
                        }
                        else{
                            System.out.println("Done!! Passenger Deleted Successfully.");
                        }
                    }
                    else{
                        System.out.println("ERROR!! "+ PassName +" is not Booked on any Seats.");
                    }
                    
                }
                         
                
    }
            
    }
    
    public static void NameSearch(String[] airplane){ // Function to find a passenger by name.
        Scanner input = new Scanner(System.in);
        String PassName ="";
        System.out.println("Please Enter the Passenger Name to Search: ");
        PassName=input.nextLine();
        
        boolean found = false;
        int SeatNum=0;
        
        for (int x = 0; x<airplane.length; x++){
            if ((PassName).equals(airplane[x])){
                found = true;
                SeatNum = x;
            }
        }
        if (found){
            System.out.println("Passenger " + PassName + " is Booked on Seat " + SeatNum +".");
        }
        else{
            System.out.println(PassName + " is Not Booked on any seats.");
        }
    
    }
    
    
    public static void StoreData(String[] airplane){ //create external file to store Array data.
       
        Scanner input = new Scanner(System.in); // Scanner Class for inputs
        System.out.println("Please Enter  A Name for file to store your Data: ");
        String FileNamex = input.next(); // Save User Input (Name for the file)
       try (PrintWriter PrintFile = new PrintWriter(FileNamex)) { // Exceptional Handling (Try  & Catch)  
            for (String airplanetemp : airplane) {
                PrintFile.println(airplanetemp);
                
                
            }
           PrintFile.close();
           System.out.println("File Created Successfully");
       } 
       catch (FileNotFoundException ex) { //Error Handler to dsplaty the message if there's an Error
           System.out.println("Error!! File Name Already Exixts" +ex);
       }
       
     
    }
    
    public static void ImportData(String[] airplane){ //Import Array Data from external File.
        
       try {
           Scanner input = new Scanner(System.in);
           System.out.println("Please Enter the name of file to Import Data From: ");
           String FileName = input.next();
           
           File DataFile = new File(FileName);
           Scanner FileData = new Scanner(DataFile);
           
           for (int x=0; x<airplane.length; x++){
               airplane[x] = FileData.nextLine();
               System.out.println(airplane[x]);
           }
           FileData.close();
           System.out.println("Data Imported Successfully.");
       } 
       catch (FileNotFoundException ex) {
           System.out.println("ERROR!! Operation Failed." +ex);
       }   
    }
    
    public static void BubbleSort(String[] airplane){ // Bubble Store to sort the passengers alphabetically.
        
        String [] Temp = new String[SEATING_CAPACITY]; // Created a tempreey Array.
        
        
        for (int x = 0; x < Temp.length; x++){
            Temp[x] = airplane[x]; // Copy Data into a TEMP array.
        }
        
        for (int x=0; x<Temp.length; x++){
            for(int y = x + 1; y<Temp.length; y++){
                if (Temp[x].compareToIgnoreCase(Temp[y])>0){
                    // Perfrom the swap with the help of tempr String
                    String temporary = Temp[x];
                    Temp[x] = Temp[y];
                    Temp[y] = temporary;
                }
            }
                    
                    
        }    
        
        
        System.out.println("Data is Sorted: ");
        for(String x : Temp){
            if("AVAILABLE".equals(x)){
                
                System.out.print("");
            }
            else{
                System.out.println(x + " ");
            }
        }
    }
    
    
    
} //************************************************************** END OF PROGRAM **************************************************************************