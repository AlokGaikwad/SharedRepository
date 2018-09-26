package redBus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

		 

		/*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Date date = new Date();

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

		 

		double currentDate = Integer.parseInt(driver.findElement(By.xpath("//td[contains(@class,'current day')]")).getAttribute("textContent"));

		int newDate = (int) (currentDate +2);

		System.out.println(newDate);

		
		}

	}
