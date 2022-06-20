package data_quanly_cafe;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Employ {
	private int id;
	private String name;
	private String numberPhone;
	private String address;
	protected double salary;
	
	Scanner input=new Scanner(System.in);
	static ArrayList<Employ> dsNhanVien=new ArrayList<Employ>();
	
	public boolean isInteger(String n) {// hàm kiểm tra có phải là số nguyên
		try {
			Integer.parseInt(n);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Employ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employ(int id, String name, String numberPhone, String address, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.numberPhone = numberPhone;
		this.address = address;
		this.salary = salary;
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

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		NumberFormat numberFormat=NumberFormat.getInstance();
		String salary1=numberFormat.format(salary);
		
		return "id=" + id + "||name=" + name + "|| numberPhone=" + numberPhone + "|| address=" + address
				+ "|| salary=" + salary1;
		
	}
	
	public void nhap() {
		boolean kt=false;
		do {
			System.out.println("Nhập id:");
			id=Integer.parseInt(input.nextLine());
			for (Employ employ : dsNhanVien) {
				if(id==employ.getId()) {
					kt=true;
					System.out.println("id đã trùng, vui lòng nhập lại:");
					break;
				}else {
					kt=false;
				}
			}
		} while (kt);
		System.out.println("Nhập tên nhân viên:");
		name=input.nextLine();
		System.out.println("Nhập số điện thoại:");
		numberPhone=input.nextLine();
		System.out.println("Nhập địa chỉ:");
		address=input.nextLine();
	}
	
	

}

