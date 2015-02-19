package dsk.colorpicker.plugin.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ColorPickerWindow extends JDialog {

    public ColorPickerWindow(Window owner) {
        super(owner);
        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("カラー設定");
        this.setResizable(false);
        this.setSize(new Dimension(244, 180));
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ColorPickerWindow window = new ColorPickerWindow(null);
                window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                window.setVisible(true);
            }
        });
    }
}
