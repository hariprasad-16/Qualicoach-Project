package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateUser {

	public WebDriver driver;
	public CreateUser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By UsersTab=By.xpath("//a[contains(text(),'Users')]");
	By AddNewUser=By.xpath("//a[contains(text(),'Add a new user')]");
	By UserName=By.id("id_username");
	By FirstName=By.id("id_firstname");
	By SurName=By.id("id_lastname");
	By EmailId=By.id("id_email");
	By NewPassword= By.xpath("//em[contains(text(),'Click to enter text')]");
	By PasswordText=By.id("id_newpassword");
	By SubmitButton=By.cssSelector("input[id='id_submitbutton']");
	
	
	
	
	
	public WebElement getUsersTab() {
		return driver.findElement(UsersTab);
	}
	public WebElement getAddNewUser() {
		return driver.findElement(AddNewUser);
	}
	public WebElement getUserName() {
		return driver.findElement(UserName);
	}
	public WebElement getFirstName() {
		return driver.findElement(FirstName);
	}
	public WebElement getSurName() {
		return driver.findElement(SurName);
	}
	public WebElement getEmailId() {
		return driver.findElement(EmailId);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(SubmitButton);
	}
	public WebElement getNewPassword() {
		return driver.findElement(NewPassword);
	}
	public WebElement getPasswordText() {
		return driver.findElement(PasswordText);
	}
}
