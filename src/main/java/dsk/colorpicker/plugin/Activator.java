package dsk.colorpicker.plugin;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;
import com.change_vision.jude.api.inf.view.IEntitySelectionEvent;
import java.util.Arrays;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) {
        try {
            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
            diagramViewManager.addEntitySelectionListener((IEntitySelectionEvent event) -> {
                Arrays.stream(diagramViewManager.getSelectedPresentations()).forEach(presentation -> {
                    System.out.printf("NAME: %s\n", presentation.getLabel());
                    System.out.printf("FILL: %s\n", presentation.getProperty(PresentationPropertyConstants.Key.FILL_COLOR));
                    System.out.printf("LINE: %s\n", presentation.getProperty(PresentationPropertyConstants.Key.LINE_COLOR));
                    System.out.printf("FONT: %s\n", presentation.getProperty(PresentationPropertyConstants.Key.FONT_COLOR));
                });
                Arrays.stream(diagramViewManager.getSelectedElements()).forEach(element -> {
                    if (element instanceof INamedElement) {
                        INamedElement namedElement = (INamedElement) element;
                        System.out.printf("NAME: %s\n", namedElement.getName());
//                        namedElement.getPresentations()
                        
                    }
                });
            });
        } catch (InvalidUsingException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(BundleContext context) {
    }
}
