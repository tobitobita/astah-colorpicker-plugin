package dsk.colorpicker.plugin.action;

import dsk.colorpicker.plugin.ui.ColorPickerWindow;
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;

public class ColorPickerAction implements IPluginActionDelegate {

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
