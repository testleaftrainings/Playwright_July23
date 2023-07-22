package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.DragToOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class LearnMouseHover {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setSlowMo(2000)
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://practice.geeksforgeeks.org/courses?source=google&medium=cpc&device=c&keyword=geeksforgeeks&matchtype=b&campaignid=20039445781&adgroup=147845288105&gad=1&gclid=Cj0KCQjw2eilBhCCARIsAG0Pf8vjeNLtO7lBuQk2OSHcyvxWVVMTwKsh-p0ClAIkm3xIWDSe_Y1LKFwaAuEiEALw_wcB");
		page.hover("//span[text()='Tutorials']");
		page.hover("//span[text()='Data Structures & Algorithms']");
		page.click("//a[text()='Complete DSA Tutorial']");
	}	
}
