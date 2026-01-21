public class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignments");
    }
    @Override
    public String getCourseType() {
        return "Assignment-Based";
    }
}