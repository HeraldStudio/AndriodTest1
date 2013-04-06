package com.example.test1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DAO extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "myDataBase";
	public static final String TABLE_NAME = "user";
	public static final int    DATABASE_VERSION = 1;
	public static final String COLUMN_ID ="id";
	public static final String COLUMN_CARD_NUMBER = "cardNumber";
	public static final String COLUMN_PASSWORD ="password";
	public static final String CREATE ="create table "+TABLE_NAME+"("
			+COLUMN_ID+" integer primary key autoincrement not null , "
			+COLUMN_CARD_NUMBER+" text not null , "
			+COLUMN_PASSWORD+" text not null );";
	DAO(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE);
		Log.w(DATABASE_NAME, CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("drop table if exists "+TABLE_NAME);
		onCreate(database);
	}

}
