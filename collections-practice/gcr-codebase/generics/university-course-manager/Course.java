public class Course<T extends CourseType> {
    private final String courseCode;
    private final String courseName;
    private final T courseType;
    public Course(String courseCode, String courseName, T courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseType = courseType;
    }
    public T getCourseType() {
        return courseType;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
}