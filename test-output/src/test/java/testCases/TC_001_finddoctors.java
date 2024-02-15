package testCases;

import org.testng.annotations.Test;

import pageObjects.doctorspage;
import pageObjects.practohomepage;
import testBase.BaseClass;

public class TC_001_finddoctors extends BaseClass{

	  
		practohomepage php;
		doctorspage dp;
		
		@Test(priority=-1,groups={"regression ","master"})
		public void test_practohomepage() {
			try {
				loger.info("CLICKING ON FIND DOCTORS");
				php=new practohomepage(driver);
				php.findingdoctors();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test(priority=0,groups={"sanity","master"})
		public void test_doctorspage() {
			try {
				dp=new doctorspage(driver);
				loger.info("CLICKING ON DENTIST");
				dp.speciality();
				loger.info("APPLYING THE FILTERS TO FIND DOCTORS");
				dp.applyingfilter();
				loger.info("GETTING TOP FIVE DENTISTS");
				dp.getdocname();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
