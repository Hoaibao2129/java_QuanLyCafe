package data_quanly_cafe;

public class EmployPartTime extends Employ {
	private int timeHours;

	public EmployPartTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployPartTime(int timeHours) {
		super();
		this.timeHours = timeHours;
	}

	public int getTimeHours() {
		return timeHours;
	}

	public void setTimeHours(int timeHours) {
		this.timeHours = timeHours;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"||timesHours="+timeHours;
	}
	
	public  double getSalary(int timeHours) {
		return(double) timeHours*120000;
	}

	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		super.nhap();
		System.out.println("Nhập thời gian làm:");
		timeHours=Integer.parseInt(input.nextLine());
//		salary=EmployPartTime.getSalary(timeHours);//nếu phương thức là static
		salary=getSalary(timeHours); //viết kiểu này cũng đúng, cho dù có static hay không
	}
	
	

}
