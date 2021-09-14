package qualicoach;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateUser;
import pageObjects.LoginPage;
import resources.Base;

public class CreateNewUser extends Base {

	//log
	private static Logger Log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void NewUserCreation() {
		Log.info("---------------------------------");
		Log.info("New User Creation");
		driver.get(prop.getProperty("Admin_Url"));
		Log.info("Landed Into the URL successfully");
		LoginPage l=new LoginPage(driver);
		Log.info("Landed Into LogIn Page Successfully");
		l.getUserName().sendKeys(prop.getProperty("AdminUserName"));
		l.getPassword().sendKeys(prop.getProperty("AdminUserPassword"));
		l.getLoginButton().click();
		Log.info("Logged In Successfully");
		CreateUser c=new CreateUser(driver);
		c.getUsersTab().click();
		Log.info("Clicked On User Tab");
		c.getAddNewUser().click();
		Log.info("Clicked On Add New User Tab");
		c.getUserName().sendKeys(prop.getProperty("NewUsername"));
		c.getNewPassword().click();
		c.getPasswordText().sendKeys(prop.getProperty("NewPassword"));
		c.getFirstName().sendKeys(prop.getProperty("UserFN"));
		c.getSurName().sendKeys(prop.getProperty("UserLN"));
		c.getEmailId().sendKeys(prop.getProperty("UserMailid"));
		Log.info("Successfully filled the user creation form");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		c.getSubmitButton().click();
		Log.info("New User is Created");
		Log.info("---------------------------------");

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

	
}
