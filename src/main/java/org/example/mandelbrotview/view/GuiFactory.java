
package org.example.mandelbrotview.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.example.mandelbrotview.view.components.MandelbrotCanvas;

/**
 *
 * @author Maurice Amon
 */
public abstract class GuiFactory {   

    public abstract ToolBar createToolBar();
    
    public abstract MandelbrotCanvas createMandelbrotPane();
}
