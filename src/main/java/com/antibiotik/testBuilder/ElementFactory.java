package com.antibiotik.testBuilder;

import com.antibiotik.json_utils.JsonExtractor;
import com.antibiotik.json_utils.json_keys.ActionArgument;
import com.antibiotik.logger.MyLogger;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ElementFactory {

	public static SelenideElement getElement(JSONObject instruction, MyLogger logger) {
		String locatorType = JsonExtractor.getString(instruction, ActionArgument.SELECTOR_TYPE.getKey(), logger);
		String locatorValue = JsonExtractor.getString(instruction, ActionArgument.SELECTOR.getKey(), logger);

		return createElement(locatorType, locatorValue);
	}

	private static SelenideElement createElement(String locatorType, String locatorValue) {

		switch (locatorType) {
			case "xpath":
				return $(By.xpath(locatorValue));
			case "element id":
				return $(By.id(locatorValue));
			case "element name":
				return $(By.name(locatorValue));
			case "css selector":
				return $(By.cssSelector(locatorValue));
			case "class name":
				return $(By.className(locatorValue));
			default:
				String errorMess = "";
				return null;
		}
	}
}