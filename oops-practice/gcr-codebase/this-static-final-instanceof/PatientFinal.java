public class PatientFinal {
    // Static variable
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    // Final variable
    private final String patientID;
    private String name;
    private int age;
    private String ailment;
    // Constructor using 'this'
    public PatientFinal(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++; 
    }
    // Static method to get total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    // Method to display patient details using instanceof
    public void displayPatientDetails() {
        if (this instanceof PatientFinal) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }
    public static void main(String[] args) {
        // Create patient objects
        PatientFinal p1 = new PatientFinal("Lathika", 30, "Flu", "P001");
        PatientFinal p2 = new PatientFinal("Lidiya", 45, "Fracture", "P002");
        // Display total patients
        PatientFinal.getTotalPatients();
        // Display patient details
        p1.displayPatientDetails();
        p2.displayPatientDetails();
    }
}