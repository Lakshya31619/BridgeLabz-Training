// Base class
class Course {
    protected String courseName;
    protected int duration; // duration in hours
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
// Subclass
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}
// Subclass extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded,double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
    }
}
public class EducationalCourse {
    public static void main(String[] args) {
        Course course = new Course("Data Structures", 40);
        Course onlineCourse = new OnlineCourse("Java Programming", 30, "Byju", true);
        Course paidCourse = new PaidOnlineCourse("Advanced Java", 50, "PhysicsWallah", true, 200.0, 15.0);
        course.displayDetails();
        System.out.println();
        onlineCourse.displayDetails();
        System.out.println();
        paidCourse.displayDetails();
    }
}