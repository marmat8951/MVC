package mainUsingPull;

import moteur.Observer;
import moteur.Subject;

public class MainSubject extends Subject{
	
	private String state="";
	
	public void notifyObservers(){
		for(Observer o:Observers){
			o.update();
		}
	}
	
	public String getState(){
		return state;
	}
	
	protected void setState(String s){
		state=s;
	}

	@Override
	public void notifyObservers(String m) {
		notifyObservers();
	}
	

}
