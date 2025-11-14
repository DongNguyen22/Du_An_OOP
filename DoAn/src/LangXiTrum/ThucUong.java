package LangXiTrum;

public class ThucUong extends SanPham{
    private String gas;
    private String dungTich;
    public ThucUong(String maSP, String tenSP, double donGia, String dvt, String maLoai, String gas, String dungTich) {
        super(maSP, tenSP, donGia, dvt, maLoai);
        this.gas = gas;
        this.dungTich = dungTich;
    }
    //constructor de doc du lieu tu file
    public ThucUong( String maLoai, String maSP, String tenSP,int soLuong, double donGia, String dvt, String gas, String dungtich) {
        super(maSP, tenSP, donGia, dvt, maLoai,soLuong);
        this.gas = gas;
        this.dungTich = dungtich;
    }
    public ThucUong() {
    }
    public ThucUong(ThucUong x){
        super(x);
        this.gas =x.gas;
        this.dungTich=x.dungTich;
    }
    //getter
    public String getGas() {
        return this.gas;
    }
    public String getDungTich() {
        return this.dungTich;
    }
    //setter
    public void setGas(String gas) {
        this.gas = gas;
    }
    public void setDungTich(String dungTich) {
        this.dungTich = dungTich;
    }
    
    @Override
    public void nhap(){
        super.nhap();
        System.out.print("ban muon dung co GAS hay Khong Gas hoac nguyen chat: ");
        this.gas=sc.nextLine();
        System.out.print("Ban muon dung tich bao nhieu: ");
        this.dungTich=sc.nextLine();
    }
    public void xuat(){
        super.xuat();
            System.out.printf(" %-10s | %-10s |\n", dungTich, gas);
    }
    @Override
    public String toString() {
        return String.format("| %-8s | %-25s | %10.0f | %-8s | %8d | %-8s | %-10s | %-10s |",
            maSP, tenSP, donGia, dvt, soLuong, maLoai, dungTich, gas);
}
}
