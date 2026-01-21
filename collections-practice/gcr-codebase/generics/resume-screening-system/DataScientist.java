public class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
    @Override
    public boolean isQualified(Resume<?> resume) {
        return resume.getExperienceYears() >= 3;
    }
}