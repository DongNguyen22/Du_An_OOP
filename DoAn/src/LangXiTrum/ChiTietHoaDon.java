package LangXiTrum;

import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHD;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;
    Scanner sc = new Scanner(System.in);
    //constructor
    public ChiTietHoaDon(String maHD, String maSP,String tenSP, int soLuong, double donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP=tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public ChiTietHoaDon(ChiTietHoaDon x){
        this.maHD = x.maHD;
        this.maSP = x.maSP;
        this.tenSP=x.tenSP;
        this.soLuong=x.soLuong;
        this.donGia=x.donGia;
    }
    //getter
    public ChiTietHoaDon() {
    }
    public String getMaHD() {
        return maHD;
    }
    public String getMaSP() {
        return maSP;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public String getTenSP(){
        return tenSP;
    }
    public double getDonGia() {
        return donGia;
    }
    public double getThanhTien(){
        return this.soLuong*this.donGia;
    }
    //setter
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public void nhap(){
        System.out.print("Nhap ma san pham: ");
        this.maSP = sc.nextLine();
        System.out.print("Nhap  so luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
    }
    public void nhapN(){
        System.out.print("Nhap ma hoa don: ");
        this.maHD = sc.nextLine();
        System.out.println("Nhap ma san pham: ");
        this.maSP = sc.nextLine();
        System.out.print("Nhap Ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("Nhap  so luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap don gia: ");
        this.donGia=sc.nextDouble();
        sc.nextLine();
    }
    public void hienThi() {
    System.out.println("+------------+------------+------------------------------+------------+-----------------+-----------------+");
    System.out.printf("| %-10s | %-10s | %-28s | %10d | %15.2f | %15.2f |\n",
            maHD, maSP, tenSP, soLuong, donGia, getThanhTien());
}
    @Override
public String toString() {
    return maHD + "," + maSP + "," + tenSP + "," + soLuong + "," + donGia;
}

}