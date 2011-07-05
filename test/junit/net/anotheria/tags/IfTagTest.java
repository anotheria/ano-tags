package net.anotheria.tags;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IfTagTest extends TagTestBase {
  
	@Test 
	public void testStringValue() throws Exception {
		assertEquals(3, countOKinContent(testJSP("/if/test01.jsp")));
	}


}
