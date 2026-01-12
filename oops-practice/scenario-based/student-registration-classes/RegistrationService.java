abstract class RegistrationService {
    public abstract void register(Student student, Course course) throws CourseLimitExceededException;
    public abstract void drop(Student student, Course course);
}