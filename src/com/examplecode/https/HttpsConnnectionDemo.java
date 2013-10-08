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
		// 创建URL对象
        URL myURL = new URL("http://localhost:2000");
 
        // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
        HttpURLConnection httpsConn = (HttpURLConnection) myURL.openConnection();
        
        httpsConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36");
        httpsConn.setDoOutput(true);
        httpsConn.setRequestMethod("POST");
        
        httpsConn.getOutputStream().write("a=test&b=test2".getBytes());
//        httpsConn.geth
 
        // 取得该连接的输入流，以读取响应内容
        InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());
 
        // 读取服务器的响应内容并显示
        int respInt = insr.read();
        while (respInt != -1) {
            System.out.print((char) respInt);
            respInt = insr.read();
        }

	}

}
