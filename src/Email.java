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
        // System.out.println("Email Created: " + this.firstName + " " + this.lastName);
        // Call a method asking for the department - return the department
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        // System.out.println("Your password is: " + this.password);

        // Combine element to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "."
                + companySuffix;
        System.out.println("Your email is: " + email);
    }

    // https://gale.udemy.com/course/practice-java-by-building-projects/learn/lecture/8080730#overview

    // generate the department
    public String setDepartment() {
        System.out.println("Choose the department from the following: ");
        System.out.println("1. for Sales\n2. for Development\n3. for Accounting\n0. for None");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the department code: ");
            int depChoice = sc.nextInt();
            sc.nextLine();
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
                    return "Error: Invalid department choice";
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

}
