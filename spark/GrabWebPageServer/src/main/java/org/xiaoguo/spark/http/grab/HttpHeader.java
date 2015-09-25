package org.xiaoguo.spark.http.grab;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpHeader {
	private Map<String, Object> fields=new HashMap<String, Object>();
	
	private static final String key_Last_Modified="Last-Modified";
	
	private long contentLength=0;
	
	private Date lastModified;
	
	public static HttpHeader create(Map<String, List<String>> headerFields){
		return new HttpHeader(headerFields);
	}
	
	private HttpHeader(Map<String, List<String>> headerFields){
		Iterator<Entry<String, List<String>>> iterator = headerFields.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, List<String>> next = iterator.next();
			List<String> values = next.getValue();
			String key=next.getKey();
			if(!values.isEmpty()){
				String value=values.get(0);
				if(key_Last_Modified.equals(key)){
					fields.put(key, value);	
				}
				else{
				fields.put(key, value);	
			}
			}
		}
	}
	
	public boolean hasKey(String key){
		return fields.containsKey(key);
	}
	
	public <T> T get(String key){
		return (T)fields.get(key);
	}
	
	public long getContentLength(){
		return contentLength;
	}
	
	public Date getLastModified(){
		return lastModified;
	}
	
}
