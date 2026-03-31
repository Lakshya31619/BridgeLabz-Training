public class DataExportFeatureMain {
    public static void main(String[] args) {
        ReportExporter csv = new CSVExporter();
        ReportExporter pdf = new PDFExporter();
        ReportExporter json = new AdvancedJSONExporter();
        csv.export();
        csv.exportToJSON();
        System.out.println();
        pdf.export();
        pdf.exportToJSON();
        System.out.println();
        json.export();
        json.exportToJSON();
    }
}