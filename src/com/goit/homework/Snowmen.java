package com.goit.homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Snowmen extends Application {

    private int circleCount;
    private int minRadius;
    private int maxRadius;


    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private  static Label SetLabel(String text,int TranslateX,int TranslateY){
        Label l = new Label();
        l.setText(text);
        l.setTranslateX(TranslateX);
        l.setTranslateY(TranslateY);

        return l;
    }

    private static int StringToInteger(TextField textField){
        return Integer.parseInt(textField.getText());
    }

    public void show(Stage stage){start (stage);}

    @Override
    public void start(Stage stage) {

        stage.setTitle("Snowmen");

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

        root.getChildren().addAll(
                SetLabel("Введите количество шаров",25,30),
                SetLabel("Минимальный радиус",200,30),
                SetLabel("Максимальный радиус",420,30),
                text1,
                text2,
                text3
        );

        Button btn1 =  new Button();
        btn1.setText("Сгенерировать");
        btn1.setTranslateX(50);
        btn1.setTranslateY(100);
        btn1.setPrefSize(70,20);
        btn1.setOnAction(event0 -> {

            circleCount = StringToInteger(text1);
            minRadius = StringToInteger(text2);
            maxRadius = StringToInteger(text3);


            Circle[] circles = new Circle[circleCount];
            Circle[] hollow = new Circle[circleCount];

            circles[0] = new Circle(220,200,rnd(minRadius, maxRadius));
            hollow[0] = new Circle(circles[0].getCenterX(),circles[0].getCenterY(), circles[0].getRadius()-6,Color.WHITE);

            Circle left_eye = new Circle(circles[0].getCenterX()-(circles[0].getRadius()/2),
                    circles[0].getCenterY()-(circles[0].getRadius()/2),
                    (circles[0].getRadius()*0.05)*rnd(1,4));
            Circle left_eye_hollow = new Circle(circles[0].getCenterX()-(circles[0].getRadius()/2),
                    circles[0].getCenterY()-(circles[0].getRadius()/2),
                    (left_eye.getRadius()-2),Color.WHITE);

            Circle right_eye = new Circle(circles[0].getCenterX()+(circles[0].getRadius()/2),
                    circles[0].getCenterY()-(circles[0].getRadius()/2),
                    (circles[0].getRadius()*0.05)*rnd(1,4));
            Circle right_eye_hollow = new Circle(circles[0].getCenterX()+(circles[0].getRadius()/2),
                    circles[0].getCenterY()-(circles[0].getRadius()/2),
                    (right_eye.getRadius()-2),Color.WHITE);

            Circle mounth = new Circle(circles[0].getCenterX(),
                    circles[0].getCenterY()+(circles[0].getRadius()/2),
                    (circles[0].getRadius()*0.07)*rnd(1,4));
            Circle mounth_hollow = new Circle(circles[0].getCenterX(),
                    circles[0].getCenterY()+(circles[0].getRadius()/2),
                    (mounth.getRadius()-3),Color.WHITE);



            //root.getChildren().addAll(circles[0],hollow[0],left_eye,right_eye,mounth,left_eye_hollow,right_eye_hollow,mounth_hollow);


            for(int i = 1;i<circles.length;i++){
                int c =rnd(minRadius, maxRadius);
                circles[i] = new Circle(220,circles[i-1].getCenterY()+circles[i-1].getRadius()+c,c);
                hollow[i] = new Circle(circles[i].getCenterX(),circles[i].getCenterY(), circles[i].getRadius()-6);
                hollow[i].setFill(Color.WHITE);
                root.getChildren().addAll(circles[i],hollow[i]);
            }


            Button btn2 = new Button();
            btn2.setText("Закраска");
            btn2.setTranslateX(220);
            btn2.setTranslateY(100);
            btn2.setPrefSize(70,20);
            btn2.setOnAction(coloring_red -> {
                for(int i = 1;i<circles.length;i++) {
                    hollow[i].setFill(Color.RED);
                }
                hollow[0].setFill(Color.RED);
            });

            /*              // Градиент

            Button btn3 = new Button();
            btn3.setText("Gradient");
            btn3.setTranslateX(450);
            btn3.setTranslateY(100);
            btn3.setPrefSize(70,20);
            btn3.setOnAction(coloring_grey -> {
                LinearGradient lg1 = new LinearGradient(
                        220,
                        200-hollow[0].getRadius(),
                        220,
                        hollow[hollow.length-1].getCenterY()+hollow[hollow.length-1].getRadius(),
                        true,
                        CycleMethod.NO_CYCLE,
                        new Stop(0f,Color.BLUE),
                        new Stop(0.60f,Color.BLACK));
                //for(int i = 0;i<hollow.length;i++){hollow[i].setFill(lg1);}
            });

            */

            root.getChildren().addAll(btn2,circles[0],hollow[0],left_eye,right_eye,mounth,left_eye_hollow,right_eye_hollow,mounth_hollow);

        });

        root.getChildren().addAll(btn1);

        stage.setScene(new Scene(root,600,600));

        stage.show();

    }


}
