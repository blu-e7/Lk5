/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LK5;

import LK5.Controller.Gateway;
import LK5.Controller.SecureResponse;
import LK5.DTO.PatientProfileV1;
import LK5.DTO.PatientProfileV2;

/**
 *
 * @author FICKY
 */
public class MainSimulation {
    public static void main(String[] args) {
        System.out.println("=== MediGuard  Gateway Simulation ===\n");

        // 1. Persiapan Data Dummy di "Database"
        PatientProfileV1 dataV1 = new PatientProfileV1("P-001", "Budi Santoso", "357123456");
        PatientProfileV2 dataV2 = new PatientProfileV2("P-002", "Siti Aminah", "357987654", "Diabetes Melitus");

        // 2. Persiapan Gateway
        Gateway<PatientProfileV1> gatewayV1 = new Gateway<>(dataV1);
        Gateway<PatientProfileV2> gatewayV2 = new Gateway<>(dataV2);

        // 3. Skenario A: Dokter Umum (Clearance = 1) meminta data V1 (Security = 2)
        System.out.println("--- Skenario A: Dokter Akses Rendah (Level 1) meminta Data V1 ---");
        SecureResponse<PatientProfileV1> responseA = gatewayV1.fetchData("P-001", 1);
        System.out.println("Pesan: " + responseA.getWarningMessage());
        System.out.println("Data : " + responseA.getData().toString() + "\n");

        // 4. Skenario B: Dokter Spesialis (Clearance = 3) meminta data V2 (Security = 3)
        System.out.println("--- Skenario B: Dokter Akses Tinggi (Level 3) meminta Data V2 ---");
        SecureResponse<PatientProfileV2> responseB = gatewayV2.fetchData("P-002", 3);
        System.out.println("Pesan: " + responseB.getWarningMessage());
        System.out.println("Data : " + responseB.getData().toString() + "\n");
        
        // 5. Skenario C: Dokter Umum (Clearance = 1) meminta data V2 (Security = 3)
        // Kita buat data baru agar V2 yang lama tidak termask permanen dari simulasi sebelumnya
        PatientProfileV2 dataV2Lain = new PatientProfileV2("P-003", "Andi Wijaya", "357111222", "Kanker Paru");
        Gateway<PatientProfileV2> gatewayV2Lain = new Gateway<>(dataV2Lain);
        
        System.out.println("--- Skenario C: Dokter Akses Rendah (Level 1) meminta Data V2 ---");
        SecureResponse<PatientProfileV2> responseC = gatewayV2Lain.fetchData("P-003", 1);
        System.out.println("Pesan: " + responseC.getWarningMessage());
        System.out.println("Data : " + responseC.getData().toString() + "\n");
    }
}
