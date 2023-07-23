package week3.day2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.LoadState;
import com.sun.tools.javac.util.Context;
import com.microsoft.playwright.Playwright;

public class Screenshots {

	public static void main(String[] args) throws InterruptedException {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://leafground.com/");
		//Screenshot of full page
		page.screenshot(new Page.ScreenshotOptions().setFullPage(true)
				.setPath(Paths.get("snaps/lg_page_headless.png")));
		//Screenshot of a particular web element
		page.locator("#message").screenshot(new Locator.ScreenshotOptions().
				setPath(Paths.get("snaps/lg_ele_headless.png")));
		
		byte[] screenshot = page.screenshot();
		String string = Base64.getEncoder().encodeToString(screenshot);
		Thread.sleep(2000);
		//page.waitForLoadState(LoadState.NETWORKIDLE);
		//String string = encode.toString();
		System.out.println(string);
		
		page.close();
		browser.close();
		pw.close();

	}

}
