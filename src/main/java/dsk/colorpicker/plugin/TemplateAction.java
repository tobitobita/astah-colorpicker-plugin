package dsk.colorpicker.plugin;

import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;

public class TemplateAction implements IPluginActionDelegate {

    private ColorPickerWindow picker;

    @Override
    public Object run(IWindow window) throws UnExpectedException {
        System.out.println("run");
        if (picker == null) {
            picker = new ColorPickerWindow(window.getParent());
        }
        picker.setVisible(true);
        return null;
    }
}
