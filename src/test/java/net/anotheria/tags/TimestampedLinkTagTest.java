package net.anotheria.tags;

import net.anotheria.util.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimestampedLinkTagTest extends TagTestBase {

	private final String LINK1 = "link1";
	private final String LINK2 = "link2";
	private final String LINK3 = "link3";

	@Test
	public void testMethod() throws Exception {

		for (String s : testJSP("/timestampedLink/test01.jsp").split("\\n")) {
			if (s.contains(LINK1)) {
				assertEquals("quantity of char '?' is wrong ", 1, StringUtils.charCount(s, '?') );
				assertEquals("quantity of char '%' is wrong ", 1, StringUtils.charCount(s, '&') );
			}

			if (s.contains(LINK2)) {
				assertEquals("quantity of char '?' is wrong ", 1, StringUtils.charCount(s, '?') );
				assertEquals("quantity of char '%' is wrong ", 2, StringUtils.charCount(s, '&') );
			}

			if (s.contains(LINK3)) {
				assertEquals("quantity of char '?' is wrong ", 1, StringUtils.charCount(s, '?') );
				assertEquals("quantity of char '%' is wrong ", 0, StringUtils.charCount(s, '&') );
			}
		}

//		try{
//			testJSP("/timestampedLink/test02.jsp");
//			fail("exception should be thrown");
//		} catch (Exception e){
//			assertTrue("Unexpected exception", e instanceof JspException);
//		}
	}


}
