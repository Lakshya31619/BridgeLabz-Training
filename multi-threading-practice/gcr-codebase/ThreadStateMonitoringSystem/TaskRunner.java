class TaskRunner implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }
            Thread.sleep(2000);
            for (int i = 0; i < 1_000_000; i++) {
                Math.pow(i, 2);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}