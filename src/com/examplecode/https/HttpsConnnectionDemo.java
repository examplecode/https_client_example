package com.examplecode.https;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpsConnnectionDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException   {
		// ����URL����
        URL myURL = new URL("http://localhost:2000");
 
        // ����HttpsURLConnection���󣬲�������SSLSocketFactory����
        HttpURLConnection httpsConn = (HttpURLConnection) myURL.openConnection();
        
        httpsConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36");
        httpsConn.setDoOutput(true);
        httpsConn.setRequestMethod("POST");
        
        httpsConn.getOutputStream().write("a=test&b=test2".getBytes());
//        httpsConn.geth
 
        // ȡ�ø����ӵ����������Զ�ȡ��Ӧ����
        InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());
 
        // ��ȡ����������Ӧ���ݲ���ʾ
        int respInt = insr.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = insr.read();
        }

	}

}
