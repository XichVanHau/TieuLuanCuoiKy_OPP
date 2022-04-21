import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NhapHangHoa {
    
    public static Scanner scanner = new Scanner(System.in);
    SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa nhapHangHoa(){
        HangHoa hangHoa = null;

        String maHang = null;
        System.out.println("Nhập Mã Hàng Hóa: ");
        maHang = scanner.nextLine();
        String tenHang = null;
        System.out.println("Nhập Tên Hàng: ");
        tenHang = scanner.nextLine();
        int soLuongTon = 0;
        System.out.println("Nhập Số Lượng Tồn Kho: ");
        try {
            soLuongTon = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Vui Lòng Nhập Số");
            e.printStackTrace();
        }
        double donGia = 0;
        System.out.println("Nhập Đơn Giá: ");
        try {
            donGia = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Vui Lòng Nhập Số");
            e.printStackTrace();
        }

        int loai = 0;
        System.out.println("Bạn Muốn Chọn Loại Hàng Nào?"
        		+ "Hàng THực Phẩm -> 1 , "
        		+ "Hàng Sành Sứ   -> 2, "
        		+ "Hàng Điện Máy  -> 3 ");
        try {
            loai = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Vui Lòng Nhập Số");
        }
        if(loai == 1){
            System.out.println("Hàng THực Phẩm ");
            Date ngaySanXuat = null;
            System.out.println("Nhập Ngày Sản Xuất: ");
            try {
                ngaySanXuat = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }

            Date ngayHetHan = null;
            System.out.println("Nhập Ngày Hết Hạn: ");
            try {
                ngayHetHan = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            String nhaCungCap = null;
            System.out.println("Nhập Nhà Cung Cấp: ");
            nhaCungCap = scanner.nextLine();
            hangHoa = new ThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
        }else if(loai == 2){
            System.out.println("Hàng Sành Sứ ");
            String nhaSanXuat = null;
            System.out.println("Nhập Nhà Sản Xuất: ");
            nhaSanXuat = scanner.nextLine();
            Date ngayNhapKho = null;
            System.out.println("Nhập Ngày Nhập Kho: ");
            try {
                ngayNhapKho = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            hangHoa = new SanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho);
        }else{
            System.out.println("Hàng Điện Máy ");
            int thoiGianBaoHanh = 0;
            System.out.println("Thời Gian Bảo Hành / Tháng: ");
            try {
                thoiGianBaoHanh = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            double congSuat =  0;
            System.out.println("Nhập Công Suất: ");
            try {
                congSuat = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            hangHoa = new DienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
        }
        return hangHoa;
    }

   
    public static Date chuyenChuoiSangNgay(String chuoiNgay) {
        Date date = null;
      
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = simpleDateFormat.parse(chuoiNgay);
        } catch (ParseException e) {
            System.out.println("Nhập Ngày / Tháng / Năm: ");
            e.printStackTrace();
        }
        return date;
    }

    public HangHoa suaHangHoa(String maHang){
        HangHoa hangHoa = null;

        String tenHang = null;
        System.out.println("Nhập Tên Hàng: ");
        tenHang = scanner.nextLine();
        int soLuongTon = 0;
        System.out.println("Nhập Số Lượng Tồn Kho: ");
        try {
            soLuongTon = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Vui Lòng Nhập Số");
            e.printStackTrace();
        }
        double donGia = 0;
        System.out.println("Nhập Đơn Giá: ");
        try {
            donGia = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Vui Lòng Nhập Số");
            e.printStackTrace();
        }

        System.out.println("Bạn Muốn Chọn Loại Hàng Nào?"
        		+ "Hàng THực Phẩm -> 1 , "
        		+ "Hàng Sành Sứ   -> 2, "
        		+ "Hàng Điện Máy  -> 3 ");
        int loai = scanner.nextInt();
        scanner.nextLine();
        if(loai == 1){
            System.out.println("Hàng THực Phẩm ");
            Date ngaySanXuat = null;
            System.out.println("Nhập Ngày Sản Xuất: ");
            try {
                ngaySanXuat = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            

            Date ngayHetHan = null;
            System.out.println("Nhập Ngày Hết Hạn: ");
            try {
                ngayHetHan = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            System.out.println("Nhập Nhà Cung Cấp: ");
            String nhaCungCap = scanner.nextLine();
            hangHoa = new ThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
        }else if(loai == 2){
            System.out.println("Hàng Sành Sứ ");
            System.out.println("Nhập Nhà Sản Xuất ");
            String nhaSanXuat = scanner.nextLine();
            Date ngayNhapKho = null;
            System.out.println("Nhập Ngày Nhập Kho: ");
            try {
                ngayNhapKho = chuyenChuoiSangNgay(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            hangHoa = new SanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho);
        }else{
            System.out.println("Hàng Điện Máy ");
            int thoiGianBaoHanh = 0;
            System.out.println("Thời Gian Bảo Hành / Tháng: ");
            try {
                thoiGianBaoHanh = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            double congSuat =  0;
            System.out.println("Nhập Công Suất KW: ");
            try {
                congSuat = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Vui Lòng Nhập Số");
                e.printStackTrace();
            }
            hangHoa = new DienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
        }
        return hangHoa;
    }
}
