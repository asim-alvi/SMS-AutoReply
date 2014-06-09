package com.example.autoreply;


public class GlobalVariables {

	   private static GlobalVariables instance;
	public String newEntry="I am working out";
	public Integer startHour=0;
	public Integer startMin=0;
	public Integer stopHour=0;
	public Integer stopMin=0;
	public int isOn=1;
	
	
	public GlobalVariables(){
		
	}
	public void setEntry(String s){
		newEntry=s;
	}
	public String getEntry(){
		return newEntry;
	}
	public String getCheck(){
		return "CHECK";
	}
	
	public void setStartHour(Integer i){
		startHour=i;
	}
	public void setStartMin(Integer i){
		startMin=i;
	}
	public void setStopHour(Integer i){
		stopHour=i;
	}
	public void setStopMin(Integer i){
		stopMin=i;
	}
	
	public void setIsOn(int i){
		isOn=i;
		
	}
	
	public static synchronized GlobalVariables getInstance(){
	     if(instance==null){
	       instance=new GlobalVariables();
	     }
	     return instance;
	   }
	
	/*public 	ArrayAdapter<String> spinnerAdapter=null;

	public ArrayAdapter<String> getSpinner(){
		return spinnerAdapter;

		
	}
	
	public void setSpinner(ArrayAdapter<String> s){
		spinnerAdapter=s;

		
	}*/

}
