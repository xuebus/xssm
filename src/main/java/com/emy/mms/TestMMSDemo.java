package com.emy.mms;

import com.emy.mms.client.MMSClient;
import com.emy.mms.client.SingletonClient;

import java.io.FileInputStream;

public class TestMMSDemo {

	public static void main(String[] args) {
		// ���Է��Ͳ���
		System.out.println(sendMMS());
		System.out.println("====================");

		// ���Բ�ѯ���
		System.out.println(testGetBalance());
		System.out.println("====================");

		// ���Ի��״̬����
		System.out.println(testGetReport());


	}
	
	/**
	 * ���Ͳ���
	 */
	public static String sendMMS() {
		String result = null;
		try {
			String mmsTitle = "�����������Ͳ��Žӿ�";
			String userNumbers = "15801081566";
			int sendType = 1;
			byte[] content = readContent();
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
	public static Long testGetBalance() {
		Long mmsCount = null;
		try {
			String userName = "bf-test";
			String password = "c5f1213ce8";
			System.out.println();
			MMSClient mmsClient = SingletonClient.getClient(userName, password);
			mmsCount = mmsClient.getMMSCount(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mmsCount;
	}
	
	/**
	 * ���״̬����
	 */
	public static String testGetReport() {
		String statusReport = null;
		try {
			String userName = "bf-test";
			String password = "c5f1213ce8";
			MMSClient mmsClient = SingletonClient.getClient(userName, password);
			statusReport = mmsClient.getStatusReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusReport;
	}

}
