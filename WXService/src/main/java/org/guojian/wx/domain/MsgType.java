package org.guojian.wx.domain;

import org.guojian.wx.domain.msg.TextMessage;
import org.guojian.wx.domain.msg.WXMessage;

public enum MsgType {
	/**�ı�����*/
	text("text",TextMessage.class),
	/**ͼƬ����*/
	image("image",TextMessage.class),
	/**��������*/
	voice("voice",TextMessage.class),
	/**��Ƶ����*/
	video("video",TextMessage.class),
	/**С��Ƶ����*/
	shortvideo("shortvideo",TextMessage.class),
	/**����λ������*/
	location("location",TextMessage.class),
	/**��������*/
	link("link",TextMessage.class),
	/**�¼�����*/
	event("event",TextMessage.class);
	
	 MsgType(String key,Class<? extends WXMessage>clz){
		this.key=key;
		this.clz=clz;
	}
	public final  String key;
	public Class<? extends WXMessage> clz;
	/**
	 * ����key����msgType�����û���ҵ���Ĭ��Ϊtext����
	 * */
	public static MsgType get(String key){
		for(MsgType type:values()){
			if(type.key.equals(key)){
				return type;
			}
		}
		return text;
	}
}
