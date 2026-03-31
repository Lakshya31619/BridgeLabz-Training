public enum BookCategory implements ProductCategory {
    FICTION, NON_FICTION, EDUCATIONAL;
    @Override
    public String getName() {
        return name();
    }
}
