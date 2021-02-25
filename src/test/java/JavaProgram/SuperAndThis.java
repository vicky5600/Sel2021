package JavaProgram;

public class SuperAndThis extends dataAndCalendar {
	String dataNew = "childvariableData";
	int a=5;
	public void getData()
	{
		System.out.println(super.dataNew);
		System.out.println("child class method Data");
		super.getData();
	}
	
	public void sameClass()
	{
		int a=3;
		System.out.println(a);
		System.out.println(this.a);;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SuperAndThis sT = new SuperAndThis();
		sT.getData();
		sT.sameClass();
		
		
	}

}
