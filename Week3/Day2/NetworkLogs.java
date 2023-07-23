package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NetworkLogs {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.onRequest(handler ->{
			String method = handler.method();
			//System.out.println(method);
			String url = handler.url();
			String postData = handler.postData();
			if(url.contains("createRecord=1")) {
			System.out.println(method+":::"+url+":::"+postData);
			}
		});
		page.onResponse(handler ->{
			int status = handler.status();
			String statusText = handler.statusText();
			System.out.println(status+":::"+statusText);
		});
		page.navigate("https://login.salesforce.com/");
		page.type("#username", "ranjini.r@testleaf.com");
		page.type("#password", "Testleaf@1234");
		page.click("#Login");
		page.click(".slds-icon-waffle");
		page.click("//p[text()='Service']");
		page.click("//span[text()='Accounts']");
		page.click("//div[@title='New']");
		page.type("[name=Name]", "Bala");
		page.click("[name=SaveEdit]");

	}

}
