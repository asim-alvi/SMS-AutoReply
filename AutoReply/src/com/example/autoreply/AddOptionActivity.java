package com.example.autoreply;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddOptionActivity extends Activity {
	
	private Button addbutton;
	public EditText message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_option);
		newMessage();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_option, menu);
		return true;
	}
	
	public void newMessage(){
		
		addbutton=(Button)findViewById(R.id.addMes);

		message=(EditText)findViewById(R.id.editText1);
		System.out.println("Hi");

		System.out.println("Hello");

		addbutton.setOnClickListener(
		        new View.OnClickListener()
		        {
		            public void onClick(View view)
		            {
		        	    
		            	//MainActivity MA = ((MainActivity)getApplicationContext());
		            	
		        	    //MA.spinnerAdapter.add(message.getText().toString());
		        		GlobalVariables g = GlobalVariables.getInstance();
		        		g.setEntry(message.getText().toString());
		                Log.v("EditText", message.getText().toString());
		                finish();
		            }
		        });
		}
		
	}


