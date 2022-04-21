import java.util.Date;

public class ThucPham extends HangHoa{
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;

    public void setNgaySanXuat(Date ngaySanXuat) {
        if(ngaySanXuat!=null){
        this.ngaySanXuat = ngaySanXuat;
        }else{
            System.out.println("Ngày Sản Xuất Không Được Để Trống");
        }
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if(ngayHetHan!=null){
            if(ngayHetHan.after(ngaySanXuat)){
                this.ngayHetHan = ngayHetHan;
            }else{
                System.out.println("Ngày Hết Hạn Phải sau Ngày Sản Xuất");
            }
        }else{
            System.out.println("Ngày Hết Hạn Không Được Để Trống!");
        }
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNhaCungCap(String nhaCungCap) {
        if(nhaCungCap!=null){
        this.nhaCungCap = nhaCungCap;
        }else{
            System.out.println("Nhà Cung Cấp Không Được Để Trống");
        }
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public ThucPham(){
        super();
        this.ngaySanXuat = null;
        this.ngayHetHan = null;
        this.nhaCungCap = null;
    }

    public ThucPham(String maHang, String tenHang, int soLuongTon, double donGia, Date ngaySanXuat, Date ngayHetHan,
            String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setNgaySanXuat(ngaySanXuat);
        this.setNgayHetHan(ngayHetHan);
        this.setNhaCungCap(nhaCungCap);
    }

    @Override
    public String toString() {
        return "Hàng Thực Phẩm" + super.toString() + "(Ngày Hết Hạn = " + ngayHetHan + ", Ngày Sản Xuất = " + ngaySanXuat + ", Nhà Cung Cấp =" + nhaCungCap
                + ")";
    }

    @Override
    public double tinhVAT() {
        double vAT = 0;
        vAT = this.getDonGia() * 0.05;
        return vAT;
    }

    private boolean tinhHSD(){
        boolean daHetHan = false;
        Date ngayHienTai = new Date();
        if(this.ngayHetHan.before(ngayHienTai)){
            daHetHan = true;
        }
        return daHetHan;
    }
    @Override
    public void danhGiaBanBuon() {
        if(this.getSoLuongTon()>0 & tinhHSD()==true){
            System.out.println("Đánh Giá: Khó Bán");
        }else{
            System.out.println("Không Đánh Giá");
        }
    }
}