public class DienMay extends HangHoa{
    private int thoiGianBaoHanh;
    private double congSuat;

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if(thoiGianBaoHanh >=0){
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        }else{
            System.out.println("Thời Gian BẢo Hành Phải > 0 Tháng");
        }
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setCongSuat(double congSuat) {
        if(congSuat>0){
        this.congSuat = congSuat;
        }else{
            System.out.println("Công Suất Phải > 0 KW");
        }
    }

    public DienMay() {
        super();
        this.thoiGianBaoHanh = 0;
        this.congSuat = 0;
    }

    public DienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh,
            double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setThoiGianBaoHanh(thoiGianBaoHanh);
        this.setCongSuat(congSuat);
    }

    @Override
    public String toString() {
        return "Hàng Điện Máy" + super.toString() + "(Công Suất = " + congSuat + ", Thời Gian Bảo Hành = " + thoiGianBaoHanh + ")";
    }

    @Override
    public double tinhVAT() {
        double vAT = 0;
        vAT = this.getDonGia() * 0.1;
        return vAT;
    }

    @Override
    public void danhGiaBanBuon() {
        if(this.getSoLuongTon() >0 & this.getSoLuongTon()<3){
            System.out.println("Đánh Giá: Bán ĐƯợc");
        }else{
            System.out.println("Không Đánh Giá");
        }
    }
}