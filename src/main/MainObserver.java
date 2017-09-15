package main;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainObserver extends Observer{
	
	private TextArea t=new TextArea();
	Stage newFenetre=new Stage();
	
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

	@Override
	public void update(String message) {
		System.out.println("Updating: "+message);
		t.setText(t.getText()+"\n"+message);
		
	}
	
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
