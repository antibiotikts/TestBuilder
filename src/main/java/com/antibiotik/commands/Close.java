package com.antibiotik.commands;

import com.codeborne.selenide.Selenide;

public class Close implements Command {

	@Override
	public void execute() {
		Selenide.closeWebDriver();
	}
}
