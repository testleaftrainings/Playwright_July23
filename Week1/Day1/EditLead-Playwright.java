package week1.day2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class EditLead {
	
	@Test
	public void runTC_002() {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch( 
				 new BrowserType.LaunchOptions().setChannel("chrome") .setHeadless(false));
		
		
		  BrowserContext context = browser.newContext( new
		  Browser.NewContextOptions().setRecordVideoDir(Paths.get(""+"videos/")));
		  
		  context.tracing().start(new Tracing.StartOptions() .setScreenshots(true)
		  .setSnapshots(true));
		 
		 
		 
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.locator("#username").type("democsr");
		page.locator("#password").type("crmsfa");
		page.locator("//*[@class='decorativeSubmit']").click();
		page.locator("//a[contains(text(),'CRM/SFA')]").click();
		page.locator("//a[text()='Leads']").click();
		page.locator("//a[text()='Find Leads']").click();
		page.locator("(//span[text()='Advanced']/following::input)[2]").type("Babu");
		page.locator("//button[text()='Find Leads']").click();
		page.locator("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//div/a)[1]").click();
		page.locator("//a[text()='Edit']").click();
		page.locator("#updateLeadForm_companyName").type("TestLeaf");
		page.locator("text=Update").click();
		String text = page.locator("#viewLead_companyName_sp").innerText();
		System.out.println(text);		
		
		
		  context.tracing().stop(new
		  Tracing.StopOptions().setPath(Paths.get("trace.zip"))); page.close();
		  context.close();
		 
		//browser.close();
		
	}
		
	

}
