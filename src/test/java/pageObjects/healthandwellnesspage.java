package pageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class healthandwellnesspage extends BasePage{

	public Properties p=new Properties();
	public healthandwellnesspage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/span[2]")
	WebElement forcorporate;

	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/div/div[1]/a")
	WebElement healthandwellnessplan;

	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement name;

	@FindBy(xpath="//*[@id=\"organizationName\"]")
	WebElement organizationname;
	
	@FindBy(xpath="//*[@id=\"contactNumber\"]")
	WebElement contactnum;

    @FindBy(xpath="//*[@id=\"officialEmailId\"]")
	WebElement emailid;
    
    @FindBy(xpath="//*[@id=\"organizationSize\"]")
	WebElement orgsize;

	@FindBy(xpath="//*[@id=\"organizationSize\"]/option[5]")
	WebElement orgdropdown;

	@FindBy(xpath="//*[@id=\"interestedIn\"]/option[2]")
	WebElement intrstdrop;

    @FindBy(xpath="//*[@id=\"interestedIn\"]")
	WebElement intrestedin;
    
    @FindBy(xpath="//*[@id=\"header\"]/div[2]/div/form/button")
	WebElement schedule;
    
    @FindBy(xpath="/html/body/div[4]/div/div")
    WebElement thankyou; 
    
    @FindBy(xpath="//*[@id=\"header\"]/div[2]/div/h2")
    WebElement scheduledemo;
    
    @FindBy(xpath="//div[text()='THANK YOU']")
    WebElement thankyoudisplayed; 
    
    public void health() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.navigate().back();
    	Thread.sleep(3000);
    	forcorporate.click();
    	healthandwellnessplan.click();
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView()",scheduledemo);

    }
    
    public boolean invaliddetails() throws IOException {
    	FileReader file = new FileReader(".//src//test//resources//config.properties");
        p.load(file);
    	name.clear();
    	name.sendKeys(p.getProperty("name"));
    	organizationname.clear();
        organizationname.sendKeys(p.getProperty("orgname"));
        contactnum.clear();
        contactnum.sendKeys(p.getProperty("mobnum"));
        emailid.clear();
        emailid.sendKeys(p.getProperty("invalidemailid"));
        orgsize.click();
        orgdropdown.click();
        intrstdrop.click();
        intrestedin.click();
        Boolean schedulebutton=schedule.isEnabled();
		return schedulebutton;
    }
  
    public boolean validdetails() throws InterruptedException, IOException {
    	FileReader file = new FileReader(".//src//test//resources//config.properties");
        p.load(file);
    	name.clear();
    	name.sendKeys(p.getProperty("name"));
    	organizationname.clear();
        organizationname.sendKeys(p.getProperty("orgname"));
        contactnum.clear();
        contactnum.sendKeys(p.getProperty("mobnum"));
        emailid.clear();
        emailid.sendKeys(p.getProperty("validemailid"));
        orgsize.click();
        orgdropdown.click();
        intrstdrop.click();
        intrestedin.click();
        Boolean schedulebutton=schedule.isEnabled();
        schedule.click();
		return schedulebutton;
    }
    
    public boolean validatethankyou() throws InterruptedException {
    	Thread.sleep(10000);
    	String expected="THANK YOU";
    	if((thankyoudisplayed.getText().equals(expected))){
    		return true;
    	}else {
    		return false;
    	}
    }


}
