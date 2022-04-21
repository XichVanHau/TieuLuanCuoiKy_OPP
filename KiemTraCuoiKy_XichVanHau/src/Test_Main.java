import java.util.InputMismatchException;
import java.util.Scanner;

public class Test_Main {
    public static void main(String[] args) {
        int luaChon;
        Scanner scanner = new Scanner(System.in);

        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        System.out.println(" ______________");
        System.out.println("|              |");
        System.out.println("|   KHO HÀNG   |");
        System.out.println("|______________|");
        System.out.println("");
        danhSachHangHoa.themKhoHang();
        danhSachHangHoa.inDanhSach();
        do{
            System.out.println(" _______________________________________________________");
            System.out.println("|   1. Thêm Hàng                                        |");
            System.out.println("|   2. In Danh Sách Hàng Hóa                            |");
            System.out.println("|   3. Xóa Hàng Theo Mã                                 |");
            System.out.println("|   4. Sửa Hàng Theo Mã                                 |");
            System.out.println("|   5. Tìm Kiếm Theo Mã                                 |");
            System.out.println("|   6. Sắp Sếp Danh Sách Hàng Hóa Tăng Dần Theo Đơn Giá |");
            System.out.println("|   7. Thống Kê Hàng Hóa                                |");
            System.out.println("|   8. Báo Cáo Hàng Hóa                                 |");
            System.out.println("|   9. Ghi Danh Sách Ra File                            |");
            System.out.println("|   10. Đoc Danh Sách Từ File                           |");
            System.out.println("|   11. Thoát                                           |");
            System.out.println("|_______________________________________________________|");
            luaChon = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------");
            switch(luaChon)
            {
                case 1:
                String nhapTiep = " ";

                NhapHangHoa nhapHangHoa = new NhapHangHoa();

                do {
                    HangHoa hangHoa = nhapHangHoa.nhapHangHoa();
                    if(danhSachHangHoa.soSanhMaHang(hangHoa.getMaHang())== false) {
                    danhSachHangHoa.them(hangHoa);
                    }else{
                        System.out.println("Không Thêm Được Do Trùng Mã Hàng");
                    }
                    System.out.println("Ban Có Muốn Tiếp Tục hay Không? Y/N");
                    nhapTiep = nhapHangHoa.scanner.nextLine();
                }while(nhapTiep.equalsIgnoreCase("Y"));
                break;

                case 2:
                danhSachHangHoa.inDanhSach();
                break;

                case 3:
                System.out.println("Nhập Mã Hàng Cần Xóa: ");
                String maHangXoa = scanner.nextLine();
                HangHoa hangHoaXoa = danhSachHangHoa.timHangHoaTheoMa(maHangXoa);
                danhSachHangHoa.xoaHangHoa(hangHoaXoa);
                break;

                case 4:
                NhapHangHoa suaHangHoa = new NhapHangHoa();
                System.out.println("Nhập Mã Hàng Cần Sửa: ");
                String maHangSua = scanner.nextLine();
                HangHoa hangHoaSua = danhSachHangHoa.timHangHoaTheoMa(maHangSua);
                int viTriSua = danhSachHangHoa.timViTriHangHoa(hangHoaSua);
                hangHoaSua = suaHangHoa.suaHangHoa(maHangSua);
                danhSachHangHoa.suaHangHoa(viTriSua, hangHoaSua);
                break;

                case 5: 
                int luaChon1 = 0;
                do{
                    System.out.println("______________________________________");
                    System.out.println("|  1. Tìm Hàng Theo Mã               |");
                    System.out.println("|  2. Tìm Hàng Thực Phẩm Theo Mã     |");
                    System.out.println("|  3. Tìm Hàng Sành Sứ Theo Mã       |");
                    System.out.println("|  4. Tìm Hàng Điện Máy Theo Mã      |");
                    System.out.println("|  5. Thoát KHỏi Menu                |");
                    System.out.println("|____________________________________|");
                    System.out.print("Lua chon: ");
                    try {
                        luaChon1 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Vui Lòng Nhập Số");
                    }
                    switch(luaChon1){
                        case 1:
                        System.out.println("Nhập Mã Hàng Cần Tìm: ");
                        String maHangTim = scanner.nextLine();
                        HangHoa hangHoa = danhSachHangHoa.timHangHoaTheoMa(maHangTim);
                        System.out.println(hangHoa);
                        break;
                        case 2: 
                        System.out.println("Nhập Mã Hàng Thực Phẩm Cần Tìm: ");
                        String maHangThucPhamTim = scanner.nextLine();
                        HangHoa hangHoaThucPham = danhSachHangHoa.timHangThucPhamTheoMa(maHangThucPhamTim);
                        if(hangHoaThucPham!=null)
                        System.out.println(hangHoaThucPham);
                        else
                        System.out.println("Không Có Hàng Thực Phẩm Có Mã " + maHangThucPhamTim);
                        break;
                        case 3:
                        System.out.println("Nhập Mã Hàng Sành Sứ Cần Tìm: ");
                        String maHangSanhSuTim = scanner.nextLine();
                        HangHoa hangHoaSanhSu = danhSachHangHoa.timHangSanhSuTheoMa(maHangSanhSuTim);
                        if(hangHoaSanhSu!=null)
                        System.out.println(hangHoaSanhSu);
                        else
                        System.out.println("Không Có Hàng Sành Sứ Có Mã " + maHangSanhSuTim);
                        break;
                        case 4:
                        System.out.println("Nhập Mã Hàng Điện Máy Cần Tìm: ");
                        String maHangDienMayTim = scanner.nextLine();
                        HangHoa hangHoaDienMay = danhSachHangHoa.timHangDienMayTheoMa(maHangDienMayTim);
                        if(hangHoaDienMay!=null)
                        System.out.println(hangHoaDienMay);
                        else
                        System.out.println("Không Có Hàng Điện Máy Có Mã " + maHangDienMayTim);
                        break;
                        case 5:
                        luaChon1 = 5;
                    }
                }while(luaChon1 <=4);
                break;

                case 6:
                danhSachHangHoa.sapXepHangTheoDonGia();
                danhSachHangHoa.inDanhSach();
                break;

                case 7:
                int luaChon3 = 0;
                do{
                    System.out.println(" ______________________________________");
                    System.out.println("|  1. Tổng Số Lượng Hàng Hóa Trong Kho |");
                    System.out.println("|  2. Tổng Số Lượng từng Loại Hàng     |");
                    System.out.println("|  3. Thoát KHỏi MEnu                  |");
                    System.out.println("|______________________________________|");
                    System.out.print("Lua chon: ");
                    try {
                        luaChon3 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Vui Lòng Nhập Số");
                    }
                    switch(luaChon3){
                        case 1:
                        System.out.println("Tổng Số Lượng Hàng Hóa: " + danhSachHangHoa.tinhTongSoLuongHangHoa());
                        break;
                        case 2: 
                        danhSachHangHoa.tinhTongSLTungLoai();
                        break;
                        case 3:
                        luaChon3 = 3;
                    }
                }while(luaChon3 <=2);
                break;

                case 8:
                int luaChon4 = 0;
                do{
                    System.out.println("  _____________________________");
                    System.out.println(" | 1. Đánh Giá Buôn.           |");
                    System.out.println(" | 2. Xuất Danh Sách VAT.      |");
                    System.out.println(" | 3. Thoát Khỏi Menu.         |");
                    System.out.println(" |_____________________________|");
                    System.out.print("Lua chon: ");
                    try {
                        luaChon4 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Vui Lòng Nhập Số");
                    }
                    switch(luaChon4){
                        case 1:
                        danhSachHangHoa.danhGiaBanBuonTungLoaiHang();
                        break;
                        case 2: 
                        danhSachHangHoa.xuatVATTungLoaiHang();
                        break;
                        case 3:
                        luaChon4 = 3;
                    }
                }while(luaChon4 <=2);
                break;

                case 9:
                System.out.println("Nhập Tên File Muốn Ghi: ");
                String tenFile = scanner.nextLine();
                danhSachHangHoa.ghiFileDanhSachHangHoa(tenFile);
                break;

                case 10:
                System.out.println("NHập Tên File MUốn Đọc: ");
                String File = scanner.nextLine();
                danhSachHangHoa.docFileDanhSachHangHoa(File);
                break;

                case 11: 
                System.exit(0);
            }
        }while(true);
    }
}