import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachHangHoa {
    private List<HangHoa> danhSach = new ArrayList<>();

    private int soLuongHangThucPham;
    private int soLuongHangSanhSu;
    private int soLuongHangDienMay;

    public int getSoLuongHangThucPham() {
        return soLuongHangThucPham;
    }

    public int getSoLuongHangSanhSu() {
        return soLuongHangSanhSu;
    }

    public int getSoLuongHangDienMay() {
        return soLuongHangDienMay;
    }

    public boolean soSanhMaHang(String maHang) {
        boolean daTrungMaHang = false;
        for (HangHoa hangHoa : danhSach) {
            if(maHang.equals(hangHoa.getMaHang())) {
                daTrungMaHang = true;
            }
        }
        return daTrungMaHang;
    }

    public void them(HangHoa hangHoa){
        this.danhSach.add(hangHoa);
    }

    public void  inDanhSach() {
        for (HangHoa hangHoa : danhSach) {
            System.out.println(hangHoa);
            System.out.println("");
        }
    }

    public void xoaHangHoa(HangHoa hangHoa) {
        this.danhSach.remove(hangHoa);
    }

    public int timViTriHangHoa(HangHoa hangHoa) {
        int viTri = -1;
        viTri = this.danhSach.indexOf(hangHoa);
        return viTri;
    }

    public void suaHangHoa(int viTri, HangHoa hangHoa) {
        this.danhSach.set(viTri, hangHoa);
    }

    public HangHoa timHangHoaTheoMa(String maHang) {
        HangHoa hangHoa = null;
        for (HangHoa hangHoa1 : danhSach) {
            if (hangHoa1.getMaHang().toString().equalsIgnoreCase(maHang)) {
                hangHoa = hangHoa1;
            }
        }
        return hangHoa;
    }

    public ThucPham timHangThucPhamTheoMa(String maHang) {
        ThucPham hangThucPham = null;
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa.getMaHang().toString().equalsIgnoreCase(maHang) && hangHoa instanceof ThucPham) {
                hangThucPham = (ThucPham) hangHoa;
            }
        }
        return hangThucPham;
    }

    public SanhSu timHangSanhSuTheoMa(String maHang) {
        SanhSu hangSanhSu = null;
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa.getMaHang().toString().equalsIgnoreCase(maHang) && hangHoa instanceof SanhSu) {
                hangSanhSu = (SanhSu) hangHoa;
            }
        }
        return hangSanhSu;
    }

    public DienMay timHangDienMayTheoMa(String maHang) {
        DienMay hangDienMay = null;
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa.getMaHang().toString().equalsIgnoreCase(maHang) && hangHoa instanceof DienMay) {
                hangDienMay = (DienMay) hangHoa;
            }
        }
        return hangDienMay;
    }

    public void sapXepHangTheoDonGia() {
        Collections.sort(danhSach, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa h1, HangHoa h2) {
                if(h1.getDonGia() < h2.getDonGia()){
                    return -1;
                }else{
                    if (h1.getDonGia() == h2.getDonGia()) {
                        return 0;
                    }else {
                        return 1;
                    }
                }
            }
        });
    }



    public void themKhoHang(){
        danhSach.add(new ThucPham("TP01", "G???o Tr???ng", 0, 10000.0, NhapHangHoa.chuyenChuoiSangNgay("01/01/2010"), NhapHangHoa.chuyenChuoiSangNgay("01/02/2010"), "G???o G?? C??ng"));
        danhSach.add(new ThucPham("TP02", "Rau C??? Qu???", 10, 20000.0, NhapHangHoa.chuyenChuoiSangNgay("02/02/2012"), NhapHangHoa.chuyenChuoiSangNgay("02/12/2012"), "N??ng Tr???i Rau S???ch"));
        danhSach.add(new ThucPham("TP03", "Kh?? M???c C??c Lo???i", 20, 30000.0, NhapHangHoa.chuyenChuoiSangNgay("03/03/2013"), NhapHangHoa.chuyenChuoiSangNgay("03/05/2013"), "X?????ng H???i S???n Kh??"));

        danhSach.add(new SanhSu("SS01", "Ch???u B??ng", 60, 7000.0, "L?? G???m Ninh Thu???n"  ,NhapHangHoa.chuyenChuoiSangNgay("10/01/2010")));
        danhSach.add(new SanhSu("SS02", "ch??n B??t", 9, 20000.0, "l?? G???m B??t Tr??ng"  ,NhapHangHoa.chuyenChuoiSangNgay("20/03/2012")));
        danhSach.add(new SanhSu("SS03", "Ly Ki???n", 100, 15000.0, "l??? G???m JAPAN"  ,NhapHangHoa.chuyenChuoiSangNgay("30/03/2013")));
        
        danhSach.add(new DienMay("DM01", "M??y Gi???c", 5, 5000000.0, 12  , 220));
        danhSach.add(new DienMay("DM02", "T??? L???nh", 10, 10000000.0, 36  , 300));
        danhSach.add(new DienMay("DM03", "TiVi", 20, 1500000.0, 24  , 240));
        danhSach.add(new DienMay("DM03", "B???p ??i???n", 30, 2000000.0, 6  , 220));
    }

    public void tinhTongSLTungLoai() {

        for (HangHoa hangHoa : danhSach) {
            if (hangHoa instanceof ThucPham) {
                this.soLuongHangThucPham++;
            } else if(hangHoa instanceof SanhSu){
                this.soLuongHangSanhSu++;
            }else{
                this.soLuongHangDienMay++;
            }
        }
        System.out.println("T???ng S??? L?????ng H??ng Th???c Ph???m: " + this.soLuongHangThucPham);
        System.out.println("T???ng S??? L?????ng H??ng S??nh S???: " + this.soLuongHangSanhSu);
        System.out.println("T???ng S??? L?????ng H??ng ??i???n M??y: " + this.soLuongHangDienMay);
    }

    public int tinhTongSoLuongHangHoa(){
        int sumSoLuongHH =0;
        for(HangHoa hangHoa : danhSach){
            sumSoLuongHH+=1;
        }
        return sumSoLuongHH;
    }

    public void danhGiaBanBuonTungLoaiHang(){
        for (HangHoa hangHoa : danhSach) {
            if (hangHoa instanceof ThucPham) {
                System.out.println(hangHoa);
                hangHoa.danhGiaBanBuon();
                System.out.println("");
            } else if(hangHoa instanceof SanhSu){
                System.out.println(hangHoa);
                hangHoa.danhGiaBanBuon();
                System.out.println("");
            }else if(hangHoa instanceof DienMay){
                System.out.println(hangHoa);
                hangHoa.danhGiaBanBuon();
                System.out.println("");
            }
        }
    }

    public void xuatVATTungLoaiHang(){
        double vATThucPham = 0;
        double vATSanhSu = 0;
        double vATDienMay = 0;

        for (HangHoa hangHoa : danhSach) {
            if (hangHoa instanceof ThucPham) {
                vATThucPham = hangHoa.tinhVAT();
                System.out.println(hangHoa + " ---> VAT: " + vATThucPham);
                System.out.println("");
            } else if(hangHoa instanceof SanhSu){
                vATSanhSu = hangHoa.tinhVAT();
                System.out.println(hangHoa + " ---> VAT: " + vATSanhSu);
                System.out.println("");
            }else if(hangHoa instanceof DienMay){
                vATDienMay = hangHoa.tinhVAT();
                System.out.println(hangHoa + " ---> VAT: " + vATDienMay);
                System.out.println("");
            }
        }
    }
    
    public void ghiFileDanhSachHangHoa(String tenFile){
        try {
            FileOutputStream outFile = new FileOutputStream(tenFile);
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            objOut.writeObject(danhSach);
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docFileDanhSachHangHoa(String tenFile){
        try {
            FileInputStream inFile = new FileInputStream(tenFile);
            ObjectInputStream objIn = new ObjectInputStream(inFile);
            danhSach = (List) objIn.readObject();
            objIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}