package junit.exmaples.parametrized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class JUnit5MethodArgumentParametrizedTests {
	@ParameterizedTest
	@MethodSource("argumentsSource")
	public void test_MethodSource_withMoreArgs(String month, Integer number) {
		switch(number) {
			case 1: assertEquals("Jan", month); break;
			case 2: assertEquals("Feb", month); break;
			case 3: assertEquals("Mar", month); break;
			default: assertFalse(true);
		}
	}

	// Simply returns a collection of Arguments where each Arguments is String:Integer
	static Collection<Arguments> argumentsSource() {
		return Arrays.asList(
				Arguments.of("Jan", 1),
				Arguments.of("Feb", 2),
				Arguments.of("Mar", 3),
				Arguments.of("Apr", 4)); //Should fail on this line, pass others
	}
}
