package com.example.test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

   EditText etCardNumber;
   EditText etPassword ;
   Button btLogin;
   AlertDialog.Builder message; 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLogin= (Button)findViewById(R.id.login);
        etCardNumber = (EditText)findViewById(R.id.cardNumber);
        etPassword   = (EditText)findViewById(R.id.password);
        btLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 String sCardNumber = etCardNumber.getText().toString();
			     String sPassword = etPassword.getText().toString();
			     message= new  AlertDialog.Builder(MainActivity.this);
			     if( sCardNumber != null && sPassword != null)
			     {
			    	 login(sCardNumber,sPassword);
			     }
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    class param implements NameValuePair
	{
		private String name;
		private String value;
		param(String name,String value)
		{
			this.name = name;
			this.value = value;
		}
		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getValue() {
			return value;
		}
		
	}
	class LoginTask extends AsyncTask<Void,Integer,String>{
		String url;
		List<NameValuePair> list;
		LoginTask(String url,List<NameValuePair> list){
			this.url = url;
			this.list = list;
		}
		@Override
		protected String doInBackground(Void... arg0) {
			try {
				String result = HttpConnecter.post(url, list);
				return result;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				message.setMessage("ClientProtocolException").show();
			} catch(IOException e){
				e.printStackTrace();
				message.setMessage("Error").show();
			}
			return null;
		}
		@Override
	    protected void onPostExecute(String result) {
			if(result != null){
				if(result == "ConnectTimeoutException"){
					message.setMessage("网络连接超时").show();
				}else{
					String[] userInfo = result.split(","); 
//				message.setMessage("欢迎你，"+userInfo[0]).show();
					Bundle data = new Bundle();
					data.putString("userName", userInfo[0]);
					Intent intent = new Intent(MainActivity.this,CurriculumActivity.class);
					intent.putExtras(data);
					startActivity(intent);

				}
				
			}else{
				message.setMessage("用户名或密码错误").show();
			}
	    }
		
	}
    private void login(String cardNumber, String password) 
    {
    	
    	ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	if(networkInfo == null || !networkInfo.isConnected()){
    		message.setMessage("网络连接错误").show();
    	}else{
    		List<NameValuePair> list = new ArrayList<NameValuePair>();
        	list.add(new param("username",cardNumber));
        	list.add(new param("password",password));
        	String url = "http://121.248.63.105:8080/authentication/";
        	LoginTask loginTask = new LoginTask(url,list);
        	loginTask.execute();
    	}
    }
}
