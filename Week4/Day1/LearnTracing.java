package week4.day1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class LearnTracing {

	public static void main(String[] args) {
	
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch( 
				 new BrowserType.LaunchOptions().setChannel("chrome") .setHeadless(false));
		
		BrowserContext context = browser.newContext();
		
		//Enable Tracing
		
		context.tracing().start(new Tracing.StartOptions()
				.setName("EditLead_Tracing")
				.setScreenshots(true)
				.setSnapshots(true)
				.setTitle("EditLead")
				.setSources(true));
				
		
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		//page.locator("#username").type("democsr");
		page.type("#username", "democsr");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		page.locator("text=CRM/SFA").click();
		page.locator("//a[text()='Leads']").click();
		page.locator("//a[text()='Find Leads']").click();
		page.locator("(//span[text()='Advanced']/following::input)[2]").type("Ranjini");
		page.locator("//button[text()='Find Leads']").click();
		page.locator("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//div/a)[1]").click();
		//page.locator("//a[text()='Edit']").click();
		page.click("//a[text()='Edit']");
		page.locator("#updateLeadForm_companyName").type("TestLeaf");
		page.locator("text=Update").click();
		String text = page.locator("#viewLead_companyName_sp").innerText();
		System.out.println(text);	
		
		//Stop tracing
		context.tracing().stop(new Tracing.StopOptions()
				.setPath(Paths.get("traces/Edit_Lead.zip")));
		
		pw.close();

	}

}
