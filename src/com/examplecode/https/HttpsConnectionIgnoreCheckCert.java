package com.examplecode.https;

import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * ����֤����
 * @author mac
 *
 */
public class HttpsConnectionIgnoreCheckCert {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception   {
		
		
		// ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
        TrustManager[] tm = { new ExpX509TrustManager() };;
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // ������SSLContext�����еõ�SSLSocketFactory����
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        
        // ����URL����
		// ����URL����
        URL myURL = new URL("https://github.com");
 
        // ����HttpsURLConnection���󣬲�������SSLSocketFactory����
        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
        
        httpsConn.setSSLSocketFactory(ssf);
        
        
        
 
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


class ExpX509TrustManager implements X509TrustManager{
	   public ExpX509TrustManager(){}
	   public void checkClientTrusted(X509Certificate[] chain,   String authType) {}
	      public void checkServerTrusted(X509Certificate[] chain,String authType) {
	       //System.out.println("cert: " + chain[0].toString() + ", authType: " + authType);
	      }
	      public X509Certificate[] getAcceptedIssuers() {
	       return null;
	      }
	}
