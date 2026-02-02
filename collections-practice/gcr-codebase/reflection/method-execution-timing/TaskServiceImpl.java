public class TaskServiceImpl implements TaskService {
    @Override
    public void fastTask() {
        for (int i = 0; i < 1_000_000; i++) {
        }
    }
    @Override
    public void slowTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}