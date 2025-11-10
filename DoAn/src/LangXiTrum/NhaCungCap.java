package LangXiTrum;

import java.util.Scanner;

public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String SDT;
    private String DiaChi;
    Scanner sc = new Scanner(System.in);
    public NhaCungCap(String maNCC, String tenNCC, String sDT, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.SDT = sDT;
        this.DiaChi = diaChi;
    }
    public NhaCungCap() {
    }
    public NhaCungCap(NhaCungCap x){
        this.maNCC = x.maNCC;
        this.tenNCC = x.tenNCC;
        this.SDT = x.SDT;
        this.DiaChi = x.DiaChi;
    }
    //getter
    public String getMaNCC() {
        return maNCC;
    }
    public String getTenNCC() {
        return tenNCC;
    }
    public String getSDT() {
        return SDT;
    }
    public String getDiaChi() {
        return DiaChi;
    }
    // setter
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
    public void setSDT(String sDT) {
        SDT = sDT;
    }
    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
    public void nhap(){
        System.out.println("Nhap Ma NCC");
        this.maNCC=sc.nextLine();
        System.out.println("Nhap Ten NCC");
        this.tenNCC=sc.nextLine();
        System.out.println("Nhap SDT NCC");
        this.SDT=sc.nextLine();
        System.out.println("Nhap Dia Chi NCC");
        this.DiaChi=sc.nextLine();
    }
    @Override
public String toString() {
    return String.format("MaNCC: %-8s | Ten: %-20s | SDT: %-12s | Dia Chi: %s",
                         maNCC, tenNCC, SDT, DiaChi);
}

}
