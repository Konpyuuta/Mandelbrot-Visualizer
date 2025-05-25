package org.example.mandelbrotview.commands;

import org.apache.commons.math3.complex.Complex;
import org.example.mandelbrotview.HelloApplication;
import org.example.mandelbrotview.MandelThread;
import org.example.mandelbrotview.MandelbrotArray;
import org.example.mandelbrotview.PixelRange;
import org.example.mandelbrotview.view.MainWindow;
import org.example.mandelbrotview.view.components.MandelbrotToolbar;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Maurice Amon
 */

public class ExecuteCommand implements Command {


    private final Integer WIDTH = 1200;

    private final Integer HEIGHT = 700;

    private Integer amountOfThreads;

    private Integer maxIterations;

    public ExecuteCommand() {
    }

    @Override
    public void execute() {
        MainWindow mainWindow = MainWindow.getInstance(null);
        ((MandelbrotToolbar)mainWindow.getToolBar()).switchFieldEnabling();
        this.amountOfThreads = ((MandelbrotToolbar)mainWindow.getToolBar()).getAmountOfThreads();
        this.maxIterations = ((MandelbrotToolbar)mainWindow.getToolBar()).getIterations();
        CountDownLatch latch = new CountDownLatch(amountOfThreads);
        MandelbrotArray mandelbrotArray = MandelbrotArray.getInstance();
        Complex a = new Complex(0, -1);
        Complex b = new Complex(0, -1);
        Complex c = a.multiply(b);

        Integer widthArea = (int)Math.floor(WIDTH / amountOfThreads);
        Integer heightArea = (int)Math.floor(HEIGHT / amountOfThreads);
        Integer startWidth = 0;
        Integer startHeight = 0;
        System.out.println(Thread.currentThread().getName() + " started.");
        long tStart = System.nanoTime();

        for(int i = 0; i < amountOfThreads; i++) {
            PixelRange widthRange;
            PixelRange heightRange;
            if(i + 1 >= amountOfThreads) {
                widthRange = new PixelRange(startWidth, startWidth + WIDTH);
                heightRange = new PixelRange(startHeight, startHeight + HEIGHT);
            } else {
                widthRange = new PixelRange(startWidth, (i + 1) * widthArea);
                heightRange = new PixelRange(startHeight, (i + 1) * heightArea);
            }

            HelloApplication.executor.submit(new MandelThread(new PixelRange(0, 1200), new PixelRange(startHeight, ((i+1)*heightArea)), latch));
            startWidth = ((i + 1) * widthArea) + 1;
            startHeight = ((i + 1) * heightArea);
        }

        try {
            latch.await();
            long tEnd = System.nanoTime();
            System.out.println(Thread.currentThread().getName() + " finished in " + (tEnd - tStart)/1_000_000 + " ms.");
            System.out.println("Mandelbrot completed.");
            mainWindow.getMandelbrotPane().insertPixelColor(mandelbrotArray.getMandelbrotArray());
            ((MandelbrotToolbar)mainWindow.getToolBar()).switchFieldEnabling();
            /*for (int i = 0; i < mandelbrotArray.getMandelbrotArray().length; i++) {
                for (int j = 0; j < mandelbrotArray.getMandelbrotArray()[i].length; j++) {
                    System.out.print(mandelbrotArray.getMandelbrotArray()[i][j] + " ");
                }
                System.out.println(); // For new row
            }*/




    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
