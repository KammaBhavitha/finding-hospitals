package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.surgeriespage;

public class TC_002_surgeries extends TC_001_finddoctors {
	
	surgeriespage sp;
	@Test(priority=1,groups={"regression","master"})
	public void test_surgeriespage() throws InterruptedException, IOException {
		
			sp=new surgeriespage(driver);
			loger.info("CLICKING ON SURGERIES");
			sp.surgeriesPage();
			
			}
	
	@Test(priority=2,groups={"sanity","master"})
	public void test_popsurgeries() throws IOException {
		sp.getpopsurgeries();
	}
	
	@Test(priority=3,groups={"sanity","master"})
	public void test_getsurgeriespage() throws InterruptedException, IOException {
		loger.info("GETTING ALL THE SURGERIES");
			sp.getallsurgeries();
			}
}
	
	



