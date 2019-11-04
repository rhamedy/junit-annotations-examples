package junit.exmaples.theories;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JUnit4TheoriesExample1Tests {
	@DataPoints
	public static String[] oss = new String[] {"Linux", "macOS", "Windows"};

	@DataPoints
	public static Integer[] numbers() {
		return new Integer[] {1, 2, 3};
	}

	/*
	 * Outputs: 3 ^ 2 = 9 combinations
	 *
	 * Linux - Linux
	 * Linux - macOS
	 * Linux - Windows
	 * macOS - Linux
	 * macOS - macOS
	 * macOS - Windows
	 * Windows - Linux
	 * Windows - macOS
	 * Windows - Windows
	 */
	@Theory
	public void testTheory3(String a, String b) {
		System.out.println(a + " - " + b);
	}

	@Theory
	public void testTheory5(String a) {
		System.out.println(a);
	}

	/*
	 * Outputs: 3 ^ 3 = 27 combinations
	 */
	@Theory
	public void testTheory3(String a, String b, String c) {
		System.out.println(a + " <-> " + b + "<->" + c);
	}

	/*
	 * The numbers method is the data points for this Theory.
	 */
	@Theory
	public void testTheory4(Integer a, Integer b) {
		System.out.println(a + " - " + b);
	}
}
