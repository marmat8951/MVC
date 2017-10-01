package TP2.src.main;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class Vue1 implements Observer {

	private Stage newFenetre=new Stage();
	private Slider s=new Slider(Model.MIN_VALUE, Model.MAX_VALUE, 0);	
	public void lunch(Model m){
		m.addObserver(this);
		s.setOrientation(Orientation.VERTICAL);
		newFenetre.setX(100);
		newFenetre.setY(0);
		s.setValue(m.getCelcus());
		s.setShowTickLabels(true);
		s.setShowTickMarks(true);
		s.setMajorTickUnit(10);
		s.setBlockIncrement(0.5);
		s.setMinorTickCount(9);
		newFenetre.setMinHeight(400);
		Scene sceneFenetre=new Scene(s);
		newFenetre.setScene(sceneFenetre);
		newFenetre.setTitle("Slider Celsius");
		newFenetre.setOnCloseRequest(e->{
			m.deleteObserver(this);
		});
		s.setOnMousePressed(e->{
			m.setCelcus(s.getValue());
		});
		s.setOnMouseClicked(e->{
			m.setCelcus(s.getValue());
		});
		s.addEventHandler(ActionEvent.ACTION, e->{
			m.setCelcus(s.getValue());
		});
		s.setOnMouseDragged(e->{
			m.setCelcus(s.getValue());
		});
		s.setOnKeyPressed(e->{
			m.setCelcus(s.getValue());
		});
		newFenetre.show();
	}


	@Override
	public void update(Observable o, Object arg) {
		Model m=(Model)o;
		this.s.setValue(m.getCelcus());
	}

}
