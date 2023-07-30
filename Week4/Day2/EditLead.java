package week4.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

public class EditLead extends BaseClass{
	
	@Test()
	public void run_EditLead() {
		
		page.locator("//a[text()='Find Leads']").click();
		page.locator("(//input[@name='firstName'])[3]").type("Rahul");
		page.locator("//button[text()='Find Leads']").click();
		page.locator("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//div/a)[1]").click();
		//page.locator("//a[text()='Edit']").click();
		page.click("//a[text()='Edit']");
		page.locator("#updateLeadForm_companyName").type("TestLeaf");
		
		Locator firstName = page.locator("#updateLeadForm_firstName");
		firstName.clear();
		firstName.type("Hari");
		page.locator("text=Update").click();
		String text = page.locator(".viewLead_firstName_sp").innerText();
		System.out.println(text);			


	}

}
