package main;

public class MainSubject extends Subject{
	
	private String state="";
	
	public void notifyObservers(String s){
		state=state+"\n"+s;
		for(Observer o:Observers){
			o.update(s);
		}
	}
	
	public String getState(){
		return state;
	}
	public void setState(String s){
		state=s;
	}
	

}
