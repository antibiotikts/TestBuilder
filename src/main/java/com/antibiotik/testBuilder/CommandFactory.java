package com.antibiotik.testBuilder;

import com.antibiotik.commands.*;
import com.antibiotik.element.Elements;
import com.antibiotik.json_utils.JsonExtractor;
import com.antibiotik.json_utils.json_keys.Action;
import com.antibiotik.json_utils.json_keys.ActionArgument;
import com.antibiotik.logger.MyLogger;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;



public class CommandFactory {
	public static Command createCommand(JSONObject instruction, Elements elements, MyLogger logger) {

		String action = JsonExtractor.getString(instruction, "action", logger);

		if (action == null) {
			String errorMess = "When trying to get an action got a null";
			logger.errorLog(errorMess);
			return null;
		}

		if(action.equals(Action.ASSERT.getKey())) {
			SelenideElement element = ElementFactory.getElement(instruction, elements, logger);
			String value = JsonExtractor.getString(instruction, ActionArgument.VALUE.getKey(), logger);
			return new Assert(element, value);
		}
		if(action.equals(Action.CLICK.getKey())) {
			SelenideElement element = ElementFactory.getElement(instruction, elements, logger);
			return new Click(element);
		}
		if(action.equals(Action.CLOSE.getKey())) {
			return new Close();
		}
		if(action.equals(Action.OPEN.getKey())) {
			String value = JsonExtractor.getString(instruction, ActionArgument.URL.getKey(), logger);
			return new OpenUrl(value);
		}
		if(action.equals(Action.PRESS_ENTER.getKey())) {
			SelenideElement element = ElementFactory.getElement(instruction, elements, logger);
			return new PressEnter(element);
		}
		if(action.equals(Action.SCROLL_TO.getKey())) {
			SelenideElement element = ElementFactory.getElement(instruction, elements, logger);
			return new ScrollTo(element);
		}
		if(action.equals(Action.SET_VALUE.getKey())) {
			SelenideElement element = ElementFactory.getElement(instruction, elements, logger);
			String value = JsonExtractor.getString(instruction, ActionArgument.VALUE.getKey(), logger);
			return new SetValue(element, value);
		}
		if(action.equals(Action.SHOULD_BE.getKey())) {
			SelenideElement element = ElementFactory.getElement(instruction, elements, logger);
			String value = JsonExtractor.getString(instruction, ActionArgument.VALUE.getKey(), logger);
			String condition = JsonExtractor.getString(instruction, ActionArgument.CONDITION.getKey(), logger);
			return new ShouldBe(element, condition, value);
		}
		String errorMess = "A non-existent command was transferred: " + action;
		logger.errorLog(errorMess);

		return null;
	}
}
