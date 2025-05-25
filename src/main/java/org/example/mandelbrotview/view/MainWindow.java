
package org.example.mandelbrotview.view;

import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.mandelbrotview.view.components.MandelbrotCanvas;


/** Class initializes the IDE Window of the application ..
 *
 * @author Maurice Amon
 */
public class MainWindow extends View {

    private final String WINDOW_TITLE = "Mandelbrot Viewer";

    private Scene scene;

    public Stage stage;

    private GuiFactory factory;

    private final VBox VERT_LAYOUT = new VBox();

    private static MainWindow mainWindow = null;

    private MainWindow(GuiFactory factory) {
        this.factory = factory;
    }

    public static MainWindow getInstance(GuiFactory factory) {
        if (mainWindow == null) {
            mainWindow = new MainWindow(factory);
        }
        return mainWindow;
    }

    @Override
    public void prepareView() {
        this.toolBar = factory.createToolBar();
        this.mandelbrotView = factory.createMandelbrotPane();
    }

    @Override
    public void initComponents() {
        VERT_LAYOUT.getChildren().addAll(this.toolBar, this.mandelbrotView);
        stage = new Stage();
        scene = new Scene(VERT_LAYOUT, 1200, 720);
        stage.setTitle(WINDOW_TITLE);
        stage.setScene(scene);
        stage.setWidth(1200);
        stage.setHeight(720);
        stage.setResizable(false);
        //stage.getIcons().add(new Image("/logo.png"));
    }

    @Override
    public void showView() {
        stage.show();
    }

    public MandelbrotCanvas getMandelbrotPane() {
        return mandelbrotView;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }


}
