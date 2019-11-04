package junit.exmaples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Output:
//
//(@BeforeAll) Runs once before any tests.
//(@BeforeEach Main class) Runs before each test.
//Testing the main class.
//(@AfterEach Main class) Runs after each test.
//(@BeforeEach Main class) Runs before each test.
//(@BeforeEach Nested class) Runs before each test.
//Testing the nested class.
//(@AfterEach Nested class) Runs after each test.
//(@AfterEach Main class) Runs after each test.
//(@AfterAll) Runs once only after all the tests run.
public class JUnit5NestedAnnotationTests {
	@BeforeAll
	public static void classLevelSetup() {
		System.out.println("(@BeforeAll) Runs once before any tests.");
	}

	@AfterAll
	public static void classLevelCleanup() {
		System.out.println("(@AfterAll) Runs once only after all the tests run.");
	}

	@BeforeEach
	public void beforeEachTest() {
		System.out.println("(@BeforeEach Main class) Runs before each test.");
	}

	@AfterEach
	public void afterEachTest() {
		System.out.println("(@AfterEach Main class) Runs after each test.");
	}

	@Test // Make sure to import JUnit 5 version of this annotation
	public void test_mainClass() {
		System.out.println("Testing the main class.");
	}

	@Nested // Without this annotation only above test runs.
	class JUnit5NestedAnnotationTestsNested {
		@BeforeEach
		public void beforeEachTest() {
			System.out.println("(@BeforeEach Nested class) Runs before each test.");
		}

		@AfterEach
		public void afterEachTest() {
			System.out.println("(@AfterEach Nested class) Runs after each test.");
		}

		@Test
		public void test_nestedClass() {
			System.out.println("Testing the nested class.");
		}
	}
}
