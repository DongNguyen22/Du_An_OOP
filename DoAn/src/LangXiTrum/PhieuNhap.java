package LangXiTrum;

import java.util.Arrays;
import java.util.Scanner;

public class PhieuNhap {
    private String maPN;
    private String maNV;
    private String maNCC;
    private String ngayNhap;
    private int tongSoLuong;
    private DanhSachChiTietPhieuNhap dsCTPN;
    private DanhSachNhaCungCap dsNCC = new DanhSachNhaCungCap();
    Scanner sc = new Scanner(System.in);
    public PhieuNhap(String maPN, String maNV, String maNCC, String ngayNhap, int tongSoLuong) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongSoLuong = tongSoLuong;
        dsCTPN = new DanhSachChiTietPhieuNhap();
        dsNCC.docFile();
    }
    public PhieuNhap() {
        dsCTPN = new DanhSachChiTietPhieuNhap();
        dsNCC.docFile();
    }
    //getter
    public String getMaPN() {
        return maPN;
    }
    public String getMaNV() {
        return maNV;
    }
    public String getMaNCC() {
        return maNCC;
    }
    public String getNgayNhap() {
        return ngayNhap;
    }
    public int getTongSoLuong() {
        return tongSoLuong;
    }
    public DanhSachChiTietPhieuNhap getDSCTPN(){
        return this.dsCTPN;
    }
    public DanhSachNhaCungCap getDSNCC(){
        return this.dsNCC;
    }
    //setter
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }
    public void setDSCTPN(DanhSachChiTietPhieuNhap dsctpn){
        this.dsCTPN = dsctpn;
    }
    public void setDSNCC(DanhSachNhaCungCap dsncc){
        this.dsNCC = dsncc;
    }
    public void nhap(String maPN){
        this.maPN = maPN;
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhap ma NCC: ");
        this.maNCC = sc.nextLine();
        System.out.print("Nhap ngay lap phieu lap: ");
        this.ngayNhap = sc.nextLine();
        System.out.print("Nhap so luong chi tiet phieu nhap: ");
        int n = sc.nextInt();
        sc.nextLine();
        this.dsCTPN.nhap(n);
        this.tongSoLuong = getTongSoLuong();
    }
    public double getTongTien() {
    double sum = 0;
    for (ChiTietPhieuNhap ctpn : dsCTPN.getChiTietPhieuNhaps()) {
        sum += ctpn.getThanhTien();
    }
    return sum;
    }
   public void xuatPhieuNhap() {
    System.out.printf(
    "\n========= THONG TIN PHIEU NHAP =========\n" +
    "MaPN: %-10s | MaNV: %-8s | MaNCC: %-8s | NgayNhap: %-12s | TongSL: %d\n",
    maPN, maNV, maNCC, ngayNhap, tinhTongSoLuong());
    System.out.println("\n------ DANH SACH CHI TIET PHIEU NHAP ------");
    xuatTieuDeCTPN();
    dsCTPN.xuat();
    xuatKetBangCTPN();
    System.out.println("------   Thong tin nha cung cap   ------");
    System.out.println(dsNCC.timNCC(maNCC));
    System.out.printf("\nTong tien nhap: %.2f VND\n", getTongTien());
}
    public static void xuatTieuDeCTPN() {
    System.out.println("+------------+------------+------------+-----------------+-----------------+");
    System.out.println("| Ma PN      | Ma SP      | So Luong   | Don Gia(VND)    | Thanh Tien(VND) |");
    System.out.println("+------------+------------+------------+-----------------+-----------------+");
}
    public static void xuatKetBangCTPN() {
    System.out.println("+------------+------------+------------+-----------------+-----------------+");
}

    public int tinhTongSoLuong() {
    int sum = 0;
    for (ChiTietPhieuNhap ctpn : dsCTPN.getChiTietPhieuNhaps()) {
        sum += ctpn.getSoLuong();
    }
    return sum;
}
}
