package com.shk.autocomplete;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

	static String DB_NAME = "colordb";
	static int DB_VERSION = 1;
	String sql;
	String table_name = "color_tbl";
	String color_id = "id";
	String color_name = "name";
	SQLiteDatabase db;
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		sql = "create table " + table_name +" ("+ color_id +" integer primary key, " +
				color_name +" text);";
		db.execSQL(sql);
		Log.i("Table created","Table created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.i("Table Updated","Table Updated");
	}
	public void insertIntoTable(String name){
		if(!chkColor(name)){
		db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(color_name, name);
		db.insert(table_name, null, values);
		db.close();
		Log.i("Insert Status", "Data inserted");
		}else{
			Log.i("Insert Status", "Duplicate Entry not aallowed");	
		}
	}
	public String[] getAllColors(){
		
		//List<Colors> colors = new ArrayList<Colors>();
		db = this.getReadableDatabase();
		String all = "Select * from "+ table_name;
		Cursor cur = db.rawQuery(all, null);
		if(cur.moveToFirst()){
			String[] str = new String[cur.getCount()];
			int i = 0;
			do{
				//Colors c = new Colors();
				//c.setId(cur.getInt(cur.getColumnIndex(color_name)));
				//c.setColorName(cur.getString(cur.getColumnIndex(color_name)));
				str[i] = cur.getString(cur.getColumnIndex(color_name));
				//colors.add(c);
				i++;
			}while(cur.moveToNext());			
			return str;
	    }
		//return colors;
		return new String[]{};
	}
	public boolean chkColor(String name){
		db = this.getReadableDatabase();
		String sql = "Select * from " + table_name + " where " + color_name+ " = '"+name+"'";
		Cursor cur = db.rawQuery(sql, null);
		if(cur.getCount() > 0){
			return true;
		}else{
			return false;
		}
	}
}
