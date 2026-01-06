import java.util.ArrayList;
import java.util.List;
//Main class
public class HospitalPatientApp {
    public static void main(String[] args) {
        List<BasePatient> patients = new ArrayList<>();
        patients.add(new InHospitalPatient(1, "John Cena", 49, 5, 2000));
        patients.add(new OutHospitalPatient(2, "Undertaker", 56, 500));
        // Polymorphic processing
        for (BasePatient patient : patients) {
            double billAmount = patient.calculateBill();
            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill : " + billAmount);
            if (patient instanceof MedicalRecordable) {
                MedicalRecordable record = (MedicalRecordable) patient;
                record.addRecord("Routine Checkup Completed");
                System.out.println("Medical Records: " + record.viewRecords());
            }
            System.out.println("------------------------------------");
        }
    }
}
//Interface
interface MedicalRecordable {
    void addRecord(String record);
    List<String> viewRecords();
}
//Abstract class
abstract class BasePatient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    protected BasePatient(int patientId, String name, int age) {
        setPatientId(patientId);
        setName(name);
        setAge(age);
    }
    // Abstract method
    public abstract double calculateBill();
    // Concrete method
    public String getPatientDetails() {
        return "Patient ID : " + patientId +", Name : " + name +", Age : " + age;
    }
    // Encapsulation
    public int getPatientId() {
        return patientId;
    }
    private void setPatientId(int patientId) {
        if (patientId <= 0) {
            throw new IllegalArgumentException("Invalid patient ID.");
        }
        this.patientId = patientId;
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid age.");
        }
        this.age = age;
    }
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    protected String getDiagnosis() {
        return diagnosis;
    }
}
//In-Patient class
class InHospitalPatient extends BasePatient implements MedicalRecordable {
    private int numberOfDays;
    private double dailyCharge;
    private List<String> medicalHistory = new ArrayList<>();
    public InHospitalPatient(int patientId, String name, int age,int numberOfDays, double dailyCharge) {
        super(patientId, name, age);
        this.numberOfDays = numberOfDays;
        this.dailyCharge = dailyCharge;
    }
    @Override
    public double calculateBill() {
        return numberOfDays * dailyCharge;
    }
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }
}
//Out-patient class
class OutHospitalPatient extends BasePatient implements MedicalRecordable {
    private double consultationFee;
    private List<String> medicalHistory = new ArrayList<>();
    public OutHospitalPatient(int patientId, String name, int age,double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }
}