/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LK5.Controller;

import LK5.Interface.MedicalRecord;
import LK5.Interface.Versioned;
import LK5.Interface.Confidential;

/**
 *
 * @author FICKY
 */
public class Gateway<T extends MedicalRecord & Versioned & Confidential> {
    private T mockDatabaseRecord;

    public Gateway(T record) {
        this.mockDatabaseRecord = record;
    }

    public SecureResponse<T> fetchData(String id, int requesterClearanceLevel) {
        String warning = "Data retrieved successfully.";
        
        // Cek apakah ID cocok
        if (!mockDatabaseRecord.getPatientId().equals(id)) {
            return new SecureResponse<>(false, null, "Patient ID not found.");
        }

        // Logika Masking tanpa menggunakan if (instanceof)
        if (requesterClearanceLevel < mockDatabaseRecord.getSecurityLevel()) {
            mockDatabaseRecord.maskSensitiveData(); // Polimorfisme bekerja di sini
            warning = "WARNING: Some data masked due to low clearance level.";
        }

        return new SecureResponse<>(true, mockDatabaseRecord, warning);
    }
}
