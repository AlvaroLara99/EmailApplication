package EmailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "realcompany.com";

	// Constructor to receive the fist name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// Call method asking for the department - return the department
		this.department = setDepartment();

		// Call method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password: " + this.password);

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}

	// Ask for department
	private String setDepartment() {
		int depChoice;
		String department = "";
		boolean valid = false;
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("New Worker: " + firstName);
			System.out.println("Department Codes:");
			System.out.print("1.Sales\n");
			System.out.print("2.Development\n");
			System.out.print("3.Accounting\n");
			System.out.print("4.N/A\n");
			System.out.print("5.Exit\n");
			System.out.print("Please make a choice: ");
			while (!input.hasNextInt()) {
				System.out.printf("Not a valid number! Please try again: ");
				input.next();
			}

			depChoice = input.nextInt();

			switch (depChoice) {
			case 1:
				valid = true;
				department = "Sales";
				break;
			case 2:
				valid = true;
				department = "Development";
				break;
			case 3:
				valid = true;
				department = "Accounting";
				break;
			case 4:
				valid = true;
				department = "N/A";
				break;
			case 5:
				System.out.println("Exiting Applicaiton");
				System.exit(0);
			default:
				System.out.println("Not a valid choice! Please try again");
			}
		} while (valid == false);
		return department;
	}

	// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Name: " + firstName + " " + lastName +
				"\nCompany Email: " + email +
				"\nMailbox Capacity: " + mailboxCapacity +"mb";
		
	}
}