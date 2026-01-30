package com.lakshya;
public class PerformanceTesting {
    public String longRunningTask() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}