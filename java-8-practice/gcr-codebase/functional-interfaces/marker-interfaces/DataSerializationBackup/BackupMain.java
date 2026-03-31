public class BackupMain {
    public static void main(String[] args) {
        PatientRecord record = new PatientRecord(101, "Alice");
        SessionCache cache = new SessionCache("ABC123");
        BackupService.processBackup(record);
        BackupService.processBackup(cache);
    }
}