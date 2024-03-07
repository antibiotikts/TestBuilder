package com.antibiotik.commands;

import com.codeborne.selenide.SelenideElement;

public class ScrollTo implements Command {
	SelenideElement element;

	public ScrollTo(SelenideElement element) {
		this.element = element;
	}

	@Override
	public void execute() {
		element.scrollTo();
	}
}
