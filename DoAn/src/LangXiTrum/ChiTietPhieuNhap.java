package LangXiTrum;

import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maPN;
    private String maSP;
    private int soLuong;
    private Double donGia;
    Scanner sc = new Scanner(System.in);
    public ChiTietPhieuNhap(String maPN, String maSP, int soLuong, Double donGia) {
        this.maPN = maPN;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    //getter
    public ChiTietPhieuNhap() {
    }
    public String getMaPN() {
        return maPN;
    }
    public String getMaSP() {
        return maSP;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public Double getDonGia() {
        return donGia;
    }
    public Double getThanhTien(){
        return donGia*soLuong;
    }
    //setter
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    public void nhapCTPN(){
        System.out.print("Nhap ma Phieu Nhap: ");
        this.maPN = sc.nextLine();
        System.out.print("Nhap ma San Pham: ");
        this.maSP = sc.nextLine();
        System.out.println("Nhap so luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap don gia: ");
        this.donGia = sc.nextDouble();
        sc.nextLine();
    }
    public void xuatCTPN() {
        System.out.println("+------------+------------+------------+-----------------+-----------------+");
        System.out.printf("| %-10s | %-10s | %10d | %15.2f | %15.2f |\n",
                maPN, maSP, soLuong, donGia, getThanhTien());
    }
}
