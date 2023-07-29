package week4.day1;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserContext.GrantPermissionsOptions;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GrantPermissions {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserContext context = pw.chromium().launchPersistentContext(
				Paths.get("C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),
				new BrowserType.LaunchPersistentContextOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		context.grantPermissions(Arrays.asList("notifications"), new 
				BrowserContext.GrantPermissionsOptions().setOrigin("https://www.flipkart.com/"));
		context.grantPermissions(Arrays.asList("camera","microphone"), new
				BrowserContext.GrantPermissionsOptions().setOrigin("https://zoom.us/"));
		
		Page page = context.newPage();

		// Load the URL
		page.navigate("https://www.flipkart.com/");
		page.navigate("https://zoom.us/");

	}

}
