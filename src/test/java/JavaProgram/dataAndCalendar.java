package JavaProgram;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dataAndCalendar {
	public String dataNew="Parent data New";
	public void getData()
	{
		System.out.println("Parent method data type");
	}
	
	public void dataFormat()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM:dd:YYYY");
		System.out.println(sdf.format(d));
		Calendar ca = Calendar.getInstance();
		System.out.println(ca.get(Calendar.DATE));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataAndCalendar dat = new dataAndCalendar();
		dat.dataFormat();
		Constructor co = new Constructor(4,5);
		
		
	}

}
