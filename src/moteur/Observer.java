package moteur;

public abstract class Observer {
	
public abstract void update(String message);

public abstract void update();

public abstract void close();
}
