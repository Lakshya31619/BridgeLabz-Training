public class ClassroomMain {
    public static void main(String[] args) {
        AttendanceService service = new AttendanceService();
        try {
            service.markAttendance("S101", "ST001");
            service.markAttendance("S101", "ST002");
            service.markAttendance("S101", "ST001");
        } catch (DuplicateAttendanceException e) {
            System.out.println(e.getMessage());
        }
        service.displayAttendance("S101");
        service.removeAttendance("S101", "ST002");
        service.displayAllAttendance();
    }
}