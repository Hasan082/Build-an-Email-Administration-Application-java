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

    /**
     * Constructor initializes firstName and lastName.
     * It also sets the department, generates a random password, and creates the
     * email address.
     * 
     * @param firstName First name of the employee
     * @param lastName  Last name of the employee
     */
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);

        // Combine elements to generate email
        if (department.isEmpty()) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +
                    "." + companySuffix;
        }
    }

    /**
     * Prompts the user to choose a department and returns the corresponding
     * department name.
     * It validates the input to ensure a valid department code is chosen.
     * 
     * @return The name of the department or an empty string if none is chosen
     */
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

    /**
     * Generates a random password of the specified length.
     * 
     * @param length Length of the password
     * @return The generated password
     */
    private String randomPassword(int length) {
        String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz12345678901!@#$%";

        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    /**
     * Sets the mailbox capacity for the email.
     * 
     * @param capacity Mailbox capacity in MB
     */
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    /**
     * Sets an alternate email address.
     * 
     * @param altEmail The alternate email address
     */
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    /**
     * Changes the password for the email.
     * 
     * @param password The new password
     */
    public void changePassword(String password) {
        this.password = password;
    }

    /**
     * Gets the mailbox capacity.
     * 
     * @return Mailbox capacity in MB
     */
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    /**
     * Gets the alternate email address.
     * 
     * @return The alternate email address
     */
    public String getAlternateEmail() {
        return alternateEmail;
    }

    /**
     * Gets the current password.
     * 
     * @return The current password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Displays the information about the new employee.
     * 
     * @return A string containing the employee's information
     */
    public String showInfo() {
        return "\nNew Employee Info is below:- \nName: " + firstName + " " + lastName
                + "\nDepartment: " + department
                + "\nEmail: " + email
                + "\nPassword: " + password
                + "\nMailbox Capacity: " + mailboxCapacity + "mb\n";
    }

    /**
     * Prompts the user for an integer input and validates it.
     * 
     * @param scanner The Scanner object for user input
     * @param prompt  The prompt message for the user
     * @return The validated integer input
     */
    public static int checkIntegerInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume new line
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from the list.");
                scanner.nextLine(); // Consume new line
            }
        }
        return value;
    }

}
