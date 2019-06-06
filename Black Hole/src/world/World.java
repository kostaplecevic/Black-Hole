
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends Application {

    public static int WIDTH = 900;
    public static int HEIGHT = 700;
//    final int TARGET_FPS = 60;
//    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    long lastLoopTime;

    GScene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("The Big Bang");
        
        scene = new GScene();
        scene.init();
        

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

//        Image earth = new Image("blue.png");
//        Image sun = new Image("sun.png");
//        Image space = new Image("space.png");

        lastLoopTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentLoopTime) {
                double delta = (currentLoopTime - lastLoopTime) / 1000000000.0;
                lastLoopTime = currentLoopTime;
//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);

                scene.update(delta);
//                gc.clearRect(0, 0, WIDTH,HEIGHT);
                scene.draw(gc);
            }
        }.start();

        theStage.show();
    }
}