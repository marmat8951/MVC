package moteur;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
protected List<Observer> Observers= new ArrayList<Observer>();

public boolean attach(Observer o){
	return Observers.add(o);
}

public boolean detach(Observer o){
	return Observers.remove(o);
}

public abstract void notifyObservers(String m);

public void closeObservers(){
	for(Observer o:Observers){
		o.close();
	}
}

}

