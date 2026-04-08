/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LK5.DTO;

import LK5.Interface.Confidential;
import LK5.Interface.MedicalRecord;
import LK5.Interface.Versioned;

/**
 *
 * @author FICKY
 */
public class PatientProfileV1 implements MedicalRecord, Versioned, Confidential {
    private String patientId;
    private String name;
    private String data;
    private int securityLevel = 2; // Restricted

    public PatientProfileV1(String patientId, String name, String data) {
        this.patientId = patientId;
        this.name = name;
        this.data = data;
    }

    @Override
    public String getPatientId() { return patientId; }

    @Override
    public int getVersion() { return 1; }

    @Override
    public int getSecurityLevel() { return securityLevel; }

    @Override
    public void maskSensitiveData() {
        // Jika data ada, maka nilainya diganti dengan "******" untuk menyembunyikannya dari user yang aksesnya kurang.
        if (this.data != null) {
            this.data = "******"; // Logika masking
        }
    }

    // Method tambahan untuk mempermudah print di console
    @Override
    public String toString() {
        return "PatientProfileV1 [ID=" + patientId + ", Name=" + name + ", Private Data=" + data + "]";
    }
    
}
