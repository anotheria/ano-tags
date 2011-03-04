package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PresentTagTest extends TagTestBase {
  
	@Test 
	public void testNameValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notPresent/notPresentTagTest01.jsp")));
	}
	
	@Test 
	public void testNamePropertyValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notPresent/notPresentTagTest02.jsp")));
	}
}
