package junit.exmaples.theories;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JUnit4TheoriesExample2Tests {
	@DataPoint
	public static String java = "Java";
	@DataPoint
	public static String node = "node";

	/*
	 * Output: 2 x 1 = 2
	 *
	 * java
	 * node
	 */
	@Theory
	public void testTheory(String a) {
		System.out.println(a);
	}

	/*
	 * Output: 2 x 2 = 4 combination
	 *
	 * Java - Java
	 * Java - node
	 * node - Java
	 * node - node
	 */
	@Theory
	public void testTheory2(String a, String b) {
		System.out.println(a + " - " + b);
	}
}
