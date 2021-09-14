package qualicoach;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CourseCreation;
import pageObjects.LoginPage;
import resources.Base;

public class CreateCourse extends Base {

	
	private static Logger Log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void testLogin() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void CreateNewCourse() throws IOException
	{
		
		
		Log.info("---------------------------------");
		Log.info("New Course Creation");
		driver.get(prop.getProperty("Admin_Url"));
		LoginPage l=new LoginPage(driver);
		l.getUserName().sendKeys(prop.getProperty("AdminUserName"));
		l.getPassword().sendKeys(prop.getProperty("AdminUserPassword"));
		l.getLoginButton().click();
		Log.info("Logged In Successfully");
		CourseCreation co=new CourseCreation(driver);
		co.getCourseTab().click();
		Log.info("Clicked on Course Tab");
		co.getManageCourse().click();
		co.getCreateCategory().click();
		Select ParentCategory_DD = new Select(co.getParentCategory());
		ParentCategory_DD.selectByIndex(0);
		co.getCategoryName().sendKeys(prop.getProperty("Course_Category_name"));
		co.getCategoryButton().click();
		Log.info("New Course Category is created");
		List<WebElement> Clist=co.getCategoryList();
		ListIterator<WebElement>iter=Clist.listIterator();
		while(iter.hasNext())
		{
			WebElement eachCategory=(WebElement)iter.next();
			if(eachCategory.getText().equalsIgnoreCase(prop.getProperty("Course_Category_name")));
			{
				eachCategory.click();
				break;
			}
			
		}
		co.getCreateNewCourse().click();
		co.getCourseName().sendKeys(prop.getProperty("Course_name"));
		co.getCourseShortName().sendKeys(prop.getProperty("Course_short_name"));
		co.getSaveCourse().click();
		Log.info("New Course is Created");
		Log.info("---------------------------------");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
//