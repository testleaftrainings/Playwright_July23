package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	public Playwright pw;
	public Browser browser;
	public Page page;
	@Given("The url is loaded in the chrome")
	
	public void the_url_is_loaded_in_the_chrome() {
		
		pw = Playwright.create();
		browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));
		page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
	    
	}
	
	@When("The username is entered as (.*)$")
	public void the_username_is_entered_as_demosalesmanager(String username) {
		
		page.type("#username", username);
	    
	}
	@When("The password is entered as (.*)$")
	public void the_password_is_entered_as_crmsfa(String password) {
		
		page.locator("#password").type(password);
	   
	}
	
	@When("The Login button is clicked")
	public void the_login_button_is_clicked() {
		
		page.click(".decorativeSubmit");

	   
	}
	@Then("Verify the home page is displayed")
	public void verify_the_home_page_is_displayed() {
	    
		System.out.println(page.title());
	}

}
