package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NotEqualTagTest extends TagTestBase {
  
	@Test 
	public void testNameValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEqual/notEqualTagTest01.jsp")));
	}
	
	@Test 
	public void testNamePropertyValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEqual/notEqualTagTest02.jsp")));
	}
	
	@Test 
	public void testNameName2() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEqual/notEqualTagTest03.jsp")));
	}
	
	@Test 
	public void testNamePropertyName2Property2() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEqual/notEqualTagTest04.jsp")));
	}
}
