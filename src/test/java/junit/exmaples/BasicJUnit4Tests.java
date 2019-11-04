package junit.exmaples;

import static org.junit.Assert.assertFalse;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BasicJUnit4Tests {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test(timeout = 1)
	public void timeout_test() throws InterruptedException {
		Thread.sleep(2); // Fails because it took longer than 1 second.
	}

	@Ignore("Ignored because of a good reason")
	@Test
	public void test_something() {
		assertFalse("Always false", true);
	}

	@Test(expected = NullPointerException.class)
	public void exception_test() {
		throw new IllegalArgumentException(); // Fails because it expects NPE.
	}

	@Test
	public void expectedException_inMethodLevel() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cause of the error");
		throw new IllegalArgumentException("Cause of the error");
	}
}
