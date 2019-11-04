package junit.exmaples.tags;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("junit.exmaples.v2.tags")
@IncludeTags({"qa", "development"})
@ExcludeTags({"report", "dao"})
public class JUnit5TagTests {}
