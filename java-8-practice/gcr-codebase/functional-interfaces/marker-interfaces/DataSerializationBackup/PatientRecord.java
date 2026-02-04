public class PatientRecord implements BackupSerializable {
    private int patientId;
    private String name;
    public PatientRecord(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
}