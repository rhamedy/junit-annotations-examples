package junit.exmaples.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(CategoryA.class)
@SuiteClasses({CategoriesTests.class})
public class CategroyTestSuite {

}
