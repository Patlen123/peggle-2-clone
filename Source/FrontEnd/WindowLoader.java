package Source.FrontEnd;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/***
 * This class is used to load new windows.
 * @author Christian Sanger
 */
public class WindowLoader {
    private static final String fileLocation = "Source/FrontEnd/FXML/";
    // Reference to the primary stage, it's public so it can be used with CustomAlerts
    public static Stage w;
	FXMLLoader loader;
	URL fxmlURL;
    /***
     * Creates a window loader that changes the scene shown to the user.
     * @param window any Node object on the stage that you wish control.
     */
    public WindowLoader(Node window) {
        w = (Stage) window.getScene().getWindow();
    }

	/**
	 * Creates a new window loader that can change the current scene in this window
	 * @param primaryStage primary stage as reference to which window to change
	 */
	public WindowLoader(Stage primaryStage) {
		w = primaryStage;
	}

	/***
	 * swaps the scene for the given scene. Window should file be the scene file name
	 * i.e. to swap to MenuScreen.fxml use "MenuScreen"
	 *
	 * @param window scene name
	 * @param initData state of application
	 */
	public void load(String window, HashMap<String, String> initData) {
		Parent root = null;
		try {
			loader = new FXMLLoader();
			String fxmlFile = fileLocation + window + ".fxml";
			URL fxmlURL_weird = getClass().getClassLoader().getResource(fxmlFile);
			fxmlURL = (new File(fxmlFile).toURI().toURL());
			loader.setLocation(Objects.requireNonNull(fxmlURL));

			root = loader.load();
			StateLoad controller = loader.getController();
			controller.setInitData(initData);
			controller.initialize(null, null);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		if (root == null) {
			System.exit(1);
		} else {
			if (w.getScene() == null) {
				w.setFullScreen(true);
				w.setScene(new Scene(root));
			} else {
				w.setFullScreen(true);
				w.getScene().setRoot(root);
			}
		}
	}

}
