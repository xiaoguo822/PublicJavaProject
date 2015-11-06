package org.guojian.wx.domain.msg;

import org.w3c.dom.Element;

/**
 * 微信消息的父类
 * @author xiaoguo
 *
 */
public abstract class WXMessage {
	/*** 开发者微信号 */
	protected String toUserName;
	/**发送方帐号（一个OpenID）*/
	protected String fromUserName;
	/**消息创建时间*/
	protected int CreateTime;
	/**	 * 消息类型 */
	protected String MsgType;
	/**消息id*/
	protected long MsgId;
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public int getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
	
	public abstract WXMessage parse(Element xml);
}
