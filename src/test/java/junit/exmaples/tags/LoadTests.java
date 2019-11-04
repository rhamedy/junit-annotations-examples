package junit.exmaples.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("qa")
public class LoadTests {
	@Tag("auth")
	@Test
	public void login_test() {}

	@Tag("auth")
	@Test
	public void logout_test() {}

	@Tag("auth")
	@Test
	public void forgot_password_test() {}

	@Tag("report")
	@Test
	public void generate_monthly_report() {}
}
