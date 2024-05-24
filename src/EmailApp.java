public class EmailApp {
    /**
     * The main method to run the Email application.
     * 
     * @throws Exception If an exception occurs during the execution
     */
    public static void main(String[] args) throws Exception {
        // Create a new Email object with the first name "Md" and last name "Hasan"
        Email eml1 = new Email("Md", "Hasan");

        // Display the information of the created email object
        System.out.println(eml1.showInfo());
    }
}
