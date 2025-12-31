public class Course {
    // Instance variables
    private String courseName;
    private int duration;     // in weeks
    private double fee;
    // Class variable
    private static String instituteName = "Udemy";
    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    // Instance method
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: Rs." + fee);
    }
    // Class method
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 8, 12000);
        Course c2 = new Course("Web Development", 10, 15000);
        System.out.println("Course 1 Details:");
        c1.displayCourseDetails();
        System.out.println();
        System.out.println("Course 2 Details:");
        c2.displayCourseDetails();
        System.out.println("\nUpdating Institute Name : \n");
        // Update institute name using class method
        Course.updateInstituteName("Physics Wallah");
        System.out.println("Course Details After Update:");
        c1.displayCourseDetails();
    }
}