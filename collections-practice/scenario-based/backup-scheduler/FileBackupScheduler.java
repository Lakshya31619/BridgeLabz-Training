import java.util.PriorityQueue;
public class FileBackupScheduler {
    private PriorityQueue<BackupTask> backupQueue = new PriorityQueue<>();
    public void scheduleBackup(BackupTask task) throws InvalidBackupPathException {
        if (task.getFolderPath() == null || task.getFolderPath().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path.");
        }
        backupQueue.add(task);
        System.out.println("Scheduled: " + task);
    }
    public void executeBackups() {
        System.out.println("\nExecuting backups:");
        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            System.out.println("Backing up -> " + task);
        }
    }
}