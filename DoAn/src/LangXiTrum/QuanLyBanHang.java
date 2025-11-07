package LangXiTrum;

import java.net.Socket;
import java.util.Scanner;

public class QuanLyBanHang {
    Scanner sc= new Scanner(System.in);
    private  DanhSachConNguoi dsConNguoi = new DanhSachConNguoi();
    private  DanhSachSanPham dSachSanPham = new DanhSachSanPham();
    private  DanhSachHoaDon dSachHoaDon = new DanhSachHoaDon();
    private  DanhSachPhieuNhap dSachPhieuNhap = new DanhSachPhieuNhap();
    public QuanLyBanHang(){
        dsConNguoi.docFile();
        dSachSanPham.docFile();
        dSachHoaDon.docFile();
        dSachPhieuNhap.docFile();
    }
    public void menuChinh() {
        int choice;
        do {
            System.out.println("╔═══════════════════════════════════╗");
            System.out.println("║         MENU QUAN LY CHINH        ║");
            System.out.println("╠═══════════════════════════════════╣");
            System.out.println("║ 1. Quan ly san pham               ║");
            System.out.println("║ 2. Quan ly hoa don & chi tiet hd  ║");
            System.out.println("║ 3. Quan ly phieu nhap & chi tiet  ║");
            System.out.println("║ 4. Quan ly khach hang             ║");
            System.out.println("║ 5. Quan ly nhan vien              ║");
            System.out.println("║ 0. Ket thuc chuong trinh          ║");
            System.out.println("╚═══════════════════════════════════╝");
            System.out.print("-> Moi ban chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    menuSanPham();
                    break;
                case 2:
                    menuHoaDon();
                    break;
                case 3:
                    menuPhieuNhap();
                    break;
                case 4:
                    menuKhachHang();
                    break;
                case 5:
                    menuNhanVien();
                    break;
                case 6:
                    thongKeTheoQuy(2025);
                case 0:
                    dsConNguoi.ghiFile();
                    dSachSanPham.ghiFile();
                    dSachHoaDon.ghiFile();
                    dSachPhieuNhap.ghiFile();
                    System.out.println("-> Thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le, vui long thu lai!");
            }

        } while (choice != 0);
    }
    // ===================== MENU CON NHAN VIÊN =====================
    public void menuNhanVien() {
        int chon;
        do {
            System.out.println("========== MENU QUAN LY NHAN VIEN ==========");
            System.out.println("1. Xem danh sach nhan vien");
            System.out.println("2. Them nhan vien moi");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Tim nhan vien theo ten");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1 -> dsConNguoi.xuatNhanVien();
                case 2 -> dsConNguoi.themNV();
                case 3 -> suaNVIEN();
                case 4 -> xoaNVIEN();
                case 5 -> timNVIEN(); 
                case 0 -> System.out.println("Quay lai menu chinh...");
                default -> System.out.println("Lua chon khong hop le!");
                

            }
            System.out.println();
        } while (chon != 0);
    }
    private void suaNVIEN(){
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String maSua = sc.nextLine();
                    dsConNguoi.suaNV(maSua);
                }
    private void xoaNVIEN(){
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maXoa = sc.nextLine();
                    dsConNguoi.xoaNV(maXoa);
                }
    private void timNVIEN(){
                    System.out.print("Nhap ten nhan vien can tim: ");
                    String tenNV = sc.nextLine();
                    NhanVien[] dsNV=dsConNguoi.timNvTheoTen(tenNV);
                    System.out.println("Danh sach Nhan Vien tim thay:");
                    for(NhanVien nv : dsNV) System.out.println(nv);
                }
    
    // ===================== MENU CON KHÁCH HÀNG =====================
    public  void menuKhachHang() {
        int chon;
        do {
            System.out.println("========== MENU QUAN LY KHACH HANG ==========");
            System.out.println("1. Xem danh sach khach hang");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Sua thong tin khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Tim khach hang theo ten");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsConNguoi.xuatKhachHang();
                case 2 -> dsConNguoi.themKH();
                case 3 -> suaKH();
                case 4 -> xoaKH();
                case 5 -> timKH();
                case 0 -> System.out.println("Quay lai menu chinh...");
                default -> System.out.println("Lua chon khong hop le!");
            }
            System.out.println();
        } while (chon != 0);
    }
    private void suaKH(){
                    System.out.print("Nhap ma khach hang can sua: ");
                    String maSua = sc.nextLine();
                    dsConNguoi.suaKH(maSua);
                }
    private void xoaKH(){
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String maXoa = sc.nextLine();
                    dsConNguoi.xoaKH(maXoa);
                }  
    private void timKH(){
                    System.out.print("Nhap ten khach hang can tim: ");
                    String tenKH = sc.nextLine();
                    KhachHang[] dskh=dsConNguoi.timKhTen(tenKH);
                    System.out.println("Danh sach khach hang tim thay:");
                    for(KhachHang kh : dskh) System.out.println(kh);
                }              
    // ===================== MENU CON Sản Phẩm =====================
    public void menuSanPham() {
        int chon;
        do {
            System.out.println("\n========== QUAN LY SAN PHAM ==========");
            System.out.println("1. Doc du lieu tu file");
            System.out.println("2. Ghi du lieu ra file");
            System.out.println("3. Hien thi danh sach san pham");
            System.out.println("4. Them san pham");
            System.out.println("5. Sua thong tin san pham");
            System.out.println("6. Xoa san pham");
            System.out.println("7. Tim san pham theo ma");
            System.out.println("0. Thoat");
            System.out.print(">> Nhap lua chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1 -> dSachSanPham.docFile();
                case 2 -> dSachSanPham.ghiFile();
                case 3 -> dSachSanPham.xuat();
                case 4 -> dSachSanPham.them();
                case 5 -> menuSuaSanPham();
                case 6 -> menuXoaSanPham();
                case 7 -> menuTimSanPham();
                case 0 -> System.out.println("Quay lai menu chinh!");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
    private void menuSuaSanPham() {
        System.out.print("Nhap ma san pham can sua: ");
        String maSP = sc.nextLine();
        dSachSanPham.sua(maSP);
    }
    private void menuXoaSanPham() {
        System.out.print("Nhap ma san pham can xoa: ");
        String maSP = sc.nextLine();
        dSachSanPham.xoa(maSP);
    }
    private void menuTimSanPham() {
        System.out.print("Nhap ma san pham can tim: ");
        String maSP = sc.nextLine();
        SanPham sp = dSachSanPham.timSPtheoMaSp(maSP);
        if (sp != null) System.out.println("==> Tim thay san pham: " + sp);
        else System.out.println("Khong tim thay san pham co ma: " + maSP);
    }
    // ===================== MENU CON Hóa Đơn =====================
    public void menuHoaDon() {
    int chon;
    do {
        System.out.println("========== MENU QUAN LY HOA DON ==========");
        System.out.println("1. Xem danh sach hoa don");
        System.out.println("2. Them hoa don moi");
        System.out.println("3. Sua thong tin hoa don");
        System.out.println("4. Xoa hoa don");
        System.out.println("5. Tim hoa don theo ma hoa don");
        System.out.println("6. Tim hoa don theo ma nhan vien");
        System.out.println("7. Doc du lieu tu file");
        System.out.println("8. Ghi du lieu ra file");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon=sc.nextInt();
        sc.nextLine();

        switch (chon) {
            case 1:
                dSachHoaDon.xuat();
                break;
            case 2:
        System.out.println("=== THEM HOA DON MOI ===");
        System.out.print("Nhap ma hoa don: ");
        String maHD = sc.nextLine().trim();
        if (dSachHoaDon.timHD(maHD) != null) {
        System.out.println(" Da ton tai hoa don co ma: " + maHD);
        break;
        }
        HoaDon hd = new HoaDon();
        hd.nhap(maHD); 
        boolean flag = true;
        for (ChiTietHoaDon ct : hd.getDSCTHD().getDsct()) {
        SanPham sp = dSachSanPham.timSPtheoMaSp(ct.getMaSP());
        if (sp != null) {
            if (ct.getSoLuong() > sp.getSoLuong()) {
                System.out.println(" San pham " + sp.getMaSP() + 
                    " khong du hang! So luong ton: " + sp.getSoLuong());
                flag = false;
                break;
            }
        } else {
            System.out.println(" Khong tim thay san pham co ma: " + ct.getMaSP());
            flag = false;
            break;
        }
    }
        if (flag) {
        for (ChiTietHoaDon ct : hd.getDSCTHD().getDsct()) {
            SanPham sp = dSachSanPham.timSPtheoMaSp(ct.getMaSP());
            sp.setSoLuong(sp.getSoLuong() - ct.getSoLuong());
        ct.setMaHD(maHD);
        ct.setDonGia(sp.getDonGia());
        ct.setTenSP(sp.getTenSP());
        }
        dSachHoaDon.them(hd);
        System.out.println(" Da them hoa don thanh cong!");
        } else {
        System.out.println(" Khong the them hoa don do du lieu khong hop le!");
    }
        break;
            case 3:
                System.out.print("Nhap ma hoa don can sua: ");
                String maSua = sc.nextLine();
                dSachHoaDon.sua(maSua);
                break;
            case 4:
                System.out.print("Nhap ma hoa don can xoa: ");
                String maXoa = sc.nextLine();
                dSachHoaDon.xoa(maXoa);
                break;
            case 5:
                System.out.print("Nhap ma hoa don can tim: ");
                String maTim = sc.nextLine();
                HoaDon kq = dSachHoaDon.timHD(maTim);
                if (kq != null) {
                System.out.println("Thong tin hoa don tim thay:");
                kq.hienThi();
                } else {
                System.out.println("Khong tim thay hoa don co ma " + maTim);
                }
                break;
                case 6:
                System.out.print("Nhap ma nhan vien can tim: ");
                String maNV = sc.nextLine();
                 HoaDon[] kqua = dSachHoaDon.timHDtheoNV(maNV);
                if (kqua != null) {
                for (HoaDon hoaDon : kqua) {
                hoaDon.hienThi();
                }
                } else {
                System.out.println("Khong tim thay hoa don co ma " + maNV);
                }
                break;            
            case 7:
                dSachHoaDon.docFile();
                break;
            case 8:
                dSachHoaDon.ghiFile();
                break;
            case 0:
                System.out.println("Quay lai menu chinh");
                break;
            default:
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
        }
        System.out.println();
    } while (chon != 0);
}   // ===================== MENU CON Phieu =====================
    public void menuPhieuNhap() {
    int chon;
    do {
        System.out.println("\n===== MENU PHIEU NHAP =====");
        System.out.println("1. Doc du lieu tu file");
        System.out.println("2. Ghi du lieu ra file");
        System.out.println("3. Xuat danh sach phieu nhap");
        System.out.println("4. Them mot phieu nhap moi");
        System.out.println("5. Sua thong tin phieu nhap");
        System.out.println("6. Xoa phieu nhap");
        System.out.println("7. Tim phieu nhap theo ma");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon = sc.nextInt();
        sc.nextLine();

        switch (chon) {
            case 1:
                dSachPhieuNhap.docFile();
                break;
            case 2:
                dSachPhieuNhap.ghiFile();
                break;
            case 3:
                dSachPhieuNhap.xuat();
                break;
            case 4:
                System.out.print("Nhap ma phieu nhap moi: ");
                String maPN = sc.nextLine();
                if(dSachPhieuNhap.timPN(maPN) != null){
                    System.out.println("Da ton tai phieu nhap nay:");
                    break;
                }
                PhieuNhap pn = new PhieuNhap();
                pn.nhap(maPN);
                ChiTietPhieuNhap[] ctpn = pn.getDSCTPN().getChiTietPhieuNhaps();
                for (ChiTietPhieuNhap chiTietPhieuNhap : ctpn) {
                    System.out.print("Nhap ma san pham: ");
                    String maSP = sc.nextLine();
                    SanPham sp = dSachSanPham.timSPtheoMaSp(maSP);
                    if( sp != null ){
                        System.out.print("Nhap so luong: ");
                        chiTietPhieuNhap.setSoLuong(sc.nextInt());
                        sc.nextLine();
                        sp.setSoLuong(chiTietPhieuNhap.getSoLuong()+sp.getSoLuong());
                        chiTietPhieuNhap.setDonGia(sp.getDonGia());
                        chiTietPhieuNhap.setMaSP(maSP);
                        chiTietPhieuNhap.setMaPN(maPN);
                    }
                }
                dSachPhieuNhap.them(pn);
                System.out.println("-> Da them phieu nhap moi!");
                break;
            case 5:
                System.out.print("Nhap ma phieu nhap can sua: ");
                dSachPhieuNhap.sua(sc.nextLine());
                break;
            case 6:
                System.out.print("Nhap ma phieu nhap can xoa: ");
                dSachPhieuNhap.xoa(sc.nextLine());
                break;
            case 7:
                System.out.print("Nhap ma phieu nhap can tim: ");
                PhieuNhap tim = dSachPhieuNhap.timPN(sc.nextLine());
                if (tim != null) {
                    System.out.println("Tim thay phieu nhap:");
                    tim.xuatPhieuNhap();
                } else {
                    System.out.println("Khong tim thay phieu nhap!");
                }
                break;
            case 0:
                System.out.println("Thoat menu phieu nhap...");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    } while (chon != 0);
}
    public void thongKeTheoQuy(int nam) {
    double[] tongThu = new double[4];
    double[] tongChi = new double[4];
    // tinh tong thu
    for(HoaDon hd : dSachHoaDon.getDsHD()){
        if(hd == null ) continue;
        String[] parts = hd.getNgayLap().split("-");
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if(year == nam){
            int quy =(month -1)/3;
            tongThu[quy]+=hd.getTongTien();
        }
    }
    // tinh tong chi
    for(PhieuNhap pn : dSachPhieuNhap.getDsPN()){
        if(pn == null) continue;
        String[] parts = pn.getNgayNhap().split("-");
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if(year == nam){
            int quy =(month -1)/3;
            tongChi[quy]+=pn.getTongTien();
        }
    }
    // ===== HIỂN THỊ KẾT QUẢ =====
    System.out.println("══════════════════════════════════════════════════════════════════");
    System.out.printf("   THONG KE TAI CHINH THEO QUY NAM %d\n", nam);
    System.out.println("══════════════════════════════════════════════════════════════════");
    System.out.printf("%-8s | %-15s | %-15s | %-15s\n", "Quy", "Tong Thu (VND)", "Tong Chi (VND)", "Loi Nhuan (VND)");
    System.out.println("------------------------------------------------------------------");
    double tongThuNam = 0, tongChiNam = 0;
    for (int i = 0; i < 4; i++) {
        double loiNhuan = tongThu[i] - tongChi[i];
        tongThuNam += tongThu[i];
        tongChiNam += tongChi[i];
        System.out.printf("%-8d | %-15.2f | %-15.2f | %-15.2f\n",
                (i + 1), tongThu[i], tongChi[i], loiNhuan);
    }
    System.out.println("------------------------------------------------------------------");
    System.out.printf("%-8s | %-15.2f | %-15.2f | %-15.2f\n",
            "TONG", tongThuNam, tongChiNam, tongThuNam - tongChiNam);
    System.out.println("══════════════════════════════════════════════════════════════════");
}
}
