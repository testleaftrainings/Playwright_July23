package week6.day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class CreateAndDelete {
	
	Playwright pw;
	Map<String, String> headers;
	APIRequestContext request;
	private String sys_id;

	@BeforeClass
	public void setUpRequests() {
		
		pw = Playwright.create();

		headers = new HashMap<>();

		headers.put("Authorization", "Basic YWRtaW46ZkhAKjRlekNzWUgy");

		headers.put("Content-Type", "application/json");
		
		request = pw.request().newContext(new APIRequest.NewContextOptions()
				.setBaseURL("https://dev141455.service-now.com/api/now/")
				.setExtraHTTPHeaders(headers));

	}
	
	@Test
	public void createInc() {

		String jsonBody = "{\"short_description\":\"Created a new incident from Playwright\"}";

		APIResponse response = request.post("table/incident", RequestOptions.create().setData(jsonBody));
		
		JsonElement json = new Gson().fromJson(response.text(),JsonElement.class);
		JsonElement resultjsonElement = json.getAsJsonObject().get("result");	
		

		sys_id = getJsonElement(resultjsonElement, "sys_id");
		System.out.println(sys_id);

		System.out.println(getJsonElement(resultjsonElement, "number"));
	}

	private String getJsonElement(JsonElement json, String key) {
		return json.getAsJsonObject().get(key).getAsString();

	}

	@Test(dependsOnMethods = "createInc")
	public void del_Inc() {

		APIResponse response = request.delete("table/incident/"+sys_id);
		int status = response.status();
		System.out.println(status);
	


	}
}
