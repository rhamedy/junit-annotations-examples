package junit.exmaples.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("development")
public class UnitTests {
	@Tag("web-layer")
	@Test
	public void login_controller_test() {}

	@Tag("web-layer")
	@Test
	public void logout_controller_test() {}

	@Tag("db-layer")
	@Tag("dao")
	@Test
	public void user_dao_tests() {}
}
