package mainUsingPull;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application{

	private MainSubject ms=new MainSubject();
	private Controller ctrl = new Controller(ms);
	@Override
	public void start(Stage stage) throws Exception {
		VBox root=new VBox();
		Button buttonNewAudit=new Button();
		Button sendMessage=new Button();
		TextField message =new TextField();
		TextArea tf=new TextArea();
		tf.setMinWidth(Double.MAX_VALUE);
		tf.setMinHeight(100);
		tf.setText("Messages: \n");
		tf.setEditable(false);
		message.setPrefWidth(Double.MAX_VALUE);
		sendMessage.setText("SendMessage");
		sendMessage.setPrefWidth(Double.MAX_VALUE);
		
		message.addEventHandler(KeyEvent.KEY_PRESSED, e->{
			if(e.getCode()==KeyCode.ENTER){
				ctrl.addLine(message.getText());
				ms.notifyObservers();
				tf.setText(ms.getState());
				message.clear();
			}
			
		});
		
		sendMessage.addEventHandler(ActionEvent.ACTION, e->{
			ctrl.addLine(message.getText());
			ms.notifyObservers();
			tf.setText(ms.getState());
			message.clear();
		});
		
		
		buttonNewAudit.setText("Nouvel Auditeur");
		buttonNewAudit.setPrefWidth(Double.MAX_VALUE);
		buttonNewAudit.addEventHandler(ActionEvent.ACTION, e->{
			MainObserver mo=new MainObserver(ms);
			ms.attach(mo);
			mo.lunch(ms);
			
		});
		root.getChildren().add(buttonNewAudit);
		
		
		
		root.getChildren().add(tf);
		root.getChildren().add(message);
		root.getChildren().add(sendMessage);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setOnCloseRequest(e->{
			ms.closeObservers();
		});
		stage.setTitle("RadioTchat");
		stage.show();

	}
	
	public static void main(String[] args) {
	    Application.launch(args);
	}

}
