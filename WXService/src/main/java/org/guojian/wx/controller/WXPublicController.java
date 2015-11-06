package org.guojian.wx.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.guojian.wx.suport.Encrypt;
import org.guojian.wx.suport.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     @Controller
@RequestMapping("/")
public class WXPublicController {
	
	private final static String EncodingAESKey="0123456789zxcvbnmasdfghjklqwertyuiop9876543";
	private final static String token = "guojian";
	private final static  String appId = "wx82cd3c06b901ccd6";
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String post(HttpServletRequest req,@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce,@RequestParam("encrypt_type") String encrypt_type,@RequestParam("msg_signature") String msg_signature) throws IOException, AesException, ParserConfigurationException, SAXException {
		Optional<String> optlContent = Utils.inputStream2String(req.getInputStream());
		if (optlContent.isPresent()) {
			ByteArrayInputStream is = new ByteArrayInputStream(optlContent.get().getBytes("UTF8"));
			Optional<String> inputStream2String = Utils.inputStream2String(is);
			if(inputStream2String.isPresent()){
				String replyMsg = inputStream2String.get();	
				WXBizMsgCrypt pc = new WXBizMsgCrypt(token, EncodingAESKey, appId);
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				StringReader sr = new StringReader(replyMsg);
				InputSource ins = new InputSource(sr);
				Document document = db.parse(ins);

				Element root = document.getDocumentElement();
				NodeList nodelist1 = root.getElementsByTagName("Encrypt");
				NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

				String encrypt = nodelist1.item(0).getTextContent();
				//String msgSignature = nodelist2.item(0).getTextContent();

				
				//
				// 公众平台发送消息给第三方，第三方处理
				//

				// 第三方收到公众号平台发送的消息
				String result2 = pc.decryptMsg(msg_signature, timestamp, nonce, replyMsg);
				System.out.println("解密后明文: " + result2);
			}
		}

		return "";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) throws IOException {

		if (nonce == null) {
			return "nonce is null!";
		}
		if (signature == null) {
			return "signature is null!";
		}
		if (timestamp == null) {
			return ("timestamp is null!");
		}
		List<String> list = new ArrayList<String>();
		String token = "guojian";
		list.add(token);
		list.add(timestamp);
		list.add(nonce);
		Collections.sort(list);
		String sign = list.stream().reduce((result,item)->result+item).get();
		Encrypt e = new Encrypt();
		if (e.encrypt(sign, "SHA1").equals(signature)) {
			return (echostr);
		} else {
			return "Validation fails!";
		}

	}
}
