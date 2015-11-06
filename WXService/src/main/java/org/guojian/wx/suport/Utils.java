package org.guojian.wx.suport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class Utils {
	public static Optional<String> inputStream2String(InputStream in) {
		try {
			StringBuffer out = new StringBuffer();
			byte[] b = new byte[4096];
			int n;
			while ((n = in.read(b)) != -1) {
				out.append(new String(b, 0, n));
			}
			return Optional.of(out.toString());
		} catch (IOException e) {
			return Optional.empty();
		}
	}
	/**
	 * StringתΪint��
	 * ������� ��Ϊ0
	 * @param value
	 * @return
	 */
	public static int intValue(String value) {
		if(StringUtils.isNotEmpty(value) && NumberUtils.isNumber(value))
			return Double.valueOf(value).intValue();
		else
			return 0;
	}
	
	public static int intValue(Integer value) {
		if(null == value)
			return 0;
		else
			return value;
	}
	/**
	 * StringתΪlong��
	 * ������� ��Ϊ0
	 * @param value
	 * @return
	 */
	public static long longValue(String value) {
		if(StringUtils.isNotEmpty(value) && NumberUtils.isNumber(value))
			return Long.valueOf(value);
		else
			return 0;
	}
	public static long longValue(Long value) {
		if(null == value)
			return 0;
		else
			return value;
	}
	/**
	 * StringתΪdouble��
	 * ������� ��Ϊ0.0
	 * @param value
	 * @return
	 */
	public static double doubleValue(String value) {
		if(StringUtils.isNotEmpty(value) && NumberUtils.isNumber(value))
			return Double.valueOf(value);
		else
			return 0.0D;
	}
	public static double doubleValue(Double value){
		if(null == value)
			return 0.0D;
		else
			return value;
	}
	
	/**
	 * StringתΪfloat��
	 * ������� ��Ϊ0.0
	 * @param value
	 * @return
	 */
	public static float floatValue(String value) {
		if(StringUtils.isNotEmpty(value) && NumberUtils.isNumber(value))
			return Float.valueOf(value);
		else
			return 0.0f;
	}
	public static float floatValue(Float value){
		if(null == value)
			return 0.0f;
		else
			return value;
	}
	
	/**
	 * StringתΪboolean��
	 * ������� ��Ϊfalse
	 * @param value
	 * @return
	 */
	public static boolean booleanValue(String value) {
		if("true".equalsIgnoreCase(value) && value != null)
			return true;
		else
			return false;
	}
	
}
