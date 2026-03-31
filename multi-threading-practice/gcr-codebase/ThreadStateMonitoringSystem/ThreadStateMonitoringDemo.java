public class ThreadStateMonitoringDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread task1 = new Thread(new TaskRunner(), "Task-1");
        Thread task2 = new Thread(new TaskRunner(), "Task-2");
        StateMonitor monitor = new StateMonitor(task1, task2);
        monitor.start();
        Thread.sleep(500);
        task1.start();
        task2.start();
        task1.join();
        task2.join();
        monitor.join();
    }
}