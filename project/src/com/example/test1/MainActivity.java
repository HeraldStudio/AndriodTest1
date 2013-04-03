package com.example.test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

   EditText etCardNumber;
   EditText etPassword ;
   Button btLogin;
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
			     if( sCardNumber == null || sPassword == null)
			     {
			    	 return ;
			     }
			     AlertDialog.Builder message = new  AlertDialog.Builder(MainActivity.this);
			     String result = null; 
			     try {
			    	result = login(sCardNumber,sPassword);
					if(result != null)
					 {
						
						 String[] userInfo = result.split(","); 
						 message.setMessage("欢迎你，"+userInfo[0]).show();
					 }
					else
					{
						message.setMessage("用户名或密码错误").show();
					}
				} catch (ClientProtocolException e) {
					 message.setMessage("ClientProtocolException").show();
//					e.printStackTrace();
				} catch (IOException e) {
					message.setMessage("IOException").show();
//					e.printStackTrace();
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
    
    private String login(String cardNumber, String password) throws ClientProtocolException, IOException
    {
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
    	List<NameValuePair> list = new ArrayList<NameValuePair>();
    	list.add(new param("username",cardNumber));
    	list.add(new param("password",password));
    	String url = "http://121.248.63.105:8080/authentication/";
//    	String url = "http://www.baidu.com";
    	String result=HttpConnecter.post(url, list); 
//    	String result=HttpConnecter.get(url); 
//    	if(result == null)
//    	{
//    		return false;
//    	}
//    	
//    	return true;
    	return result;
    }
}
