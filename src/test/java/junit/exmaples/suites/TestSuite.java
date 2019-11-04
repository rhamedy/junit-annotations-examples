package junit.exmaples.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestSuiteA.class, TestSuiteB.class})
public class TestSuite {
	// Will run tests from TestSuiteA and TestSuiteB classes
}
