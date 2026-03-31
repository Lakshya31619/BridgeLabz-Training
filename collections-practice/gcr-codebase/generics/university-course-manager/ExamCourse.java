public class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Final Exam");
    }
    @Override
    public String getCourseType() {
        return "Exam-Based";
    }
}