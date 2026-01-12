public class StudentCourse {
    public static void main(String[] args) {
        Student student = new Student(1, "Kunwar Devrishi Thakur");
        Course c1 = new Course("C1", "Java");
        Course c2 = new Course("C2", "Springboot");
        Course c3 = new Course("C3", "Angular");
        Course c4 = new Course("C4", "AI/ML");
        RegistrationService service = new RegistrationServiceImpl();
        try {
            service.register(student, c1);
            service.register(student, c2);
            service.register(student, c3);
            service.register(student, c4);
        } catch (CourseLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
        student.addGrade("Java", "A+");
        student.addGrade("Springboot", "A");
        student.viewGrades();
        student.displayInfo();
    }
}