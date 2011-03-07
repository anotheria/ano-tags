package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EqualTagTest extends TagTestBase {
  
	@Test 
	public void testNameValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/equal/equalTagTest01.jsp")));
	}
	
	@Test 
	public void testNamePropertyValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/equal/equalTagTest02.jsp")));
	}
	
	@Test
	public void testNameName2() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/equal/equalTagTest03.jsp")));
	}
	
	@Test
	public void testNamePropertyName2Property2() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/equal/equalTagTest04.jsp")));
	}
}
