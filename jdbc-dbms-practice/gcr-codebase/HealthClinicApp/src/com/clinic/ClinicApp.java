package com.clinic;
import java.util.List;

import com.clinic.dao.PatientDAO;
import com.clinic.model.Patient;
import com.clinic.util.InputUtil;
public class ClinicApp {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();
        boolean flag = false;
        while(true){
            System.out.println("\n=== Health Clinic App ===");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient by ID");
            System.out.println("3. Search Patient");
            System.out.println("0. Exit");
            int choice = InputUtil.getInt("Enter choice");
            switch(choice){
                case 1:
                    Patient p = new Patient();
                    p.setName(InputUtil.getString("Enter Name"));
                    p.setDob(InputUtil.getString("Enter DOB (YYYY-MM-DD)"));
                    p.setPhone(InputUtil.getString("Enter Phone"));
                    p.setEmail(InputUtil.getString("Enter Email"));
                    p.setAddress(InputUtil.getString("Enter Address"));
                    p.setBloodGroup(InputUtil.getString("Enter Blood Group"));
                    patientDAO.addPatient(p);
                    break;
                case 2:
                    int id = InputUtil.getInt("Enter Patient ID");
                    Patient patient = patientDAO.getPatientById(id);
                    if(patient != null)
                        System.out.println(patient.getName() + " | " + patient.getPhone());
                    else
                        System.out.println("Patient not found!");
                    break;
                case 3:
                    String keyword = InputUtil.getString("Enter Name or Phone to search: ");
                    List<Patient> results = patientDAO.searchPatients(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No patients found!");
                    } else {
                        System.out.println("\nSearch Results:");
                        for (Patient pat : results) {
                            System.out.println("ID: " + pat.getPatientId()
                                    + " | Name: " + pat.getName()
                                    + " | Phone: " + pat.getPhone()
                                    + " | Email: " + pat.getEmail());
                        }
                    }
                    break;
                case 0:
                    flag = true;
            }
            if(flag) break;
        }
    }
}