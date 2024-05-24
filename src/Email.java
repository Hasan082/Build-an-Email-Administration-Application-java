import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);

        // Combine element to generate email
        if (department.isEmpty()) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +
                    "." + companySuffix;
        }
    }

    // generate the department
    public String setDepartment() {

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose the department code from the following: ");
                System.out.println("1. for Sales\n2. for Development\n3. for Accounting\n0. for None");
                int depChoice = checkIntegerInput(sc, "Enter the department code: ");
                switch (depChoice) {
                    case 1:
                        return "Sales";
                    case 2:
                        return "Development";
                    case 3:
                        return "Accounting";
                    case 0:
                        return "";
                    default:
                        System.out.println("\nError: Invalid department choice. Please try again.\n");
                }
            }
        }

    }

    // generate the Random password
    private String randomPassword(int length) {
        String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz12345678901!@#$%";

        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // generate the mailbox capacity
    public void setmailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // generate the alternate email
    public void setalternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // get alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // get password
    public String getPassword() {
        return password;
    }

    public String showInfo() {

        return "\nNew Employe Info is below:- \nName: " + firstName + " " + lastName
                + "\nDepartment: " + department
                + "\nEmail: " + email
                + "\nPassword: " + password
                + "\nMailbox Capacity: " + mailboxCapacity + "mb\n";
    }

    // handling exceptions user input
    public static int checkIntegerInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine();// consume new line
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an number from the list.");
                scanner.nextLine(); // consume new line
            }
        }
        return value;
    }

}
