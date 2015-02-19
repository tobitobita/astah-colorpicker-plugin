package dsk.colorpicker.plugin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
        this.m.redProperty().bindBidirectional(this.slider.valueProperty());
        this.label.textProperty().bind(this.m.redProperty().asString());
    }

    @FXML
    protected void textAction(ActionEvent event) {
        System.out.println("text");
        // TODO Bean validateと組み合わせるはず。
        try {
            int value = Integer.parseInt(text.getText());
            if (value >= 0 || value <= 100) {
                m.setRed(value);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
