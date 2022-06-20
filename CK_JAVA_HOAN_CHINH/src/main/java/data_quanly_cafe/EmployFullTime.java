package data_quanly_cafe;

public class EmployFullTime extends Employ {
	private int numberWorkDay;

	public EmployFullTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployFullTime(int numberWorkDay) {
		super();
		this.numberWorkDay = numberWorkDay;
	}

	public int getNumberWorkDay() {
		return numberWorkDay;
	}

	public void setNumberWorkDay(int numberWorkDay) {
		this.numberWorkDay = numberWorkDay;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"||numberWorkDay=" +numberWorkDay;
	}
	
	public  double getSalary(int numberWorkDay) {
		return (double) numberWorkDay*1500000;
	}

	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		super.nhap();
		System.out.println("Nhập số ngày làm:");
		numberWorkDay=Integer.parseInt(input.nextLine());
		salary=getSalary(numberWorkDay);
	}
	
	
	
	

}
