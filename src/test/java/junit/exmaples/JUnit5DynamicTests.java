package junit.exmaples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import junit.examples.PrimeNumberUtil;

public class JUnit5DynamicTests {
	@TestFactory
	Stream<DynamicTest> dynamicTests() {
		PrimeNumberUtil util = new PrimeNumberUtil();
		return IntStream.of(3, 7 , 11, 13, 15, 17) // 15 is not a prime
				.mapToObj(number -> DynamicTest.dynamicTest("Is " + number + " Prime?",
						() -> assertTrue(util.isPrime(number))));
	}
}