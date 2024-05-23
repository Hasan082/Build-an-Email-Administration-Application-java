import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength;
    private int mailboxCapacity;
    private String alternateEmail;

    // constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + this.firstName + " " + this.lastName);
        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
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
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";

        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // generate the password
    // public void setpassword(String password) {
    // this.password = password;
    // }

    // // generate the mailbox capacity
    // public void setmailboxCapacity(int mailboxCapacity) {
    // this.mailboxCapacity = mailboxCapacity;
    // }

    // // generate the email
    // public String generateEmail() {
    // return this.firstName + "." + this.lastName + "@" + this.department +
    // ".company.com";
    // }

    // // generate the alternate email
    // public void setalternateEmail(String alternateEmail) {
    // this.alternateEmail = alternateEmail;
    // }

}
