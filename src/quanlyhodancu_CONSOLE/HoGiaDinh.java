
package quanlyhodancu_CONSOLE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class HoGiaDinh implements Serializable{
    private ArrayList<Nguoi> list;
    private String soNha;
    private int soThanhVien;

    public ArrayList<Nguoi> getList() {
        return list;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }
    
    public boolean checkCMND(int cmnd){
        if(this.list == null){
            return false;
        }
        for(Nguoi n : list){
            if(n.getSoCMND() == cmnd){
                return true;
            }
        }
        return false;
    }
    
    public HoGiaDinh() {
        list = new ArrayList<Nguoi>();
    }

    public HoGiaDinh(String soNha) {
        this.soNha = soNha;
        this.list = new ArrayList<Nguoi>();
    }

    public String getSoNha() {
        return soNha;
    }
    
    public void xuatThongTin(){
        System.out.println("Số nhà: " + getSoNha());
        System.out.println("Số thành viên: " + this.list.size());
        int i = 0;
        for(Nguoi n : list){
            i+=1;
            System.out.println("Thông tin thành viên thứ "+i+": ");
            n.xuatThongTin();
        }
    }
    
    public void themThanhVien(Nguoi nguoi){
        this.list.add(nguoi);
    }
    
    public void xoaThanhVien(Nguoi nguoi){
        this.list.remove(nguoi);
    }
}
