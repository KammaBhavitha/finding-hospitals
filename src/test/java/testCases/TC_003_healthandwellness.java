package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.healthandwellnesspage;

public class TC_003_healthandwellness extends TC_002_surgeries{
	
	healthandwellnesspage hw;
	@Test(priority=4,groups={"regression","master"})
	public void test_details() {
		try {
		hw=new healthandwellnesspage(driver);
		loger.info("CLICKING ON HEALTH AND WELLNESS");
		hw.health();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=5,groups={"sanity","master"})
	public void test_invaliddetails() {
		try {
			loger.info("VALIDATING SCHEDULE A DEMO FORM WITH INVALID DETAILS");
			Boolean value=hw.invaliddetails();
			Assert.assertEquals(false,value);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=6,groups={"sanity","master"})
	public void test_validdetails() {
		try {
			loger.info("VALIDATING SCHEDULE A DEMO FORM WITH VALID DETAILS");
			Boolean value=hw.validdetails();
			Assert.assertEquals(true,value);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=7,groups={"sanity","master"})
	public void test_validatethankyou() {
		try {
			loger.info("VALIDATING THANKYOU MESSAGE");
			Boolean value=hw.validatethankyou();
			Assert.assertEquals(true,value);
			System.out.println("Thankyou is displayed");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
