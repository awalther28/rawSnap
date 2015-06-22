
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class controlPanel extends Application // implements EventHandler<Action
												// Event>
{

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("A Control Panel");

		GridPane grid = new GridPane();
		grid.setHgap(30);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		Button javaLand = new Button();
		javaLand.setText("Hello JavaScript");
		

		TextField t1 = new TextField();
		t1.setText("XML Here");
		t1.setPrefWidth(1000);

		TextField t2 = new TextField();
		t2.setText("where am I?");
		t2.setPrefWidth(1000);

		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();
		
		// Display a local webpage
		webEngine.load(getClass().getResource("snap.html").toExternalForm());
		JSObject jsobj = (JSObject) webEngine.executeScript("window");
		jsobj.setMember("javaTextField", t1);
		jsobj.setMember("javaProcess", t2);

		grid.add(t1, 0, 4, 2, 1);
		grid.add(t2, 0, 5, 2, 1);
		grid.add(browser, 0, 6, 4, 1);

		Scene scene = new Scene(grid, 1000, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
