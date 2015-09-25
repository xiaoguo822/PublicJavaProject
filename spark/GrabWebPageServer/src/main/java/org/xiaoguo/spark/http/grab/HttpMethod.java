package org.xiaoguo.spark.http.grab;

public enum HttpMethod {
	GET("get"),
	POST("post");
	
	private String name;
	
	HttpMethod(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
