package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizPage {
	public WebDriver driver;
	public QuizPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By AllQuiz=By.xpath("//div[contains(text(),'Quiz')]");
	By AllModules=By.xpath("//li[@class='allsectionnames']/a[contains(text(),'Mod')]");
	By AttemptQuiz=By.xpath("//input[@value='Attempt quiz now']");
	By StartAttempt=By.xpath("//input[@value='Start attempt']");
	By OptionsList=By.xpath("//label/span[@lang='EN-GB']");
	By Next=By.xpath("//input[@value='Next page']");
	By FinishQuiz=By.xpath("//input[@value='Finish attempt ...']");
	
	
	public List<WebElement> getAllQuiz() {
		return driver.findElements(AllQuiz);
	}
	public List<WebElement> getAllModules() {
		return driver.findElements(AllModules);
	}
	public WebElement getAttemptQuiz() {
		return driver.findElement(AttemptQuiz);
	}
	public WebElement getStartAttempt() {
		return driver.findElement(StartAttempt);
	}
	public WebElement getNext() {
		return driver.findElement(Next);
	}
	public WebElement getFinishQuiz() {
		return driver.findElement(FinishQuiz);
	}
}
