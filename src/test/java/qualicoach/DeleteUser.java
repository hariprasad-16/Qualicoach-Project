package qualicoach;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UserDelete;
import resources.Base;

public class DeleteUser extends Base {

	//log
	private static Logger Log= LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void UserDeletion() {
		Log.info("---------------------------------");
		Log.info("Deleting User");
		driver.get(prop.getProperty("Admin_Url"));
		Log.info("Landed Into the URL successfully");
		LoginPage l=new LoginPage(driver);
		Log.info("Landed Into LogIn Page Successfully");
		l.getUserName().sendKeys(prop.getProperty("AdminUserName"));
		l.getPassword().sendKeys(prop.getProperty("AdminUserPassword"));
		l.getLoginButton().click();
		Log.info("Logged In Successfully");
		UserDelete u=new UserDelete(driver);
		u.getUsersTab().click();
		Log.info("Clicked On User Tab");
		u.getBrowseUser().click();
		Log.info("Clicked On Browse List Of User");
		u.getSearchUser().sendKeys(prop.getProperty("UserFN")+" "+prop.getProperty("UserLN"));
		u.getAddFilter().click();
		Log.info("Entered the User Name in search box and clicked on Filter");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",u.getDelete() );
		u.getDelete().click();
		Log.info("Clicked On Delete");
		u.getDeleteButton().click();
		Log.info("User Deleted Successfully");
		Log.info("---------------------------------");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
