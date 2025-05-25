package org.example.mandelbrotview.commands;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Maurice Amon
 */

public class MandelbrotCommandClient implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
        Command command;
        switch (getItemId(actionEvent)) {
            case Actions.EXECUTE_ID:
                command = new ExecuteCommand();
                break;
            default:
                command = new DoNothingCommand();
                break;
        }
        command.execute();
    }

        /** Extract the ID from the GUI-component that fired the event ..
         *
         * @param event
         * @return
         */

        private String getItemId(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            return ((Button) event.getSource()).getId();
        }
        if (event.getSource() instanceof MenuItem) {
            return ((MenuItem) event.getSource()).getId();
        }
        return null;
    }
}
