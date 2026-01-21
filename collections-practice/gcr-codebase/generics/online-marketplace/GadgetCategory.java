public enum GadgetCategory implements ProductCategory {
    MOBILE, LAPTOP, ACCESSORY;
    @Override
    public String getName() {
        return name();
    }
}