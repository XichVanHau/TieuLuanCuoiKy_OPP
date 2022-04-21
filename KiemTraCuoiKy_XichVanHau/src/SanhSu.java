import java.util.Calendar;
import java.util.Date;

public class SanhSu extends HangHoa{
    private String nhaSanXuat;
    private Date ngayNhapKho;

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }
    protected void setNhaSanXuat(String nhaSanXuat) {
        if(nhaSanXuat != null){
        this.nhaSanXuat = nhaSanXuat;
        }else{
            System.out.println("Nhà Sản Xuất Không Được Để Trống");
        }
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    protected void setNgayNhapKho(Date ngayNhapKho) {
        if(ngayNhapKho != null){
        this.ngayNhapKho = ngayNhapKho;
        }else{
            System.out.println("Ngày Nhập Kho Không Được Để Trống");
        }
    }
    public SanhSu() {
        super();
        this.nhaSanXuat = null;
        this.ngayNhapKho = null;
    }

    public SanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
            Date ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setNhaSanXuat(nhaSanXuat);
        this.setNgayNhapKho(ngayNhapKho);
    }
    @Override
    public String toString() {
        return "Hàng Sành Sứ" + super.toString() + "(Ngày Nhập Kho = " + ngayNhapKho + ", Nhà Sản Xuất = " + nhaSanXuat + ")";
    }

    @Override
    public double tinhVAT() {
        double vAT = 0;
        vAT = this.getDonGia() * 0.1;
        return vAT;
    }

    private long tinhThoiGianLuuKho(){
        Calendar ngayHienTai = Calendar.getInstance();
        Calendar ngayNhapKho = Calendar.getInstance();
        Date ngayHT = new Date();
        Date ngayNK = this.ngayNhapKho;
        ngayHienTai.setTime(ngayHT);
        ngayNhapKho.setTime(ngayNK);
        long soNgayLuuKho = (ngayHienTai.getTime().getTime() - ngayNhapKho.getTime().getTime()) / (24*3600*1000);
        return soNgayLuuKho;
    }

    @Override
    public void danhGiaBanBuon() {
        if(this.getSoLuongTon()>50 & tinhThoiGianLuuKho()>10){
            System.out.println("Đánh Giá: Bán Chậm");
        }else{
            System.out.println("Không Đánh Giá");
        }
    }
}