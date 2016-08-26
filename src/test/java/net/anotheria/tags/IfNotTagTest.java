package net.anotheria.tags;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IfNotTagTest extends TagTestBase {
  
	@Test 
	public void testStringValue() throws Exception {
		assertEquals(4, countOKinContent(testJSP("/ifNot/test01.jsp")));
	}


}
