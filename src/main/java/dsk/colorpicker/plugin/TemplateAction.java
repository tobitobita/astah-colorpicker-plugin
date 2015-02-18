package dsk.colorpicker.plugin;

import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;

public class TemplateAction implements IPluginActionDelegate {
    private ColorPickerWindow picker = new ColorPickerWindow();

    @Override
    public Object run(IWindow window) throws UnExpectedException {
        System.out.println("run");
        picker.setVisible(true);
//        TransactionManager.beginTransaction();
//        try {
//            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
//            Arrays.stream(diagramViewManager.getSelectedPresentations()).forEach(presentation -> {
//                try {
//                    presentation.setProperty(FILL_COLOR, "#80FFCCCC");
//                    presentation.setProperty(LINE_COLOR, "#80FF0000");
//                    presentation.setProperty(FONT_COLOR, "#800000FF");
//                } catch (InvalidEditingException e) {
//                    e.printStackTrace();
//                }
//            });
//            TransactionManager.endTransaction();
//        } catch (InvalidUsingException | ClassNotFoundException e) {
//            TransactionManager.abortTransaction();
//            e.printStackTrace();
//        }
        return null;
    }
}
