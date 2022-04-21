import java.io.Serializable;

public abstract class HangHoa implements Serializable{
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    

    protected String getMaHang() {
        return maHang;
    }

    private void setMaHang(String maHang) {
        if(maHang!=null){
            this.maHang = maHang;
        }else{
            System.out.println("Mã Hàng Không Được Để Trống");
        }
    }

    protected String getTenHang() {
        return tenHang;
    }

    protected void setTenHang(String tenHang) {
        if(tenHang!=null){
        this.tenHang = tenHang;
        }else{
            System.out.println("Tên Hàng Không Được Để Trống");
        }
    }

    protected int getSoLuongTon() {
        return soLuongTon;
    }

    protected void setSoLuongTon(int soLuongTon) {
        if(soLuongTon>=0){
        this.soLuongTon = soLuongTon;
        }else{
            System.out.println("Số Lượng Tồn Phải > = 0");
        }
    }

    protected double getDonGia() {
        return donGia;
    }

    protected void setDonGia(double donGia) {
        if(donGia>0){
        this.donGia = donGia;
        }else{
            System.out.println("Đơn Giá Phải > 0");
        }
    }

    protected HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setSoLuongTon(soLuongTon);
        this.setDonGia(donGia);
    }

    protected HangHoa(){}

    @Override
    public String toString() {
        return " (Đơn Giá = " + donGia + ", Mã Hàng = " + maHang + ", Số Lượng Tồn = " + soLuongTon + ", Tên Hàng = "  + tenHang + ")";
    };

    public abstract double tinhVAT();

    public abstract void danhGiaBanBuon();
}