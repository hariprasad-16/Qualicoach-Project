package qualicoach;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import pageObjects.EditProfile;
import pageObjects.LoginPage;
import pageObjects.UserProfile;
import resources.Base;

public class UpdateUserProfile extends Base {
	WebDriver driver = null;
	private static Logger Log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		Log.info("Landed into the URL Successfully");
	}

	@Test
	public void EditUserProfile() {
		
		Log.info("---------------------------------");
		Log.info("Edit User Profile");
		driver.get(prop.getProperty("Update_user_url"));
		Log.info("Landed into the URL Successfully");

		// login page
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys(prop.getProperty("TestUserName"));
		login.getPassword().sendKeys(prop.getProperty("TestUserPassword"));
		login.getLoginButton().click();
		Log.info("Logged In Successfully");
		// click on user picture
		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.getUserPhoto().click();
		Log.info("Landed into the DashBoard Page");
		// click on profile option
		dashboard.getProfileOption().click();

		// click on edit Profile
		UserProfile userProf = new UserProfile(driver);
		userProf.getEditProfile().click();
		
		// Edit the User Profile
		Log.info("Landed into the Edit Profile Page");
		EditProfile editProfile = new EditProfile(driver);
		editProfile.getFirstName().clear();
		editProfile.getFirstName().sendKeys("TestUser");
		editProfile.getLastName().clear();
		editProfile.getLastName().sendKeys("No1");
		Select Email_display_DD = new Select(editProfile.getMailDisplay());
		Email_display_DD.selectByIndex(1);
		editProfile.getCityOrTown().clear();
		editProfile.getCityOrTown().sendKeys("New_York");
		Select countryDropdown = new Select(editProfile.getcountryDropDown());
		countryDropdown.selectByValue("IN");
		Select TimeZone_DD = new Select(editProfile.getTimeZone());
		TimeZone_DD.selectByValue("UTC");
		editProfile.getAdditionalName().click();
		editProfile.getFirstNamePhonetic().clear();
		editProfile.getFirstNamePhonetic().sendKeys("User_first-name-phonetic");
		editProfile.getLastNamePhonetic().clear();
		editProfile.getLastNamePhonetic().sendKeys("User_last-name-phonetic");
		editProfile.getMiddleName().clear();
		editProfile.getMiddleName().sendKeys("Uesr_middle-name");
		editProfile.getAlternateName().clear();
		editProfile.getAlternateName().sendKeys("Test-User-Alternate_Name");
		editProfile.getUpdateProfileButton().click();
		Log.info("User Information Updated Successfully");
		Log.info("---------------------------------");
	}


	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
