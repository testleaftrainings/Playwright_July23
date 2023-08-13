package week6.day2;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;

public class GenerateOAuth {

	@Test
	public void getOauth2() {


		Playwright pw = Playwright.create();


		//Send API request -> base endpoint URL (without the changing resource info) and with the headers
		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://login.salesforce.com/services/oauth2/token"));

		//request POST call 
		APIResponse response = request.post("", RequestOptions.create().setForm(
					FormData.create()
					.set("grant_type", "password")
					.set("client_id", "3MVG9pRzvMkjMb6lZlt3YjDQweyw6xqljTUY.cNM0_PxMf71iXZgPLalHXS71fyHWC5bapw09.XlF3F1BLnBR")
					.set("client_secret", "39174F36EBBBC3A06E3E0353A0D1079F89225B3109C4CF89B8CA123B9BBC1477")
					.set("username", "ranjini.r@testleaf.com")
					.set("password", "Testleaf$321")));



		JsonElement json = new Gson().fromJson(response.text(),JsonElement.class);
		JsonElement accessToken = json.getAsJsonObject().get("access_token");	
		System.out.println(accessToken.getAsString());


	}


}
