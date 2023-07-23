package week3.day2;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class File_Download {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://leafground.com/file.xhtml");
		
		Download download = page.waitForDownload(() ->{		
		page.click("//h5[text()='Basic Download']/following::span[2]");
		});
		
		String url = download.url();
		System.out.println("URL: " +url);
		
		Path fileName = download.path().getFileName();
		System.out.println("File Name: " +fileName);
		
		Path path = download.path();
		System.out.println(	"Root Directory: " +path.getRoot());
		
		download.saveAs(Paths.get("./downloads.png"));

	}

}
