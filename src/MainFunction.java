
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MainFunction {
	static Scanner sc = new Scanner(System.in);
	static String[] hotel = new String[11];
	static String exit;
	static Date curDate;
	static Room roomObject = new Room();
	static Customer cusObject = new Customer();
	//Initialize 10 queues for each room because every room has a queue with
	//the capacity of 7
	static Queue q1 = new Queue();
	static Queue q2 = new Queue();
	static Queue q3 = new Queue();
	static Queue q4 = new Queue();
	static Queue q5 = new Queue();
	static Queue q6 = new Queue();
	static Queue q7 = new Queue();
	static Queue q8 = new Queue();
	static Queue q9 = new Queue();
	static Queue q10 = new Queue();


	public void loginFunction() {
		asciiDesign();

		/* LOGIN FUNCTION */
		System.out.println("\nEnter Username: ");
		String username = sc.nextLine();

		System.out.println("\nEnter Password: ");
		String password = sc.nextLine();

		if ("123".equalsIgnoreCase(username) && "123".equals(password)) {
			System.out.println("Login Successful!");
			System.out.println("Loading...");
			menu();
		} else {
			System.err.println("The username and password is incorrect. System Exit.");
			// Exit the system
			System.exit(0);
		}
	}

	// ASCII Design
	public static void asciiDesign() {
		System.out.println("\t\t\t  ______  .______       ______   ____    __    ____ .__   __. ");
		System.out.println("\t\t\t /      | |   _  \\     /  __  \\  \\  \\   /  \\  /   / |  \\ |  | ");
		System.out.println("\t\t\t|  ,----' |  |_)  |   |  |  |  |  \\   \\/    \\/   /  |   \\|  | ");
		System.out.println("\t\t\t|  |      |      /    |  |  |  |   \\            /   |  . `  | ");
		System.out.println("\t\t\t|  `----. |  |\\  \\-.  |  `--'  |    \\    /\\    /    |  |\\   | ");
		System.out.println("\t\t\t \\______| | _| `.__|   \\______/      \\__/  \\__/     |__| \\__| \n");

		System.out.println("\t\t\t\t\t\t\t\t  _  _     _       _ ");
		System.out.println("\t\t\t\t\t\t\t\t | || |___| |_ ___| |");
		System.out.println("\t\t\t\t\t\t\t\t | __ / _ \\  _/ -_) |");
		System.out.println("\t\t\t\t\t\t\t\t |_||_\\___/\\__\\___|_|");

		// Display Current date and time
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
		System.out.println("\nCurrent Time: " + timeStamp);

		// Welcome Message and the Login
		System.out.println('\n' + "Welcome to Crown Hotel Rooms Management System ");
	}

	/* MENU FUNCTION */
	public static void menu() {
		System.out.println(
				"___________________________________________________________________________________________________");
		System.out.println("\t \t \t \t \t     | Menu |");
		System.out.println("\t \t \t \t \t     '------'\n");
		System.out.println(
				"[ A - Add Customer to the Room]   [D - Delete Customer from Room]   [  U - Update Customer Data   ]");
		System.out.println(
				"[ F - Find Customer by Name   ]   [     V - View All Rooms      ]   [   E - Display Empty Rooms   ] ");
		System.out.println(
				"[  G - Get Customer Details   ]   [   S - Store Program Data    ]   [    L - Load Program Data    ]");
		System.out.println(
				"[O - View Rooms Sorted by Name]   [  3 - Remove from the Queue  ]   [          H - Help           ]");
		System.out.println(
				"                                  [          X - Exit           ]");
		System.out.println(
				"___________________________________________________________________________________________________");

		Scanner sc = new Scanner(System.in);
		String command = "";

		do {
			System.out.println("\n\n Enter Command: ");
			command = sc.nextLine();

			if ("A".equalsIgnoreCase(command)) {
				addCustomer();
				continue;
			} else if ("D".equalsIgnoreCase(command)) {
				delCustomer();
				continue;
			} else if ("U".equalsIgnoreCase(command)) {
				updateCustomer();
				continue;
			} else if ("3".equalsIgnoreCase(command)) {
				removeQueue();
				continue;
			} else if ("F".equalsIgnoreCase(command)) {
				findCustomer();
				continue;
			} else if ("G".equalsIgnoreCase(command)) {
				customerDetail();
				continue;
			} else if ("V".equalsIgnoreCase(command)) {
				viewRooms(hotel);
				continue;
			} else if ("E".equalsIgnoreCase(command)) {
				emptyRooms();
				continue;
			} else if ("O".equalsIgnoreCase(command)) {
				orderRooms(hotel);
				continue;
			} else if ("S".equalsIgnoreCase(command)) {
				storeData(hotel);
				continue;
			} else if ("L".equalsIgnoreCase(command)) {
				loadData();
				continue;
			} else if ("H".equalsIgnoreCase(command)) {
				helpBar();
				continue;
			} else if ("X".equalsIgnoreCase(command)) {
				do {
					// Exit function
					System.out.println("Are you sure? (Y/N)");
					exit = sc.next();
					if ("y".equalsIgnoreCase(exit)) {
						System.out.println("Thank You. Have a nice day!");
						System.out.println("Developed by Lakindu Gunasekara");
						System.exit(0);
					} else if ("n".equalsIgnoreCase(exit)) {
						menu();
					} else {
						System.out.println("Enter a valid command.");
					}
				} while (!"n".equalsIgnoreCase(exit) && !"y".equalsIgnoreCase(exit));

			} else {
				System.err.println("Invalid Command, Please enter a valid command.");
			}
		} while (!"X".equalsIgnoreCase(command));

	}
	//Remove customers from the queue function
	private static void removeQueue() {
		Scanner in = new Scanner(System.in);
		System.out.println("Queue Function");
		System.out.println("--------------\n");	
		System.out.println("Enter the room number: ");
		int x = in.nextInt();
		
		if(x == 1){
		for (int i=0;i<3;i++){		
			System.out.println("Removed the following customers: "+q1.dequeue());
		}
		}
		else if(x == 2){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q2.dequeue());
			}
		}
		else if(x == 3){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q3.dequeue());
			}
		}
		else if(x == 4){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q4.dequeue());
			}
		}
		else if(x == 5){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q5.dequeue());
			}
		}
		else if(x == 6){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q6.dequeue());
			}
		}
		else if(x == 7){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q7.dequeue());
			}
		}
		else if(x == 8){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q8.dequeue());
			}
		}
		else if(x == 9){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q9.dequeue());
			}
		}
		else if(x == 10){
			for (int i=0;i<3;i++){		
				System.out.println("Removed the following customers: "+q10.dequeue());
			}
		}

		
	}
	//Adding customer function
	private static void addCustomer() {
		System.out.println("ADD CUSTOMER");
		System.out.println("------------\n");
				do {
			try {
				System.out.println("\n     ROOM TYPES");
				System.out.println("---------------------");
				System.out.println("Single Rooms: 1, 2, 3");
				System.out.println("Double Rooms: 4, 5, 6");
				System.out.println("Duplex Rooms: 7");
				System.out.println("Luxery Rooms: 8, 9, 10");
				System.out.println("");
				System.out.println("Enter room number (1-10) or 11 to stop:");

				// Get the room number and set the roomNum with the room object
				roomObject.setRoomNum(sc.nextInt());
				// Catch input mismatch exceptions
			} catch (InputMismatchException e) {
				System.out.println("Enter room number (1-10 or 11 to stop:");
			}
			sc.nextLine(); // clears the buffer
			// If roomNum is between 1 to 10, get the customer name
			if (roomObject.getRoomNum() >= 1 && roomObject.getRoomNum() <= 10) {
				System.out.println("Enter Customer name " + roomObject.getRoomNum() + " :");
				String cus = sc.nextLine();
				cusObject.setCustomerName(cus);
				//Adding customer name to the queue
				if (roomObject.getRoomNum() ==1){
				try{
				q1.enqueue(cus);
				}catch (Exception e){
					System.out.println("Unexpected overflow. Queue is full.");
					q1.theArray[0]=cus;
					
				}	
				}
				if (roomObject.getRoomNum() ==2){
					try{
					q2.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q2.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==3){
					try{
					q3.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q3.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==4){
					try{
					q4.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q4.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==5){
					try{
					q5.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q5.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==6){
					try{
					q6.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q6.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==7){
					try{
					q7.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q7.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==8){
					try{
					q8.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q8.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==9){
					try{
					q9.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q9.theArray[0]=cus;
					}
					}
				else if (roomObject.getRoomNum() ==10){
					try{
					q10.enqueue(cus);
					}catch (Exception e){
						System.out.println("Unexpected overflow. Queue is full.");
						q10.theArray[0]=cus;
					}
					}
				// Display message successfully added
				System.out.println("Successfully added.");
				// Get the room rate according to the room type
				roomObject.setRoomRate();
				// Display the room rate details
				System.out.println(
						"\nThe cost of " + cusObject.getCustomerName() + ", room is " + roomObject.getRoomRate());
				System.out.println("");

				// Assign customerName to the array
				hotel[roomObject.getRoomNum()] = cusObject.getCustomerName();
				// Add data to customer details
				try {
					// Create a file called customer details
					File cusFile = new File("Customer Details.txt");
					cusFile.createNewFile();
					// Write the user input data in the file
					// In case the file exists, the data will append to the file
					FileWriter fileWrite = new FileWriter(cusFile, true);
					BufferedWriter bf = new BufferedWriter(fileWrite);
					bf.write("\n" + cusObject.getCustomerName() + "\t\t" + cusObject.getCustomerAddress() + "\t\t"
							+ cusObject.getCustomerNic() + "\t" + cusObject.getCustomerTel());
					// Force to write data to the file
					bf.flush();
					// Close bufferedWriter
					bf.close();
				} catch (IOException error) {
					System.out.println("File does not exist or you are trying to read a file that has been deleted");
				}

				// if user enters number 11, the system exits the addCustomer
				// function and load to main menu
			} else if (roomObject.getRoomNum() == 11) {
				System.out.println("Back to Main menu.");
				menu();

				// If an invalid input is entered, display following message
			} else {
				System.out.println("Please enter a correct input. Thank You!");

			}
			// Do while the user enters a correct input
		} while (roomObject.getRoomNum() > 1 && roomObject.getRoomNum() <= 11);
	}

	
	/* FIND CUSTOMER FUNCTION */
	private static void findCustomer() {
		System.out.println("FIND CUSTOMER BY NAME");
		System.out.println("---------------------\n");
		System.out.println("Enter Customer Name: ");
		// set customerName to the customer object
		cusObject.setCustomerName(sc.nextLine());
		// for loop to read every line of the hotel array
		for (int i = 0; i < hotel.length; i++) {
			// if the hotel [i] is not null AND the user input customer name
			// matches with the array
			if (hotel[i] != null && hotel[i].equalsIgnoreCase(cusObject.getCustomerName())) {
				System.out.println("Searching...");
				System.out.println(" ");
				System.out.println("Result found.");
				// Display the entered users room number
				System.out.println("Room Number of the requested cusomter is: No " + i);
				// System.out.println("Customer deleted successfully.");
				break;
			}
			// If the entered customers name not matched
			if (i == hotel.length - 1) {
				System.out.println("Searching...");
				System.out.println(" ");
				// Display message, requested customer not found
				System.out.println("Requested customer not exists");
			}

		}
	}

	/* UPDATE CUSTOMER FUNCTION */
	private static void updateCustomer() {
		System.out.println("UPDATE CUSTOMER");
		System.out.println("------------\n");
		System.out.println("Enter the customer name: ");
		// Get the customer name which needs to be edited
		cusObject.setCustomerName(sc.nextLine());
		// Run the for loop to read every line
		for (int i = 0; i < hotel.length; i++) {
			// if the hotel[i] not null AND the input matches the customerName
			if (hotel[i] != null && hotel[i].equalsIgnoreCase(cusObject.getCustomerName())) {
				// Get the new name of the customer
				System.out.println("Edit customer name " + cusObject.getCustomerName());
				hotel[i] = sc.nextLine();

				System.out.println("Enter Customer Address: ");
				cusObject.setCustomerAddress(sc.nextLine());

				System.out.println("Enter Customer NIC Number: ");
				cusObject.setCustomerNic(sc.nextLine());
				// Validate whether the user input is a number
				try {
					System.out.println("Enter Customer Telephone Number: ");
					cusObject.setCustomerTel(sc.nextInt());
				} catch (InputMismatchException e) {
					System.out.println("Please enter number");
				}
				// set the new name to the array
				System.out.println("Name saved as " + cusObject.getCustomerName());
				System.out.println("Customer updated successfully.");

				try {
					// Write the user input data in the file
					// In case the file exists, the data will append to the file
					FileWriter fileWrite = new FileWriter("Customer Details.txt");
					BufferedWriter bf = new BufferedWriter(fileWrite);
					bf.write(cusObject.getCustomerName() + "\t\t" + cusObject.getCustomerAddress() + "\t\t"
							+ cusObject.getCustomerNic() + "\t" + cusObject.getCustomerTel());
					// Force to write data to the file
					bf.flush();
					// Close bufferedWriter
					bf.close();
				} catch (IOException error) {
					System.out.println("File does not exist or you are trying to read a file that has been deleted");
				}
				break;
			}
			// If the requested customer not exists display following message
			if (i == hotel.length - 1) {
				System.out.println("Requested customer not exists");
			}
		}
	}

	/* DELETE CUSTOMER FUNCTION */
	private static void delCustomer() {
		System.out.println("DELETE CUSTOMER");
		System.out.println("---------------\n");

		System.out.println("Select the customer you want to delete:");
		// Get the customer name which needs to be deleted
		cusObject.setCustomerName(sc.nextLine());
		// Read the all lines of the hotel array
		for (int i = 0; i < hotel.length; i++) {
			// if hotel [i] is not null AND equals to the user input
			if (hotel[i] != null && hotel[i].equalsIgnoreCase(cusObject.getCustomerName())) {
				// set the customer name as EMPTY
				hotel[i] = null;
				System.out.println("Customer deleted successfully.");

				try {
					// Declare buffered Writer to studentdetails.txt
					BufferedWriter out = new BufferedWriter(new FileWriter("Customer Details.txt"));
					// Delete data
					out.write("");
					// close buffered writer
					out.close();

				} catch (IOException e) {
					System.out.println("exception occoured" + e);
					System.out.println("File does not exist or you are trying to read a file that has been deleted");
				}

				break;
			}
			// If the customer entered not exists, display following message
			if (i == hotel.length - 1) {
				System.out.println("Requested customer not exists");
			}

		}
	}

	/* CUSTOMER DETAILS FUNCTION */
	private static void customerDetail() {
		System.out.println("CUSTOMER DETAILS");
		System.out.println("----------------\n");
		try {
			// Declares a bufferedReader to read the file
			BufferedReader bf = new BufferedReader(new FileReader("Customer Details.txt"));
			// line is used to store the data which reads by bufferedReader
			String line;
			// Displays the heading of the table
			System.out.println("Customer Name\t\tAddress\t\t\t\t\tNIC No\t\tTelephone");

			while ((line = bf.readLine()) != null) {
				// Displays data stored in variable line
				System.out.println(line);
			}
		} catch (IOException error) {
			System.out.println("File does not exist or you are trying to read a file that has been deleted");
		}

	}

	/* VIEW ROOMS FUNCTION */
	private static void viewRooms(String hotel[]) {
		System.out.println("VIEW ALL ROOMS");
		System.out.println("--------------\n");
		// Read the hotel array
		for (int x = 1; x < hotel.length; x++) {
			// Read the rooms which are occupied and display customer name of
			// the particular room
			if (hotel[x] != null)
				System.out.println("Room " + x + " occupied by " + hotel[x]);
			else {
				// Display the empty rooms
				System.out.println("Room " + x + " occupied by Nobody");
			}
		}
	}

	/* EMPTY ROOMS FUNCTION */
	private static void emptyRooms() {
		System.out.println("VIEW EMPTY ROOMS");
		System.out.println("----------------\n");
		// Read the hotel array
		for (int x = 1; x < hotel.length; x++) {
			// If the room number (x) is having a null value, display
			// roomNumbers
			if (hotel[x] == null) {
				System.out.println("Room " + x + " is empty");
			}
		}
	}

	/* SORT CUSTOMER NAMES FUNCTION */
	private static void orderRooms(String hotel[]) {
		System.out.println("SORT BY NAME");
		System.out.println("------------\n");
		// Initialize end as false
		boolean end = false;
		// While end equals to false, run the loop
		while (end == false) {
			// Assign end as true
			end = true;
			// Read the hotel array
			for (int i = 1; i < hotel.length - 1; i++) {
				// Initialize a variable called num and assign 0
				int num = 0;
				// if the hotel[i] AND hotel[i+1] both are having values
				// Create two string and assign the arrays to lists respectively
				if (hotel[i] != null && hotel[i + 1] != null) {
					String list1 = hotel[i];
					String list2 = hotel[i + 1];
					// compare list1 with list2 and sort the customer names
					num = list1.compareTo(list2);

				}
				// If BOTH array values are null, assign 0 to num variable
				else if (hotel[i] == null && hotel[i + 1] == null) {
					num = 0;
				}
				// if hotel[i] array is null assign num = 1
				else if (hotel[i] == null) {
					num = 1;
				}
				// Else assign num as -1 and ignore
				else {
					num = -1;
				}
				// If num is more than 0, continue
				if (num > 0) {
					String str = hotel[i];
					hotel[i] = hotel[i + 1];
					hotel[i + 1] = str;
					end = false;

				}
			}
		}
		printData();
	}

	private static void printData() {
		// Read the hotel array
		for (int x = 1; x < hotel.length; x++) {
			// Get the sorted list of customerNames and display
			if (hotel[x] != null) {
				System.out.println(hotel[x]);
			}
			// Display the empty rooms
			else {
				System.out.println(x + " is empty");
			}
		}
	}

	/* STORE DATA FUNCTION */
	private static void storeData(String hotel[]) {
		System.out.println("STORE DATA TO A FILE");
		System.out.println("--------------------\n");
		try {
			// Create date variable
			curDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			// Location of the file to be saved and create file
			File file = new File("/Eclipse - Workspace/CW1-SDP2/log/" + curDate + ".txt");
			file.createNewFile();
			// Declare file writer and buffered writer
			FileWriter fileWrite = new FileWriter(file, true);
			BufferedWriter bf = new BufferedWriter(fileWrite);
			// bf.write(curDate+"\n");

			// Read hotel array
			for (int x = 1; x < hotel.length; x++) {
				// bf.write("\nRoom " + x + " occupied by " + hotel[x]);

				// Buffered Write is used to write data
				bf.write(hotel[x] + "\n");
			}
			// Force to write data to the file
			bf.flush();
			// Close buffered writer
			bf.close();

			System.out.println("File saved successfully");

		} catch (IOException error) {
			System.err.println("File not exists.");
		}
	}

	/* LOAD DATA FUNCTION */
	private static void loadData() {
		System.out.println("LOAD DATA FROM A FILE");
		System.out.println("---------------------\n");
		// Display the log folder
		File folder = new File("/Eclipse - Workspace/CW1-SDP2/log");
		// Declare file array
		File[] listOfFiles = folder.listFiles();
		// Get the .txt files from the log folder and display
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")) {
				System.out.println("File: " + i + " " + listOfFiles[i].getName());
			}
			// If .txt files are not exists display the directory
			else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

		Scanner in = new Scanner(System.in);
		System.out.println("Select the file by number: ");
		try {
			// Select the file
			int number = sc.nextInt();
			// Declare buffered reader and locate the file
			BufferedReader br = new BufferedReader(
					new FileReader("/Eclipse - Workspace/CW1-SDP2/log/" + listOfFiles[number].getName()));
			// Declare a temporary variable to store data
			String str;
			// Declare an array list and store data to array list
			List<String> hotelList = new ArrayList<String>();
			while ((str = br.readLine()) != null) {
				hotelList.add(str);
			}
			// Convert data of array list to an array
			String[] hotelArr = hotelList.toArray(new String[0]);
			hotel = hotelArr;
			System.out.println("File loaded successfully.");
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		} catch (IOException er) {
			System.err.println(er.getMessage());
		} catch (ArrayIndexOutOfBoundsException err) {
			System.err.println("Invalid Number");
		}
	}

	private static void helpBar() {
		System.out.println("HELP");
		System.out.println("----\n");

		System.out.println("For each functions, enter the following Keys.\n");
		System.out.print("A - Add Customer to the Room\n" + "D - Delete Customer from Room\n"
				+ "U - Update Customer Data\n" + "F - Find Customer by Name\n" + "V - View All Rooms\n"
				+ "E - Display Empty Rooms\n" + "O - View Rooms Sorted by Name\n" + "S - Store Program Data\n"
				+ "L - Load Program Data\n" + "X - Exit\n" + "Y - Yes command\n" + "N - No command\n");
		System.out.println("\nThe above KeyWords are not Case-sensitive.");

	}

}
