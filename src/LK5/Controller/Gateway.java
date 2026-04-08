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
// Generic Class yang lebih ketat. T harus mengimplementasikan KETIGA interface sekaligus.
// Gateway bertugas sebagai "pintu masuk" untuk meminta data rekam medis.
public class Gateway<T extends MedicalRecord & Versioned & Confidential> {
    private T mockDatabaseRecord;   // Data simulasi yang seolah-olah ditarik dari database

    public Gateway(T record) {
        this.mockDatabaseRecord = record;
    }
    // Method utama untuk meminta data berdasarkan ID Pasien dan Level Akses (Clearance) Peminta/Dokter
    public SecureResponse<T> fetchData(String id, int requesterClearanceLevel) {
        String warning = "Data retrieved successfully.";// Pesan default jika sukses

        // Cek apakah ID yang diminta (parameter id) cocok dengan ID data di "database"
        if (!mockDatabaseRecord.getPatientId().equals(id)) {
            return new SecureResponse<>(false, null, "Patient ID not found.");
        }

        // Logika Masking tanpa menggunakan if (instanceof)
        if (requesterClearanceLevel < mockDatabaseRecord.getSecurityLevel()) {
            mockDatabaseRecord.maskSensitiveData(); // Polimorfisme bekerja di sini
            warning = "WARNING: Some data masked due to low clearance level.";
        }
        // Kembalikan rekam medis (tersensor atau tidak) beserta pesan status atau peringatan.
        return new SecureResponse<>(true, mockDatabaseRecord, warning);
    }
}
