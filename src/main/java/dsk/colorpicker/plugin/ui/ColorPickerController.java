package dsk.colorpicker.plugin.ui;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.presentation.IPresentation;
import static com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants.Key.FILL_COLOR;
import static com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants.Key.FONT_COLOR;
import static com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants.Key.LINE_COLOR;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;
import java.awt.EventQueue;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorPickerController implements Initializable {

    @FXML
    private ColorPicker fillColor;

    @FXML
    private CheckBox enableFillColor;

    @FXML
    private ColorPicker textColor;

    @FXML
    private CheckBox enableTextColor;

    @FXML
    private ColorPicker lineColor;

    @FXML
    private CheckBox enableLineColor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // #fffec9
        double red = ((double) Integer.decode("0xff")) / 255d;
        double green = ((double) Integer.decode("0xfe")) / 255d;
        double blue = ((double) Integer.decode("0xc9")) / 255d;
        this.fillColor.setValue(new Color(red, green, blue, 1d));
        this.textColor.setValue(Color.BLACK);
        this.lineColor.setValue(Color.BLACK);
    }

    @FXML
    protected void setColorAction(ActionEvent event) {
        final boolean enableFill = this.enableFillColor.isSelected();
        final boolean enableText = this.enableTextColor.isSelected();
        final boolean enableLine = this.enableLineColor.isSelected();
        final Color fill = this.fillColor.getValue();
        final Color text = this.textColor.getValue();
        final Color line = this.lineColor.getValue();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransactionManager.beginTransaction();
                try {
                    IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
                    for (IPresentation presentation : diagramViewManager.getSelectedPresentations()) {
                        String orgColor = presentation.getProperty(FILL_COLOR);
                        if (orgColor != null && !presentation.getProperty(FILL_COLOR).equals("null") && enableFill) {
                            System.out.println(presentation.getProperty(FILL_COLOR));
                            String color = fill.toString().substring(0, 8);
                            presentation.setProperty(FILL_COLOR, color);
                        }
                        orgColor = presentation.getProperty(FONT_COLOR);
                        if (orgColor != null && !presentation.getProperty(FONT_COLOR).equals("null") && enableText) {
                            System.out.println(presentation.getProperty(FONT_COLOR));
                            String color = text.toString().substring(0, 8);
                            presentation.setProperty(FONT_COLOR, color);
                        }
                        orgColor = presentation.getProperty(LINE_COLOR);
                        if (orgColor != null && !presentation.getProperty(LINE_COLOR).equals("null") && enableLine) {
                            System.out.println(presentation.getProperty(LINE_COLOR));
                            String color = line.toString().substring(0, 8);
                            presentation.setProperty(LINE_COLOR, color);
                        }
                    }
                    TransactionManager.endTransaction();
                } catch (InvalidUsingException | InvalidEditingException | ClassNotFoundException e) {
                    TransactionManager.abortTransaction();
                    e.printStackTrace();
                }
            }
        });
    }
}
