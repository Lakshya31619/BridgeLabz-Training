import java.util.List;
public class CourseUtils {
    // Upper-bounded wildcard for handling any course type
    public static void displayCourses(
            List<? extends CourseType> courseTypes) {
        for (CourseType type : courseTypes) {
            System.out.println("Course Type: " + type.getCourseType() + " | Evaluation: " + type.getEvaluationMethod());
        }
    }
}