package com.xuebusi.xssm.test.mms;

import com.xuebusi.xssm.test.mms.client.MMSClient;
import com.xuebusi.xssm.test.mms.client.SingletonClient;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;

public class TestMMSDemo {

	public static void main(String[] args) {
		try {
			byte[] content = readContent();
			testSendMMS("�����������Ͳ��Žӿ�", "15801081566", content, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���Ͳ���
	 */
	public static void testSendMMS(String mmsTitle, String userNumbers, byte[] content, int sendType) {
		try {
			String userName = "bf-test";
			String password = "c5f1213ce8";
			MMSClient mmsClient = SingletonClient.getClient(userName, password);
			String result = mmsClient.sendMMS(mmsTitle, userNumbers, content, sendType);
			System.out.println(result);
			if (StringUtils.isEmpty(result) && result.startsWith("OK")) {
				System.out.println("���ŷ��ͳɹ�=====================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ��������
	 * @return
	 */
	private static byte[] readContent() {
		FileInputStream fs;
		try {
			fs = new FileInputStream("Report.zip");
			byte[] content=new byte[fs.available()];
			fs.read(content,0,content.length);
			fs.close();
			return content;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ѯ���
	 * 1�������˻���2�ǵ㿨�˻�
	 */
	public static void testGetBalance() {
		try {
			String userName = "bf-test";
			String password = "c5f1213ce8";
			System.out.println(SingletonClient.getClient(userName, password).getMMSCount(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���״̬����
	 */
	public static void testGetReport() {
		try {
			String userName = "bf-test";
			String password = "c5f1213ce8";
			System.out.println(SingletonClient.getClient(userName, password).getStatusReport());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
