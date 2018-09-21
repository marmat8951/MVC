package mainUsingPush;

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

	MainSubject ms=new MainSubject();
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
				ms.notifyObservers(message.getText());
				tf.setText(tf.getText()+"\n"+message.getText());
				message.setText("");
				
				
			}
			
		});
		
		sendMessage.addEventHandler(ActionEvent.ACTION, e->{
			ms.notifyObservers(message.getText());
			tf.setText(tf.getText()+"\n"+message.getText());
			message.setText("");
		});
		
		
		buttonNewAudit.setText("Nouvel Auditeur");
		buttonNewAudit.setPrefWidth(Double.MAX_VALUE);
		buttonNewAudit.addEventHandler(ActionEvent.ACTION, e->{
			MainObserver mo=new MainObserver();
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
