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

public class DanhSachPhieuNhap {
    private PhieuNhap[] dsPN;
    Scanner sc = new Scanner(System.in);
    public DanhSachPhieuNhap(){
        dsPN = new PhieuNhap[0];
    }
    public PhieuNhap timPN(String key){
        for (PhieuNhap phieuNhap : dsPN) {
            if( phieuNhap.getMaPN().equalsIgnoreCase(key)){
                return phieuNhap;
            }
        }
        return null;
    }
    public void nhap(int n){
        dsPN = Arrays.copyOf(dsPN, n);
        for(int i=0; i<n; i++){
            System.out.println("Nhap phieu nhap thu "+(i+1)+" ");
            System.out.print("Nhap ma phieu nhap: ");
            String maPN = sc.nextLine();
            PhieuNhap pn = new PhieuNhap();
            pn.nhap(maPN);
            dsPN[i]=pn;
        }
    }
    public void xuat() {
        System.out.println("========== DANH SACH PHIEU NHAP HANG ==========");
        if (dsPN.length == 0) {
            System.out.println("Chua co phieu nhap ");
            return;
        }
        for (PhieuNhap pn : dsPN) {
            pn.xuatPhieuNhap();
        }
    }
    public void them(PhieuNhap pn) {
        dsPN = Arrays.copyOf(dsPN, dsPN.length+1);
        dsPN[dsPN.length-1] = pn;
    }
    public void sua(String maPN) {
    for (PhieuNhap phieuNhap : dsPN) {
        if (phieuNhap.getMaPN().equalsIgnoreCase(maPN)) {
            int choice;
            do {
                System.out.println("\n===== MENU SUA PHIEU NHAP =====");
                System.out.println("1. Sua ma nhan vien");
                System.out.println("2. Sua ma nha cung cap");
                System.out.println("3. Sua ngay nhap");
                System.out.println("4. Sua tong so luong nhap");
                System.out.println("5. Sua chi tiet phieu nhap");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ma nhan vien moi: ");
                        phieuNhap.setMaNV(sc.nextLine());
                        System.out.println(" Da sua ma nhan vien thanh cong!");
                        break;

                    case 2:
                        System.out.print("Nhap ma nha cung cap moi: ");
                        phieuNhap.setMaNCC(sc.nextLine());
                        System.out.println(" Da sua ma nha cung cap thanh cong!");
                        break;

                    case 3:
                        System.out.print("Nhap ngay lap moi (dd-MM-yy): ");
                        phieuNhap.setNgayNhap(sc.nextLine());
                        System.out.println(" Da sua ngay lap thanh cong!");
                        break;

                    case 4:
                        System.out.print("Nhap tong so luong moi: ");
                        phieuNhap.setTongSoLuong(sc.nextInt());
                        sc.nextLine();
                        System.out.println(" Da sua tong so luong thanh cong!");
                        break;

                    case 5:
                        System.out.println("=== SUA CHI TIET PHIEU NHAP ===");
                        System.out.print("Nhap ma san pham can sua chi tiet: ");
                        phieuNhap.getDSCTPN().sua(sc.nextLine());
                        break;

                    case 0:
                        System.out.println(" Thoat sua phieu nhap...");
                        break;

                    default:
                        System.out.println(" Lua chon khong hop le, vui long nhap lai!");
                        break;
                }
            } while (choice != 0);
            return; 
        }
    }
    System.out.println(" Khong tim thay phieu nhap co ma: " + maPN);
}
    public void xoa(String maPN) {
        int n=dsPN.length;
        for (int i = 0; i < n; i++) {
            if(dsPN[i].getMaPN().equalsIgnoreCase(maPN)){
                for(int j=i;j<n-1;j++){
                    dsPN[j]=dsPN[j+1];
                }
        --n;
        dsPN=Arrays.copyOf(dsPN, n);
                break;
            }
        }
        System.out.println("-> Da xoa Phieu Nhap thanh cong");
    }
    public void docFile() {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("PhieuNhap.txt"), "UTF-8"))) {
             String line;
            int size = 0;
            dsPN = new PhieuNhap[0];
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String maPN = parts[0].trim();
                    String maNV = parts[1].trim();
                    String maNCC = parts[2].trim();
                    String ngayLap = parts[3].trim();
                    int tongSoLuong = Integer.parseInt(parts[4].trim());
                    PhieuNhap pn = new PhieuNhap(maPN, maNV, maNCC, ngayLap, tongSoLuong);
                    DanhSachChiTietPhieuNhap dsCTPN = new DanhSachChiTietPhieuNhap();
                    dsCTPN.docFile(maPN);
                    pn.setDSCTPN(dsCTPN);
                    dsPN = Arrays.copyOf(dsPN, size + 1);
                    dsPN[size++] =pn;
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file  phieu nhap: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("khong tim thay file phieu nhap");
        }
    }
    public void ghiFile() {
        try (BufferedWriter bwPN = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("PhieuNhap.txt", false), "UTF-8"));
         BufferedWriter bwCT = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("ChiTietPhieuNhap.txt", false), "UTF-8"))) {
        for (PhieuNhap pn : dsPN) {
            String linePN = pn.getMaPN() + ";" +
                            pn.getMaNV() + ";" +
                            pn.getMaNCC() + ";" +
                            pn.getNgayNhap() +";"+
                            pn.getTongSoLuong();
            bwPN.write(linePN);
            bwPN.newLine();
            ChiTietPhieuNhap[] dsct = pn.getDSCTPN().getChiTietPhieuNhaps();
            if (dsct != null) {
                for (ChiTietPhieuNhap ct : dsct) {
                    if (ct != null) {
                        String lineCT = pn.getMaPN() + ";" +
                                        ct.getMaSP() + ";" +
                                        ct.getSoLuong() + ";" +
                                        ct.getDonGia();
                        bwCT.write(lineCT);
                        bwCT.newLine();
                    }
                }
            }
        }
        System.out.println(" Ghi file PhieuNhap.txt và ChiTietPhieuNhap.txt thanh cong!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    public PhieuNhap[] getDsPN() {
        return dsPN;
    }
}
