package dsk.colorpicker.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;

public class ColorPickerWindow extends JFrame {

    private static final String FXML_FILE = "ColorPicker.fxml";

    private boolean initFx;

    private ColorPickerController controller;

    public ColorPickerWindow() {
        this.initComponents();
    }

    private void initComponents() {
        if (initFx) {
            return;
        }
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        final JFXPanel panel = new JFXPanel();
        this.add(panel);
        final ClassLoader classLoader = this.getClass().getClassLoader();
        this.initFx = true;
        FutureTask<Void> futureTask = new FutureTask<>(() -> {
            panel.setScene(createScene(classLoader));
            return null;
        });
        Platform.runLater(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Scene createScene(ClassLoader classLoader) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(classLoader);
        // TODO
        //loader.setResources(ResourceBundle.getBundle("fx_message"));
        try (InputStream is = classLoader.getResource(FXML_FILE).openConnection().getInputStream()) {
            loader.load(is);
            this.controller = loader.getController();
            Parent root = loader.getRoot();
            Scene scene = new Scene(root);
            return scene;
        }
    }
}
