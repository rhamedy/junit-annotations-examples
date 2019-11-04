package junit.exmaples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class JUnit5RepeatedTests {
	@RepeatedTest(2)
	public void test_executed_twice() {
		System.out.println("RepeatedTest"); // Prints twice
	}

	// Output:
	// name attr:test_RepeatedTest_WithAllAttributes executed 1 of 3
	// name attr:test_RepeatedTest_WithAllAttributes executed 2 of 3
	// name attr:test_RepeatedTest_WithAllAttributes executed 3 of 3
	@RepeatedTest(value = 3, name = "{displayName} executed {currentRepetition} of {totalRepetitions}")
	@DisplayName("Repeated 3 Times Test")
	public void repeatd_three_times_test(TestInfo info) {
		System.out.println("name attr:" + info.getDisplayName());
		assertTrue("display name matches", info.getDisplayName()
				.contains("Repeated 3 Times Test"));
	}

	// Output:
	// test_RepeatedTest_WithRepetitionInfo_Annotation is 1 of 2
	// test_RepeatedTest_WithRepetitionInfo_Annotation is 2 of 2
	@RepeatedTest(value = 2, name = "{displayName}")
	@DisplayName("Repeated 2x Test")
	public void repeated_twice_test(TestInfo testInfo, RepetitionInfo repInfo) {
		System.out.println(testInfo.getDisplayName() + " is " + repInfo.getCurrentRepetition() + " of " +
				repInfo.getTotalRepetitions());
		assertEquals("total repetition matches", 2, repInfo.getTotalRepetitions());
	}
}
