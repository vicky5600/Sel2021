package JavaProgram;

import java.sql.Array;

public class stringProgram {
	
	public void stringJavaP()
	{
		String s = "madam";
		System.out.println(s.charAt(2));;
		System.out.println(s.indexOf("d"));;
		System.out.println(s.substring(2, 4));
		System.out.println(s.substring(3));
		System.out.println(s.concat("is good"));
		System.out.println(s.toUpperCase());
		System.out.println(s.trim());
		String[] ar = s.split("d");
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(s.replace(s, "p"));
		String t="";
		for(int i=s.length()-1;i>=0;i--)
		{
			t=t+s.charAt(i);
		}
		System.out.println(t);
		if(t.equals(s))
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("String not a palindrome");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		stringProgram st = new stringProgram();
		st.stringJavaP();

	}

}
