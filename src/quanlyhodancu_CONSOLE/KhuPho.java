
package quanlyhodancu_CONSOLE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class KhuPho {
    private ArrayList<HoGiaDinh> list;
    Scanner sc = new Scanner(System.in);

    public KhuPho() {
        list = new ArrayList<HoGiaDinh>();
    }
    public void show(){
        if(this.list == null){
            System.out.println("Danh sách rỗng");
        }else{
            for(HoGiaDinh hgd : list){
                for(Nguoi nguoi : hgd.getList()){
                    nguoi.xuatThongTin();
                    System.out.println("--------------------------");
                    }
                }
        }
    }

    public void setList(ArrayList<HoGiaDinh> list) {
        this.list = list;
    }
    
    
    public void timTheoCMND(int cmnd){
        for(HoGiaDinh hgd : list){
            for(Nguoi nguoi : hgd.getList()){
                if(nguoi.getSoCMND() == cmnd){
                    nguoi.xuatThongTin();
                    break;
                }
            }
        }
    }

    public ArrayList<HoGiaDinh> getList() {
        return list;
    }
    
    
    
    public boolean checkCMND(int cmnd){
        if(this.list == null){
            return false;
        }
        for(HoGiaDinh hgd : list){
            for(Nguoi nguoi : hgd.getList()){
                if(nguoi.getSoCMND() == cmnd){
                    return true;
                }
            }
        }return false;
    }
    
    public boolean checkSoNha(String soNha){
        for(HoGiaDinh hgd : list){
            if(hgd.getSoNha().equals(soNha)){
                return true;
            }
        }
        return false;
    }
    
    public int checkFolmat(){
        int temp = 0;
        try {
            temp = Integer.parseInt(sc.nextLine());
            return temp;
            } catch (Exception e) {
            System.out.println("BẠN ĐÃ NHẬP SAI CÚ PHÁP");
            return checkFolmat();
            }
    }
    
    public void xuatThongTin(String soNha){
        if(this.list == null){
            System.out.println("Danh sách rỗng");
        }else{
            for(HoGiaDinh hgd : list){
                if(hgd.getSoNha().equals(soNha)){
                    hgd.xuatThongTin();
                }
            }
        }
    }
    
    public void write(){
        try {
            FileOutputStream fos = new FileOutputStream("dulieu.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("GHI THÀNH CÔNG");
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("LỖI GHI FILE");
        }
    }
    
    public void read(){
        try {
            FileInputStream fis = new FileInputStream("dulieu.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.list = (ArrayList<HoGiaDinh>)ois.readObject();
            System.out.println("ĐỌC VÀ LẤY DỮ LIỆU FILE THÀNH CÔNG");
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("LỖI ĐỌC FILE");
        }
    }
    
    public void themHoGiaDinh(HoGiaDinh hgd){
        this.list.add(hgd);
    }
    
    public void xoaNguoi(int cmnd){
        if(this.checkCMND(cmnd)==false){
            System.out.println("Số CMND này chưa có trong danh sách");
        }else{
            for(HoGiaDinh hgd : list){
                for(Nguoi nguoi : hgd.getList()){
                    if(nguoi.getSoCMND() == cmnd){
                        hgd.xoaThanhVien(nguoi);
                        if(hgd.getList()==null){
                            this.list.remove(hgd);
                        }
                        System.out.println("ĐÃ XÓA THÔNG TIN NGƯỜI DÂN SỐ CMND " + cmnd);
                        break;
                    }
                }
            }
        }
    }
    
    public void themThongTinHoGiaDinh(String soNha){
        HoGiaDinh hgd = new HoGiaDinh(soNha);
        System.out.println("Nhập số thành viên trong hộ gia đình:");
        int i = checkFolmat();
        hgd.setSoThanhVien(i);
        for (int j = 0; j < i; j++) {
            System.out.println("Nhập thông tin thành viên thứ " + (j+1));
            int ok = 1;
            int soCMND;
            do{
                ok = 1;
                System.out.println("Nhập số CMND: ");
                soCMND = checkFolmat();
                if(checkCMND(soCMND) || hgd.checkCMND(soCMND)){
                System.out.println("Số CMND không hợp lệ, vui lòng nhập lại");
                ok = 0;
                }
            }while(ok == 0);
            System.out.println("Nhập họ và tên: ");
            String hoTen = chuanHoaTen();
            System.out.println("Nhập tuổi: ");
            int tuoi = checkFolmat();
            System.out.println("Nhập nghề nghiệp: ");
            String ngheNghiep = chuanHoaTen();
            Nguoi nguoi = new Nguoi(hoTen,tuoi,ngheNghiep,soCMND,soNha);
            hgd.themThanhVien(nguoi);
            
        }
        this.list.add(hgd);
    }
    
    public String chuanHoaTen() {
         String ten = sc.nextLine();
         if (!isValidName(ten)) 
         {
             System.out.println("CHUỖI BỊ LỖI, VUI LÒNG NHẬP LẠI");
             return chuanHoaTen();}
        String[] arr = ten.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (s.length() > 0) {
                sb.append(Character.toUpperCase(s.charAt(0)));
                sb.append(s.substring(1).toLowerCase());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
     public boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (isSpecialCharacter(c)) {
                return false;
            }
        }
        return true;
}

    public boolean isSpecialCharacter(char c) {

        return !(Character.isLetter(c) || Character.isWhitespace(c));
    }
}
