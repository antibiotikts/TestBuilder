package com.antibiotik.commands;

import com.codeborne.selenide.SelenideElement;

public class Click implements Command {
	SelenideElement element;

	public Click(SelenideElement element) {
		this.element = element;
	}

	@Override
	public void execute() {
		element.click();
	}
}
