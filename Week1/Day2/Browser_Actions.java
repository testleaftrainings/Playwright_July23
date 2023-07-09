package week1.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Browser_Actions {

	@Test
	public void runBrowser_Actions() {

		// Initialize Playwright
		Playwright pw = Playwright.create();
		// Launch the browser
		/*
		 * BrowserType browserType = pw.chromium(); Browser browser =
		 * browserType.launch();
		 */
		Browser browser = pw.chromium()
				.launch((new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
		// Open a new Page
		Page page = browser.newPage();
		// Load the URL
		page.navigate("http://leaftaps.com/opentaps/control/main");

		/*
		 * Locators 
		 * text 
		 * css (more of css) 
		 * id, classname
		 */
		// Find the username and enter the value
		page.locator("id=username").type("Demosalesmanager");
		// Find the password and enter the value
		page.locator("id=password").type("crmsfa");
		// Find the login and click
		page.locator(".decorativeSubmit").click();
		// Click CRM/SFA
		page.locator("text=CRM/SFA").click();
		// Click Leads Tab
		//page.locator("text=Leads").click();
		page.locator("//a[text()='Leads']").click();
		  // Click Create Lead
		page.locator("text=Create Lead").click(); 
		  // Type Company Name, First Name and Last Name
		page.locator("id=createLeadForm_companyName").type("TestLeaf");
		page.locator("id=createLeadForm_firstName").type("Babu");
		page.locator("id=createLeadForm_lastName").type("Manickam");
		  // Click Create Lead Button 
		page.locator(".smallSubmit").click();
		  // Print the status of the created lead 
		String status = page.locator("#viewLead_statusId_sp").innerText();
		System.out.println(status);
		  
		 

	}

}
