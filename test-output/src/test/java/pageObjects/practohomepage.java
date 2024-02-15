package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class practohomepage extends BasePage{

	public practohomepage(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a/div[1]")
	WebElement finddoc;
	
	public void findingdoctors() throws InterruptedException{
		js.executeScript("arguments[0].click()",finddoc);
	}
	

}
