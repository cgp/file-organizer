package com.cgpsoftware.fileorganizer;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.text.StrSubstitutor;


/**
 * Tried velocity, the latest POM had missing dependencies somehow, this is simpler and more to my liking anyway. 
 *  
 * http://stackoverflow.com/questions/3655424/string-replacement-in-java-similar-to-a-velocity-template
 * 
 */
public class TemplateProcessor
{

	public static String process(Map<String, String> contextMap, String template) {
		StrSubstitutor sub = new StrSubstitutor(contextMap);
		String resolvedString = sub.replace(template);
		return resolvedString;
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("price", "$15.00");
		System.out.println(process(map, "The price is ${price}."));
	}
	
	
}
