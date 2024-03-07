package org.example;

import com.antibiotik.json_utils.JsonReader;
import com.antibiotik.logger.TestLogger;
import com.antibiotik.path.MyPaths;
import com.antibiotik.testBuilder.TestBuilder;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	public void testing() {
		System.out.println("Start");
		TestBuilder testBuilder = new TestBuilder(new TestLogger(TestBuilder.class));
		System.out.println("Create test builder object");
		testBuilder.buildTest(new JsonReader(new TestLogger(JsonReader.class)).getJsonArray(MyPaths.BASE_TEST_CONFIG.getPath()));
		testBuilder.executeCommands();
	}
}
