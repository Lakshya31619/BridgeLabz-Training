package com.clinic;

import com.clinic.dao.*;
import com.clinic.model.Doctor;
import com.clinic.model.Patient;
import com.clinic.util.InputUtil;

public class ClinicApp {
    public static void main(String[] args) {

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        VisitDAO visitDAO = new VisitDAO();
        BillingDAO billingDAO = new BillingDAO();
        SpecialityDAO specialityDAO = new SpecialityDAO();

        while(true){
            System.out.println("\n=== Health Clinic App ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Scheduling");
            System.out.println("4. Visit & Medical Records");
            System.out.println("5. Billing & Payments");
            System.out.println("6. Specialties Management");
            System.out.println("0. Exit");

            int choice = InputUtil.getInt("Enter choice: ");

            switch(choice){
                case 1:
                    System.out.println("\n--- Patient Management ---");
                    System.out.println("1. Register New Patient");
                    System.out.println("2. Update Patient Info");
                    System.out.println("3. View Patient by ID");
                    System.out.println("4. Search Patient by Name/Phone");
                    System.out.println("5. View Patient Visit History");
                    int pChoice = InputUtil.getInt("Enter choice: ");
                    switch(pChoice){
                        case 1:
                            Patient p = new Patient();
                            p.setName(InputUtil.getString("Enter Name: "));
                            p.setDob(InputUtil.getString("Enter DOB (YYYY-MM-DD): "));
                            p.setPhone(InputUtil.getString("Enter Phone: "));
                            p.setEmail(InputUtil.getString("Enter Email: "));
                            p.setAddress(InputUtil.getString("Enter Address: "));
                            p.setBloodGroup(InputUtil.getString("Enter Blood Group: "));
                            if(patientDAO.addPatient(p)) System.out.println("Patient registered. ID: " + p.getPatientId());
                            else System.out.println("Failed to add patient.");
                            break;
                        case 2:
                            int updateId = InputUtil.getInt("Enter Patient ID to update: ");
                            Patient pUpdate = patientDAO.getPatientById(updateId);
                            if(pUpdate != null){
                                pUpdate.setName(InputUtil.getString("Enter Name: "));
                                pUpdate.setDob(InputUtil.getString("Enter DOB (YYYY-MM-DD): "));
                                pUpdate.setPhone(InputUtil.getString("Enter Phone: "));
                                pUpdate.setEmail(InputUtil.getString("Enter Email: "));
                                pUpdate.setAddress(InputUtil.getString("Enter Address: "));
                                pUpdate.setBloodGroup(InputUtil.getString("Enter Blood Group: "));
                                if(patientDAO.updatePatient(pUpdate)) System.out.println("Patient updated successfully.");
                                else System.out.println("Update failed.");
                            } else System.out.println("Patient not found.");
                            break;

                        case 3:
                            int id = InputUtil.getInt("Enter Patient ID: ");
                            Patient patient = patientDAO.getPatientById(id);
                            if(patient != null){
                                System.out.println("ID:" + patient.getPatientId() + " | Name:" + patient.getName() +
                                        " | Phone:" + patient.getPhone() + " | Email:" + patient.getEmail() +
                                        " | Blood Group:" + patient.getBloodGroup());
                            } else System.out.println("Patient not found.");
                            break;

                        case 4:
                            patientDAO.searchPatientInteractive();
                            break;

                        case 5:
                            int pid = InputUtil.getInt("Enter Patient ID: ");
                            visitDAO.viewVisitHistory(pid);
                            break;

                        default: System.out.println("Invalid choice."); break;
                    }
                    break;

                case 2:
                    System.out.println("\n--- Doctor Management ---");
                    System.out.println("1. Add Doctor");
                    System.out.println("2. Assign/Update Specialty");
                    System.out.println("3. View Doctors by Specialty");
                    System.out.println("4. Deactivate Doctor");
                    int dChoice = InputUtil.getInt("Enter choice: ");
                    switch(dChoice){
                        case 1:
                            Doctor d = new Doctor();
                            d.setName(InputUtil.getString("Enter Doctor Name: "));
                            d.setPhone(InputUtil.getString("Enter Phone: "));
                            d.setSpecialtyId(InputUtil.getInt("Enter Specialty ID: "));
                            d.setConsultationFee(InputUtil.getDouble("Enter Consultation Fee: "));
                            doctorDAO.addDoctor(d);
                            break;

                        case 2: doctorDAO.assignSpecialty(); break;
                        case 3: doctorDAO.viewDoctorsBySpecialty(); break;
                        case 4:
                            int did = InputUtil.getInt("Enter Doctor ID to deactivate: ");
                            doctorDAO.deactivateDoctor(did); break;
                        default: System.out.println("Invalid choice."); break;
                    }
                    break;

                case 3:
                    System.out.println("\n--- Appointment Scheduling ---");
                    System.out.println("1. Book Appointment");
                    System.out.println("2. Check Doctor Availability");
                    System.out.println("3. Cancel Appointment");
                    System.out.println("4. Reschedule Appointment");
                    System.out.println("5. View Daily Schedule");
                    int aChoice = InputUtil.getInt("Enter choice: ");
                    switch(aChoice){
                        case 1: appointmentDAO.bookAppointment(); break;
                        case 2: appointmentDAO.checkAvailability(); break;
                        case 3: appointmentDAO.cancelAppointment(); break;
                        case 4: appointmentDAO.rescheduleAppointment(); break;
                        case 5: appointmentDAO.viewDailySchedule(); break;
                        default: System.out.println("Invalid choice."); break;
                    }
                    break;

                case 4:
                    System.out.println("\n--- Visit & Medical Records ---");
                    System.out.println("1. Record Patient Visit");
                    System.out.println("2. View Patient Medical History");
                    System.out.println("3. Add Prescription");
                    int vChoice = InputUtil.getInt("Enter choice: ");
                    switch(vChoice){
                        case 1: visitDAO.recordVisit(); break;
                        case 2: visitDAO.viewMedicalHistory(); break;
                        case 3: visitDAO.addPrescription(); break;
                        default: System.out.println("Invalid choice."); break;
                    }
                    break;

                case 5:
                    System.out.println("\n--- Billing & Payments ---");
                    System.out.println("1. Generate Bill for Visit");
                    System.out.println("2. Record Payment");
                    System.out.println("3. View Outstanding Bills");
                    System.out.println("4. Generate Revenue Report");
                    int bChoice = InputUtil.getInt("Enter choice: ");
                    switch(bChoice){
                        case 1: billingDAO.generateBill(); break;
                        case 2: billingDAO.recordPayment(); break;
                        case 3: billingDAO.viewOutstandingBills(); break;
                        case 4: billingDAO.generateRevenueReport(); break;
                        default: System.out.println("Invalid choice."); break;
                    }
                    break;

                case 6:
                    System.out.println("\n--- Specialties Management ---");
                    System.out.println("1. Add Specialty");
                    System.out.println("2. Update Specialty");
                    System.out.println("3. Delete Specialty");
                    System.out.println("4. View Specialties");
                    int sChoice = InputUtil.getInt("Enter choice: ");
                    switch(sChoice){
                        case 1: specialityDAO.addSpeciality(); break;
                        case 2: specialityDAO.updateSpeciality(); break;
                        case 3: specialityDAO.deleteSpeciality(); break;
                        case 4: specialityDAO.viewSpecialties(); break;
                        default: System.out.println("Invalid choice."); break;
                    }
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
