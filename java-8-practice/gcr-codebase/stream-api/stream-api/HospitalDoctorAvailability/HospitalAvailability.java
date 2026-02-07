import java.util.*;
public class HospitalAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Mehta", "Cardiology", true),
                new Doctor("Dr. Sharma", "Neurology", false),
                new Doctor("Dr. Iyer", "Orthopedics", true),
                new Doctor("Dr. Khan", "Dermatology", true),
                new Doctor("Dr. Verma", "Cardiology", false)
        );
        List<Doctor> weekendDoctors = doctors.stream()
                .filter(Doctor::isAvailableOnWeekend)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .toList();
        weekendDoctors.forEach(System.out::println);
    }
}