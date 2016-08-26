package net.anotheria.tags;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotMatchTagTest extends TagTestBase {
  
	@Test 
	public void testStringValue() throws Exception {
		assertEquals(3, countOKinContent(testJSP("/notMatch/notMatchTagTest01.jsp")));

		assertEquals(2, countOKinContent(testJSP("/notMatch/notMatchTagTest02.jsp")));

	}


}
