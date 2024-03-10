package com.antibiotik.element;

import com.antibiotik.json_utils.JsonReader;
import com.antibiotik.logger.MyLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Elements {
	private final Map<String, MyElement> elementsMap = new HashMap<>();
	private final MyLogger logger;

	public Elements(MyLogger logger) {
		this.logger = logger;
	}

	public void createElementsMap(Path path) {
		JSONArray jsonArray = new JsonReader(logger).getJsonArray(path);

		if(jsonArray == null) {
			return;
		}

		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject;

			try {
				jsonObject = jsonArray.getJSONObject(i);
			} catch (JSONException e) {
				String errorMess = "JSON Object does not open";
				logger.errorLog(errorMess, e);
				continue;
			}

			String element = jsonObject.optString("element", null);

			if(element == null) {
				String errorMassage = "element does not found" + "JsonObject id: " + i;
				logger.errorLog(errorMassage);
				continue;
			}

			MyElement myElement = new MyElement(logger);

			myElement.setElement(jsonObject.optString("element", null));

			if(myElement.getElement() == null) {
				String errorMess = "Element not found";
				logger.errorLog(errorMess);
				continue;
			}
			myElement.setXpath(jsonObject.optString("xpath", null));
			myElement.setId(jsonObject.optString("id", null));
			myElement.setName(jsonObject.optString("name", null));
			myElement.setCss_selector(jsonObject.optString("css selector", null));
			myElement.setClass_name(jsonObject.optString("class name", null));

			elementsMap.put(element, myElement);
		}
	}

	public Map<String, MyElement> getElementsMap() {
		return elementsMap;
	}
}
