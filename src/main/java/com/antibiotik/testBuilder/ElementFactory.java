package com.antibiotik.testBuilder;

import com.antibiotik.element.Elements;
import com.antibiotik.element.MyElement;
import com.antibiotik.json_utils.JsonExtractor;
import com.antibiotik.json_utils.json_keys.ActionArgument;
import com.antibiotik.logger.MyLogger;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ElementFactory {

	public static SelenideElement getElement(JSONObject instruction, Elements elements, MyLogger logger) {
		String locatorType = JsonExtractor.getString(instruction, ActionArgument.SELECTOR_TYPE.getKey(), logger);

		if (locatorType == null) {
			String errorMess = "Element type equal null.";
			logger.errorLog(errorMess);
			assert false;
		}

		if (instruction.has(ActionArgument.SELECTOR.getKey())) {
			String locatorValue = JsonExtractor.getString(instruction, ActionArgument.SELECTOR.getKey(), logger);
			return createElement(locatorType, locatorValue, logger);

		} else if(instruction.has("element")) {
			String elementName = JsonExtractor.getString(instruction,"element", logger);
			MyElement element = elements.getElementsMap().get(elementName);
			return createElement(locatorType, element.getSelectorByType(locatorType), logger);
		}
		String errorMess = "ElementFactory failed to create an element.";
		logger.errorLog(errorMess);
		return null;
	}

	private static SelenideElement createElement(String locatorType, String locatorValue, MyLogger logger) {
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
				String errorMess = "This element type:" + locatorType + " is not registered.";
				logger.errorLog(errorMess);
				return null;
		}
	}

}
