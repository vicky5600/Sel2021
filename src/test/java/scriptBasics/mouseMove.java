package scriptBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mouseMove {
	
	@Test
	public void s1()
	{
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("venk");
		ar.add("Rat");
		ar.add("Ravi");
		int count=0;
		for(int i=0;i<ar.size();i++)
		{
			if(ar.get(i).startsWith("R"))
			{
				count++;
			}
		}
		System.out.println(count);
		
		long a = ar.stream().filter(s->s.startsWith("v")).count();
		System.out.println(a);
	}
	
	@Test
	public void streamS2()
	{
		long t = Stream.of("mouse","center","good").filter(s->s.endsWith("r")).count();
		System.out.println(t);
		Stream.of("mod","swing","bad").sorted().forEach(s->System.out.println(s));
		List<String> s1 = Arrays.asList("da","er","tr","gh");
		List<String> s2 = Arrays.asList("dm","rr","rr","yh");
		List<Integer> in = Arrays.asList(1,2,3,4,6,1,2,5,8);
		Stream<String> s3= Stream.concat(s1.stream(), s2.stream());
	    s3.sorted().forEach(s->System.out.println(s));
	    boolean flag = s2.stream().anyMatch(s->s.contains("dm"));
	    Assert.assertTrue(flag);
	    List<Integer>ints = in.stream().distinct().collect(Collectors.toList());
	    System.out.println(ints);
		
	}

	

	

}
