public class AdvancedJSONExporter implements ReportExporter {
    @Override
    public void export() {
        System.out.println("Exporting report using advanced JSON exporter");
    }
    @Override
    public void exportToJSON() {
        System.out.println("Exporting report data to JSON with custom schema");
    }
}