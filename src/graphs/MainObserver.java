package graphs;

import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import main.MainSubject;
import moteur.Observer;

public class MainObserver extends Observer {
	Stage newFenetre=new Stage();
	
	public void lunch(MainSubject ms){
		PieChart pc=new PieChart();
		Scene sceneFenetre=new Scene(pc);
		
		
	}

	//PUSH VERSION, NOT USED HERE
	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		
	}

	//PULL VERSION
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
