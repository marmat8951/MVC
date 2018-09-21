package mainUsingPull;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import moteur.Observer;

public class MainObserver extends Observer{

	private TextArea t=new TextArea();
	Stage newFenetre=new Stage();
	private MainSubject ms;
	
	public MainObserver(MainSubject subjectToWatch) {
		ms = subjectToWatch;
	}

	public void lunch(MainSubject ms){

		t.setEditable(false);
		t.setText(ms.getState());
		Scene sceneFenetre=new Scene(t);
		newFenetre.setScene(sceneFenetre);
		newFenetre.setTitle("Auditeur");
		newFenetre.setOnCloseRequest(e->{
			ms.detach(this);
		});
		newFenetre.show();
	}
	

	//PULL VERSION 
	@Override
	public void update() {
		t.setText(ms.getState());
	}
	
	//PUSH VERSION (NOT USED HERE)
	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		
	}

	
	
	//close
	public void close(){
		newFenetre.close();
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	


}
