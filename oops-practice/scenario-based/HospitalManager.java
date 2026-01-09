import java.util.*;
//Interface
interface IPayable {
    double calculateBill();
}
//Abstract Class
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    // Encapsulation
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // Polymorphism
    public abstract void displayInfo();
}
//Inheritance
class InPatient extends Patient implements IPayable {
    private int daysAdmitted;
    private double dailyCharge;
    public void setDaysAdmitted(int daysAdmitted) {
        this.daysAdmitted = daysAdmitted;
    }
    public void setDailyCharge(double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }
    @Override
    public void displayInfo() {
        System.out.println("[InPatient] ID: " + getPatientId() + ", Name: " + getName() + ", Age: " + getAge() + ", Bill: " + calculateBill());
    }
}
//Inheritance
class OutPatient extends Patient implements IPayable {
    private double consultationFee;
    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    @Override
    public void displayInfo() {
        System.out.println("[OutPatient] ID: " + getPatientId() + ", Name: " + getName() + ", Age: " + getAge() + ", Bill: " + calculateBill());
    }
}
//Doctor class
class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }
}
//Bill Class
class Bill {
    private int billId;
    private double amount;
    public Bill(int billId, double amount) {
        this.billId = billId;
        this.amount = amount;
    }
}
//CRUD Operations
class HospitalService {
    private List<Patient> patients = new ArrayList<>();
    // CREATE
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    // READ
    public void viewPatients() {
        for (Patient p : patients) {
            p.displayInfo(); // Polymorphism
        }
    }
    // UPDATE
    public void updatePatient(int id, String newName) {
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                p.setName(newName);
                break;
            }
        }
    }
    // DELETE
    public void deletePatient(int id) {
        patients.removeIf(p -> p.getPatientId() == id);
    }
}
//Main Class
public class HospitalManager {
    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        InPatient ip = new InPatient();
        ip.setPatientId(1);
        ip.setName("Armando");
        ip.setAge(45);
        ip.setDaysAdmitted(4);
        ip.setDailyCharge(1500);
        OutPatient op = new OutPatient();
        op.setPatientId(2);
        op.setName("Toni");
        op.setAge(30);
        op.setConsultationFee(600);
        service.addPatient(ip);
        service.addPatient(op);
        System.out.println("---- Patient List ----");
        service.viewPatients();
        service.updatePatient(2, "Armando Diaz");
        service.deletePatient(1);
        System.out.println("\n---- After Update & Delete ----");
        service.viewPatients();
    }
}