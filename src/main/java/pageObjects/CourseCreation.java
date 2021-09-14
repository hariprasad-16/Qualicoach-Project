package pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CourseCreation  {

	public WebDriver driver;
	public 	Properties prop;
	public CourseCreation(WebDriver driver) 
	{
		this.driver=driver;
		
	}
	By CategoryList=By.className(".float-left.categoryname");
	By CourseTab=By.xpath("//div/ul[@class='nav nav-tabs']/li/a[contains(text(),'Courses')]");
	By ManageCourse=By.xpath("//a[contains(text(),'Manage courses and categories')]");
	By CreateCategory=By.xpath("//a[contains(text(),'Create new category')]");
	By ParentCategory=By.id("id_parent");
	By CategoryName=By.cssSelector("input[id='id_name']");
	By CategoryButton=By.cssSelector("input[id='id_submitbutton']");
	By SelectCategory=By.xpath("//a[contains(text(),'Hari')]");
	By CreateNewCourse=By.xpath("//a[contains(text(),'Create new course')]");
	By CourseName=By.id("id_fullname");
	By CourseShortName=By.id("id_shortname");
	By SaveCourse=By.id("id_saveanddisplay");
	
	public WebElement getCourseTab() {
		return driver.findElement(CourseTab);
	}
	public WebElement getManageCourse() {
		return driver.findElement(ManageCourse);
	}
	public WebElement getCreateCategory() {
		return driver.findElement(CreateCategory);
	}
	public WebElement getParentCategory() {
		return driver.findElement(ParentCategory);
	}
	public WebElement getCategoryName() {
		return driver.findElement(CategoryName);
	}
	public WebElement getCategoryButton() {
		return driver.findElement(CategoryButton);
	}
	public WebElement getSelectCategory() {
		return driver.findElement(SelectCategory);
	}
	public WebElement getCreateNewCourse() {
		return driver.findElement(CreateNewCourse);
	}
	public WebElement getCourseName() {
		return driver.findElement(CourseName);
	}
	public WebElement getCourseShortName() {
		return driver.findElement(CourseShortName);
	}
	public WebElement getSaveCourse() {
		return driver.findElement(SaveCourse);
	}
	public List<WebElement> getCategoryList() {
		return driver.findElements(CategoryList);
	}
	
	
	
	
	
	
}