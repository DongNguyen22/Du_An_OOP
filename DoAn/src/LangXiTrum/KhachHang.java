package LangXiTrum;

public class KhachHang extends ConNguoi{
    private String maKH;
    //constructor
    public KhachHang() {
    }
    public KhachHang(String maKH,String ten, String gtinh, String sdt, String diaChi) {
        super(ten, gtinh, sdt, diaChi);
        this.maKH = maKH;
    }
    //copy constructor
    public KhachHang(KhachHang x){
        super(x);
        this.maKH=x.maKH;
    }
    //nhap thong tin cho 1 khach hang
    @Override
    public void nhap(){
        super.nhap();
    }
    @Override
    public void xuat() {
        System.out.printf("| %-9s |", maKH);
        super.xuat();
    }
    @Override
    public String toString() {
    return String.format("| %-6s | %-19s| %-5s | %-10s | %-20s",
            maKH, ten, gtinh, sdt, diaChi);
}
    //getter
    public String getMaKH() {
        return this.maKH;
    }
    //setter
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
}
    
