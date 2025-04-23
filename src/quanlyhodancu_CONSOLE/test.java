
package quanlyhodancu_CONSOLE;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KhuPho khuPho = new KhuPho();
        int c;
        do{
            System.out.println("---QUẢN LÝ HỘ DÂN CƯ---\n"
                    + "OPTION 1: Thêm hộ gia đình\n"
                    + "OPTION 2: Tìm theo số CMND\n"
                    + "OPTION 3: Hiện toàn bộ thông tin khu phố\n"
                    + "OPTION 4: Hiện thông tin theo số nhà\n"
                    + "OPTION 5: Xoá thông tin người theo số CMND\n"
                    + "OPTION 6: Lưu file\n"
                    + "OPTION 7: Lấy dữ liệu từ file\n"
                    + "OPTION 0: THOÁT\n"
                    + "Mời bạn chọn option.");
            c = khuPho.checkFolmat();
            if(c==1){
                System.out.println("Nhập vào số nhà: ");
                String soNha = sc.nextLine();
                if(khuPho.checkSoNha(soNha)){
                    System.out.println("Số nhà đã bị trùng lặp");
                }else{
                    khuPho.themThongTinHoGiaDinh(soNha);
                }
            }else if(c==2){
                int cmnd;
                System.out.println("Nhập số CMND cần tìm: ");
                cmnd = khuPho.checkFolmat();
                khuPho.timTheoCMND(cmnd);
            }else if(c==3){
                khuPho.show();
            }else if(c==4){
                System.out.println("Nhập số nhà cần hiện thông tin:");
                String soNha = sc.nextLine();
                khuPho.xuatThongTin(soNha);
            }else if(c==6){
                khuPho.write();
            }else if(c==7){
                khuPho.read();
            }else if(c==5){
                System.out.println("Nhập số CMND cần xóa");
                khuPho.xoaNguoi(khuPho.checkFolmat());
            }else{
                System.out.println("Hãy nhập lựa chọn từ 0-7");
            }
        }while(c!=0);
    }
}
