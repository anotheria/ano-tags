package net.anotheria.tags;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WriteTagTest extends TagTestBase {
  
	@Test 
	public void testLinebreak() throws Exception {
		String content = testJSP("/write/linebreakTest.jsp");
		//System.out.println("content: "+content);
		assertTrue(content.indexOf("Hello<br>World")!=-1);
	}
	
}
