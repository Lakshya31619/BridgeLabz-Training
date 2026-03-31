public class BackupService {
    public static void processBackup(Object obj) {
        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("Skipping backup for: " + obj.getClass().getSimpleName());
        }
    }
}