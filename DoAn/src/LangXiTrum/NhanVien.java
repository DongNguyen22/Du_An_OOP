package LangXiTrum;

public class NhanVien extends ConNguoi {
    //thuoc tinh
    private String maNV;
    private String chucVu;
    private String ngaySinh;
    private static final double luongCB=3000;
    //constructor
    public NhanVien(String maNV,String ten ,String ngaySinh, String gtinh, String sdt, String diachi,String chucVu) {
        super(ten, gtinh, sdt, diachi);
        this.maNV=maNV;
        this.chucVu=chucVu;
        this.ngaySinh = ngaySinh;
    }
    public NhanVien(){

    }
    //copy constructor 
    public NhanVien(NhanVien x){
        super(x);
        this.maNV=x.maNV;
        this.chucVu=x.chucVu;
        this.ngaySinh=x.ngaySinh;
    }
    //tinh luong
    public double tinhLuong() {
    double heSo;
    switch (chucVu.toUpperCase()) {
        case "QL": heSo = 1.05; break;
        case "NV": heSo = 1.03; break;
        default: heSo = 1.0;
    }
    return luongCB * heSo;
}
    @Override
    public void nhap(){
        super.nhap();
        System.out.print("nhap chuc vu: ");
        this.chucVu=sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        this.ngaySinh = sc.nextLine();
    }
    @Override
    public void xuat() {
    System.out.printf("| %-8s | %-12s | %-12s | %10.2f | ",
        maNV, ngaySinh, chucVu, tinhLuong());
        super.xuat();
}

    @Override
    public String toString() {
    return String.format("| %-6s | %-20s | %-20s | %-5s | %-10s | %-10s | %-20s | %10.2f      |",
            maNV, ten,ngaySinh, gtinh, sdt, chucVu, diaChi, tinhLuong());
}

   //getter
   public String getMaNV() {
    return this.maNV;
   }
   public String getChucVu() {
    return this.chucVu;
   }
   public String getNgaySinh(){
    return this.ngaySinh;
   }
   //setter
   public void setMaNV(String maNV) {
    this.maNV = maNV;
   }
   public void setChucVu(String chucVu) {
    this.chucVu = chucVu;
   }
   public void setNgaySinh(String ngaySinh){
    this.ngaySinh = ngaySinh;
   }
}
