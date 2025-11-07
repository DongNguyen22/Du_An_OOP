package LangXiTrum;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKH;
    private String ngayLap;
    private DanhSachChiTietHoaDon dsCT;
    Scanner sc = new Scanner(System.in);
    // constructor
    public HoaDon() {
        dsCT = new DanhSachChiTietHoaDon();
    }
    public HoaDon(String maHD, String maNV, String maKH, String ngayLap) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.dsCT = new DanhSachChiTietHoaDon();
    }
    //nhap
    public void nhap(String maHD){
        this.maHD = maHD;
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        this.maKH = sc.nextLine();
        System.out.print("Nhap ngay lap hoa don: ");
        this.ngayLap = sc.nextLine();
        themCTHD();
    }
    public void themCTHD(){
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int k=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<k;i++){
            System.out.println("Nhap chi tiet hoa don thu: "+(i+1)+": ");
            this.dsCT.them();
        }
    }
    // hien thi
    public void hienThi() {
        System.out.println("========== Thong tin hoa don ==========");
        System.out.println("Ma hoa don: " + maHD);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ngay lap hoa don: " + ngayLap);
        xuatTieuDeCTHD();
        dsCT.xuat();
        xuatKetBangCTHD();
        System.out.println("Tong cong: "+ getTongTien() +" VND");
    }
    public static void xuatTieuDeCTHD() {
    System.out.println("+------------+------------+------------------------------+------------+-----------------+-----------------+");
    System.out.println("| Ma HD      | Ma SP      | Ten San Pham                 | So Luong   | Don Gia         | Thanh Tien      |");
    System.out.println("+------------+------------+------------------------------+------------+-----------------+-----------------+");
}
    public static void xuatKetBangCTHD() {
    System.out.println("+------------+------------+------------------------------+------------+-----------------+-----------------+");
    }

    // getter
    public String getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getNgayLap() {
        return ngayLap;
    }
    public DanhSachChiTietHoaDon getDSCTHD() {
    if (dsCT == null) dsCT = new DanhSachChiTietHoaDon();
    return dsCT;
}
    public double getTongTien() {
        double tongTien = 0;
        for (ChiTietHoaDon cthd : dsCT.getDsct()) {
            tongTien += cthd.getThanhTien();
        }
        return tongTien;
    }

    // setter
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    public void setDsCT(DanhSachChiTietHoaDon dsCT) {
        this.dsCT = dsCT;
    }
}