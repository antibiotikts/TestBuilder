package org.example;

import com.antibiotik.element.Elements;
import com.antibiotik.json_utils.JsonReader;
import com.antibiotik.logger.TestLogger;
import com.antibiotik.path.MyPaths;
import com.antibiotik.testBuilder.TestBuilder;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	public void testing() {

		Elements elements = new Elements(new TestLogger(TestBuilder.class));
		elements.createElementsMap(MyPaths.ELEMENTS.getPath());
		TestBuilder testBuilder = new TestBuilder(new TestLogger(TestBuilder.class));
		testBuilder.addOutSideElements(elements);
		testBuilder.buildTest(new JsonReader(new TestLogger(JsonReader.class)).getJsonArray(MyPaths.TEST.getPath()));
		testBuilder.executeCommands();
	}
}
