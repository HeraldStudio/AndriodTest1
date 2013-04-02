package com.example.test1;

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
			     if(login(sCardNumber,sPassword))
			     {
			    	 
			    	 
			     }
			     new  AlertDialog.Builder(MainActivity.this).setTitle("").
			    		 setMessage(sCardNumber+","+sPassword).
			    		 show();
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private Boolean login(String cardNumber, String password)
    {
    	return false;
    }
}
