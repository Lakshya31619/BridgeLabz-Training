public abstract class JobRole {
    private final String roleName;
    protected JobRole(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }
    public abstract boolean isQualified(Resume<?> resume);
}