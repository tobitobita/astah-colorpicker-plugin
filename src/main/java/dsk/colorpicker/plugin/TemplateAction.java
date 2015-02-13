package dsk.colorpicker.plugin;

import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;
import javafx.application.Platform;

public class TemplateAction implements IPluginActionDelegate {

    @Override
    public Object run(IWindow window) throws UnExpectedException {
        Platform.runLater(() -> {
            
        });
        return null;
    }
}
