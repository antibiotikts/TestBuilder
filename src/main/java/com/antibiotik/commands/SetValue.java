package com.antibiotik.commands;

import com.codeborne.selenide.SelenideElement;

public class SetValue implements Command {
	SelenideElement element;
	String value;

	public SetValue(SelenideElement element, String value) {
		this.element = element;
		this.value = value;
	}

	@Override
	public void execute() {
		element.setValue(value);
	}
}
