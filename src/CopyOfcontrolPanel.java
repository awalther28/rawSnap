
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import netscape.javascript.JSObject;
public class CopyOfcontrolPanel extends Application //implements EventHandler<Action Event>
{

    public static void main(String[] args){
	launch(args);
}

    @Override

    public void start(Stage primaryStage) throws Exception{
	primaryStage.setTitle("A Control Panel");
	
	GridPane grid = new GridPane();
	grid.setHgap(30);
	grid.setVgap(10);
	grid.setPadding(new Insets(0,10,0,10));


	Button btnOK = new Button("    OK    ");
	Button btnNop = new Button("    NOP   ");
	Button btnHuh = new Button("    Huh    ");

	TextField tSlide = new TextField();
	tSlide.setText("50");
	tSlide.setPrefWidth(50);	
	TextField t1 = new TextField();
	t1.setText("Hello World");
	t1.setPrefWidth(100);
	TextField t2 = new TextField();
	t2.setText("Hello World") ;
	
	Slider s = new Slider(0,100,50);
	s.setShowTickMarks(true);
	s.setShowTickLabels(true);
	//	s.setMajorTickUnit(0.25f);
	//	s.setBlockIncrement(0.1f);
	
	//	s.setOnAction(e -> tSlide.setText("change"));

	WebView browser = new WebView();
        	
	WebEngine webEngine = browser.getEngine();
	// Display a local webpage
	webEngine.load(getClass().getResource("snap.html").toExternalForm());
	JSObject jsobj = (JSObject) webEngine.executeScript("window");
	jsobj.setMember("javaTextField", t1);


	btnOK.setOnAction(e -> 
			  {t1.setText("OK");
			      t2.setText("OK");
			  });
	btnNop.setOnAction(e -> 
			  {t1.setText("Nope");
			      t2.setText("Nope");
			  });
	btnHuh.setOnAction(e -> 
			   {
			       t1.clear();
			       t2.clear();
			  });

	s.valueProperty().addListener(e-> tSlide.setText(String.valueOf(s.getValue())) );

	try{
	tSlide.setOnKeyPressed(e-> s.setValue(Double.parseDouble(tSlide.getCharacters().toString()) ));
	}
	catch (NumberFormatException e1) {

	}



 	grid.add(btnOK,0,0);
 	grid.add(btnNop,1,0);
 	grid.add(tSlide,0,1);
	grid.add(s,0,2,2,1);
	grid.add(btnHuh,1,1);
 	grid.add(t1,0,4,2,1);
 	grid.add(t2,0,5,2,1);
	grid.add(browser,0,6,4,1);
	//rectTop.setFill(Color.PURPLE);

	//top.getChildren().addAll(btnTop, rectTop);       
	//	BPane.setTop(top);		
	Scene scene = new Scene (grid, 300,600);
	primaryStage.setScene(scene);
	primaryStage.show();



    }

}
