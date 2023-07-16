package week2.day2;

import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class TakeScreenshot {
	
	@Test
	public void dropDown_TC01() throws InterruptedException {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
//		page.navigate("http://leaftaps.com/opentaps/control/main");
//	//	page.locator("[id='username']").type("demosalesmanager");
//		page.type("#username", "demosalesmanager");
//		page.locator("#password").type("crmsfa");
//		page.click(".decorativeSubmit");
//		page.click("text=CRM/SFA");
//		page.click("a:has-text('Leads')");
//		page.click("//a[text()='Create Lead']");
//		page.fill("#createLeadForm_companyName", "Testleaf"); 
//		Locator cName = page.locator("#createLeadForm_companyName");
//		  
//		  cName.clear(); cName.type("Testleaf");
//		  
//		  cName.fill(""); cName.type("Qeagle");
//		  
//		  // Enter the First Name 
//		  page.type("[id=createLeadForm_firstName]","Ranjini"); // Enter the last name 
//		  page.type("#createLeadForm_lastName","R"); //Click Create Lead button 
//		 // page.locator("#createLeadForm_dataSourceId").selectOption("LEAD_DIRECTMAIL");
//		  Locator sourceDD = page.locator("#createLeadForm_dataSourceId");
//		  Locator optionsDD = sourceDD.locator("option");
//		  List<String> allInnerTexts = optionsDD.allInnerTexts();
//		  for (String string : allInnerTexts) {
//			System.out.println(string);
//		}
//		  page.locator("#createLeadForm_dataSourceId").selectOption(new SelectOption().setIndex(3));
//		  
//		  page.click(".smallSubmit");
		  
		  page.screenshot(new Page.ScreenshotOptions().setFullPage(true)
				  .setPath(Paths.get("snaps/screenshot.png")));
	}
}
