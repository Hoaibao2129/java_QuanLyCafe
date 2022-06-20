package data_quanly_cafe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main_TruyVan truyVan = new Main_TruyVan();
        Scanner input = new Scanner(System.in);
        boolean kt = true;

        while (kt) {
            System.out.println("Mời lựa chọn chức năng:\n" + "1.Quản lý nhà cung cấp \n" + "2.Quản lý đồ uống\n"
                    + "3.Quản lý nhân viên\n" + "0.Thoát");
            String j = input.nextLine();
            switch (j) {
                case "1": {
                    boolean kt1 = true;
                    do {
                        System.out.println("Mời chọn chức năng");
                        System.out.println("1.Thêm nhà cung cấp ");
                        System.out.println("2.Xem thông tin nhà cung cấp ");
                        System.out.println("3.Xóa nhà cung cấp ");
                        System.out.println("4.Sửa nhà cung cấp ");
                        System.out.println("5.Tìm kiếm nhà cung cấp ");
                        System.out.println("6.Sắp xếp theo tên nhà cung cấp ");
                        System.out.println("0.Thoát quản lý nhà cung cấp ");
                        String i = input.nextLine();
                        switch (i) {
                            case "1":
                                truyVan.themNhaCungCap();
                                System.out.println();
                                break;
                            case "2":
                                truyVan.hienThiDanhSachNhaCungCap();
                                System.out.println();
                                break;
                            case "3":
                                truyVan.XoaNhaCungCap();
                                System.out.println();
                                break;
                            case "4":
                                truyVan.SuaNhaCungCap();
                                System.out.println();
                                break;
                            case "5":
                                truyVan.timKiemNhaCungCap();
                                System.out.println();
                                break;
                            case "6":
                                truyVan.sapXepTheoTenNhaCungCap();
                                System.out.println();
                                break;
                            default:
                                kt1 = false;

                                break;
                        }

                    } while (kt1);
                    break;
                }
                case "2": {
                    boolean kt1 = true;
                    do {
                        System.out.println("Nhập vào lựa chọn của bạn");
                        System.out.println("1: Thêm sản phẩm\n");
                        //System.out.println("2: Lưu sản phẩm\n");
                        System.out.println("2: Sửa sản phẩm\n");
                        System.out.println("3: Xóa sản phẩm\n ");
                        System.out.println("4: Xuất thông tin sản phẩm\n");
                        System.out.println("5: Tìm kiếm đồ uống\n");
                        System.out.println("6: Sắp xếp đồ uống theo tên\n");
                        System.out.println("0: Thoát quản lý sản phẩm");
                        String i = input.nextLine();
                        switch (i) {
                            case "1": {
                                truyVan.themDoUong();
                                System.out.println();
                                break;
                            }
//					case "2": {
//						truyVan.save();
//						break;
//					}
                            case "2": {
                                truyVan.suaDoUong();
                                break;
                            }
                            case "3": {
                                truyVan.xoaDoUong();
                                break;
                            }
                            case "4": {
                                truyVan.xuatDS();
                                break;
                            }
                            case  "5": {
                            truyVan.timKiemDU();
                            break;
                            }
                            case  "6":{
                            truyVan.sapxepDU();
                            break;
                            }
                            default: {
                                kt1 = false;
                                break;
                            }
                        }
                        ;
                    } while (kt1);
                    break;
                }

                case "3": {
                    boolean kt1 = true;
                    do {
                        System.out.println("Mời chọn chức năng:");
                        System.out.println("1.Nhập danh sách nhân viên:");
                        System.out.println("2.Xem thông tin nhân viên:");
                        System.out.println("3.Sửa thông tin nhân viên:");
                        System.out.println("4.Tính tiền lương nhân viên:");
                        System.out.println("5.Tìm kiếm thông tin nhân viên:");
                        System.out.println("6.Sắp xếp nhân viên theo tên");
                        System.out.println("0.Thoát quản lý nhân viên");
                        String key = input.nextLine();

                        switch (key) {
                            case "1": {
                                truyVan.nhapDsNhanVien();
                                System.out.println("\n");

                                break;
                            }
                            case "2": {
                                truyVan.employInfo();
                                System.out.println("\n");
                                break;
                            }
                            case "3": {
                                truyVan.suaThongTinNhanVien();
                                System.out.println("\n");
                                break;
                            }
                            case "4": {
                                truyVan.luongNhanVien();
                                ;
                                System.out.println("\n");
                                break;
                            }
                            case "5": {
                                truyVan.timKiem();
                                ;
                                System.out.println("\n");
                                break;
                            }
                            case "6": {
                                truyVan.sortName();
                                ;
                                System.out.println("\n");
                                break;
                            }

                            default: {

                                kt1 = false;
                                break;
                            }
                        }

                    } while (kt1);
                    break;
                }

                default: {
                    kt = false;
                    System.out.println("Đã thoát chương trình");
                    break;
                }
            }

        }
        ;

    }
}
