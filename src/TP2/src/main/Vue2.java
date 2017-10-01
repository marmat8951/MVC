package TP2.src.main;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Vue2 implements Observer {
	private Button bp=new Button("+");
	private Button bm=new Button("-");
	private TextField tf=new TextField();
	private Stage newFenetre=new Stage();
	private HBox hbxbutton=new HBox();
	private VBox root=new VBox();
	DecimalFormat f = new DecimalFormat();
	
	private Controler1 c;
	
	public void lunch(Model m){
		m.addObserver(this);
		f.setMaximumFractionDigits(2);
		c=new Controler1(m);
		newFenetre.setX(200);
		newFenetre.setY(0);
		hbxbutton.getChildren().add(bm);
		hbxbutton.getChildren().add(bp);
		hbxbutton.setAlignment(Pos.CENTER);
		root.getChildren().addAll(tf,hbxbutton);
		tf.setText(f.format(m.getCelcus()));
		tf.setAlignment(Pos.CENTER);
		Scene sceneFenetre=new Scene(root);
		newFenetre.setScene(sceneFenetre);
		newFenetre.setTitle("Degres Celcus");
		newFenetre.setOnCloseRequest(e->{
			m.deleteObserver(this);
		});
		bp.addEventHandler(ActionEvent.ACTION, e->{
			c.incDegCel();
		});
		bm.addEventHandler(ActionEvent.ACTION, e->{
			c.decDegCel();
		});
		tf.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER){
				try{
				c.setDegCel(Double.parseDouble(tf.getText()));
				}
				catch(Exception exc){
					tf.setText(Double.toString(m.getCelcus()));
					System.err.println("non");
				}
			}
		});
		newFenetre.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		Model m=(Model)o;
		this.tf.setText(f.format(m.getCelcus()));
		if(m.getCelcus()==Model.MAX_VALUE){
			bp.setDisable(true);
		}else if(m.getCelcus()==Model.MIN_VALUE){
			bm.setDisable(true);
		}	
		else{
			bp.setDisable(false);
			bm.setDisable(false);
		}
	}

}
