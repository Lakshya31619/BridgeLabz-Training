public class Resume<T extends JobRole> {
    private final String candidateName;
    private final int experienceYears;
    private final T appliedRole;
    public Resume(String candidateName, int experienceYears, T appliedRole) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.appliedRole = appliedRole;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public T getAppliedRole() {
        return appliedRole;
    }
    public String getCandidateName() {
        return candidateName;
    }
}