package com.antibiotik.commands;

import com.codeborne.selenide.SelenideElement;

public class PressEnter implements Command {
	SelenideElement element;

	public PressEnter(SelenideElement element) {
		this.element = element;
	}

	@Override
	public void execute() {
		element.pressEnter();
	}
}
