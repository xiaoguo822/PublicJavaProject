package org.xiaoguo.spark.http.grab;
/**
 * 每一个url是一个单独的对象
 * 请求的结果基本类型是byte[]
 * 我们可以根据Content-Type决定返回的具体类型和后续操作
 * @author xiaoguo
 *
 */
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
