class RegistrationServiceImpl extends RegistrationService {
    public void register(Student student, Course course) throws CourseLimitExceededException {
        student.enrollCourse(course);
    }
    public void drop(Student student, Course course) {
        student.dropCourse(course);
    }
}