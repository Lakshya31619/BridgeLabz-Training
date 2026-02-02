public class PerformanceService {
    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1_000_000; i++) {
        }
    }
    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 100_000_000; i++) {
        }
    }
    public void normalTask() {
        System.out.println("Normal task (no logging)");
    }
}