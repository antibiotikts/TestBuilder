package com.antibiotik.json_utils;

import com.antibiotik.logger.MyLogger;
import org.json.JSONObject;

public class JsonExtractor {

	private JsonExtractor() {
	}

	public static String getString(JSONObject jsonObject, String key, MyLogger logger) {
		String data = jsonObject.optString(key, null);

		if(data == null)  {
			String errorMess = "By key: " + key + "the object not found";
			logger.errorLog(errorMess);
			return null;
		}
		return data;
	}
}
