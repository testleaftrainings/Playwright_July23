package week6.day2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;

public class E2E {

	Playwright pw;
	private String oAuthToken, leadID;
	public String firstName = "Renu", lastName = "Balaji", companyName = "TCS", phoneNumber="9876543210";

	//OAuth token created and set
	@BeforeClass
	public void setup() {

		pw = Playwright.create();

		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://login.salesforce.com/services/oauth2/token"));

		APIResponse response = request.post("", RequestOptions.create().setForm(
				FormData.create()
				.set("grant_type", "password")
				.set("client_id", "3MVG9pRzvMkjMb6lZlt3YjDQwexmEoVga2N_AFruHEDdTJv3peWD8r2z8yADwJgqs7A1mcGIgykkMtTkc58Yd")
				.set("client_secret", "BCA4E3C1D2C5BF54C32A8B4B5FFABD86F04FB4AF082DE5808BF07B488E7D014E")
				.set("username", "ranjini.r@testleaf.com")
				.set("password", "Testleaf$321")));


		JsonElement json = new Gson().fromJson(response.text(),JsonElement.class);
		JsonElement accessToken = json.getAsJsonObject().get("access_token");	
		System.out.println(accessToken.getAsString());
		setoAuthToken(accessToken.getAsString());

	}

	//Create Test Data using API for lead
	@BeforeMethod
	public void doCreateLead() {

		Map<String, String> headers = new HashMap<>();

		headers.put("Authorization", "Bearer "+getoAuthToken());

		headers.put("Content-Type", "application/json");


		String jsonBody = "{\r\n"
				+ "    \"FirstName\": \""+firstName+"\",\r\n"
				+ "    \"LastName\": \""+lastName+"\",\r\n"
				+ "    \"Company\": \""+companyName+"\"\r\n"
				+ "}";


		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://testleaf30-dev-ed.develop.my.salesforce.com/services/data/v58.0/sobjects/")
				.setExtraHTTPHeaders(headers));

		APIResponse response = request.post("Lead/", RequestOptions.create().setData(jsonBody));

		System.out.println(response.text());
		JsonElement json = new Gson().fromJson(response.text(),JsonElement.class);
		JsonElement leadId = json.getAsJsonObject().get("id");	
		//System.out.println(leadId.getAsString());
		setLeadID(leadId.getAsString());
	}

	//Testcase run using UI
	@Test
	public void editExistigLead() {

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();

		page.navigate("https://login.salesforce.com/");
		page.type("#username", "ranjini.r@testleaf.com");
		page.type("#password", "Testleaf$321");
		page.click("#Login");
		page.click(".slds-icon-waffle");
		page.click("//button[text()='View All']");
		page.type("//input[@placeholder='Search apps or items...']", "Sales");
		page.click("(//span[text()='All Apps']/following::mark)[3]");
		page.click("(//span[text()='Leads'])[1]");
		page.type(".slds-input", firstName);
		page.keyboard().press("Enter");
		page.click("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]");
		page.click("//a[@title='Edit']");
		page.locator("//label[text()='Phone']/following::input[1]").clear();
		page.type("//label[text()='Phone']/following::input[1]",phoneNumber);
		page.click("//button[text()='Save']");
	}

	@AfterMethod
	public void verifyLeadCreated() {

		Map<String, String> headers = new HashMap<>();

		headers.put("Authorization", "Bearer "+getoAuthToken());

		headers.put("Content-Type", "application/json");



		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://testleaf30-dev-ed.develop.my.salesforce.com/services/data/v58.0/sobjects/")
				.setExtraHTTPHeaders(headers));

		APIResponse response = request.get("Lead/"+ getLeadID());

		System.out.println(response.text());
		JsonElement json = new Gson().fromJson(response.text(),JsonElement.class);
		JsonElement phone = json.getAsJsonObject().get("Phone");	
		System.out.println(phone.getAsString());


	}
	public String getoAuthToken() {
		return oAuthToken;
	}

	public void setoAuthToken(String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}

	public String getLeadID() {
		return leadID;
	}

	public void setLeadID(String leadID) {
		this.leadID = leadID;
	}




}
