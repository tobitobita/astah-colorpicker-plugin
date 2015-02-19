package dsk.colorpicker.plugin;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorPickerApplication extends Application {
    
    private static final String FXML_FILE = "ColorPicker.fxml";
    
    public Scene createScene(ClassLoader classLoader) throws IOException {
        if (classLoader == null) {
            classLoader = this.getClass().getClassLoader();
        }
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setClassLoader(classLoader);
        // TODO
        //loader.setResources(ResourceBundle.getBundle("fx_message"));
        try (InputStream is = classLoader.getResource(FXML_FILE).openConnection().getInputStream()) {
            fxmlLoader.load(is);
//            ColorPickerController controller = loader.getController();
            Parent root = fxmlLoader.getRoot();
            Scene scene = new Scene(root);
            return scene;
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(this.createScene(null));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}
