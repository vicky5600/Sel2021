package JavaProgram;

public class interfaceExample implements trafficLights, trainSignalLights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trafficLights rT = new interfaceExample();
		rT.greenSignal();
		rT.redSignal();
		rT.yellowSignal();
		trainSignalLights train = new interfaceExample();
		train.trainGreenSignal();
		train.trainRedSignal();
		interfaceExample local = new interfaceExample();
		local.shipAirTrafficLocal();

	}
	
	public void shipAirTrafficLocal()
	{
		System.out.println("shipAirTrafficLocal");
	}

	public void trainRedSignal() {
		// TODO Auto-generated method stub
		System.out.println("trainRedSignal");
		
	}

	public void trainGreenSignal() {
		// TODO Auto-generated method stub
		System.out.println("trainGreenSignal");
		
	}

	public void greenSignal() {
		// TODO Auto-generated method stub
		System.out.println("greeenSignal");
		
	}

	public void redSignal() {
		// TODO Auto-generated method stub
		System.out.println("redSignal");
	}

	public void yellowSignal() {
		// TODO Auto-generated method stub
		System.out.println("yellowSignal");
	}

}
