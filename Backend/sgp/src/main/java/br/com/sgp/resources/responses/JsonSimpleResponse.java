package br.com.sgp.resources.responses;

import java.util.HashMap;
import java.util.Map;

public class JsonSimpleResponse {
	private Map<String, Object> responseBody;
	
	public JsonSimpleResponse() {
		responseBody = new HashMap<String, Object>();
	}
	
	public JsonSimpleResponse addPair(String key, Object value) {
		responseBody.put(key, value);
		return this;
	}
	
	public Map<String, Object> getResponseBody() {
		return responseBody;
	}
}
