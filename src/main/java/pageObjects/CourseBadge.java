package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseBadge {

	WebDriver driver=null;

	public CourseBadge(WebDriver driver) {

		this.driver = driver;
	}
	By BadgeAndFeedback=By.xpath("//div[@id='heading7']");
	By ClaimBadge=By.xpath("//div[contains(text(),'Click here to claim your Gold badge')]");
	By FeedBack=By.xpath("//div[contains(text(),'Feedback')]");
	By FeedBackForm=By.xpath("//a[contains(text(),'Answer the questions')]");
	By FQ1=By.xpath("//label[@for='id_multichoice_335_0_1']");
	By FQ2=By.xpath("//label[@for='id_multichoice_336_0_1']");
	By SubmitFeedBack=By.id("id_savevalues");
	
	public WebElement getBadgeAndFeedback()
	{
		return driver.findElement(BadgeAndFeedback);
	}
	public WebElement getClaimBadge()
	{
		return driver.findElement(ClaimBadge);
	}	
	public WebElement getFeedBack()
	{
		return driver.findElement(FeedBack);
	}
	public WebElement getFeedBackForm()
	{
		return driver.findElement(FeedBackForm);
	}
	public WebElement getFQ1()
	{
		return driver.findElement(FQ1);
	}
	public WebElement getFQ2()
	{
		return driver.findElement(FQ2);
	}
	public WebElement getSubmitFeedBack()
	{
		return driver.findElement(SubmitFeedBack);
	}
}
