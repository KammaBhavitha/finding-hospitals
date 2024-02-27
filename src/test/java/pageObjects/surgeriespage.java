package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.Apachii;

public class surgeriespage extends BasePage{

	public surgeriespage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	Actions act=new Actions(driver);
	
	@FindBy(xpath="//div[text()='Surgeries']")
	WebElement surgery;
	
	@FindBy(xpath="//div[@class='SurgicalSolutions-module_ailmentItemWrapper__Krx-u']")
	List<WebElement> popsurgeries;
	
	@FindBy(xpath="//div[@class='OurDepartments-module_item__jmn2- shrink']")
	List<WebElement> surgeriesnames;
	
	@FindBy(xpath="//div[@style='width: 11%;']")
	List<WebElement> allsurgerynames;
	
	@FindBy(xpath="//div[@class='BaseModal-module_overlay__4K5ho BaseModal-module_overlayOpen__75dJG ScreenCenteredModal-module_overlay__-Y4uM']")
	WebElement cross;
	
	@FindBy(xpath="//div[@class='BaseModal-module_content__QRGf- ScreenCenteredModal-module_content__46Djy w-[792px]']")
	WebElement getss;
	
	
	public void surgeriesPage() {
		surgery.click();
	}
	
	public void getpopsurgeries() throws IOException {
		
		act.sendKeys(Keys.PAGE_DOWN).perform();
		System.out.println("Top popular surgeries are:");
		System.out.println("---------------------------");
		int k=0;
		for(int i=0;i<popsurgeries.size();i++) {
			String name=popsurgeries.get(i).getText();
			System.out.println(name);
			Apachii.writeInExcel("popular_surgeries" ,k  , 0 ,name);
			k++;
		}
	System.out.println();
	}
	
	public void getallsurgeries() throws InterruptedException, IOException {

		act.sendKeys(Keys.PAGE_DOWN).perform();
		int l=0;
		for(int i=0;i<surgeriesnames.size();i++) {
			String s=surgeriesnames.get(i).getText();
			System.out.println(surgeriesnames.get(i).getText());
			System.out.println("------------------");
		    js.executeScript("arguments[0].click()",surgeriesnames.get(i));
			Thread.sleep(3000);
			
		 File SrcFile= getss.getScreenshotAs(OutputType.FILE);
			 File destFile= new File("C:\\Users\\2303458\\eclipse-workspace\\hackproject\\screenshots\\surgeries\\surgeries"+i+".png");
			 try {
				 FileUtils.copyFile(SrcFile, destFile);
			 }catch(IOException e){
				 e.printStackTrace();
			 }
				int j=0;
				for(int k=0; k<allsurgerynames.size()+1; k++) {
					if(k==0) {
				   Apachii.writeInExcel("all_surgeries" , k, l,s);
					}
					else{
					Apachii.writeInExcel("all_surgeries" , k, l,allsurgerynames.get(j).getText());
					System.out.println(allsurgerynames.get(j).getText());
					j++;
				}	
				}
			l++;
			js.executeScript("arguments[0].click()",cross);
			System.out.println();
		}	
		
		}
		
}

