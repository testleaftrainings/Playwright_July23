package week3.day2;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class File_Upload {

	public static void main(String[] args) {
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://leafground.com/file.xhtml");
		page.locator("[name='j_idt88:j_idt89_input']").setInputFiles(Paths.get("C:\\Users\\user\\Downloads\\FrameNew.pdf"));

	}

}
