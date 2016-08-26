package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NotEmptyTagTest extends TagTestBase {
  
	@Test 
	public void testStringValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEmpty/notEmptyTagTest01.jsp")));
	}
	
	@Test 
	public void testCollectionValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEmpty/notEmptyTagTest02.jsp")));
	}

	@Test 
	public void testMapValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEmpty/notEmptyTagTest03.jsp")));
	}
	
	@Test 
	public void testArrayValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/notEmpty/notEmptyTagTest04.jsp")));
	}
}
