package JavaProgram;

public class singleAndMultiDimentionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		singleAndMultiDimentionalArray a = new singleAndMultiDimentionalArray();
		a.singleDimentional();
		a.multiDimentional();
		a.smallestFromList();

	}
	
	public void singleDimentional()
	{
		int a[] = {1,2,3,4,5,6};
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public void multiDimentional()
	{
		
		int a[][] = {{7,6,3},{7,2,9},{9,7,9}};
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				{
					System.out.print(a[i][j]);
				}
					
			}
			System.out.println();
		}
	}
	
	public void smallestFromList()
	{
		
		int a[][] = {{7,6,3},{7,2,9},{9,7,9}};
		int min=a[0][0];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]<min)
				{
					min=a[i][j];
		
				}
			}
		}
		System.out.println(min);
	}


}
