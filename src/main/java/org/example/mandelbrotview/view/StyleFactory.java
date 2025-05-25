package org.example.mandelbrotview.view;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.example.mandelbrotview.view.components.MandelbrotCanvas;
import org.example.mandelbrotview.view.components.MandelbrotToolbar;


/** Concrete Factory for the standard design of the application ..
 *
 * @author Maurice
 */
public class StyleFactory extends GuiFactory {

    @Override
    public ToolBar createToolBar() {
        return new MandelbrotToolbar();
    }

    @Override
    public MandelbrotCanvas createMandelbrotPane() {
        return new MandelbrotCanvas();
    }




}
