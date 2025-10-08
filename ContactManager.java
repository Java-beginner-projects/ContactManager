package Contact_Manager;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
	
	//static ArrayLists can be accessed by any static method without creating an object of the class
	static ArrayList<String> names = new ArrayList<>();
	static ArrayList<String> phones = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void handleChoice(String choice) {
		if(choice.equals("1")) {
			addContact();
		}else if(choice.equals("2")) {
			viewContacts();
		}else if(choice.equals("3")) {
			searchContact();
		}
		else if(choice.equals("4")){
			updateContact();
		}
		else if(choice.equals("5")) {
			deleteContact();
		}else if(choice.equals("6")) {
			System.out.println("Goodbye!");
		}else {
			System.out.println("Invalid choice!");
		}
	}
	
	public static void addContact() {
		System.out.print("Enter contact name: ");
		String name = sc.nextLine().trim();
		
		System.out.print("Enter phone number (10 digits): ");
		String phone = sc.nextLine().trim();
		
		//check for string empty or not, Check for length of the string
		if(name.isEmpty() || phone.isEmpty() || !phone.matches("\\d{10}")) {
			System.out.println("Invalid input!");
			return;
		}
		if(names.contains(name)) {
			System.out.println("Contact already exists!");
		}else {
			names.add(name);
			phones.add(phone);
			System.out.println("Contact added successfully!");
		}
	}
	public static void viewContacts() {
		System.out.println("[viewContacts] method not implemented yet.");
	}
	public static void searchContact() {
		System.out.println("[searchContact] method not implemented yet.");
	}
	public static void updateContact() {
		System.out.println("[updateContact] method not implemented yet.");
	}
	public static void deleteContact() {
		System.out.println("[deleteContact] method not implemetned yet.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		System.out.println("Contact Manager Menu: ");
		System.out.println("1. Add a Contact");
		System.out.println("2. View Contacts");
		System.out.println("3. Search for a Contact");
		System.out.println("4. Update a Contact");
		System.out.println("5. Delete a Contact");
		System.out.println("6. Exit");
		System.out.println("Choose an option (1-6): ");
		String choice = sc.nextLine().trim();
		if(choice.equals("6")) {
			System.out.println("Goodbye!");
			break;
		}
		handleChoice(choice);
		}
		

	}

}
