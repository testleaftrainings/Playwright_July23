package week4.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

public class DeleteLead extends BaseClass{
	@Test()
	public void run_DeleteLead() throws InterruptedException {


				// Click Find Leads
				page.click("//a[text()='Find Leads']");

				// Enter the firstname
				page.type("(//input[@name='firstName'])[3]", "Rahul");

				// Click Find Leads button
				page.click("//button[text()='Find Leads']");

				// Get the count of Leads ID
				Locator leadIds = page.locator("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
				int count = leadIds.count();
				System.out.println(count);
				 
				Thread.sleep(2000);
				// Click the first resulting Leads ID
				Locator eleFirst = leadIds.first();
				String lead = eleFirst.innerText();
				System.out.println(lead);
				eleFirst.click();

				// Click Delete Lead button
				page.click(".subMenuButtonDangerous");

				// Click Find Leads
				page.click("//a[text()='Find Leads']");

				// Enter the Lead ID
				page.type("[name=id]", lead);

				// Click Find Leads button
				page.click("//button[text()='Find Leads']");
				Thread.sleep(2000);
				// Verify the Lead ID is deleted
				String innerText = page.locator(".x-paging-info").innerText();
				System.out.println(innerText);

//				page.close();
//				browser.close();
			

	}

}
