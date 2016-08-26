package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChooseTagTest extends TagTestBase {
  
	@Test 
	public void testConditionalTags() throws Exception {
		assertEquals(10, countOKinContent(testJSP("/choose/chooseTagTest01.jsp")));
	}

}
