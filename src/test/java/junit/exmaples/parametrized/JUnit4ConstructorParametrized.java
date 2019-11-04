package junit.exmaples.parametrized;

import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.examples.PrimeNumberUtil;

@RunWith(Parameterized.class)
public class JUnit4ConstructorParametrized {
	private int number;
	private boolean expectedResult;

	public JUnit4ConstructorParametrized(int input, boolean result) {
		this.number = input;
		this.expectedResult = result;
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
			{1, false}, {2, true}, {7, true}, {12, false}
		});
	}

	@Test
	public void test_isPrime() {
		PrimeNumberUtil util = new PrimeNumberUtil();
		assertSame(util.isPrime(number), expectedResult);
	}
}
