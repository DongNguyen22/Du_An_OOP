package LangXiTrum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHoaDon{
    private HoaDon[] dsHD;
    Scanner sc= new Scanner(System.in);
    public DanhSachHoaDon() {
        dsHD = new HoaDon[0];
    }
    // doc danh sach hoa don
    public void docFile() {
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("HoaDon.txt"), "UTF-8"))) {
        String line;
        int size = 0;
        dsHD = new HoaDon[0]; 
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 4) {
                String maHD = parts[0].trim();
                String maNV = parts[1].trim();
                String maKH = parts[2].trim();
                String ngayLap = parts[3].trim();
                HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayLap);
                DanhSachChiTietHoaDon dsct = new DanhSachChiTietHoaDon();
                dsct.docFile(maHD);
                hd.setDsCT(dsct);
                dsHD = Arrays.copyOf(dsHD, size + 1);
                dsHD[size++] = hd;
            }
        }
    } catch (IOException e) {
        System.out.println(" Loi doc file HoaDon.txt: " + e.getMessage());
    }
}
    //them hoa don
   public void them(HoaDon hd) {
    dsHD = Arrays.copyOf(dsHD, dsHD.length + 1);
    dsHD[dsHD.length - 1] = hd;
}
    //khoi tao n phan tu dau tien trong danh sach hoa don
    public void nhap(int n) {
      for (int i = 0; i < n; i++) {
         System.out.println("Nhap hoa don thu: "+(i+1)+": ");
         HoaDon hd = new HoaDon();
          hd.nhapN();
          dsHD[i] = hd;
     } 
    }
    public void xuat() {
        System.out.println("========== DANH SACH HOA DON ==========");
        if (dsHD.length == 0) {
            System.out.println("Chua co hoa don");
            return;
        }
        for (HoaDon hd : dsHD) {
            hd.hienThi();
        }
    }
    public void sua(String maHD) {
    boolean found = false;
      for (HoaDon hoaDon : dsHD) {
        if (hoaDon.getMaHD().equalsIgnoreCase(maHD)) {
            found = true;
            int choice;
            do {
                System.out.println("=== SUA HOA DON ===");
                System.out.println("1. Sua ma nhan vien");
                System.out.println("2. Sua ma khach hang");
                System.out.println("3. Sua ngay lap");
                System.out.println("4. Sua chi tiet hoa don");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon: ");
                choice = Integer.parseInt(sc.nextLine());
                
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ma nhan vien moi: ");
                        String maNV = sc.nextLine();
                        hoaDon.setMaNV(maNV);
                        System.out.println("Da sua ma nhan vien thanh cong!");
                        break;
                    case 2:
                        System.out.print("Nhap ma khach hang moi: ");
                        String maKH = sc.nextLine();
                        hoaDon.setMaKH(maKH);
                        System.out.println("Da sua ma khach hang thanh cong!");
                        break;
                    case 3:
                        System.out.print("Nhap ngay lap moi (dd/MM/yyyy): ");
                        String ngayLap = sc.nextLine();
                        hoaDon.setNgayLap(ngayLap);
                        System.out.println("Da sua ngay lap thanh cong!");
                        break;
                    case 4:
                        System.out.println("=== Nhap ma san pham can sua ===");
                        hoaDon.getDSCTHD().sua(sc.nextLine());
                        break;
                    case 0:
                        System.out.println("Thoat sua hoa don...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } while (choice != 0);
            break;
        }
    }
    if (!found) {
        System.out.println("Khong tim thay hoa don co ma: " + maHD);
    }
}
    public void xoa(String maHD) {
        int n=dsHD.length;
        for (int i = 0; i < n; i++) {
            if(dsHD[i].getMaHD().equalsIgnoreCase(maHD)){
                for(int j=i;j<n-1;j++){
                    dsHD[j]=dsHD[j+1];
                }
        --n;
        dsHD=Arrays.copyOf(dsHD, n);
                break;
            }
        }
        System.out.println("-> Da xoa hoa don thanh cong");
    }
    public void ghiFile() {
    try (BufferedWriter bwHD = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("HoaDon.txt", false), "UTF-8"));
         BufferedWriter bwCT = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("ChiTietHoaDon.txt", false), "UTF-8"))) {
        for (HoaDon hd : dsHD) {
            String lineHD = hd.getMaHD() + ";" +
                            hd.getMaNV() + ";" +
                            hd.getMaKH() + ";" +
                            hd.getNgayLap();
            bwHD.write(lineHD);
            bwHD.newLine();
            ChiTietHoaDon[] dsct = hd.getDSCTHD().getDsct();
            if (dsct != null) {
                for (ChiTietHoaDon ct : dsct) {
                    if (ct != null) {
                        String lineCT = hd.getMaHD() + ";" +
                                        ct.getMaSP() + ";" +
                                        ct.getTenSP() + ";"+
                                        ct.getSoLuong() + ";" +
                                        ct.getDonGia();
                        bwCT.write(lineCT);
                        bwCT.newLine();
                    }
                }
            }
        }
        System.out.println(" Ghi file HoaDon.txt và ChiTietHoaDon.txt thanh cong!");
    } catch (IOException e) {
        System.out.println("Lỗi ghi file: " + e.getMessage());
    }
}

    // tim kiem
    public HoaDon timHD(String key){
        for (HoaDon hoaDon : dsHD) {
            if(hoaDon.getMaHD().equalsIgnoreCase(key))
            {
                return hoaDon;
            }
        }
        return null;
    }
    // tim kiem nang cao
    public HoaDon[] timHDperMonth(int start , int end , int months , int years){
        HoaDon[] ketqua = new HoaDon[0];
        int size = 0;
         for (HoaDon hoaDon : dsHD) {
            if(hoaDon.getNgayLap() == null ) continue;
            String[] parts = hoaDon.getNgayLap().split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            if( day >= start && day <= end && month == months && year == years){
                ketqua = Arrays.copyOf(ketqua, size+1);
                ketqua[size++] = hoaDon;
            }
        }
        return ketqua;
    }
    //tim hoa don theo ma nhan vien 
    public HoaDon[] timHDtheoNV(String maNV) {
    HoaDon[] ketQua = new HoaDon[0];
      for (HoaDon hoaDon : dsHD) {
        if (hoaDon.getMaNV().equalsIgnoreCase(maNV)) {
            ketQua = Arrays.copyOf(ketQua, ketQua.length + 1);
            ketQua[ketQua.length - 1] = hoaDon;
        }
    }
    return ketQua;
}
    public HoaDon[] getDsHD() {
        return dsHD;
    }
}