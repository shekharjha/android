package com.shk.autocomplete;

import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	AutoCompleteTextView actv;
	DBHelper db;
	List<Colors> colors;
	String str[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		db = new DBHelper(this);
		db.insertIntoTable("Red");		
		db.insertIntoTable("Blue");
		db.insertIntoTable("Black");
		db.insertIntoTable("Green");
		db.insertIntoTable("Yellow");
		db.insertIntoTable("Violet");
		db.insertIntoTable("Orange");
		db.insertIntoTable("Purple");
		//colors = db.getAllColors();
		str = db.getAllColors();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, str);
		actv.setAdapter(adapter);
		actv.setThreshold(1);
		actv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				arg0.getItemAtPosition(arg2);
				Log.i("SELECTED TEXT WAS------->", str[arg2]);

				// TODO Auto-generated method stub
				
			}
			
		});
	}

	
}
