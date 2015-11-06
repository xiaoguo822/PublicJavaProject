package org.guojian.wx.suport;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	public String encrypt(String strSrc, String encName)
	  {
	    MessageDigest md = null;
	    String strDes = null;
	    
	    byte[] bt = strSrc.getBytes();
	    try
	    {
	      if ((encName == null) || (encName.equals(""))) {
	        encName = "MD5";
	      }
	      md = MessageDigest.getInstance(encName);
	      md.update(bt);
	      strDes = bytes2Hex(md.digest());
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	      System.out.println("Invalid algorithm.");
	      return null;
	    }
	    return strDes;
	  }
	  
	  private String bytes2Hex(byte[] bts)
	  {
	    String des = "";
	    String tmp = null;
	    for (int i = 0; i < bts.length; i++)
	    {
	      tmp = Integer.toHexString(bts[i] & 0xFF);
	      if (tmp.length() == 1) {
	        des = des + "0";
	      }
	      des = des + tmp;
	    }
	    return des;
	  }
}
