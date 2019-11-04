package junit.exmaples.parametrized;

import static org.junit.Assert.assertTrue;

import java.util.EnumSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class JUnit5EnumSourceParametrizedTests {
	enum Level {
		  LOW,
		  MEDIUM,
		  HIGH
		}

	@ParameterizedTest
	@EnumSource(Level.class)
	public void testEnums(Level level) {
		assertTrue(EnumSet.of(Level.HIGH, Level.LOW, Level.MEDIUM).contains(level));
	}

	@ParameterizedTest
	@EnumSource(value = Level.class, names = { "MEDIUM", "HIGH"})
	public void testEnums_Specific(Level level) {
		assertTrue(EnumSet.of(Level.MEDIUM, Level.HIGH).contains(level));
	}

	@ParameterizedTest
	@EnumSource(value = Level.class, mode = Mode.INCLUDE, names = { "MEDIUM", "HIGH"})
	public void testEnums_Include_Specific(Level level) {
		assertTrue(EnumSet.of(Level.MEDIUM, Level.HIGH).contains(level));
	}

	// Same test as above but, we used EXCLUDE mode so it's expecting LOW only hence, fails.
	@ParameterizedTest
	@EnumSource(value = Level.class, mode = Mode.EXCLUDE, names = { "MEDIUM", "HIGH"})
	public void testEnums_exclude_Specific(Level level) {
		assertTrue(EnumSet.of(Level.MEDIUM, Level.HIGH).contains(level));
	}
}
