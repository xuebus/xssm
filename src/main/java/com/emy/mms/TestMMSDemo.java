package com.emy.mms;

import com.emy.mms.client.MMSClient;
import com.emy.mms.client.SingletonClient;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;

public class TestMMSDemo {

	public static void main(String[] args) {
		try {
			String mmsTitle = "�����������Ͳ��Žӿ�";
			String userNumbers = "15801081566";
			int sendType = 1;
			byte[] content = readContent();
			String result = sendMMS(mmsTitle, userNumbers, content, sendType);
			System.out.println(result);
			if (!StringUtils.isEmpty(result) && result.startsWith("OK")) {
				System.out.println("���ŷ��ͳɹ�=====================");
			} else {
				System.out.println("���ŷ���ʧ��=====================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���Ͳ���
	 */
	public static String sendMMS(String mmsTitle, String userNumbers, byte[] content, int sendType) {
		String result = null;
		try {
			String userName = "bf-test";
			String password = "c5f1213ce8";
			MMSClient mmsClient = SingletonClient.getClient(userName, password);
			result = mmsClient.sendMMS(mmsTitle, userNumbers, content, sendType);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
