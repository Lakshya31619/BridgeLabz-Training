public class BackupSchedulerMain {
    public static void main(String[] args) {
        FileBackupScheduler scheduler = new FileBackupScheduler();
        try {
            scheduler.scheduleBackup(new BackupTask("./collections-practice/scenario-based/backup-scheduler", 3, "02:00 AM"));
            scheduler.scheduleBackup(new BackupTask("/collections-practice/scenario-based/backup-scheduler", 1, "03:00 AM"));
            scheduler.scheduleBackup(new BackupTask("/collections-practice/scenario-based/backup-scheduler", 2, "01:00 AM"));
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }
        scheduler.executeBackups();
    }
}