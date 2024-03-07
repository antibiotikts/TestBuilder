package com.antibiotik.commands;

import com.codeborne.selenide.SelenideElement;

public class Assert implements Command {
	SelenideElement element;
	String value;

	public Assert(SelenideElement element, String value) {
		this.element = element;
		this.value = value;
	}

	@Override
	public void execute() {
		String actualValue = element.getValue();
		org.testng.Assert.assertEquals(actualValue, value);
	}
}
