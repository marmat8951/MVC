package graphs;

import moteur.Observer;
import moteur.Subject;

public class MainSubject extends Subject {
	
	private double val1=25;
	private double val2=50;
	private double val3=25;

	@Override
	public void notifyObservers(String m) {
		for(Observer o : Observers){
			o.update();
		}

	}

	public double getVal1() {
		return val1;
	}

	public double getVal2() {
		return val2;
	}

	public double getVal3() {
		return val3;
	}

	public void setVal1(double val1) {
		this.val1 = val1;
	}

	public void setVal2(double val2) {
		this.val2 = val2;
	}

	public void setVal3(double val3) {
		this.val3 = val3;
	}
	
	

}
