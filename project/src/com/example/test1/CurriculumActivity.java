package com.example.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CurriculumActivity extends Activity {
	TextView tvUserName ;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_curriculum);
		tvUserName = (TextView)findViewById(R.id.userName);
		Intent intent = getIntent();
		Bundle data = intent.getExtras();
		String sUserName = data.getString("userName");
		tvUserName.setText(sUserName);
	}
}
