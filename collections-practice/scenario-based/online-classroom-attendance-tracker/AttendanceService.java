import classroom.exception.DuplicateAttendanceException;
import java.util.*;
public class AttendanceService {
    private Map<String, Set<String>> attendanceMap = new HashMap<>();
    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
        attendanceMap.putIfAbsent(sessionId, new HashSet<>());
        Set<String> students = attendanceMap.get(sessionId);
        if (students.contains(studentId)) {
            throw new DuplicateAttendanceException("Attendance already marked for Student: " + studentId + " in Session: " + sessionId);
        }
        students.add(studentId);
        System.out.println("Attendance marked for Student: " + studentId + " in Session: " + sessionId);
    }
    public void removeAttendance(String sessionId, String studentId) {
        if (attendanceMap.containsKey(sessionId)) {
            Set<String> students = attendanceMap.get(sessionId);
            if (students.remove(studentId)) {
                System.out.println("Attendance removed for Student: " + studentId);
            } else {
                System.out.println("Student not found in session.");
            }
        } else {
            System.out.println("Session not found.");
        }
    }
    public void displayAttendance(String sessionId) {
        if (!attendanceMap.containsKey(sessionId)) {
            System.out.println("Session not found.");
            return;
        }
        Set<String> students = attendanceMap.get(sessionId);
        System.out.println("Attendance for Session: " + sessionId);
        for (String student : students) {
            System.out.println("Student ID: " + student);
        }
    }
    public void displayAllAttendance() {
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance records available.");
            return;
        }
        for (Map.Entry<String, Set<String>> entry : attendanceMap.entrySet()) {
            System.out.println("Session: " + entry.getKey());
            for (String student : entry.getValue()) {
                System.out.println("   Student ID: " + student);
            }
        }
    }
}