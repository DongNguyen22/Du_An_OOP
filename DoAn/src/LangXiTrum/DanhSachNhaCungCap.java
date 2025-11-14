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

public class DanhSachNhaCungCap implements XuLiDuLieu {
    private NhaCungCap[] dsNCC;
    int n;
    Scanner sc = new Scanner(System.in);
    public DanhSachNhaCungCap() {
        dsNCC = new NhaCungCap[0];
        n=0;
    }
    @Override
    public void nhap(int sl) {
    System.out.println("Nhap danh sach " + sl + " nha cung cap:");
    dsNCC = Arrays.copyOf(dsNCC, n + sl);
      for (int i = 0; i < sl; i++) {
        dsNCC[n] = new NhaCungCap();
        dsNCC[n++].nhap();
    }
    System.out.println("Da nhap xong " + sl + " nha cung cap.");
}
    @Override
    public void xuat() {
        System.out.println("Danh sach nha cung cap:");
        for (NhaCungCap nhaCungCap : dsNCC) {
            System.out.println(nhaCungCap);
        }
    }
    @Override
    public void them() {
        dsNCC = Arrays.copyOf(dsNCC, n+1);
        dsNCC[n]= new NhaCungCap();
        dsNCC[n++].nhap();
        System.out.println("Them nha cung cap thanh cong");
    }
    @Override
    public void sua(String key) {
        NhaCungCap ncc= timNCC(key);
        if(ncc!=null){
            System.out.println("Thong tin can sua");
            System.out.println("1.Ten NCC");
            System.out.println("2.SDT NCC");
            System.out.println("3.Dia Chi");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhap TEN NCC");
                    ncc.setTenNCC(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhap SDT NCC");
                    ncc.setSDT(sc.nextLine());
                case 3:
                    System.out.println("Nhap Dia Chi NCC");
                    ncc.setDiaChi(sc.nextLine());
                default:
                    break;
            }
        }
    }
    @Override
    public void xoa(String key) {
        for (int i = 0; i < n; i++) {
        if (dsNCC[i].getMaNCC().equalsIgnoreCase(key)) {
            for (int j = i; j < n - 1; j++) {
                dsNCC[j] = dsNCC[j + 1];
            }
            dsNCC = Arrays.copyOf(dsNCC, --n);
            System.out.println("Da xoa NCC  co ma: " + key);
            return;
        }
    }
    System.out.println("Khong tim thay ma NCC : " + key);
    }
    @Override
    public void docFile() {try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream("NhaCungCap.txt"),"UTF-8"))){
            String line;
            dsNCC = new NhaCungCap[0];
            int size = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 4) continue;
                String maNCC = parts[0];
                String tenNCC = parts[1];
                String SDT = parts[2];
                String DiaChi = parts[3];
                dsNCC = Arrays.copyOf(dsNCC, size + 1);
                dsNCC[size++] = new NhaCungCap(maNCC, tenNCC, SDT, DiaChi);
            }
            this.n = size;
        }
    catch (IOException e) {
        System.out.println("Loi doc file: " + e.getMessage());
    }
    }
    @Override
    public void ghiFile() {try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("NhaCungCap.txt", false), "UTF-8"))) {
        for (int i = 0; i < n; i++) {
            String line = dsNCC[i].getMaNCC() + ";" +
                          dsNCC[i].getTenNCC() + ";" +
                          dsNCC[i].getSDT() + ";" +
                          dsNCC[i].getDiaChi() ;
            bw.write(line);
            bw.newLine();
        }
        System.out.println("Da ghi du lieu vao file NhaCungCap.txt!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    public NhaCungCap timNCC(String key){
        for (NhaCungCap nhaCungCap : dsNCC) {
            if(nhaCungCap.getMaNCC().equalsIgnoreCase(key))
            {
                return nhaCungCap;
            }
        }
        return null;
    }
    public NhaCungCap[] timNCCten(String tenNCC) {
        NhaCungCap[] Ketqua = new NhaCungCap[0];
        int size=0;
        for (NhaCungCap nhaCungCap : dsNCC) {
            if(nhaCungCap.getTenNCC().equalsIgnoreCase(tenNCC)){
                Ketqua = Arrays.copyOf(Ketqua, size+1);
                Ketqua[size++]=nhaCungCap;
            }
        }
        return Ketqua;
    }
    public int getSoLuong() {
    return n;
}
}
