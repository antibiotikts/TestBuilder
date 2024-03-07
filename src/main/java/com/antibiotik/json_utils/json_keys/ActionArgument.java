package com.antibiotik.json_utils.json_keys;

public enum ActionArgument {
	SELECTOR("selector"),
	ELEMENT("element"),
	CONDITION("condition"),
	URL("url"),
	VALUE("value"),
	SECOND_VALUE("second value"),
	SELECTOR_TYPE("selector_type");

	private final String key;

	ActionArgument(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
