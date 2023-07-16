package week2.day2;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DeleteLead {
	@Test
	public void run_DeleteTest() throws InterruptedException {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.type("#username", "demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.click(".decorativeSubmit");
		page.click("text=CRM/SFA");
		page.click("a:has-text('Leads')");
		page.click("//a[text()='Find Leads']");
		page.type("(//input[@name='firstName'])[3]", "Hari");
//		page.click("//span[text()='Phone']");
//		page.locator("[name=phoneCountryCode]").clear();
//		page.type("[name=phoneCountryCode]", "91");
//		page.type("[name=phoneNumber", "9922266765");
		page.click("//button[text()='Find Leads']");
		Locator leadIds = page.locator("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		int count = leadIds.count();
		System.out.println(count);
		/*
		 * List<String> allInnerTexts = leadIds.allInnerTexts(); for (String string :
		 * allInnerTexts) { System.out.println(string);
		 * 
		 * } String leadId = leadIds.first().innerText();
		 * System.out.println("First leadId: " +leadId);
		 * 
		 * leadIds.first().click();
		 */
		Thread.sleep(2000);
		Locator eleFirst = leadIds.first();
		String leadId = eleFirst.innerText();
		System.out.println(leadId);
		eleFirst.click();

		page.click(".subMenuButtonDangerous");
		page.click("//a[text()='Find Leads']");
		page.type("[name=id]", leadId);
		page.click("//button[text()='Find Leads']");
		
		String innerText = page.locator(".x-paging-info").innerText();
		System.out.println(innerText);
		page.close();
		browser.close();
		pw.close();
		
	}

}
