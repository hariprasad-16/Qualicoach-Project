package qualicoach;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class UserLogin extends Base {

	
	WebDriver driver = null;
	private static Logger Log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		Log.info("Landed into the URL Successfully");
	}
	@Test
	public void Login()
	{
		driver.get(prop.getProperty("Login_Url"));
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys(prop.getProperty("TestUserName"));
		login.getPassword().sendKeys(prop.getProperty("TestUserPassword"));
		login.getLoginButton().click();
		Log.info("Logged In Successfully");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
