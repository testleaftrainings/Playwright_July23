package week6.day2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class CreateLead {
	@Test
	public void createLead() {
		

		Playwright pw = Playwright.create();
		
		Map<String, String> headers = new HashMap<>();
		//Headers - Authorization
		headers.put("Authorization", "Bearer 00D5j00000C8pLO!ARoAQGUV_dBrZuou.xnVBAESOmiBspnFoQtIN7.vIwgGTfV.1lEOEarVjo7wvi3abY4I3Eb3k31Ac9LnhLfUq5vGAc3U8HBO");
		//Content type in headers
		headers.put("Content-Type", "application/json");
		
		//(json is a String) 
		String jsonBody = "{\r\n"
				+ "    \"FirstName\": \"Sangavi\",\r\n"
				+ "    \"LastName\": \"S\",\r\n"
				+ "    \"Company\": \"TCS\"\r\n"
				+ "}";
		
		//Send API request -> base endpoint URL (without the changing resource info) and with the headers
		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://testleaf30-dev-ed.develop.my.salesforce.com/services/data/v58.0/sobjects/")
				.setExtraHTTPHeaders(headers));
		
		//request POST call 
		APIResponse response = request.post("Lead/", 
				//Construction of json
				RequestOptions.create().setData(jsonBody));
		
		//print the status
		int status = response.status();
		System.out.println(status);
		System.out.println(response.statusText());
		System.out.println(response.text());
	}	
		
}
