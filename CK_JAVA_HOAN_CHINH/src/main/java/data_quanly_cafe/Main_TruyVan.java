package data_quanly_cafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static data_quanly_cafe.Employ.dsNhanVien;

public class Main_TruyVan {

    NhaCungCap nhaCungCap = new NhaCungCap();

    ArrayList<DOUONG> dsDoUongOrder = new ArrayList<DOUONG>();
    ArrayList<NhaCungCap> dsNhaCungCap = new ArrayList<NhaCungCap>();
    List<DOUONG> ListNv = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public boolean isInteger(String n) {// hàm kiểm tra có phải là số nguyên
        try {
            Integer.parseInt(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // =============NHÀ CUNG CÂP===================
    // thêm nhà cung cấp
    public void themNhaCungCap() {
        System.out.println("Nhập số lượng nhà cung cấp cần thêm");
        int n = Integer.parseInt(input.nextLine());
        boolean kt = false;
        String id1;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhà cung cấp thứ " + (i + 1));
            do {
                System.out.println("Nhập id:");
                id1 = input.nextLine();
                if (!isInteger(id1)) { // kiem tra id co phai la so nguyen
                    System.out.println(" Id không phải là số nguyên, vui lòng nhập lại:");
                    kt = true;
                    continue;
                } else {
                    kt = false;
                }
                if (Integer.parseInt(id1) <= 0) { // kiểm tra có <0 hay không
                    System.out.println("id nhập phải lớn hơn 0, vui lòng nhập lại");
                    kt = true;
                    continue;
                } else {
                    kt = false;
                }

                for (NhaCungCap nhaCungCap : dsNhaCungCap) { // kiem tra id co bi trung hay khong
                    String id2 = Integer.toString(nhaCungCap.getId());
                    if (id1.equals(id2)) {
                        System.out.println("id đã trùng, vui lòng nhập lại");
                        kt = true;
                        break;
                    } else {
                        kt = false;
                    }

                }

            } while (kt);

            int id = Integer.parseInt(id1);

            System.out.println("Nhập tên nhà cung câp:");
            String name = input.nextLine();
            System.out.println("Nhập địa chỉ nhà cung cấp:");
            String address = input.nextLine();
            System.out.println("Nhập email nhà cung cấp:");
            String email = input.nextLine();
            System.out.println("Nhập số điện thoại:");
            String phone = input.nextLine();
            nhaCungCap = new NhaCungCap(id, name, address, email, phone);
            dsNhaCungCap.add(nhaCungCap);
        }

    }

    // xóa nhà cung cấp
    public void XoaNhaCungCap() {
        if (!dsNhaCungCap.isEmpty()) {
            System.out.println("Nhập id nhà cung cấp cần xóa");
            int id1 = Integer.parseInt(input.nextLine());
            boolean kt = true;
            for (int i = 0; i < dsNhaCungCap.size(); i++) {
                if (id1 == dsNhaCungCap.get(i).getId()) {
                    dsNhaCungCap.remove(i);
                    System.out.println("Xóa nhà cung cấp thành công");
                    kt = false;
                }
            }
            if (kt) {
                System.out.println("id nhà cung cấp không tồn tại");
            }

        } else {
            System.out.println("Danh sách nhà cung cấp rỗng");
        }
    }

    // sửa nhà cung cấp
    public void SuaNhaCungCap() {
        System.out.println("Nhập id nhà cung cấp cần sửa thông tin");
        int id1 = Integer.parseInt(input.nextLine());
        boolean kt = false;
        int i;
        for (i = 0; i < dsNhaCungCap.size(); i++) {
            if (dsNhaCungCap.get(i).getId() == id1) {
                kt = true;
                break;
            }

        }
        if (kt) {
            System.out.println("Nhập lại tên nhà cung cấp:");
            String name = input.nextLine();
            System.out.println("Nhập lại địa chỉ nhà cung cấp:");
            String address = input.nextLine();
            System.out.println("Nhập lại email nhà cung cấp:");
            String email = input.nextLine();
            System.out.println("Nhập lại số điện thoại:");
            String phone = input.nextLine();
            NhaCungCap nhaCungCap = new NhaCungCap(id1, name, address, email, phone);
            dsNhaCungCap.set(i, nhaCungCap);
        } else {
            System.out.println("Id nhà cung cấp không tồn tại");
        }
    }

    // hiển thị thông tin nhà cung cấp
    public void hienThiDanhSachNhaCungCap() {
        System.out.println("Danh sách nhà cung cấp là:");
        if (!dsNhaCungCap.isEmpty()) {
            for (NhaCungCap nhaCungCap : dsNhaCungCap) {
                System.out.println(nhaCungCap);
            }
        } else {
            System.out.println("Danh sách nhà cung cấp rỗng");
        }
    }

    // tìm kiếm nhà cung cấp
    public void timKiemNhaCungCap() {
        System.out.println("Nhập tên nhà cung cấp cần tìm");
        String name = input.nextLine();
        System.out.println("Thông tin nhà cung cấp cần tìm là:");
        boolean kt = true;
        if (!dsNhaCungCap.isEmpty()) {
            for (NhaCungCap nhaCungCap : dsNhaCungCap) {
                if (nhaCungCap.getName().equalsIgnoreCase(name)) {
                    System.out.println(nhaCungCap);
                    kt = false;
                }
            }
            if (kt) {
                System.out.println("Không tìm thấy nhà cung cấp cần tìm");
            }
        } else {
            System.out.println("Danh sách nhà cung cấp rỗng");
        }
    }

    ;

	// sắp xếp nhà cung cấp

	public void sapXepTheoTenNhaCungCap() {
        Collections.sort(dsNhaCungCap, new Comparator<NhaCungCap>() {
            @Override
            public int compare(NhaCungCap o1, NhaCungCap o2) {
                String name1 = o1.getName();

                String name2 = o2.getName();

                return name1.compareToIgnoreCase(name2);
            }
        });
        System.out.println("Đã sắp xếp thành công");
    }

    ;
	// ===========ĐỒ UỐNG===============

        public void sapxepDU() {
        Collections.sort(ListNv, new Comparator<DOUONG>() {
            @Override
            public int compare(DOUONG o1, DOUONG o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareToIgnoreCase(name2);
            }

        });

    }

    public void themDoUong() {
        System.out.println("Vui lòng nhập vào sô lượng sản phẩm cần thêm");
        boolean nhap = false;

        while (!nhap) {
            try {
                int n = Integer.parseInt(input.nextLine());

                for (int i = 0; i < n; i++) {
                    DOUONG nv = new DOUONG();
                    nv.nhap();
                    ListNv.add(nv);
                }
                nhap = true;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập vào sô lượng sản phẩm cần thêm");
            }

        }

    }

     public void suaDoUong() {
        System.out.println("Nhap id cua san pham can sua");
        boolean nhap = false;
        boolean kt = true;
        while (!nhap) {
            try {
                int id = Integer.parseInt(input.nextLine());

                for (DOUONG nhanvien : ListNv) {
                    if (nhanvien.getId() == id) {
                        nhanvien.nhap();
                        kt = false;

                    }

                }
                if (kt) {
                    System.out.println("ID đồ uống không tồn tại");
                }
                nhap = true;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại ID ");
            }

        }

    }
   public void xoaDoUong() {
        System.out.println("Nhap id san pham can xoa");

        boolean kt = true;
        boolean nhap = false;
        while (!nhap) {
            try {
                int id = Integer.parseInt(input.nextLine());

                for (DOUONG nhanvien : ListNv) {
                    if (nhanvien.getId() == (id)) {
                        ListNv.remove(nhanvien);
                        kt = false;
                        break;
                    }
                }
                if (kt) {
                    System.out.println("ID bạn nhập không tồn tại");
                }
                nhap = true;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại ID");
            }

        }

    }

//	public void save() {
//		System.out.println("Bat dau luu");
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream("nhanvien.txt", true);
//
//			for (DOUONG nhanvien : ListNv) {
//				String line = nhanvien.line();
//				byte[] b = line.getBytes("utf8");
//
//				fos.write(b);
//
//			}
//		} catch (Exception e) {
//		}
//
//	}
    public void xuatDS() {
        if (!ListNv.isEmpty()) {
            System.out.format("%-5s %-20s %-15s %-15s %-15s\n", "ID", "TEN SP", "GIA TIEN", "NHA PHAN PHOI",
                    "NGAY NHAP KHO");
            for (int i = 0; i < ListNv.size(); i++) {
                ListNv.get(i).xuat();

            }

        }
    }

    public void timKiemDU() {
        System.out.println("Nhập tên sản phẩm bạn muốn tìm kiếm");
        String name = input.nextLine();
        boolean kt = true;
        for (DOUONG douong : ListNv) {
            if (douong.getName().equals(name)) {
                System.out.format("%-5s %-20s %-15s %-15s %-15s\n", "ID", "TEN SP", "GIA TIEN", "NHA PHAN PHOI",
                        "NGAY NHAP KHO");
                System.out.format("%-5s %-20s %-15s %-15s %-15s\n", douong.getId(), douong.getName(), douong.getgiaTien(), douong.tenNhaPhanPhoi, douong.ngayNhap);
                kt = false;
                break;

            }

        }
        if (kt) {
            System.err.println("Tên đồ uống không tồn tại");
        }

    }

    // =============QUẢN LÝ NHÂN VIÊN====================
    // thêm danh sách nhân viên
    public void nhapDsNhanVien() {
        System.out.println("Nhập số lượng nhân viên cần thêm:");
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập nhân viên thứ" + (i + 1));

            System.out.println("Chọn loại nhân viên: 1.part time  2.full time");
            String j = input.nextLine();

            switch (j) {
                case "1": {
                    EmployPartTime employPartTime = new EmployPartTime();
                    employPartTime.nhap();
                    dsNhanVien.add(employPartTime);

                    break;
                }

                default: {
                    EmployFullTime employFullTime = new EmployFullTime();
                    employFullTime.nhap();
                    dsNhanVien.add(employFullTime);

                    break;
                }
            }
        }
    }

    //sửa thông tin nhân viên
    public void suaThongTinNhanVien() {
        String j;
        boolean kt = false;
        do {
            System.out.println("Nhập id nhân viên cần sửa thông tin:");
            j = input.nextLine();
            if (!isInteger(j)) {
                kt = true;
                System.out.println("id vừa nhập không phải là số, vui lòng nhập lại");
            } else {
                kt = false;
            }

        } while (kt);

        int id1 = Integer.parseInt(j);
        boolean kiemtra = true;
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getId() == id1) {

//				System.out.println("Nhập lại tên nhân viên:");
//				String name=input.nextLine();
//				dsNhanVien.get(i).setName(name);
//				System.out.println("Nhập lại số điện thoại:");
//				String numberPhone=input.nextLine();
//				dsNhanVien.get(i).setNumberPhone(numberPhone);
//				System.out.println("Nhập lại địa chỉ:");
//				String address=input.nextLine();
//				dsNhanVien.get(i).setAddress(address);
//				if(dsNhanVien.get(i) instanceof EmployPartTime) {
//					System.out.println("Nhập lại thời gian làm");
//					int timeHours=Integer.parseInt(input.nextLine());
//					EmployPartTime employPartTime=new EmployPartTime();
//					
//				}
                if (dsNhanVien.get(i) instanceof EmployPartTime) {
                    EmployPartTime employPartTime = new EmployPartTime();
                    employPartTime.setId(id1);
                    System.out.println("Nhập lại tên nhân viên:");
                    String name = input.nextLine();
                    employPartTime.setName(name);
                    System.out.println("Nhập lại số điện thoại:");
                    String numberPhone = input.nextLine();
                    employPartTime.setNumberPhone(numberPhone);
                    System.out.println("Nhập lại địa chỉ:");
                    String address = input.nextLine();
                    employPartTime.setAddress(address);
                    System.out.println("Nhập lại thời gian làm");
                    int timeHours = Integer.parseInt(input.nextLine());

                    employPartTime.setTimeHours(timeHours);
                    employPartTime.setSalary(employPartTime.getSalary(timeHours));
                    dsNhanVien.set(i, employPartTime);

                } else {
                    EmployFullTime employFullTime = new EmployFullTime();
                    employFullTime.setId(id1);
                    System.out.println("Nhập lại tên nhân viên:");
                    String name = input.nextLine();
                    employFullTime.setName(name);
                    System.out.println("Nhập lại số điện thoại:");
                    String numberPhone = input.nextLine();
                    employFullTime.setNumberPhone(numberPhone);
                    System.out.println("Nhập lại địa chỉ:");
                    String address = input.nextLine();
                    employFullTime.setAddress(address);

                    System.out.println("Nhập lại số ngày làm:");
                    int numberWorkDay = Integer.parseInt(input.nextLine());

                    employFullTime.setNumberWorkDay(numberWorkDay);
                    employFullTime.setSalary(employFullTime.getSalary(numberWorkDay));
                    dsNhanVien.set(i, employFullTime);
                }

                kiemtra = false;
                break;
            }
        }
        if (kiemtra) {
            System.err.println("Id vừa nhập không tồn tại");
        }
    }

    // hiển thị thông tin nhân viên
    public void employInfo() {
        System.out.println("Chọn loại nhân viên muôn xem thông tin: 1.part time  2.full time 3.Toàn bộ nhân viên");
        String j = input.nextLine();
        switch (j) {
            case "1": {
                boolean kt = true;
                System.out.println("Danh sách nhân viên part time là:");
                for (Employ employ : dsNhanVien) {
                    if (employ instanceof EmployPartTime) {
                        System.out.println(employ);
                        kt = false;
                    }
                }
                if (kt) {
                    System.out.println("Không có nhân viên part time");
                }

                break;
            }

            case "2": {
                boolean kt = true;
                System.out.println("Danh sách nhân viên full time là:");
                for (Employ employ : dsNhanVien) {
                    if (employ instanceof EmployFullTime) {
                        System.out.println(employ);
                        kt = false;
                    }
                }
                if (kt) {
                    System.out.println("Không có nhân viên full time");
                }

                break;
            }
            default: {

                if (!dsNhanVien.isEmpty()) {
                    System.out.println("Danh sách nhân viên là");
                    for (Employ employ : dsNhanVien) {
                        System.out.println(employ);
                    }
                } else {
                    System.out.println("Danh sách nhân viên rỗng");
                }
                break;
            }

        }

    }

    // lương của nhân viên
    public void luongNhanVien() {
        System.out.println("Chọn loại nhân viên cần tính lương 1. part time 2.full time 3.toàn bộ công ty");
        String j = input.nextLine();

        switch (j) {
            case "1": {
                double tongTien = 0;
                for (Employ employ : dsNhanVien) {
                    if (employ instanceof EmployPartTime) {
                        tongTien += employ.getSalary();
                    }
                }
                System.out.print("Tổng tiền lương công ty chi trả cho nhân viên part time: ");
                System.out.format("%.1f%n", tongTien);

                break;
            }
            case "2": {
                double tongTien = 0;
                for (Employ employ : dsNhanVien) {
                    if (employ instanceof EmployFullTime) {
                        tongTien += employ.getSalary();
                    }
                }
                System.out.print("Tổng tiền lương công ty chi trả cho nhân viên full time: ");
                System.out.format("%.1f%n", tongTien);

                break;
            }

            default: {
                double tongTien = 0;
                for (Employ employ : dsNhanVien) {
                    tongTien += employ.getSalary();
                }
                System.out.print("Tổng tiền lương công ty chi trả cho nhân viên: ");
                System.out.format("%.1f%n", tongTien);

                break;
            }

        }

    }

    // tìm kiếm nhân viên theo họ và tên
    public void timKiem() {
        System.out.println("Nhập họ tên nhân viên mà bạn muốn tìm:");
        String name = input.nextLine();
        boolean kt = true;
        System.out.println("Thông tin nhân viên là:");
        for (Employ employ : dsNhanVien) {
            if (employ.getName().equalsIgnoreCase(name)) {
                System.out.println("name=" + employ.getName() + " id=" + employ.getId());
                kt = false;
            }
        }
        if (kt) {
            System.out.println("Không có nhân viên cần tìm");
        }
    }

    // sắp xếp ds nhân viên theo tên
    public void sortName() {
        Collections.sort(dsNhanVien, new Comparator<Employ>() {
            public int compare(Employ o1, Employ o2) {
                String name1 = o1.getName();
                int i = name1.lastIndexOf(" ");
                String lastName1 = name1.substring(i + 1);
                // Nguyen A

                String name2 = o2.getName();
                int j = name1.lastIndexOf(" ");
                String lastName2 = name2.substring(j + 1);

                return lastName1.compareToIgnoreCase(lastName2);
            }
        ;
        });

		System.out.println("Danh sách nhân viên sau khi sắp xếp:");
        for (Employ employ : dsNhanVien) {
            System.out.println(employ);
        }

    }

    //=========ORDER=======
    //order đồ uống
    public void order() {

        System.out.println("Nhập tên đồ uống cần gọi:");
        String tenDoUong = input.nextLine();
        if (ListNv.isEmpty()) {
            System.err.println("Danh sách đồ uống rỗng");

        } else {
            boolean kt = true;
            for (DOUONG doUong : ListNv) {
                if (doUong.getName().equalsIgnoreCase(tenDoUong)) {
                    System.out.println("Đồ uống đã được chọn");
                    dsDoUongOrder.add(doUong);
                    kt = false;
                    break;
                }
            }
            if (kt) {
                System.err.println("Tên đồ uống không tồn tại");
            }
        }

    }

    //thah toán
    public void thanhToan() {

    }

}
