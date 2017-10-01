package TP2.src.main;

import java.util.Observable;

public class Model extends Observable {
	private double valcelcus;
	public static final double MIN_VALUE=-20;
	public static final double MAX_VALUE=100;
	
	public Model(){
		valcelcus=20;
	}
	
	public boolean setCelcus(double val){
		if(val>=MIN_VALUE && val<=MAX_VALUE){
		valcelcus=val;
		this.setChanged();
		notifyObservers();
		return true;
		}
		return false;
	} 
	
	public boolean setFarenheit(double val){
		if((val-32)*(5.0/9.0)>=MIN_VALUE && (val-32)*(5.0/9.0)<=MAX_VALUE){
		valcelcus=(val-32)*(5.0/9.0);
		this.setChanged();
		notifyObservers();
		return true;
		}
		return false;
	}
	public double getCelcus(){
		return  valcelcus;
	}
	public double getFarenheit(){
		return valcelcus*(9.0/5.0)+32;
		
	}
	

}
