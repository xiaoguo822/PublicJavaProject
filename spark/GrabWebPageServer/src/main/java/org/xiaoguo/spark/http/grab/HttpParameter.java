package org.xiaoguo.spark.http.grab;

import java.util.ArrayList;
import java.util.List;

/**
 * http ²ÎÊý
 * 
 * @author xiaoguo
 *
 */
public class HttpParameter {

	private final static HttpParameter emptyParam = new HttpParameter();

	private List<HttpParameterKeyValue> kvs = new ArrayList<HttpParameterKeyValue>();

	public static HttpParameter empty() {
		return emptyParam;
	}

	public void addParam(HttpParameterKeyValue kv) {
		kvs.add(kv);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < kvs.size(); i++) {
			if (i != 0) {
				sb.append("&");
			}
			sb.append(kvs.get(i));
		}
		return sb.toString();
	}

}
