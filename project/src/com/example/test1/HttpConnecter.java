package com.example.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpConnecter {
	public static String  get(String uri) throws ClientProtocolException,IOException
	{
		HttpClient httpClient  = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(uri);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if(statusCode >=200 && statusCode <400)
		{
			StringBuilder stringBuilder  =  new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
			for(String s = reader.readLine();s!=null;s=reader.readLine())
			{
				stringBuilder.append(s);
			}
			reader.close();
			return stringBuilder.toString();
			
		}
		return null;
	}
	
	public static String post(String uri,List<NameValuePair>formparams) throws ClientProtocolException, IOException
	{
		HttpClient httpClient = new DefaultHttpClient();
		UrlEncodedFormEntity  entity = new UrlEncodedFormEntity(formparams,"UTF-8");
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(entity);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if(statusCode >=200 && statusCode <400)
		{
			StringBuilder stringBuilder  =  new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
			for(String s = reader.readLine();s!=null;s=reader.readLine())
			{
				stringBuilder.append(s);
			}
			reader.close();
			return stringBuilder.toString();
			
		}
		return null;
		
	}
}
