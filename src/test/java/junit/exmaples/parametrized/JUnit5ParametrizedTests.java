package junit.exmaples.parametrized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5ParametrizedTests {
	//- @ValueSource examples

	@ParameterizedTest
	@ValueSource(strings = {"Hi", "How", "Are", "You?"})
	public void testStrings(String arg) {
		System.out.println(arg);
		assertTrue(arg.length() <= 4);
	}

	@ParameterizedTest
	@ValueSource(ints = {10, 20, 30})
	public void testIntegers(Integer age) {
		System.out.println(age);
		assertTrue(age <= 30);
	}

	@ParameterizedTest
	@ValueSource(longs = {1L, 2L, 3L})
	public void testLongs(Long arg) {
		System.out.println(arg);
		assertTrue(arg <= 3);
	}

	@ParameterizedTest
	@ValueSource(doubles = {1.1, 1.2, 1.3})
	public void testDoubles(Double arg) {
		System.out.println(arg);
		assertTrue(arg <= 1.3);
	}

	//- @EnumSource examples

	enum Level {
		  LOW,
		  MEDIUM,
		  HIGH
		}

	@ParameterizedTest
	@EnumSource(Level.class)
	public void testEnums(Level level) {
		System.out.println(level.name());
		assertTrue(EnumSet.of(Level.HIGH, Level.LOW, Level.MEDIUM).contains(level));
	}

	@ParameterizedTest
	@EnumSource(value = Level.class, names = { "MEDIUM", "HIGH"})
	public void testEnums_Specific(Level level) {
		System.out.println(level.name());
		assertTrue(EnumSet.of(Level.MEDIUM, Level.HIGH).contains(level));
	}

	@ParameterizedTest
	@EnumSource(value = Level.class, mode = Mode.INCLUDE, names = { "MEDIUM", "HIGH"})
	public void testEnums_Include_Specific(Level level) {
		System.out.println(level.name());
		assertTrue(EnumSet.of(Level.MEDIUM, Level.HIGH).contains(level));
	}

	// Same test as above but, we used EXCLUDE mode so it's expecting LOW only hence, fails.
	@ParameterizedTest
	@EnumSource(value = Level.class, mode = Mode.EXCLUDE, names = { "MEDIUM", "HIGH"})
	public void testEnums_exclude_Specific(Level level) {
		System.out.println(level.name());
		assertTrue(EnumSet.of(Level.MEDIUM, Level.HIGH).contains(level));
	}

	//- @MethodSource Examples

	@ParameterizedTest
	@MethodSource("someIntegers")
	public void test_MethodSource(Integer s) {
		System.out.println("MethodSource: " + s);
		assertTrue(s <= 3);
	}

	static Collection<Integer> someIntegers() {
		return Arrays.asList(1,2,3);
	}

	@ParameterizedTest
	@MethodSource("argumentsSource")
	public void test_MethodSource_withMoreArgs(String month, Integer number) {
		System.out.println(month + " is " + number);
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

	//- @CSVSource

	@ParameterizedTest
	@CsvSource(delimiter=',', value= {"1,'A'","2,'B'"})
	public void test_CSVSource_commaDelimited(int i, String s) {
		System.out.println("CSV Source: " + i + ", " + s);
		assertTrue(i < 3);
		assertTrue(Arrays.asList("A", "B").contains(s));
	}

	//- @CSVFileSource
	@ParameterizedTest
	@CsvFileSource(resources = "/sample.csv", numLinesToSkip = 1, delimiter = ',', encoding = "UTF-8")
	public void test_CSVFileSource(String name, Integer age) {
		System.out.println("CSVFileSource: " + name + ", " + age);
		assertTrue(Arrays.asList("James", "Josh").contains(name));
		assertTrue(age < 50);
	}


}