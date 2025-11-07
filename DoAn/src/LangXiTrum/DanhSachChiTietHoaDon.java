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

public class DanhSachChiTietHoaDon  {
    private ChiTietHoaDon[] dsct;
    Scanner sc = new Scanner(System.in);
    public DanhSachChiTietHoaDon(){
        dsct = new ChiTietHoaDon[0];
    }
    public void xuat() {
        for (ChiTietHoaDon chiTietHoaDon : dsct) {
            chiTietHoaDon.hienThi();
        }
    }
    public void docFile(String mahd) {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("ChiTietHoaDon.txt"), "UTF-8"))) {
                dsct = new ChiTietHoaDon[0];
             String line;
            int size = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String maHD = parts[0];
                    if(maHD.equalsIgnoreCase(mahd)){
                    String maSP = parts[1];
                    String tenSP = parts[2];
                    int soLuong = Integer.parseInt(parts[3]);
                    double donGia = Double.parseDouble(parts[4]);
                    dsct = Arrays.copyOf(dsct, size+1);
                    dsct[size++] = new ChiTietHoaDon(maHD, maSP, tenSP, soLuong, donGia);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("loi doc file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("khong tim thay thu muc chi tiet hoa don");
        }
    }

    public void ghiFile() {
        try (BufferedWriter bwCT = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ChiTietHoaDon.txt", false), "UTF-8"))) {
            for (ChiTietHoaDon chiTietHoaDon : dsct) {
                String line = chiTietHoaDon.getMaHD() + ";" +
                          chiTietHoaDon.getMaSP() + ";" +
                          chiTietHoaDon.getTenSP() + ";" +
                          chiTietHoaDon.getSoLuong() + ";" +
                          chiTietHoaDon.getDonGia() ;
            bwCT.write(line);
            bwCT.newLine();
        }
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    public void nhap(int n) {
    dsct = new ChiTietHoaDon[n];
    for (int i = 0; i < n; i++) {
        System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
        dsct[i] = new ChiTietHoaDon();
        dsct[i].nhap();
    }
    }
    public void them() {
    int size = dsct.length;
    dsct = Arrays.copyOf(dsct, size + 1);
    dsct[size] = new ChiTietHoaDon();
    dsct[size].nhap();
    }
    public void sua(String maSP) {
    boolean found = false;
    for (ChiTietHoaDon ct : dsct) {
        if (ct.getMaSP().equalsIgnoreCase(maSP)) {
            found = true;
            int choice;
            do {
                System.out.println("=== SUA CHI TIET HOA DON ===");
                System.out.println("1. Sua ma san pham");
                System.out.println("2. Sua so luong");
                System.out.println("3. Sua don gia");
                System.out.println("0. Thoat");
                System.out.print("Chon: ");
                choice = sc.nextInt();
                sc.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ma san pham moi: ");
                        String newMaSP = sc.nextLine();
                        ct.setMaSP(newMaSP);
                        System.out.println("Da sua ma san pham!");
                        break;
                    case 2:
                        System.out.print("Nhap so luong moi: ");
                        int newSL = Integer.parseInt(sc.nextLine());
                        ct.setSoLuong(newSL);
                        System.out.println("Da sua so luong!");
                        break;
                    case 3:
                        System.out.print("Nhap don gia moi: ");
                        double newDG = Double.parseDouble(sc.nextLine());
                        ct.setDonGia(newDG);
                        System.out.println("Da sua don gia!");
                        break;
                    case 0:
                        System.out.println("Thoat sua chi tiet...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } while (choice != 0);
            break;
        }
    }
    if (!found) {
        System.out.println("Khong tim thay san pham co ma: " + maSP);
    }
}
    public void xoa(String key) {
    int size = dsct.length;
    for (int i = 0; i < size; i++) {
        if (dsct[i].getMaHD().equalsIgnoreCase(key)) {
            for (int j = i; j < size - 1; j++) {
                dsct[j] = dsct[j + 1];
            }
            dsct = Arrays.copyOf(dsct, size - 1);
            System.out.println("Da xoa chi tiet hoa don co ma: " + key);
            return;
        }
    }
    System.out.println("Khong co chi tiet hoa don can xoa!");
}
    public ChiTietHoaDon timCTHDtheoMA(String maHD){
        for (ChiTietHoaDon chiTietHoaDon : dsct) {
            if(chiTietHoaDon.getMaHD().equalsIgnoreCase(maHD))
            return chiTietHoaDon;
        }
        return null;
    }
    public ChiTietHoaDon[] getDsct() {
        return dsct;
    }
}