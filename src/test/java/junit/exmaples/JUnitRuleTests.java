package junit.exmaples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JUnitRuleTests {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void expectedException_inMethodLevel() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cause of the error");
		throw new IllegalArgumentException("Cause of the error");
	}
}
