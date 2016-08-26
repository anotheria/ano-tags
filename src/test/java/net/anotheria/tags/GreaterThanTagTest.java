package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreaterThanTagTest extends TagTestBase {
  
	@Test 
	public void testNameValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/greaterThan/greaterThanTagTest01.jsp")));
	}
	
	@Test 
	public void testNamePropertyValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/greaterThan/greaterThanTagTest02.jsp")));
	}
	
	@Test 
	public void testNameName2() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/greaterThan/greaterThanTagTest03.jsp")));
	}
	
	@Test 
	public void testNamePropertyName2Property2() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/greaterThan/greaterThanTagTest04.jsp")));
	}
}
