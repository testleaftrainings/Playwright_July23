package week3.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleFrames {

	@Test
	public void frame_handle() throws InterruptedException {
	
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://leafground.com/frame.xhtml");
		//To handle the frame
		FrameLocator frame = page.frameLocator("(//iframe)[1]");
		frame.locator("#Click").click();
		
	//	Thread.sleep(2000);
		//To go to home page
		page.click("//i[@class='pi pi-home layout-menuitem-icon']");
		
		//To handle nested frames
		FrameLocator parentFrame = page.frameLocator("(//iframe)[3]");
		FrameLocator childFrame = parentFrame.frameLocator("#frame2");
		childFrame.locator("#Click").click();
		
		
		
		
		

	}

}
