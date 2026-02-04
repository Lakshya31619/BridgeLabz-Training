import java.util.*;
public class HospitalAdminMain {
    public static void main(String[] args) {
        List<Patient> patients = List.of(
                new Patient(101, "Rahul"),
                new Patient(102, "Rakesh"),
                new Patient(103, "Rajesh")
        );
        patients.forEach(PatientPrinter::printPatientId);
    }
}