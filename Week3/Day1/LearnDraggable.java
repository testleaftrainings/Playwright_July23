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

public class LearnDraggable {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://jqueryui.com/draggable/");
		//Get into the frame
		FrameLocator frame = page.frameLocator(".demo-frame");
		//Locate the web element
		Locator draggable = frame.locator("div#draggable");
		//To Drag the box
		DragToOptions setTargetPosition = new Locator.DragToOptions().setTargetPosition(100,100);
		draggable.dragTo(draggable,setTargetPosition);
	}

}
