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


public class Maine extends Application{

    String text_count;
    int int_count;

    String text_min;
    int int_min;

    String text_max;
    int int_max;


    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Circle. Try 1");
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);

        Pane root = new Pane();


        Button btn =  new Button();
        btn.setText("Сгенерировать");
        btn.setTranslateX(220);
        btn.setTranslateY(100);
        btn.setPrefSize(70,20);
        btn.setOnAction(event -> {

            Circle[] circles = new Circle[int_count];
            Circle[] hollow = new Circle[int_count];

            circles[0] = new Circle(220,200,rnd(int_min,int_max));
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



            root.getChildren().addAll(circles[0],hollow[0],left_eye,right_eye,mounth,left_eye_hollow,right_eye_hollow,mounth_hollow);


            for(int i = 1;i<circles.length;i++){
                int c =rnd(int_min,int_max);
                circles[i] = new Circle(220,circles[i-1].getCenterY()+circles[i-1].getRadius()+c,c);
                hollow[i] = new Circle(circles[i].getCenterX(),circles[i].getCenterY(), circles[i].getRadius()-6);
                hollow[i].setFill(Color.WHITE);
                root.getChildren().addAll(circles[i],hollow[i]);
            }


            Button btn2 = new Button();
            btn2.setText("Закраска");
            btn2.setTranslateX(320);
            btn2.setTranslateY(100);
            btn2.setPrefSize(70,20);
            btn2.setOnAction(coloring_red -> {
                for(int i = 1;i<circles.length;i++) {
                    hollow[i].setFill(Color.RED);
                }
                hollow[0].setFill(Color.RED);
            });

            root.getChildren().addAll(btn2);

            Button btn3 = new Button();
            btn3.setText("Gradient");
            btn3.setTranslateX(420);
            btn3.setTranslateY(100);
            btn3.setPrefSize(70,20);
            btn3.setOnAction(coloring_grey -> {
                
            });
        });




        TextField text1 = new TextField();
        text1.setPrefColumnCount(5);
        text1.setTranslateX(50);
        text1.setTranslateY(50);
        text1.setOnAction(event -> {
            text_count = text1.getText();
            int_count = Integer.parseInt(text_count);
            System.out.println(int_count);
        });

        Label label1 = new Label();
        label1.setText("Введите количество шаров");
        label1.setTranslateX(30);
        label1.setTranslateY(30);


        TextField text2 = new TextField();
        text2.setPrefColumnCount(5);
        text2.setTranslateX(220);
        text2.setTranslateY(50);
        text2.setOnAction(event -> {
            text_min = text2.getText();
            int_min = Integer.parseInt(text_min);
            System.out.println(int_min);
        });

        Label label2 = new Label();
        label2.setText("Минимальный радиус");
        label2.setTranslateX(250);
        label2.setTranslateY(30);


        TextField text3 = new TextField();
        text3.setPrefColumnCount(5);
        text3.setTranslateX(450);
        text3.setTranslateY(50);
        text3.setOnAction(event -> {
            text_max = text3.getText();
            int_max = Integer.parseInt(text_max);
            System.out.println(int_max);
        });

        Label label3 = new Label();
        label3.setText("Максимальный радиус");
        label3.setTranslateX(380);
        label3.setTranslateY(30);



        root.getChildren().addAll(text1,label1,text2,label2,text3,label3,btn);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
