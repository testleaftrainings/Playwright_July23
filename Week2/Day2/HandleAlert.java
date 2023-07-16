package week2.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlert {
	@Test
	public void run_Alert() throws InterruptedException {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://leafground.com/alert.xhtml");
		//Listener
		page.onDialog(dialog ->{
			String message = dialog.message();
			System.out.println(message);
			dialog.dismiss();
		});
		page.click("(//h5[text()=' Alert (Simple Dialog)']/following::span[text()='Show'])[1]");
		
//		page.onceDialog(alert ->{
//			String message = alert.message();
//			System.out.println(message);
//			alert.dismiss();
//		});
		page.click("(//span[text()='Show'])[2]");
	//	Thread.sleep(2000);
//		page.onceDialog(alert ->{
//			String message = alert.message();
//			System.out.println(message);
//			alert.accept("Ranjini");
//		});
		page.click("(//span[text()='Show'])[5]");
		Thread.sleep(7000);
	}

}
