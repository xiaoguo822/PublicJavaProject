package org.xiaoguo.spark.http.grab;

public class HttpParameterKeyValue {
	/**¼üÖµÁ¬½Ó·ûºÅ*/
	private final static String SPLIT_SYMBOL="=";
	
	public String key;
	private String value;

	public HttpParameterKeyValue(String key) {
		this.key = key;
	}

	public HttpParameterKeyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return  value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer(key);
		sb.append(SPLIT_SYMBOL);
		sb.append(value);
		return sb.toString();
	}
}
