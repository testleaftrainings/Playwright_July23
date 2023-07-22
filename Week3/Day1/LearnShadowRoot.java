package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnShadowRoot {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://login.salesforce.com/");
		page.type("#username", "hari.radhakrishnan@qeagle.com");
		page.type("#password", "Leaf@1234");
		page.click("#Login");
		page.click("//span[text()='Learn More']");
		
		Page childPage = context.waitForPage(()-> {
			page.isVisible("text=Confirm redirect?");
		});
		childPage.click("//button[text()='Confirm']");
		childPage.click("text=Learning");
		childPage.hover("text=Learning on Trailhead");
		childPage.click("text=Salesforce Certification");
		

	}

}
