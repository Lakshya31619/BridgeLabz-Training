public class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research Paper");
    }
    @Override
    public String getCourseType() {
        return "Research-Based";
    }
}