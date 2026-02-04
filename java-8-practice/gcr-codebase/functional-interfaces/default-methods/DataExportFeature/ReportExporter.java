public interface ReportExporter {
    void export();
    default void exportToJSON() {
        System.out.println("Exporting report data to JSON format (default)");
    }
}