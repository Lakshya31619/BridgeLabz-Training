public class Student extends Person {
    private Course[] courses;
    private String[] grades;
    private int courseCount;
    private static final int MAX_COURSES = 3;
    public Student(int id, String name){
        super(id, name);
        courses = new Course[MAX_COURSES];
        grades = new String[MAX_COURSES];
        courseCount = 0;
    }
    public void enrollCourse(Course course) throws CourseLimitExceededException{
        if(courseCount >= MAX_COURSES){
            throw new CourseLimitExceededException("Course limit exceeded");
        }
        courses[courseCount] = course;
        grades[courseCount] = "Not assigned";
        courseCount++;
        System.out.println(name+" enrolled in "+course.getCourseName());
    }
    public void dropCourse(Course course){
        for(int i=0; i<courseCount; i++){
            if(courses[i]==course){
                for(int j=i; j<courseCount-1; j++){
                    courses[j] = courses[j+1];
                    grades[j] = grades[j+1];
                }
                courseCount--;
                System.out.println(name+" dropped "+course.getCourseName());
                return;
            }
        }
    }
    public void addGrade(String courseName, String grade){
        for(int i=0; i<courseCount; i++){
            if(courses[i].getCourseName().equals(courseName)){
                grades[i] = grade;
            }
        }
    }
    public void viewGrades() {
        System.out.println("Grades of " + name + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].getCourseName() + " → " + grades[i]);
        }
    }
    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Enrolled Courses: " + courseCount);
    }
}