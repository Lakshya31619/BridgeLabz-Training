public class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority;
    private String scheduledTime;
    public BackupTask(String folderPath, int priority, String scheduledTime) {
        this.folderPath = folderPath;
        this.priority = priority;
        this.scheduledTime = scheduledTime;
    }
    public String getFolderPath() {
        return folderPath;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }
    @Override
    public String toString() {
        return "BackupTask [folder=" + folderPath + ", priority=" + priority + ", time=" + scheduledTime + "]";
    }
}