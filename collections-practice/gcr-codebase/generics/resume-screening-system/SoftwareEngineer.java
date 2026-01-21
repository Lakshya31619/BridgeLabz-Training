public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
    @Override
    public boolean isQualified(Resume<?> resume) {
        return resume.getExperienceYears() >= 2;
    }
}