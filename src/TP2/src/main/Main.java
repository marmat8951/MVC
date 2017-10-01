package TP2.src.main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		Model mj=new Model();
		Vue1 v1=new Vue1();
		Vue2 v2=new Vue2();
		Vue3 v3=new Vue3();
		v1.lunch(mj);
		v2.lunch(mj);
		v3.lunch(mj);
		
	}

}
