package net.anotheria.tags;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchTagTest extends TagTestBase {
  
	@Test 
	public void testStringValue() throws Exception {
		assertEquals(2, countOKinContent(testJSP("/match/matchTagTest01.jsp")));

		assertEquals(1, countOKinContent(testJSP("/match/matchTagTest02.jsp")));

	}


}
