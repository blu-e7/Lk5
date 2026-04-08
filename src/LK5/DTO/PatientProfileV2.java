/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LK5.DTO;

import LK5.Interface.Confidential;
import LK5.Interface.MedicalRecord;
import LK5.Interface.Versioned;

public class PatientProfileV2 implements MedicalRecord, Versioned, Confidential{
    private String patientId;
    private String name;
    private String data; 
    private String diagnosaKhusus; // Field tambahan di V2
    private int securityLevel = 3; // Secret (Lebih ketat dari V1)

    public PatientProfileV2(String patientId, String name, String data, String diagnosaKhusus) {
        this.patientId = patientId;
        this.name = name;
        this.data = data;
        this.diagnosaKhusus = diagnosaKhusus;
    }

    @Override
    public String getPatientId() { return patientId; }

    @Override
    public int getVersion() { return 2; }

    @Override
    public int getSecurityLevel() { return securityLevel; }

    @Override
    public void maskSensitiveData() {
        if (this.data != null) this.data = "******";
        if (this.diagnosaKhusus != null) this.diagnosaKhusus = "[DATA DILINDUNGI]";
    }

    @Override
    public String toString() {
        return "PatientProfileV2 [ID=" + patientId + ", Name=" + name + ", Private Data=" + data + ", Diagnosa=" + diagnosaKhusus + "]";
    }
}
