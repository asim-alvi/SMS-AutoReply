package com.example.autoreply;

import java.util.ArrayList;
import java.util.List;


import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private static final String TAG = null;
	private Spinner replymessage;
	public static String response="I am busy, I will reply soon";
	private Button setMessage;
	private Button Add;
	private Button sched;
	private CheckBox checkbox;
	public ArrayAdapter<String> spinnerAdapter=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AudioManager audio_mngr = (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
		audio_mngr .setRingerMode(AudioManager.RINGER_MODE_SILENT);
		setAway();
		System.out.println("Nap");
	}

	protected void onResume(){
	    super.onResume();
		System.out.println("Were Back");
		GlobalVariables g = GlobalVariables.getInstance();
		System.out.println(g.getEntry());
		spinnerAdapter.add(g.getEntry());
		spinnerAdapter.notifyDataSetChanged();
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addOptions() {
		 
		/*replymessage = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		//add item to list
		list.add("list 1");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		replymessage.setAdapter(dataAdapter);
		*/
	  }
	
	public void setAway(){
		replymessage = (Spinner) findViewById(R.id.spinner1);
		//GlobalVariables g = (GlobalVariables)getApplication();
		//System.out.println(g.getCheck());
		spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		replymessage.setAdapter(spinnerAdapter);
		spinnerAdapter.add("I am driving, I will reply soon");
		spinnerAdapter.add("I am asleep, I will reply when I wake up");
		spinnerAdapter.add("I am in a meeting, I will reply when I get out");
		spinnerAdapter.add("I am busy, I will reply soon");
		spinnerAdapter.add("I am in class, I will respond when I get out");
		spinnerAdapter.notifyDataSetChanged();
		setMessage = (Button) findViewById(R.id.setMessage);
		Add= (Button) findViewById(R.id.Add);
		sched= (Button) findViewById(R.id.schedule);
		checkbox= (CheckBox)findViewById(R.id.checkBox1);
        checkbox.setChecked(true);

		checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
        		GlobalVariables g = GlobalVariables.getInstance();

				if(checkbox.isChecked()){
					g.setIsOn(1);
				}
				else{
					g.setIsOn(0);
				}
				
			}
			
		});
		Add.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddOptionActivity.class);
				startActivity(intent);
				System.out.println("Hola");
				//GlobalVariables g = GlobalVariables.getInstance();
				//System.out.println(g.getEntry());
				//spinnerAdapter.add(g.getEntry());
				//spinnerAdapter.notifyDataSetChanged();

			}
			
		});
		
		
		 
		setMessage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				response=String.valueOf(replymessage.getSelectedItem());
				Log.v(TAG,String.valueOf(replymessage.getSelectedItem()));
				
			}
	});
		
		sched.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Scheduler.class);
				startActivity(intent);
				
			}
			
		});
	}

}
