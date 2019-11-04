package junit.exmaples.parametrized;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class JUnit5CsvSourcesParametrizedTests {
	@ParameterizedTest
	@CsvSource(delimiter=',', value= {"1,'A'","2,'B'"})
	public void test_CSVSource_commaDelimited(int i, String s) {
		assertTrue(i < 3);
		assertTrue(Arrays.asList("A", "B").contains(s));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/sample.csv", numLinesToSkip = 1, delimiter = ',', encoding = "UTF-8")
	public void test_CSVFileSource(String name, Integer age) {
		assertTrue(Arrays.asList("James", "Josh").contains(name));
		assertTrue(age < 50);
	}
}
