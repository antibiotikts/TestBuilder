package com.antibiotik.json_utils.json_keys;

public enum Action {
	CLICK("click"),
	TYPE("type"),
	OPEN("open"),
	CLOSE("close"),
	PRESS_ENTER("press enter"),
	SET_VALUE("set value"),
	ASSERT("assert"),
	SCROLL_TO("scroll to"),
	SHOULD_BE("should be"),
	SET_BROWSER("set browser"),
	SET_BROWSER_SIZE("set browser size");

	private final String key;

	Action(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
