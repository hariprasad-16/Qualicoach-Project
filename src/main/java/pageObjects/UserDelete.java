package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDelete {

	public WebDriver driver;
	public UserDelete(WebDriver driver)
	{
		this.driver=driver;
	}
	By UsersTab=By.xpath("//a[contains(text(),'Users')]");
	By BrowseUser=By.xpath("//a[contains(text(),'Browse list of users')]");
	By SearchUser=By.id("id_realname");
	By Delete=By.xpath("//img[@title='Delete']");
	By AddFilter=By.id("id_addfilter");
	By DeleteButton=By.xpath("//div/input[@value='Delete']");
	
	public WebElement getUsersTab() {
		return driver.findElement(UsersTab);
	}
	public WebElement getBrowseUser() {
		return driver.findElement(BrowseUser);
	}
	public WebElement getSearchUser() {
		return driver.findElement(SearchUser);
	}
	public WebElement getDelete() {
		return driver.findElement(Delete);
	}
	public WebElement getAddFilter()
	{
		return driver.findElement(AddFilter);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(DeleteButton);
	}
}
