package org.guojian.wx.domain;

import org.guojian.wx.domain.msg.TextMessage;
import org.guojian.wx.domain.msg.WXMessage;

public enum MsgType {
	/**文本类型*/
	text("text",TextMessage.class),
	/**图片类型*/
	image("image",TextMessage.class),
	/**语音类型*/
	voice("voice",TextMessage.class),
	/**视频类型*/
	video("video",TextMessage.class),
	/**小视频类型*/
	shortvideo("shortvideo",TextMessage.class),
	/**地理位置类型*/
	location("location",TextMessage.class),
	/**连接类型*/
	link("link",TextMessage.class),
	/**事件类型*/
	event("event",TextMessage.class);
	
	 MsgType(String key,Class<? extends WXMessage>clz){
		this.key=key;
		this.clz=clz;
	}
	public final  String key;
	public Class<? extends WXMessage> clz;
	/**
	 * 根据key返回msgType，如果没有找到，默认为text类型
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
