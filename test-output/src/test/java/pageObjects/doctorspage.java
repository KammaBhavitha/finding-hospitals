package pageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Apachii;

public class doctorspage extends BasePage{
	public Properties p=new Properties();
	public doctorspage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")
	WebElement searchloc;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[1]")
	WebElement bangloc;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	WebElement searchspeciality;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]")
	WebElement dentist;
	 
	@FindBy(xpath="//h2[@class='doctor-name']")
	List<WebElement> docname;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]")
	WebElement patientstories;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]/ul/li[2]/span")
	WebElement patientstoriesdrop;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]")
	WebElement experience;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/ul/li[2]")
	WebElement experiencedrop;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[4]/span/span")
	WebElement allfilters;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[2]/div/label[2]")
	WebElement fees;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[3]/div/label[3]")
	WebElement availability;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/span")
	WebElement sorting;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li[2]")
	WebElement sortingdrop;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[2]")
	WebElement scroll;
	
	
	
	public void speciality() throws InterruptedException {
		searchspeciality.clear();
		searchspeciality.sendKeys("Dentist");
		dentist.click();
	}
    
	public void applyingfilter() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()",patientstories);
		js.executeScript("arguments[0].click()",patientstoriesdrop);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()",experience);
		js.executeScript("arguments[0].click()",experiencedrop);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()",allfilters);
		js.executeScript("arguments[0].click()",fees);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()",availability);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()",sorting);
		js.executeScript("arguments[0].click()",sortingdrop);
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView",scroll);
		}
	
	public void getdocname() throws IOException {
		FileReader file = new FileReader(".//src//test//resources//config.properties");
        p.load(file);
		System.out.println("The top5 dentists are:");
		System.out.println("---------------------");
		int k=0;
		for(int i=0;i<5;i++) {
			System.out.println(docname.get(i).getText());
			Apachii.writeInExcel("dentist_name" ,k  , 0 ,docname.get(i).getText());
			k++;
		}
		System.out.println();
		driver.navigate().to(p.getProperty("appURL"));
		
	}
}
