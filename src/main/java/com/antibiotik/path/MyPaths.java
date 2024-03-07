package com.antibiotik.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum MyPaths {
	BASE_TEST_CONFIG( "src", "main", "json_tests","assert_test.json");


	private final Path path;

	MyPaths(String... directories) {
		this.path = Paths.get(System.getProperty("user.dir"), directories);
	}

	public Path getPath() {
		return path;
	}
}
