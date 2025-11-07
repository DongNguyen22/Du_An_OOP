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

public class DanhSachChiTietPhieuNhap  {
    ChiTietPhieuNhap[] dsCTPN;
    Scanner sc = new Scanner(System.in);
    public DanhSachChiTietPhieuNhap(){
        dsCTPN = new ChiTietPhieuNhap[0];
    }
    public void xuat(){
        for (ChiTietPhieuNhap chiTietPhieuNhap : dsCTPN) {
            chiTietPhieuNhap.xuatCTPN();
        }
    }
    public void nhap(int n) {
    dsCTPN = new ChiTietPhieuNhap[n];
    for (int i = 0; i < n; i++) {
        System.out.println("Nhap chi tiet phieu nhap thu " + (i + 1) + ":");
        dsCTPN[i] = new ChiTietPhieuNhap();
    }
}
    public void them(){
        if(dsCTPN == null){
            dsCTPN = new ChiTietPhieuNhap[0];
        }
        else{
            dsCTPN = Arrays.copyOf(dsCTPN, dsCTPN.length+1);
            dsCTPN[dsCTPN.length-1] = new ChiTietPhieuNhap();
            dsCTPN[dsCTPN.length-1].nhapSoLuong();
        }
    }
    public void sua(String maPN){
        ChiTietPhieuNhap ctpn = timCTPN(maPN);
        if(ctpn != null){
            System.out.println("1.Sua ma phieu nhap");
            System.out.println("2.Sua ma san pham ");
            System.out.println("3.Sua so luong ");
            System.out.println("4.Sua don gia ");
            System.out.println("5.Nhap lai toan bo chi tiet ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhap ma phieu nhap moi:");
                    ctpn.setMaPN(sc.nextLine());
                    System.out.println("Cap nhat thanh cong");
                    break;
                case 2:
                    System.out.print("Nhap ma san pham moi:");
                    ctpn.setMaSP(sc.nextLine());
                    System.out.println("Cap nhat thanh cong");
                    break;
                case 3:
                    System.out.print("Nhap  so luong moi:");
                    ctpn.setSoLuong(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Cap nhat thanh cong");
                    break;
                case 4:
                    System.out.print("Nhap don gia moi:");
                    ctpn.setDonGia(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Cap nhat thanh cong");
                    break;
                case 5:
                    ctpn.nhapCTPN();
                default:
                    break;
            }
        }
    }
    public void xoa(String maPN){
        int size = dsCTPN.length;
        for(int i=0;i<size;i++){
            if(dsCTPN[i].getMaPN().equalsIgnoreCase(maPN)){
                for(int j=i;j<size-1;j++){
                    dsCTPN[j] = dsCTPN[j+1];
                }
            }
            dsCTPN = Arrays.copyOf(dsCTPN, size-1);
            System.out.println("Da xoa thanh cong");
            break;
        }
    }
    public ChiTietPhieuNhap timCTPN(String maSP){
        for (ChiTietPhieuNhap chiTietPhieuNhap : dsCTPN) {
            if(chiTietPhieuNhap.getMaSP().equalsIgnoreCase(maSP)){
                return chiTietPhieuNhap;
            }
        }
        return null;
    }
    public void docFile(String mapn) {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("ChiTietPhieuNhap.txt"), "UTF-8"))) {
            dsCTPN = new ChiTietPhieuNhap[0];
             String line;
            int size = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String maPN = parts[0];
                    if(maPN.equalsIgnoreCase(mapn)){
                    String maSP = parts[1];
                    int soLuong = Integer.parseInt(parts[2]);
                    double donGia = Double.parseDouble(parts[3]);
                    dsCTPN = Arrays.copyOf(dsCTPN, size+1);
                    dsCTPN[size++] = new ChiTietPhieuNhap(maPN, maSP, soLuong, donGia);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("loi doc file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("khong tim thay thu muc chi tiet phieu nhap ");
        }
    }
    public void ghiFile() {
        try (BufferedWriter bwCT = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ChiTietPhieuNhap.txt", false), "UTF-8"))) {
            for (ChiTietPhieuNhap chiTietPhieuNhap : dsCTPN) {
                String line = chiTietPhieuNhap.getMaPN() + ";" +
                          chiTietPhieuNhap.getMaSP() + ";" +
                          chiTietPhieuNhap.getSoLuong() + ";" +
                          chiTietPhieuNhap.getDonGia() ;
            bwCT.write(line);
            bwCT.newLine();
        }
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    public ChiTietPhieuNhap[] getChiTietPhieuNhaps(){
        return this.dsCTPN;
    }
}
