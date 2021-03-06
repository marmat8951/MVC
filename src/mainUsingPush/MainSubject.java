package mainUsingPush;

import moteur.Observer;
import moteur.Subject;

public class MainSubject extends Subject{
	
	private String state="";
	
	public void notifyObservers(String s){ // Push version
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

	@Override
	public void notifyObservers() { // Pull Version Not Used Here
		
	}
	

}
