public enum ClothingCategory implements ProductCategory {
    MEN, WOMEN, KIDS;
    @Override
    public String getName() {
        return name();
    }
}