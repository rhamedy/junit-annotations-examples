package junit.exmaples;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorRuleTests {
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();

	@Test
	public void reportAllFailedAssertions() {
		errorCollector.checkThat(true, is(false));  // Fails here but, continues.
		errorCollector.checkThat(false, is(false)); // Passes and continues.
		errorCollector.checkThat(2, equalTo("a"));  // Fails again. Report all.
	}
}
