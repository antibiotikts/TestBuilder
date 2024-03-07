package com.antibiotik.commands;

import com.codeborne.selenide.Selenide;

public class OpenUrl implements Command {

	String url;

	public OpenUrl(String url) {
		this.url = url;
	}

	@Override
	public void execute() {
		Selenide.open(url);
	}
}
