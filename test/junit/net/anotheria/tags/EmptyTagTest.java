package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmptyTagTest extends TagTestBase {
  
	@Test 
	public void testStringValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/empty/emptyTagTest01.jsp")));
	}
	
	@Test 
	public void testCollectionValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/empty/emptyTagTest02.jsp")));
	}

	@Test 
	public void testMapValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/empty/emptyTagTest03.jsp")));
	}
	
	@Test 
	public void testArrayValue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/empty/emptyTagTest04.jsp")));
	}
}
