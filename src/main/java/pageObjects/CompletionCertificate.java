package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletionCertificate {

	WebDriver driver=null;

	public CompletionCertificate(WebDriver driver) {

		this.driver = driver;
	}
	By Certificate=By.xpath("//a[contains(text(),'Course Certification')]");
	By ViewCertificate=By.xpath("//div[contains(text(),'ISTQB Certificate')]");
	By Submit=By.xpath("//input[@type='submit']");
	
	public WebElement getCertificate()
	{
		return driver.findElement(Certificate);
	}
	public WebElement getViewCertificate()
	{
		return driver.findElement(ViewCertificate);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(Submit);
	}
	
}
