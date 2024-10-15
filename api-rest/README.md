# Medical Appointment System

## Overview

The system is designed to manage the scheduling, handling, and follow-up of medical appointments, facilitating the interaction between patients, doctors, receptionists, and administrators. The platform supports the management of patient records, appointments, consultations, prescriptions, and the generation of reports.

## Key Modules

### 1. User Management

- **User Roles:**
  - **Receptionist**: Manages appointments and patient records.
  - **Doctor**: Conducts consultations, diagnoses, and prescribes medications.
  - **Administrator**: Oversees system settings and user roles.
  - **Patient**: Can access their medical history and consultation records.
- **User Registration**: Receptionists register first-time patients using their email as the password, assuming all patients have an email account.

### 2. Medication & Units of Measurement

- A list of medications and their units of measurement (e.g., tablets, milliliters) is maintained.
- Doctors will assign medications and dosages during consultations.

### 3. Appointment Management

- **Appointment Registration**: Receptionists can schedule appointments and assign time slots for patient visits.
- **Follow-up Appointments**: Doctors can schedule follow-up appointments as needed for continued patient care.

### 4. Consultation Process

- Doctors can access the patient’s medical history and update new consultation details, diagnoses, and prescriptions.
- Receptionists can print reports summarizing the doctor’s diagnosis and prescribed medications.

### 5. Reports and History

- **Prescription Reports**: Generate reports of prescribed medications.
- **Consultation Filtering**: Consultations can be filtered by patient ID or patient name.
- **Medical History Access**: Patients can log in to view their consultation history, diagnoses, and prescribed medications.

## Use Cases

### 1. First-time Patient Registration

Receptionists create a patient record, generating a unique patient ID, and use the patient's email as the password.

### 2. Appointment Scheduling

Receptionists schedule patient appointments upon arrival, assigning time slots for each visit.

### 3. Consultation Management

Doctors perform patient consultations, record diagnoses, prescribe medications, and schedule follow-up visits.

### 4. Medical History Access

Patients can log in to view their medical history, including previous consultations, diagnoses, and prescriptions.

## Report Generation

- **Receptionist Tasks**: Print reports of diagnoses and prescribed medications for patients.
- **System Reports**: Generate reports of prescribed medications for tracking or inventory purposes.
