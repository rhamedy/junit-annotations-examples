package junit.exmaples;

import static org.junit.Assert.assertTrue;
import static java.time.Duration.ofMillis;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicJUnit5Tests {
	@BeforeAll
	public static void setup() {
		System.out.println("Run before any test is executed.");
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("Run after all tests are executed.");
	}

	@BeforeEach
	public void beforeEachTest() {
		System.out.println("Run before each test is executed.");
	}

	@AfterEach
	public void afterEachTest() {
		System.out.println("Run after each test is executed.");
	}

	@Test
	public void always_passing_test() {
		assertTrue("Always true", true);
	}

	@Test
	public void test_assumptions() {
		Assumptions.assumeFalse(true);
		assertTrue(false);
	}

	@Test
	public void test_timeout() {
		// The test takes 2 milliseconds, assertion fails in 1 milliseconds
	    assertTimeout(ofMillis(1), () -> {
	        Thread.sleep(2);
	    });
	}

	@Test
	public void test_expected_exception() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("One"); // Throws NumberFormatException
		});
	}

	@Test
	@DisplayName("Test If Given Number is Prime")
	public void is_prime_number_test() {}
}
