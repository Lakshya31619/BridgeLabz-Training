package com.lakshya;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
public class PerformanceTestingTest {
    private PerformanceTesting taskRunner;
    @BeforeEach
    void setUp() {
        taskRunner = new PerformanceTesting();
    }
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        // This test will fail because the task takes 3 seconds but timeout is 2
        taskRunner.longRunningTask();
    }
}