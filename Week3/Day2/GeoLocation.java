package week3.day2;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class GeoLocation {

	public static void main(String[] args) {
	
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		ArrayList<String> permissions = new ArrayList<>();
		permissions.add("geolocation");
//		BrowserContext context = browser.newContext(
//				new Browser.NewContextOptions().setGeolocation(12.9716,77.5946)
//				.setPermissions(permissions));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		context.grantPermissions(permissions, new BrowserContext.GrantPermissionsOptions()
				.setOrigin("https://www.gps-coordinates.net/my-location"));
		
		
		page.navigate("https://www.gps-coordinates.net/my-location");
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		String content = page.locator("span#addr").textContent();
		System.out.println(content);
		page.navigate("https://www.pvrcinemas.com/");
	}

}
