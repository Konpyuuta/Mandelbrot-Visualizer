package org.example.mandelbrotview;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.mandelbrotview.view.MainWindow;
import org.example.mandelbrotview.view.StyleFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MandelbrotVisualizer extends Application {

    private final Integer WIDTH = 1200;

    private final Integer HEIGHT = 700;

    public static ExecutorService executor = Executors.newFixedThreadPool(10);


    @Override
    public void start(Stage stage) throws IOException {
        MainWindow window = MainWindow.getInstance(new StyleFactory());
        window.prepareView();
        window.initComponents();
        window.showView();

    }

    public static void main(String[] args) {
        launch();
    }
}