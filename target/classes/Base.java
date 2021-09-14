package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public 	Properties prop;
	public WebDriver driver=null;
	
	public WebDriver initializeDriver() throws IOException  {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("E:\\Automation_Practice\\qualicoach\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:/Chrome Driver/chromedriver_win32/chromedriver.exe" );
			driver=new ChromeDriver();
		}
		return driver;
	}
	public void takeScreenshot(String testcase,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testcase+".png";
		FileUtils.copyFile(source,new File(destFile));
	}
}


	


