package net.anotheria.tags;

import org.apache.jasper.servlet.JspServlet;
import org.junit.Before;
import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;

import static org.junit.Assert.assertEquals;

public class TagTestBase {

	private ServletTester tester = new ServletTester();
	private HttpTester request = new HttpTester();
	private HttpTester response = new HttpTester();
	 
	@Before
	public void setUp() throws Exception { 
	    tester.setResourceBase(".");
	    tester.addServlet(JspServlet.class, "*.jsp");
	    tester.start();
	    request.setMethod("GET");
	    request.setVersion("HTTP/1.0");
	  }
	  
	protected String testJSP(String jspFilename) throws Exception {
		request.setURI("/src/test/jsp" + jspFilename);
		response.parse(tester.getResponses(request.generate()));
		assertEquals(null, response.getMethod());
		assertEquals(200, response.getStatus());
		return response.getContent();
	}
	
	protected int countOKinContent(String content) {
		if(content.indexOf("NO") != -1) {
			return -1;
		}
		
		int ok = 0;
		int i = 0;
		while((i = content.indexOf("OK", i))>-1) {
			i+=2;
			ok++;
		}
		return ok;
	}
}
