package qualicoach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Enroll;
import pageObjects.LoginPage;
import pageObjects.QuizPage;
import resources.Base;

public class AttemptQuiz extends Base {

	WebDriver driver = null;
	private static Logger Log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		Log.info("Landed into the URL Successfully");
	}
	@Test
	public void AttemptQuizTest() throws FileNotFoundException
	{
		Actions a=new Actions(driver);
		Log.info("Attempting Quiz");
		driver.get(prop.getProperty("Attempt_Quiz"));
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys(prop.getProperty("NewUsername"));
		login.getPassword().sendKeys(prop.getProperty("NewPassword"));
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
		Log.info("Entered into the required course");
		QuizPage qp=new QuizPage(driver);
		List<WebElement> module=qp.getAllModules();
		List<WebElement> q=qp.getAllQuiz();
		ListIterator<WebElement> Iterate_Module=module.listIterator();
		ListIterator<WebElement> Iterate_Quiz=q.listIterator();
		while(Iterate_Module.hasNext())
		{
			WebElement eachmod=(WebElement)Iterate_Module.next();
			WebElement eachquiz=(WebElement)Iterate_Quiz.next();
			if(eachquiz.isDisplayed())
			{
				eachquiz.click();
			}
			else
			{
				eachmod.click();
				eachquiz.click();
			}
			qp.getAttemptQuiz().click();
			qp.getStartAttempt().click();
			FileInputStream fis=new FileInputStream("E:\\Automation_Practice\\qualicoach\\src\\main\\java\\resources\\QuizCorrectAnswers.txt");
			
		}
				
		
		
	}
	
}
