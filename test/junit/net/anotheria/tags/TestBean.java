package net.anotheria.tags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBean {


	public String get122StringValue() {
		return "122";
	}
	
	public String get123StringValue() {
		return "123";
	}
	
	public String get124StringValue() {
		return "124";
	}
	
	public String getAnother123StringValue() {
		return "123";
	}
	
	public String get456StringValue() {
		return "456";
	}
	

	public String getEmptyStringValue() {
		return "";
	}
	
	public String getNotEmptyStringValue() {
		return "Not Empty";
	}
	
	public Collection<String> getEmptyCollectionValue() {
		return new ArrayList<String>();
	}

	public Collection<String> getNotEmptyCollectionValue() {
		List<String> result = new ArrayList<String>();
		result.add("Not empty");
		return result;
	}
	
	public Map<String, String> getEmptyMapValue() {
		return new HashMap<String, String>();
	}
	
	public Map<String, String> getNotEmptyMapValue() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("not","empty");
		return result;
	}
	
	public String[] getEmptyArrayValue() {
		return new String[0];
	}

	public String[] getNotEmptyArrayValue() {
		return new String[1];
	}
	
	public String getNullValue() {
		return null;
	}
	
	public String getLinebrokenValue(){
		return "Hello\nWorld";
	}
	
	@Override
	public String toString() {
		return "123";
	}
}
