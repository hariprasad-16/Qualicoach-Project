package qualicoach;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CompletionCertificate;
import pageObjects.Enroll;
import pageObjects.LoginPage;
import resources.Base;

public class CourseCertificate extends Base {
	WebDriver driver = null;
	private static Logger Log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		Log.info("Landed into the URL Successfully");
	}
	@Test
	public void CourseCertification() throws InterruptedException
	{
		Log.info("Course Certification");
		driver.get(prop.getProperty("Enroll_Course"));
		Actions a=new Actions(driver);
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys(prop.getProperty("CourseUN"));
		login.getPassword().sendKeys(prop.getProperty("CoursePD"));
		login.getLoginButton().click();
		Log.info("User Logged in Successfully");
		Enroll e=new Enroll(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",e.getListOfCourses() );
		List<WebElement> l = e.getCourses();
		ListIterator<WebElement> iter = l.listIterator();
		while(iter.hasNext())
		{
			WebElement eachCourse=(WebElement)iter.next();
			a.moveToElement(eachCourse).build().perform();
			if(eachCourse.getText().equalsIgnoreCase(prop.getProperty("Enroll_CourseName")))
			{
				eachCourse.click();
				break;
			}
		}
		Log.info("Course Selected Successfully");
		CompletionCertificate c=new CompletionCertificate(driver);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView()",c.getViewCertificate());
		Thread.sleep(1000);
		if(c.getViewCertificate().isDisplayed())
		{
			c.getViewCertificate().click();
		}
		else
		{
			c.getCertificate().click();
			c.getViewCertificate().click();
		}
		c.getSubmit().click();
		Log.info("Successfully Downloaded the certificate");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
