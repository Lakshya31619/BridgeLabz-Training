import java.time.LocalTime;
import java.util.*;
class StateMonitor extends Thread {
    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();
    public StateMonitor(Thread... threads) {
        this.threads = threads;
        for (Thread t : threads) {
            stateHistory.put(t.getName(), new HashSet<>());
        }
    }
    @Override
    public void run() {
        boolean allTerminated;
        do {
            allTerminated = true;
            for (Thread t : threads) {
                Thread.State state = t.getState();
                stateHistory.get(t.getName()).add(state);
                System.out.println(
                    "[Monitor] " + t.getName() + " is in " + state +
                    " state at " + LocalTime.now()
                );
                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted.");
            }
        } while (!allTerminated);
        System.out.println("\n--- Summary ---");
        for (String name : stateHistory.keySet()) {
            System.out.println(
                name + " went through " + stateHistory.get(name).size() + " states: "
                + stateHistory.get(name)
            );
        }
    }
}