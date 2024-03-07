package com.antibiotik.json_utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
	public static List<JSONObject> toJsonObjectList(JSONArray jsonArray) {
		try {
			List<JSONObject> list = new ArrayList<>();

			for(int i = 0; i < jsonArray.length(); i++) {
				list.add(jsonArray.getJSONObject(i));
			}

			return list;
		} catch (JSONException e) {
			return null;
		}
	}
}
