package junit.exmaples;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class JUnitGlobalTimeoutRuleTests {
	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	@Test
	public void notInfinite() throws InterruptedException {
		while(true);
	}

	@Test
	public void timeout_test_pass() throws InterruptedException {
		Thread.sleep(1);
	}
}
