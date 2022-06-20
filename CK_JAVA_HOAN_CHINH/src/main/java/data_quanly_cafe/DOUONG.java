package data_quanly_cafe;

import java.util.Scanner;

public class DOUONG {
	static int cout = 0 ;
    int id ;
    String name;
    String giaTien ;
    String ngayNhap ;
    String tenNhaPhanPhoi ;
    
     public DOUONG() {
        id = ++cout;
    }

    public DOUONG(int id, String name, String giaTien, String ngayNhap, String tenNhaPhanPhoi) {
        this.id = id;
        this.name = name;
        this.giaTien = giaTien;
        this.ngayNhap = ngayNhap;
        this.tenNhaPhanPhoi = tenNhaPhanPhoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getgiaTien() {
        return giaTien;
    }

    public void setgiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getngayNhap() {
        return ngayNhap;
    }

    public void setngayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String gettenNhaPhanPhoi() {
        return tenNhaPhanPhoi;
    }

    public void settenNhaPhanPhoi(String tenNhaPhanPhoi) {
        this.tenNhaPhanPhoi = tenNhaPhanPhoi;
    }

   
    
    public void display(){
        System.out.println(this);
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
//        System.out.println("Nhap id:");
//        id = ++cout;
        
        System.out.println("Nhap ten san pham:");
        name = sc.nextLine();
        
        System.out.println("Nhap gia tien:");
        giaTien =sc.nextLine();
        
        System.out.println("Nhap ten nha phan phoi:");
        tenNhaPhanPhoi = sc.nextLine();
        
        System.out.println("Nhap ngay nhap kho:");
        ngayNhap = sc.nextLine();
    
    }
    public void xuat(){
        
        System.out.format("%-5s %-20s %-15s %-15s %-15s\n",getId(),getName(),getgiaTien(),gettenNhaPhanPhoi(),getngayNhap());
    
    }
    
    
    public String line(){
    return id +","+name+","+ngayNhap+","+tenNhaPhanPhoi+","+giaTien +"\n";
    
    }
    
    @Override
    public String toString() {
        return "NHANVIEN{" + "id=" + id + ", name=" + name + ", giaTien=" + giaTien + ", ngaySinh=" + ngayNhap + ", tenNhaPhanPhoi=" + tenNhaPhanPhoi + '}';
    }
}
