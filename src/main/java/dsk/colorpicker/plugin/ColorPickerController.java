package dsk.colorpicker.plugin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class ColorPickerController implements Initializable {

    private final Model m = new Model();

    @FXML
    private Label label;

    @FXML
    private Slider slider;

    @FXML
    private TextField text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.m.redProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            System.out.println("model");
            label.setText(newValue.toString());
            slider.setValue(newValue.doubleValue());
            text.setText(newValue.toString());
        });
        this.slider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            System.out.println("slider");
            m.setRed(newValue.intValue());
        });
        this.text.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            System.out.println("text");
            try {
                int value = Integer.parseInt(newValue);
                if (value >= 0 || value <= 100) {
                    m.setRed(value);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
    }
}
