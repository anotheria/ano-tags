package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LessThanTagTest extends TagTestBase {
  
	@Test 
	public void testNameValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/lessThan/lessThanTagTest01.jsp")));
	}
	
	@Test 
	public void testNamePropertyValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/lessThan/lessThanTagTest02.jsp")));
	}
}
