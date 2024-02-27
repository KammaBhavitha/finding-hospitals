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
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement searchloc;
	
	@FindBy(xpath="//div[text()='Use my location']")
	WebElement bangloc;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchspeciality;
	
	@FindBy(xpath="//div[text()='Dentist']")
	WebElement dentist;
	 
	@FindBy(xpath="//h2[@class='doctor-name']")
	List<WebElement> docname;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientstories;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']//li[2]")
	WebElement patientstoriesdrop;
	
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']")
	WebElement experience;
	
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']//li[2]")
	WebElement experiencedrop;
	
	@FindBy(xpath="//span[@data-qa-id='all_filters']")
	WebElement allfilters;
	
	@FindBy(xpath="//label[@for='Fees1']")
	WebElement fees;
	
	@FindBy(xpath="//span[@data-qa-id='Available Today_label']")
	WebElement availability;
	
	@FindBy(xpath="//span[@data-qa-id='sort_by_selected']")
	WebElement sorting;
	
	@FindBy(xpath="//span[text()='Experience - High to Low']")
	WebElement sortingdrop;
	
	@FindBy(xpath="//div[text()='AD']")
	WebElement scroll;
	
	
	
	public void speciality() throws InterruptedException {
		searchspeciality.clear();
		searchspeciality.sendKeys("Dentist");
		js.executeScript("arguments[0].click()",dentist);
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
