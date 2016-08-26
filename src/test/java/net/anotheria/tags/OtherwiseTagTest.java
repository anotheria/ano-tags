package net.anotheria.tags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OtherwiseTagTest extends TagTestBase {
  
	@Test 
	public void testOneTrue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/otherwise/otherwiseTagTest01.jsp")));
	}
	
	@Test 
	public void testNoneTrue() throws Exception {
		assertEquals(1, countOKinContent(testJSP("/otherwise/otherwiseTagTest02.jsp")));
	}
}
