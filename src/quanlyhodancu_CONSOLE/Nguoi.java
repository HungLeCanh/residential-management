
package quanlyhodancu_CONSOLE;

import java.io.Serializable;
import java.util.Scanner;

public class Nguoi implements Serializable{

    
    private String hoTen;
    private int tuoi;
    private String ngheNghiep;
    private int soCMND;
    private String soNha;
    
    public Nguoi() {
        }
    
    public Nguoi(String hoTen, int tuoi, String ngheNghiep, int soCMND,String soNha) {
        this.hoTen = suaTen(hoTen);
        this.tuoi = tuoi;
        this.ngheNghiep = ngheNghiep;
        this.soCMND = soCMND;
        this.soNha = soNha;
    }
    
    public String suaTen(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("\\s");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }

        return result.toString().trim();
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public int getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }
    
    public void xuatThongTin(){
        System.out.println("Họ và tên   : " + getHoTen());
        System.out.println("Số CMND     : " + getSoCMND());
        System.out.println("Nghề nghiệp : " + getNgheNghiep());
        System.out.println("Tuổi        : " + getTuoi());
        System.out.println("Số nhà      : " + getSoNha());
    }

    @Override
    public String toString() {
        return "Nguoi{" + "hoTen=" + hoTen + ", tuoi=" + tuoi + ", ngheNghiep=" + ngheNghiep + ", soCMND=" + soCMND + '}';
    }
    
    
}
