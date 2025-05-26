

package org.example.mandelbrotview.view;

import javafx.scene.control.*;
import org.example.mandelbrotview.view.components.MandelbrotCanvas;

/** Abstract class that all View-designs of the main window have to extend.
 *
 * @author Maurice Amon
 */
public abstract class View {

    public ToolBar toolBar;

    public MandelbrotCanvas mandelbrotView;

    public abstract void prepareView();

    public abstract void initComponents();

    public abstract void showView();
    
}
