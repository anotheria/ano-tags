package net.anotheria.tags;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={
		EqualTagTest.class,
		GreaterThanTagTest.class,
		LessThanTagTest.class,
		EmptyTagTest.class,
		PresentTagTest.class,
		NotEmptyTagTest.class,
		NotEqualTagTest.class,
		NotPresentTagTest.class,
		ChooseTagTest.class,
		OtherwiseTagTest.class, WriteTagTest.class} )
public class TagsTestsuite {


}
