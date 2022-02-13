package sample;


import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    FadeTransition fadeTransition;
    TranslateTransition translateTransition;
    RotateTransition rotateTransition;
    ScaleTransition scaleTransition;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane  pane = new Pane();

        Rectangle[] rectangle = new Rectangle[4];
        int y = 0;
        for (int i = 0; i < rectangle.length; i++) {

            rectangle[i] = new Rectangle(10, 50 * (i + 1) + (y * i)  , 50, 50 );
            rectangle[i].setArcHeight(15);
            rectangle[i].setArcWidth(15);
            rectangle[i].setFill(Color.DARKBLUE);
            y = 50;
        }

        for (int i = 0; i < rectangle.length; i++) {

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(3500), rectangle[i]);
            fadeTransition.setByValue(1.0f);
            fadeTransition.setToValue(0.3f);
            fadeTransition.setCycleCount(2);
            fadeTransition.setAutoReverse(true);

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), rectangle[i]);
            translateTransition.setFromX(10);
            translateTransition.setToX(300);
            translateTransition.setCycleCount(2);
            translateTransition.setAutoReverse(true);

            RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), rectangle[i]);
            rotateTransition.setByAngle(180f);
            rotateTransition.setCycleCount(4);
            rotateTransition.setAutoReverse(true);


            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectangle[i]);
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



        Scene sceneRect = new Scene(pane, 700, 500);
        for (int i = 0; i < rectangle.length; i++) {

            pane.getChildren().add(rectangle[i]);
        }

        primaryStage.setScene(sceneRect);
        primaryStage.show();


    }


    public static void main(String[] args) {

        Application.launch(args);
    }
}
