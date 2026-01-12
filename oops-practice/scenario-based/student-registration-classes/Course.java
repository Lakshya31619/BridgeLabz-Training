class Course {
    private String courseId;
    private String courseName;
    public Course(String courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
    }
    public String getCourseName(){
        return courseName;
    }
}