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
			     try {
					if(login(sCardNumber,sPassword))
					 {
						 new  AlertDialog.Builder(MainActivity.this).setTitle("").
						 setMessage(sCardNumber+","+sPassword).
						 show();
						 
					 }
				} catch (ClientProtocolException e) {
					 new  AlertDialog.Builder(MainActivity.this).setTitle("").
					 setMessage("网络连接失败").
					 show();
//					e.printStackTrace();
				} catch (IOException e) {
					 new  AlertDialog.Builder(MainActivity.this).setTitle("").
					 setMessage("网络连接失败").
					 show();
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
    
    private Boolean login(String cardNumber, String password) throws ClientProtocolException, IOException
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
    	list.add(new param("cardnumber",cardNumber));
    	list.add(new param("password",password));
    	String url = "http://121.248.63.105:8080/authentication/";
//    	String url ="http://127.0.0.1";
    	String result=HttpConnecter.post(url, list); 
    	if(result == null)
    	{
    		return false;
    	}
    	
    	return true;
    }
}
