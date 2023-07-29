package week4.day1;

import java.util.List;

import com.deque.html.axecore.playwright.AxeBuilder;
import com.deque.html.axecore.results.Rule;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Accessibility_Testing {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.flipkart.com/");
		
		AxeBuilder axebuilder = new AxeBuilder(page);
		String errorMessage = axebuilder.analyze().getErrorMessage();
		System.out.println(errorMessage);
		List<Rule> violations = axebuilder.analyze().getViolations();
		System.out.println(violations);

	}

}
