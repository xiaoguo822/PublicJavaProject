package org.xiaoguo.spark.http.grab;

public class Http {
	private String url;
	private HttpMethod method;
	private HttpParameter parameter;
	public Http(String url){
		this(url,HttpMethod.GET);
	}
	public Http(String url,HttpMethod method){
		this(url,method,HttpParameter.empty());
	}
	
	public Http(String url,HttpMethod method,HttpParameter param){
		this.url=url;
		this.method=method;
		this.parameter=param;
	}
	

	
}
