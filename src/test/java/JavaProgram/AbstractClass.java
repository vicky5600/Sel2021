package JavaProgram;

public class AbstractClass extends AbstractJava{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractClass aC  = new AbstractClass();
		aC.aeroPlane();
		aC.bike();
		aC.car();
		
	}

	@Override
	public void aeroPlane() {
		// TODO Auto-generated method stub
		System.out.println("AeroPlane");
	}

}
