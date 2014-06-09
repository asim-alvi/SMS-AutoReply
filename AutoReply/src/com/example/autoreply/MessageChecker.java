package com.example.autoreply;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.format.Time;
import android.util.Log;

public class MessageChecker extends BroadcastReceiver{


	private static final String TAG = null;
	private int flag=1;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
			 Bundle bundle = intent.getExtras();
			 if(bundle != null){
				 System.out.println("Message Recieved");
	        		GlobalVariables g = GlobalVariables.getInstance();

				 checkSchedule();
				 Object[] pdus = (Object[]) bundle.get("pdus");
				    SmsMessage[] messages = new SmsMessage[pdus.length];
				    for (int i = 0; i < pdus.length; i++)
				    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
				    for (SmsMessage message : messages) {
				    String to = message.getOriginatingAddress();
				    SmsManager smsManager = SmsManager.getDefault();
					if(flag==1 && g.isOn==1){
				    smsManager.sendTextMessage(to, null, MainActivity.response, null, null);
					}
				    Log.v(TAG,to); 
			 }
			 }
			 else{
				 Log.v(TAG,"Nothing");
			 }
		}
		
	}
	
	public void checkSchedule(){
		GlobalVariables g = GlobalVariables.getInstance();
		System.out.println(g.startHour+":"+g.startMin);
		Time current= new Time();
		current.setToNow();
		Integer startHour=g.startHour;
		Integer startMin=g.startMin;
		Integer stopHour=g.stopHour;
		Integer stopMin=g.stopMin;
		if((startHour!=0)&&(startMin!=0)&&(stopHour!=0)&&(stopMin!=0)){
		int starttime=(startHour*60)+startMin;
		int stoptime=(stopHour*60)+stopMin;
		int currenttime=(current.hour*60)+current.minute;
		if(starttime<stoptime){
			if((currenttime>=starttime) && (currenttime<=stoptime)){
				//do stuff
				flag=1;
			}
			else if(currenttime>stoptime){
				Integer i=0;
				g.setStartHour(i);
        		g.setStartMin(i);
        		g.setStopHour(i);
        		g.setStopMin(i);
        		flag=1;
			}
			else{
				flag=0;
			}
		}
		
		if(starttime>stoptime){
			if((currenttime<=(int)starttime) && (currenttime>=(int)stoptime)){
				//do stuff
				flag=1;
			}
			else if(currenttime>stoptime){
				Integer i=0;
				g.setStartHour(i);
        		g.setStartMin(i);
        		g.setStopHour(i);
        		g.setStopMin(i);
			}
			else{
				flag=0;
			}
		}
		}
	}

}
