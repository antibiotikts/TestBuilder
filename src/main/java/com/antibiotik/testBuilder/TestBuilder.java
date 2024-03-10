package com.antibiotik.testBuilder;

import com.antibiotik.commands.Command;
import com.antibiotik.element.Elements;
import com.antibiotik.json_utils.Convertor;
import com.antibiotik.logger.MyLogger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestBuilder {
	private final MyLogger logger;
	private Elements elements;
	private final Queue<Command> commandQueue = new LinkedList<>();

	public TestBuilder(MyLogger logger) {
		this.logger = logger;
	}

	public void buildTest(JSONArray steps) {
		if(steps == null) {
			assert false;
			return;
		}

		List<JSONObject> stepsList = Convertor.toJsonObjectList(steps);

		if(stepsList == null) {
			assert false;
			return;
		}

		for (JSONObject step : stepsList) {
			commandQueue.add(CommandFactory.createCommand(step, elements, logger));
		}
	}

	public void buildTest(List<JSONObject> stepsList) {
		if(stepsList == null) {
			assert false;
			return;
		}

		for (JSONObject step : stepsList) {
			commandQueue.add(CommandFactory.createCommand(step, elements, logger));
		}
	}

	public void executeCommands() {
		if (commandQueue.isEmpty()) {
			String errorMessage = "Command queue is empty, before executing commands you must build the test";
			logger.errorLog(errorMessage);
			return;
		}

		while (!commandQueue.isEmpty()) {
			commandQueue.poll().execute();
		}
	}

	public void addOutSideElements(Elements elements) {
		this.elements = elements;
	}
}
