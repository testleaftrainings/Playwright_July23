package week2.day1;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle.TypeOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CreateLead {
	@Test
	public void run_TC001() {
		// To maximize the window
		GraphicsDevice gD = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gD.getDisplayMode().getWidth();
		int height = gD.getDisplayMode().getHeight();
		System.out.println(width + "," + height);
		// Initialize Playwright
		Playwright pw = Playwright.create();

		// Launch the browser
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// Open a new page
		Page page = browser.newPage();

		// Maximize the screen
		page.setViewportSize(width, height);

		// Load the URL
		page.navigate("http://leaftaps.com/opentaps/control/main");
		// To get the url
		System.out.println( page.url());
		// To print the title of the page
		System.out.println(page.title());

		// Type the username
		// page.locator("[id='username']").type("demosalesmanager");
		page.type("#username", "demosalesmanager");
		// page.pause();
		// Type the password
		page.locator("#password").type("crmsfa");
		// Click Login
		page.click(".decorativeSubmit");
		// Click CRM/SFA
		// page.setDefaultTimeout(30000);
		page.click("text=CRM/SFA");
		// Click Leads
		page.click("text=Leads");

		// To go back to a page
		page.goBack();
		
		  // Click Create Lead 
		page.click("//a[text()='Create Lead']");
		  
		  //To go forward to a page 
		page.goForward();
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
