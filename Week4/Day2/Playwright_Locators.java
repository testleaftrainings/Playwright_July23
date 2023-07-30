package week4.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;

public class Playwright_Locators {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		// Launch the browser
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));

		// Open a new page
		Page page = browser.newPage();
//		 page.navigate("http://leaftaps.com/opentaps/control/main");
//		 //getByLabel
//		 page.getByLabel("Username").type("Demosalesmanager");
//		 page.getByLabel("Password").type("crmsfa");
//		 
//		 //getByRole
//		 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
//		 
//		 //getByText
//		 page.getByText("CRM/SFA").click();
		 page.navigate("https://www.amazon.in/");
		 page.getByPlaceholder("Search Amazon.in").type("bags");
		
	}

}
