package com.antibiotik.element;

import com.antibiotik.logger.MyLogger;

public class MyElement {
	private String element;
	private String xpath;
	private String id;
	private String name;
	private String css_selector;
	private String class_name;

	private final MyLogger logger;

	public MyElement(MyLogger logger) {
		this.logger = logger;
	}

	public String getXpath() {
		if (xpath == null) {
			String errorMassage = "Element xpath is empty, please add xpath to your selectors file";
			logger.errorLog(errorMassage);
			assert false: errorMassage;
			return null;
		}

		return xpath;
	}

	public String getId() {
		if (id == null) {
			String errorMassage = "Element id is empty, please add id to your selectors file";
			logger.errorLog(errorMassage);
			assert false: errorMassage;
			return null;
		}

		return id;
	}

	public String getName() {
		if (name == null) {
			String errorMassage = "Element name is empty, please add name to your selectors file";
			logger.errorLog(errorMassage);
			assert false: errorMassage;
			return null;
		}

		return name;
	}

	public String getCss_selector() {
		if (css_selector == null) {
			String errorMassage = "Element css selector is empty, please add css selector to your selectors file";
			logger.errorLog(errorMassage);
			assert false: errorMassage;
			return null;
		}

		return css_selector;
	}

	public String getClass_name() {
		if (class_name == null) {
			String errorMassage = "Element class name is empty, please add class name to your selectors file";
			logger.errorLog(errorMassage);
			assert false: errorMassage;
			return null;
		}

		return class_name;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCss_selector(String css_selector) {
		this.css_selector = css_selector;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getSelectorByType(String selectorType) {
		switch (selectorType) {
			case "xpath":
				return xpath;
			case "element id":
				return id;
			case "element name":
				return element;
			case "css selector":
				return css_selector;
			case "class name":
				return class_name;
			default:
				String errorMess = "This element type:" + selectorType + " is not registered.";
				logger.errorLog(errorMess);
				return null;
		}
	}

	@Override
	public String toString() {
		return  "element=' : " + element + '\'' +
				"xpath=' : " + xpath + '\'' +
				"id=' : " + id + '\'' +
				"name=' : " + name + '\'' +
				"css_selector=' : " + css_selector + '\'' +
				"class_name=' : " + class_name;
	}
}
