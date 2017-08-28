package com.goit.homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Star extends Application {

    private static Label SetLabel(String text, int TranslateX, int TranslateY) {
        Label l = new Label();
        l.setText(text);
        l.setTranslateX(TranslateX);
        l.setTranslateY(TranslateY);

        return l;
    }

    private static int StringToInteger(TextField textField) {
        return Integer.parseInt(textField.getText());
    }

    private static Line CreateLine(String id, double startX, double startY, double endX, double endY) {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);

        line.setId(id);

        return line;
    }

    public void show(Stage stage){
        start(stage);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Star");
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        Pane root = new Pane();

        TextField text1 = new TextField();
        text1.setPrefColumnCount(5);
        text1.setTranslateX(50);
        text1.setTranslateY(50);

        TextField text2 = new TextField();
        text2.setPrefColumnCount(5);
        text2.setTranslateX(220);
        text2.setTranslateY(50);

        TextField text3 = new TextField();
        text3.setPrefColumnCount(5);
        text3.setTranslateX(450);
        text3.setTranslateY(50);


        Button btn = new Button();
        btn.setText("Сгенерировать");
        btn.setTranslateX(220);
        btn.setTranslateY(100);
        btn.setPrefSize(70, 20);
        btn.setOnAction(event0 -> {

            int intX = StringToInteger(text1);
            int intY = StringToInteger(text2);
            int intRadius = StringToInteger(text3);

            double small_radius = (intRadius * Math.sin(Math.toRadians(18))) / Math.sin(Math.toRadians(126));
            double h = small_radius * Math.sin(Math.toRadians(36));
            double small_h = (h * Math.sin(Math.toRadians(63))) / Math.sin(Math.toRadians(36));

            root.getChildren().addAll(
                    CreateLine("centarRight", intX, intY - intRadius, intX + h, intY - small_h),
                    CreateLine("centarLeft", intX, intY - intRadius, intX - h, intY - small_h),
                    CreateLine("rightTop",
                            intX + (intRadius * Math.sin(Math.toRadians(72))),
                            intY-(intRadius*Math.sin(Math.toRadians(18))),
                            intX + h,
                            intY - small_h),
                    CreateLine("rightBot",
                            intX + (intRadius * Math.sin(Math.toRadians(72))),
                            intY - (intRadius * Math.sin(Math.toRadians(18))),
                            intX + (small_radius * Math.sin(Math.toRadians(72))),
                            intY + (small_radius * Math.sin(Math.toRadians(18)))),
                    CreateLine("botRigthTop",
                            intX + (intRadius * Math.sin(Math.toRadians(38))),
                            intY + (intRadius * Math.sin(Math.toRadians(54))),
                            intX + (small_radius * Math.sin(Math.toRadians(72))),
                            intY + (small_radius * Math.sin(Math.toRadians(18)))),
                    CreateLine("botRigthBot",
                            intX + (intRadius * Math.sin(Math.toRadians(38))),
                            intY + (intRadius * Math.sin(Math.toRadians(54))),
                            intX,
                            intY + small_radius),
                    CreateLine(" botLeftBot",
                            intX - (intRadius * Math.sin(Math.toRadians(38))),
                            intY + (intRadius * Math.sin(Math.toRadians(54))),
                            intX,
                            intY + small_radius),
                    CreateLine("botLeftTop",
                            intX - (intRadius * Math.sin(Math.toRadians(38))),
                            intY + (intRadius * Math.sin(Math.toRadians(54))),
                            intX - (small_radius * Math.sin(Math.toRadians(72))),
                            intY + (small_radius * Math.sin(Math.toRadians(18)))),
                    CreateLine("leftBot",
                            intX - (intRadius * Math.sin(Math.toRadians(72))),
                            intY - (intRadius * Math.sin(Math.toRadians(18))),
                            intX - (small_radius * Math.sin(Math.toRadians(72))),
                            intY + (small_radius * Math.sin(Math.toRadians(18)))),
                    CreateLine("leftTop",
                            intX - (intRadius * Math.sin(Math.toRadians(72))),
                            intY - (intRadius * Math.sin(Math.toRadians(18))),
                            intX - h,
                            intY - small_h)
                    );
        });


        root.getChildren().addAll(
                text1,
                text2,
                text3,
                btn,
                SetLabel("Кооодинаты цента X \nРекомендованые 300", 25, 15),
                SetLabel("Кооодинаты цента Y \nРекомендованые 300", 200, 15),
                SetLabel("Радиус \nРекомендованые 100", 450, 15));

        primaryStage.setScene(new Scene(root,600,600));
        primaryStage.show();

    }
}
