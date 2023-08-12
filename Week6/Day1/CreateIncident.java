package week6.day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class CreateIncident {

	@Test
	public void createInc() {
		
		//Create Playwright object -> Call browser instances
		Playwright pw = Playwright.create();
		
		Map<String, String> headers = new HashMap<>();
		//Headers - Authorization
		headers.put("Authorization", "Basic YWRtaW46ZkhAKjRlekNzWUgy");
		//Content type in headers
		headers.put("Content-Type", "application/json");
		
		//(json is a String) 
		String jsonBody = "{\"short_description\":\"Created a new incident from Playwright\"}";
		
		//Send API request -> base endpoint URL (without the changing resource info) and with the headers
		APIRequestContext request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://dev141455.service-now.com/api/now/")
				.setExtraHTTPHeaders(headers));
		
		//request POST call 
		APIResponse response = request.post("table/incident", 
				//Construction of json
				RequestOptions.create().setData(jsonBody));
		
		//print the status
		int status = response.status();
		System.out.println(status);
		System.out.println(response.statusText());
		System.out.println(response.text());
		
		JsonElement json = new Gson().fromJson(response.text(),JsonElement.class);
		JsonElement resultjsonElement = json.getAsJsonObject().get("result");	
//		JsonElement sys_id = resultjsonElement.getAsJsonObject().get("sys_id");
//		System.out.println(sys_id);
//		JsonElement category = resultjsonElement.getAsJsonObject().get("category");
//		System.out.println(category);
		System.out.println(getJsonElement(resultjsonElement, "sys_id"));
		System.out.println(getJsonElement(resultjsonElement, "category"));
		System.out.println(getJsonElement(resultjsonElement, "number"));
		
		
	}
	
	private String getJsonElement(JsonElement json, String key) {
		return json.getAsJsonObject().get(key).getAsString();
		
	}
}
