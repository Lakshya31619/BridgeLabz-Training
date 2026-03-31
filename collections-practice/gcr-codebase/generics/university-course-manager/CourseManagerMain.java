import java.util.ArrayList;
import java.util.List;
public class CourseManagerMain {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("MATH101", "Calculus", new ExamCourse());
        Course<AssignmentCourse> cs = new Course<>("CS201", "Data Structures", new AssignmentCourse());
        Course<ResearchCourse> phd = new Course<>("RES501", "Advanced Research", new ResearchCourse());
        List<CourseType> offeredCourses = new ArrayList<>();
        offeredCourses.add(math.getCourseType());
        offeredCourses.add(cs.getCourseType());
        offeredCourses.add(phd.getCourseType());
        CourseUtils.displayCourses(offeredCourses);
    }
}