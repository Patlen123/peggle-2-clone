package Source.FrontEnd;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowLoader wl = new WindowLoader(primaryStage);
        HashMap<String, String> initData;initData = new HashMap<>();
        
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Peggle 2");
        primaryStage.setResizable(true);
        wl.load("GameScreen", initData);
    }
}
