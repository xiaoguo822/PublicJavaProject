package org.guojian.wx.domain.msg;

import org.w3c.dom.Element;

/**
 * ΢����Ϣ�ĸ���
 * @author xiaoguo
 *
 */
public abstract class WXMessage {
	/*** ������΢�ź� */
	protected String toUserName;
	/**���ͷ��ʺţ�һ��OpenID��*/
	protected String fromUserName;
	/**��Ϣ����ʱ��*/
	protected int CreateTime;
	/**	 * ��Ϣ���� */
	protected String MsgType;
	/**��Ϣid*/
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
