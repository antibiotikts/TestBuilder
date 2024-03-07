package com.antibiotik.json_utils;

import com.antibiotik.logger.MyLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
	private final MyLogger logger;

	public JsonReader(MyLogger logger) {
		this.logger = logger;
	}

	public JSONArray getJsonArray(Path path) {
		String jsonContent = readToString(path);

		if (jsonContent == null) {
			String errorMess = "The error reading file with tests. The method of reading returns a null";
			logger.errorLog(errorMess);
			assert false;
		}

		try {
			return new JSONArray(jsonContent);
		} catch (JSONException e) {
			String errorMess = "Failed to create JsonArray from file content";
			logger.errorLog(errorMess, e);
		}
		return null;
	}

	private String readToString(Path path) {
		try {
			return Files.readString(path);
		} catch (IOException e) {
			String errorMess = "Failed to read the file";
			logger.errorLog(errorMess, e);
			return null;
		}
	}

	private List<JSONObject> JsonArrayToJsonObjectList(JSONArray jsonArray) {
		List<JSONObject> jsonObjectList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				jsonObjectList.add(jsonObject);
			} catch (JSONException e) {
				return null;
			}
		}
		return jsonObjectList;
	}

}
