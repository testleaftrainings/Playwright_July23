package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class LearnDragAndDrop {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://jqueryui.com/droppable/");
		//Get into the frame
		FrameLocator frame = page.frameLocator(".demo-frame");
		//Locate the drag box
		Locator draggable = frame.locator("div#draggable");
		//Locate the drop box
		Locator droppable = frame.locator("div#droppable");
		//Perform the action!
		draggable.dragTo(droppable);
		//To find the position
		BoundingBox bound = draggable.boundingBox();
		System.out.println(bound.x);
		System.out.println(bound.y);
		
		//System.out.println(droppable.innerText());
		System.out.println(droppable.textContent());
		

	}

}
