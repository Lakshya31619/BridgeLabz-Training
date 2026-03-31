public class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
    @Override
    public boolean isQualified(Resume<?> resume) {
        return resume.getExperienceYears() >= 4;
    }
}