/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LK5.Controller;

import LK5.Interface.Confidential;
import LK5.Interface.MedicalRecord;

/**
 *
 * @author FICKY
 */
// Generic Class menggunakan Bounded Type Parameters (<T extends ...>).
// Artinya, T di sini hanya bisa diisi oleh class yang mengimplementasikan MedicalRecord DAN Confidential.
public class SecureResponse<T extends MedicalRecord & Confidential> {
    private boolean success;
    private T data;
    private String warningMessage;

    public SecureResponse(boolean success, T data, String warningMessage) {
        this.success = success;
        this.data = data;
        this.warningMessage = warningMessage;
    }

    public T getData() { return data; }
    public String getWarningMessage() { return warningMessage; }
}
