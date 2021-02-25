package JavaProgram;

public class NestedLoopPrimid {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=3;
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(k);
				k=k+3;
			}
			System.out.println();
		}
	}

}
