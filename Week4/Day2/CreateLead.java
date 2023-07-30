package week4.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

public class CreateLead extends BaseClass{
	
	@Test(retryAnalyzer= week4.day2.RetryFailedTests.class)
	
	public void run_CreateLead() {

		  // Click Create Lead 
		page.click("//a[text()='Create Lead']");
		  
		// Enter the Company name

		  page.fill("#createLeadForm_companyName", "Testleaf"); 
		  
		  Locator cName = page.locator("#createLeadForm_companyName");
		  
		  cName.clear(); 
		  
		  cName.type("Testleaf");
		  
		  // Enter the First Name 
		  page.type("[id=createLeadForm_firstName]","Rahul");
		  
		  // Enter the last name 
		  page.type(".createLeadForm_lastName","R");
		  
		  //Click Create Lead button 
		  page.click(".smallSubmit");
		  

	}

}
