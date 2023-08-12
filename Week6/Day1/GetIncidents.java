package week6.day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class GetIncidents {

	@Test
	public void get_AllInc() {
		
		
		Playwright pw = Playwright.create();
		Map<String, String> headers = new HashMap<>();
		
		headers.put("Authorization", "Basic YWRtaW46ZkhAKjRlekNzWUgy");
				
		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://dev141455.service-now.com/api/now/")
				.setExtraHTTPHeaders(headers));
		
	//	APIResponse response = request.get("table/incident");
		APIResponse response = request.get("table/incident/2731a56647e87110d3341288c26d4330");
		//print the status
		int status = response.status();
		System.out.println(status);
		System.out.println(response.statusText());
		System.out.println(response.text());
		
		
	}
}
