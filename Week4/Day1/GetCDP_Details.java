package week4.day1;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GetCDP_Details {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setArgs(Arrays.asList("--remote-debugging-port=9222"))
				.setChannel("chrome")
				.setHeadless(false));
		// Open a new page
		Page page = browser.newPage();

		// Load the URL
		page.navigate("http://leaftaps.com/opentaps/control/main");

		// Type the username
		// page.locator("[id='username']").type("demosalesmanager");
		page.type("#username", "demosalesmanager");

		// Type the password
		page.locator("#password").type("crmsfa");
		// Click Login
		page.click(".decorativeSubmit");
		page.click("text=CRM/SFA");
		// Click Leads
		page.click(".Leads");

		
		// Click Create Lead 
		page.click("//a[text()='Create Lead']");

		
		// Enter the Company name
		
		page.fill("#createLeadForm_companyName", "Testleaf"); 
		//page.pause();

		Locator cName = page.locator("#createLeadForm_companyName");
		
		cName.clear(); cName.type("Testleaf");
		

		cName.fill(""); cName.type("Qeagle");

		// Enter the First Name 
		page.type("[id=createLeadForm_firstName]","Ranjini"); // Enter the last name 
		page.type("#createLeadForm_lastName","R"); //Click Create Lead button 
		page.click(".smallSubmit");


	}

}
