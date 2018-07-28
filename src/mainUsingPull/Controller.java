package mainUsingPull;

public class Controller {
	private MainSubject subject;
	
	public Controller(MainSubject ms) {
		subject = ms;
	}
	
	public void addLine(String s) {
		subject.setState(subject.getState()+"\n"+s);
		subject.notifyObservers();
	}

}
