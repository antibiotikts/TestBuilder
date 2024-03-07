package com.antibiotik.commands;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class ShouldBe implements Command {
	SelenideElement element;
	String condition;
	String value;

	public ShouldBe(SelenideElement element, String condition, String value) {
		this.element = element;
		this.condition = condition;
		this.value = value;
	}

	@Override
	public void execute() {
		switch (condition) {
			case "visible":
				element.shouldBe(Condition.visible);
				break;
			case "hidden":
				element.shouldBe(Condition.hidden);
				break;
			case "exist":
				element.shouldBe(Condition.exist);
				break;
			case "empty":
				element.shouldBe(Condition.empty);
				break;
			case "selected":
				element.shouldBe(Condition.selected);
				break;
			case "text":
				if (value == null) {
					break;
				}
				element.shouldBe(Condition.text(value));
				break;
			case "exactText":
				if (value == null) {
					break;
				}
				element.shouldBe(Condition.exactText(value));
				break;
			default:
				String errorMessage = "Unknown condition";
				assert false: errorMessage;
		}
	}
}
