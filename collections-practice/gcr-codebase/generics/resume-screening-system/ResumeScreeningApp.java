import java.util.ArrayList;
import java.util.List;
public class ResumeScreeningApp {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>("Ansh", 3, new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Aman", 2, new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Arpan", 5, new ProductManager());
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(seResume);
        resumes.add(dsResume);
        resumes.add(pmResume);
        for (Resume<? extends JobRole> resume : resumes) {
            ResumeScreeningService.screenResume(resume);
        }
    }
}