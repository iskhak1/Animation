package sample;


import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    FadeTransition fadeTransition;
    TranslateTransition translateTransition;
    RotateTransition rotateTransition;
    ScaleTransition scaleTransition;
    Scene sceneRect;
    Scene scene2;
    Button returnAll;
    Button addCircle;
     int max = 5;
    @Override
    public void start(Stage window) throws Exception {
        Pane  pane = new Pane();
        Pane pane2 = new Pane();

        Rectangle[] rectangle = new Rectangle[max];
        int y = 0;
        for (int i = 0; i < rectangle.length; i++) {

            rectangle[i] = new Rectangle(10, 50 * (i + 1) + (y * i)  , 50, 50 );
            rectangle[i].setArcHeight(15);
            rectangle[i].setArcWidth(15);
            rectangle[i].setFill(Color.DARKBLUE);
            y = 50;
        }

        for (int i = 0; i < rectangle.length; i++) {

            fadeTransition = new FadeTransition(Duration.millis(3500), rectangle[i]);
            fadeTransition.setByValue(1.0f);
            fadeTransition.setToValue(0.3f);
            fadeTransition.setCycleCount(2);
            fadeTransition.setAutoReverse(true);

            translateTransition = new TranslateTransition(Duration.millis(2000), rectangle[i]);
            translateTransition.setFromX(10);
            translateTransition.setToX(300);
            translateTransition.setCycleCount(2);
            translateTransition.setAutoReverse(true);

            rotateTransition = new RotateTransition(Duration.millis(3000), rectangle[i]);
            rotateTransition.setByAngle(180f);
            rotateTransition.setCycleCount(4);
            rotateTransition.setAutoReverse(true);


            scaleTransition = new ScaleTransition(Duration.millis(2000), rectangle[i]);
            scaleTransition.setToX(2f);
            scaleTransition.setToY(2f);
            scaleTransition.setCycleCount(2);
            scaleTransition.setAutoReverse(true);


            ParallelTransition parallelTransition = new ParallelTransition();
            parallelTransition.getChildren().addAll(
                    fadeTransition,
                    translateTransition,
                    rotateTransition,
                    scaleTransition
            );
            parallelTransition.setCycleCount(Timeline.INDEFINITE);
            parallelTransition.play();
        }
        int y2 = 0 ;
        Circle[] circle = new Circle[max];
        for (int i = 0; i <circle.length ; i++) {
            circle[i] = new Circle(300,50 * (i + 1) + (y2 * i),25);
            circle[i].setFill(Color.BURLYWOOD);

            y2 = 50;
        }
        for (int i = 0; i < rectangle.length; i++) {

            fadeTransition = new FadeTransition(Duration.millis(2000), circle[i]);
            fadeTransition.setByValue(1.0f);
            fadeTransition.setToValue(0.3f);
            fadeTransition.setCycleCount(Timeline.INDEFINITE);
            fadeTransition.setAutoReverse(true);

            translateTransition = new TranslateTransition(Duration.millis(1500), circle[i]);
            translateTransition.setFromX(300);
            translateTransition.setToX(-290);
            translateTransition.setCycleCount(Timeline.INDEFINITE);
            translateTransition.setAutoReverse(true);


            scaleTransition = new ScaleTransition(Duration.millis(2000), circle[i]);
            scaleTransition.setToX(4f);
            scaleTransition.setToY(2f);
            scaleTransition.setCycleCount(Timeline.INDEFINITE);
            scaleTransition.setAutoReverse(true);


            ParallelTransition parallelTransition2 = new ParallelTransition();
            parallelTransition2.getChildren().addAll(
                    fadeTransition,
                    translateTransition,
                    scaleTransition
            );
            parallelTransition2.setCycleCount(Timeline.INDEFINITE);
            parallelTransition2.play();
        }

        returnAll = new Button("return");
        returnAll.setVisible(true);
        returnAll.setTranslateX(200);


        addCircle = new Button("addCircle");
        addCircle.setVisible(true);

        addCircle.setOnAction(event -> { //addCircle
           pane2.getChildren().addAll(returnAll, addCircle);
           window.setScene(scene2);
        });

        returnAll.setOnAction(event -> {//return
            pane.getChildren().addAll(returnAll, addCircle);
            window.setScene(sceneRect);
        });

        scene2 = new Scene(pane2, 700, 500);
        for (int i = 0; i < circle.length; i++) {
            pane2.getChildren().add(circle[i]);
        }
        pane2.getChildren().addAll(returnAll, addCircle);


         sceneRect = new Scene(pane, 700, 500);
         for (int i = 0; i < rectangle.length; i++) {
             pane.getChildren().add(rectangle[i]);
         }
         pane.getChildren().addAll(returnAll, addCircle);
         window.setTitle("Rectangle");
         window.setScene(sceneRect);
         window.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
