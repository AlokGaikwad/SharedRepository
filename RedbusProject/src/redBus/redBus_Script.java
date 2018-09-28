package redBus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class redBus_Script {
	
	

	public static void main(String[] args) throws InterruptedException
	{
		/*ChromeOptions Options = new ChromeOptions();

		Options.addArguments("---enable-notifications");*/

		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.com");

		driver.manage().window().maximize();

		 

		WebElement popUp = driver.findElement(By.xpath("//div[@id='popup' and @style ='display: block;']//div[@id='go']"));

		popUp.click();

		 

		WebElement Location = driver.findElement(By.xpath("//div[contains(@id,'geolocation_dd')]"));

		Location.click();

		 

		List<WebElement> locatns = driver.findElements(By.xpath("//div[contains(@id,'home-lang')]//ul//li//span//span"));

		for(WebElement L:locatns)

		{

		String listoflocatns = L.getAttribute("textContent").trim();

		System.out.println(listoflocatns);

		if(listoflocatns.equals("Others"))

		{

		L.click();

		break;

		}

		}

		 Thread.sleep(5000);

		WebElement from = driver.findElement(By.xpath("//input[contains(@id,'src')]"));

		from.sendKeys("Mumbai");

		Thread.sleep(2000);

		List<WebElement> fromLocationbox = driver.findElements(By.xpath(("//ul[contains(@class,'autoFill')]//li")));

		for(WebElement fLocation:fromLocationbox)

		{

		String fromL = fLocation.getAttribute("textContent").trim();

		System.out.println(fromL);

		if (fromL.equals("Mumbai Airport"))
		{
		fLocation.click();
		break;
		}
		}

		Thread.sleep(5000);

		 

		WebElement to = driver.findElement(By.id("dest"));

		to.sendKeys("Bangalore");

		Thread.sleep(2000);

		List<WebElement> toLocationbox = driver.findElements(By.xpath("//ul[contains(@class,'autoFill')]//li"));

		for(WebElement tLocation:toLocationbox)

		{

		String toL = tLocation.getText();

		System.out.println(toL);

		if(toL.equals("Bangalore Intl Airport"))

		{

		tLocation.click();

		break;

		}

		}

		 

		Thread.sleep(5000);

		 

		DateFormat dateFormat = new SimpleDateFormat("dd");

		/*Date date = new Date();
		
		String systemdateandtime= dateFormat.format(date);

		System.out.println("Current date and time: --- "+systemdateandtime);*/

		try

		{

			WebElement calendarVisible = driver.findElement(By.xpath("//*[contains(@class,'rb-calendar')]"));

		    String classname= calendarVisible.getAttribute("class");

		    System.out.println("Calendar is visible");

		}

		 

		catch(Exception e)

		{

		WebElement fromcalendar = driver.findElement(By.id("onward_cal"));

		fromcalendar.click();

		System.out.println("Calendar forcefully opened");

		}
		
		int currentDate = Integer.parseInt(driver.findElement(By.xpath("//td[contains(@class,'current day')]")).getAttribute("textContent"));
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DAY_OF_MONTH, 2);
		
		String JStartdate = dateFormat.format(cal.getTime());

		System.out.println("Journey start date :" + JStartdate);
		
		//System.out.println("CurrentDate: " dateFormat.format(cal.getTime()));

		/*int newDate = (int) (currentDate +2);

		System.out.println(newDate);*/
		
		try
		{
		WebElement jStartdate = driver.findElement(By.xpath("//div[contains(@id,'rb-calendar_onward_cal')]//following-sibling::td[contains(text(),'"+JStartdate+"')]"));
		
		jStartdate.click();
		
		System.out.println("New Journey date selected");
		}
		
		catch(Exception e)
		{
			
			System.out.println("Journey date not selected.\n"+e.getMessage());
		}
		
		WebElement openReturncal = driver.findElement(By.xpath("//label[contains(@class,'db text-trans-uc')]"));
		openReturncal.click();

		cal.add(Calendar.DAY_OF_MONTH, 5);
		String JEnddate = dateFormat.format(cal.getTime());
		
		System.out.println(JEnddate);
		
		try
		{
		WebElement jEnddate = driver.findElement(By.xpath("//div[contains(@id,'rb-calendar_onward_cal')]//following-sibling::td[contains(text(),'"+JEnddate+"')]"));
		
		jEnddate.click();
		
		System.out.println("Return journey date selected");
		}
		catch(Exception ex)
		{
			System.out.println("Return Journey date not selected.\n" + ex.getMessage());
		}
		
		WebElement searchBus = driver.findElement(By.className("fl button"));
		searchBus.click();
		
		
		}

	}
