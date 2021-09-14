package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enroll {

	WebDriver driver=null;

	public Enroll(WebDriver driver) {

		this.driver = driver;
	}
	By Courses=By.xpath("//div/a[@class='transparent_hover']/p");
	By ListOfCourses = By.xpath("//h4[text()='What we offer']");
	By EnrollMe=By.id("id_submitbutton");
	public List<WebElement> getCourses()
	{
		return driver.findElements(Courses);
	}
	public WebElement getEnrollMe()
	{
		return driver.findElement(EnrollMe);
	}
	public WebElement getListOfCourses()
	{
		return driver.findElement(ListOfCourses);
	}
	
}
