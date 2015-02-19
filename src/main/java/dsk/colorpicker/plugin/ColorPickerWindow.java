package dsk.colorpicker.plugin;

import java.awt.Dimension;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.JFrame;

public class ColorPickerWindow extends JFrame {

    public ColorPickerWindow() {
        this.initComponents();
    }

    private void initComponents() {
        this.setSize(new Dimension(320, 240));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        final JFXPanel panel = new JFXPanel();
        this.add(panel);
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final ColorPickerApplication app = new ColorPickerApplication();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {
                    panel.setScene(app.createScene(classLoader));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
