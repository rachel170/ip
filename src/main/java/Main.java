import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Duke duke = new Duke();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Duke: The AI Butler in Training");
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            // When user close application,
            stage.setOnCloseRequest(e -> {
                // Save Duke's data
                duke.saveAtExit();
            });
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
