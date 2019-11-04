package junit.exmaples;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class JUnit5ConditionalTests {
	@Test
	@DisabledOnOs({OS.WINDOWS, OS.OTHER})
	public void test_disabled_on_windows() {
		assertTrue(true);
	}

	@Test
	@EnabledOnOs({OS.MAC, OS.LINUX})
	public void test_enabled_on_unix() {
		assertTrue(true);
	}

	@Test
	@DisabledOnOs(OS.MAC)
	public void test_disabled_on_mac() {
		assertFalse(false);
	}
}
