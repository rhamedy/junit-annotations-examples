package junit.exmaples.parametrized;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5ValueSourceParametrizedTests {
	@ParameterizedTest
	@ValueSource(strings = {"Hi", "How", "Are", "You?"})
	public void testStrings(String arg) {
		assertTrue(arg.length() <= 4);
	}

	@ParameterizedTest
	@ValueSource(ints = {10, 20, 30})
	public void testIntegers(Integer age) {
		assertTrue(age <= 30);
	}

	@ParameterizedTest
	@ValueSource(longs = {1L, 2L, 3L})
	public void testLongs(Long arg) {
		assertTrue(arg <= 3);
	}

	@ParameterizedTest
	@ValueSource(doubles = {1.1, 1.2, 1.3})
	public void testDoubles(Double arg) {
		assertTrue(arg <= 1.3);
	}
}
