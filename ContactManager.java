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
		if(phones.isEmpty()) {
			System.out.println("No contacts available.");
		}else {
			System.out.println("Contact List:");
			for(int i = 0;i<names.size();i++) {
				System.out.println(names.get(i)+": "+phones.get(i));
			}
		}
	}
	public static void searchContact() {
		System.out.println("Enater name to search: ");
		
		String name = sc.nextLine();
		int index = names.indexOf(name);
		if(index!= -1) {
			System.out.println(name+": "+phones.get(index));
		}
		else {
			System.out.println("Contact not found!");
		}
	}
	public static void updateContact() {
		System.out.print("Enter the contact name to update: ");
		
		String name = sc.nextLine();
		int index = names.indexOf(name);
		if(index == -1) {
			System.out.println("Contact not found!");
			return;
		}
		System.out.print("Enter new name(press Enter to keep same): ");
		String newName = sc.nextLine();
		System.out.print("Enter new phone number (press Enter to keep same): ");
		String newPhone = sc.nextLine();
		
		//when the name is not empty... it updates the name
		if(!newName.isEmpty()) {
			names.set(index, newName);
		}
		if(!newPhone.isEmpty()) {
			if(!newPhone.matches("\\d{10}")) {
				System.out.println("Invalid phone number!");
				return;
			}
			phones.set(index, newPhone);
		}
		System.out.println("Contact updated successfully!");
	}
	public static void deleteContact() {
		System.out.print("Enter name to delete: ");
		String nameToDelete = sc.nextLine();
		int indexToDelete = -1;
		for(int i = 0;i<names.size();i++) {
			if(names.get(i).equalsIgnoreCase(nameToDelete)) {
				indexToDelete = i;
				break;
			}
		}
		if(indexToDelete == -1) {
			System.out.println("Contact not found!");
			return;
		}else {
			names.remove(indexToDelete);
			phones.remove(indexToDelete);
			System.out.println("Contact deleted successfully!");
		}
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
		System.out.print("Choose an option (1-6): ");
		String choice = sc.nextLine().trim();
		if(choice.equals("6")) {
			System.out.println("Goodbye!");
			break;
		}
		handleChoice(choice);
		}
		

	}

}
