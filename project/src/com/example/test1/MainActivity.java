package com.example.test1;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button)findViewById(R.id.login);
        final EditText etCardNumber = (EditText)findViewById(R.id.cardNumber);
        final EditText etPassword   = (EditText)findViewById(R.id.password);
        btLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 String sCardNumber = etCardNumber.getText().toString();
			     String sPassword = etPassword.getText().toString();	
			     new  AlertDialog.Builder(MainActivity.this).setTitle("µÇÂ½").
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
    
}
