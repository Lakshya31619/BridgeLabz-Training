import java.util.List;
public class ResumeScreeningService {
    // Generic method with bounded type parameter
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        if (resume.getAppliedRole().isQualified(resume)) {
            System.out.println(resume.getCandidateName() + " is QUALIFIED for " + resume.getAppliedRole().getRoleName());
        } else {
            System.out.println(resume.getCandidateName() + " is NOT qualified for "+ resume.getAppliedRole().getRoleName());
        }
    }
    // Wildcard method to handle multiple job roles
    public static void bulkScreen(List<? extends JobRole> roles,List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            screenResume(resume);
        }
    }
}