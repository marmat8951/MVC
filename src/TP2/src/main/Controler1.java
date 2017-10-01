package TP2.src.main;

public class Controler1 {
	private Model m;
	public Controler1(Model m){
		this.m=m;
	}
	
	public boolean incDegCel(){
		return m.setCelcus(m.getCelcus()+1);
		
		
	}
	public boolean incDegFar(){
		return m.setFarenheit(m.getFarenheit()+1);
	}
	
	public boolean decDegFar(){
		return m.setFarenheit(m.getFarenheit()-1);
	}
	public boolean decDegCel(){
		return m.setCelcus(m.getCelcus()-1);
	}
	public boolean setDegCel(double val){
		return m.setCelcus(val);
	}
	public boolean setDegFar(double val){
		return m.setFarenheit(val);
	}
}
