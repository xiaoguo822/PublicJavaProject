package org.guojian.wx.domain.msg;
import org.guojian.wx.suport.Utils;
import org.w3c.dom.Element;
public class TextMessage extends WXMessage {
	/**文本消息内容*/
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public TextMessage parse(Element xml) {
		TextMessage msg=new TextMessage();
		msg.toUserName = xml.getElementsByTagName("ToUserName").item(0).getTextContent();
	    msg.fromUserName = xml.getElementsByTagName("FromUserName").item(0).getTextContent();
	    msg.content = xml.getElementsByTagName("Content").item(0).getTextContent();
	    msg.CreateTime  = Utils.intValue( xml.getElementsByTagName("CreateTime").item(0).getTextContent());
	    msg.MsgId=Utils.longValue(xml.getElementsByTagName("MsgId").item(0).getTextContent());
	    return msg;
	}
}
