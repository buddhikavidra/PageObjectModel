package methods;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.MainPage;


public class Base {

	static WebDriver driver;
	static boolean esist;


	public static void GetBrowser(String URL) {

		WebDriverManager.chromedriver().browserVersion("90").setup();
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--disable-notifications");
		//	coptions.addArguments("--headless");
		Reporter.log("browser started");
		driver = new ChromeDriver(coptions);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void Click(String Xpath) {
		WebElement element1 = driver.findElement(By.xpath(Xpath));
		element1.click();
		System.out.println("Click on " + Xpath);
		Reporter.log("Click on " + Xpath);
	}
	
	public static void Type(String Xpath,String TypeKey) {
		WebElement element1 = driver.findElement(By.xpath(Xpath));
		element1.sendKeys(TypeKey);;
		System.out.println("Type on " + Xpath +"   Value  : "+TypeKey);
		Reporter.log("Type on " + Xpath +"   Value  : "+TypeKey);
	}

	public static String gettext(String Path) {
		WebElement elem = driver.findElement(By.xpath(Path));
		String txt = elem.getText();
		System.out.println(txt);
		return txt;
	}


	public static String GetCurentURL() {
		String strUrl = driver.getCurrentUrl();
		Reporter.log("url is :  "+strUrl);
		return strUrl;
		
	}
	
	

	public static void close() {
		driver.close();
		System.out.println(" driver.close(); ");
		Reporter.log(" driver  closed ");

	}
	
	public static void pause(int low) {


		try {
			Thread.sleep(low);
			Reporter.log(" driver  paused ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String verifyUrl(String URL) {
		String strUrl = driver.getCurrentUrl();
		strUrl.trim();
		if (URL.equals(strUrl)) {
			Reporter.log("value matched with given value   input URL" +URL  +"   pageURL  :"+strUrl);
			System.out.println("value matched with given value   input URL" +URL  +"   pageURL  :"+strUrl);
		}
		else {
			Reporter.log("value not matched with given value   input URL" +URL  +"   pageURL  :"+strUrl);
			System.out.println("value not matched with given value   input URL" +URL  +"   pageURL  :"+strUrl);
		}
		return strUrl;
	}
	
	public static String verifyText(String xpath,String Text) {
		String value="not assigned";
		try {
			WebElement strPrice = driver.findElement(By.xpath(xpath));
			 value = strPrice.getText().trim();
			if (Text.equals(value)) {
				Reporter.log("value matched with given value   input value  :" + Text  +"   existing value  :"+value);
				System.out.println("value matched with given value   input value  :" + Text  +"   existing value  :"+value);
			}
			else {
				Reporter.log("value matched with given value   input value  :" +Text  +"  existing value  :"+value);
				System.out.println("value matched with given value   input value  :" +Text  +"  existing value  :"+value);
			}
			
		} catch (Exception e) {
			value = "not found";
			Reporter.log("not found");
			System.out.println("not found");
		}
		
		return value;
	}
	
	
	public static int Count(String path) {
		List<WebElement> optionCount = driver.findElements(By.xpath(path));
		System.out.println("object count  : "+optionCount.size());
		int cc = optionCount.size();
		Reporter.log(" object count is   : "+cc);
		return cc;
	}
	
}
