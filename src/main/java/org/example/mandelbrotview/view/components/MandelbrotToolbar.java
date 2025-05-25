package org.example.mandelbrotview.view.components;


import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.example.mandelbrotview.commands.MandelbrotCommandClient;

/**
 *
 * @author Maurice Amon
 */

public class MandelbrotToolbar extends ToolBar {

    private MandelbrotCommandClient mandelbrotCommandClient = new MandelbrotCommandClient();

    private final Button EXEC_TOOL = new Button("Run Mandelbrot");

    private final Label THREAD_FIELD_LABEL = new Label("Amount of Threads: ");

    private final TextField THREAD_FIELD = new TextField("1");

    private HBox spacer = new HBox(500);

    private final Label ITERATION_FIELD_LABEL = new Label("Iterations: ");

    private final TextField ITERATION_FIELD = new TextField("1000");


    public MandelbrotToolbar() {
        initComponents();
        setActions();
        spacer.setMinWidth(100);
        super.getItems().addAll(EXEC_TOOL, spacer, THREAD_FIELD_LABEL, THREAD_FIELD, ITERATION_FIELD_LABEL, ITERATION_FIELD);
        super.setStyle("-fx-background-color: linear-gradient(to bottom, #fcfff4 0%,#dfe5d7 40%,#c1beb2 100%);");
    }

    private void initComponents() {
        EXEC_TOOL.setCursor(Cursor.HAND);
        EXEC_TOOL.setTooltip(new Tooltip("Run program"));
    }


    private void setActions() {
        EXEC_TOOL.setId(org.example.mandelbrotview.commands.Actions.EXECUTE_ID);
        EXEC_TOOL.setOnAction(mandelbrotCommandClient);
    }

    public Integer getAmountOfThreads() {
        return Integer.valueOf(THREAD_FIELD.getText());
    }

    public Integer getIterations() {
        return Integer.valueOf(ITERATION_FIELD.getText());
    }

    public void switchFieldEnabling() {
        if(EXEC_TOOL.isDisabled()) {
            EXEC_TOOL.setDisable(false);
        } else {
            EXEC_TOOL.setDisable(true);
        }
    }
}
