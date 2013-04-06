package com.example.test1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOHelper {
	//private static final String[] COLS = new String[]{DAO.COLUMN_ID,DAO.COLUMN_CARD_NUMBER,DAO.COLUMN_PASSWORD};
	private SQLiteDatabase db;
	private final DAO dao;
	public DAOHelper(final Context context)
	{
		dao = new DAO(context);
		if(db==null)
			db=dao.getWritableDatabase();
		//dao.onCreate(db);
	}
	public void insert(final String cardNumber,final String password)
	{
		ContentValues values = new ContentValues();
		values.put(DAO.COLUMN_CARD_NUMBER, cardNumber);
		values.put(DAO.COLUMN_PASSWORD, password);
		db.insert(DAO.TABLE_NAME, null, values);
		db.close();
	}
	public void delete(final String cardNumber)
	{
		db.delete(DAO.TABLE_NAME,DAO.COLUMN_CARD_NUMBER+"="+ cardNumber, null);
		db.close();
	}
	public List<String> getCardNumbers()
	{
		List<String> result = new ArrayList<String>();
		String column[] = new String[]{DAO.COLUMN_CARD_NUMBER};
		Cursor cursor = db.query(DAO.TABLE_NAME, column, null, null, null, null, null);
		for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext())
		{
			String temp = cursor.getString(0);
			result.add(temp);
		}
		return result;
	}
}
