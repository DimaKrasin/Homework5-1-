import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Star extends Application {

    public void start(Stage primaryStage) throws Exception {
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

        Label label1 = new Label();
        label1.setText("Кооодинаты цента X \nРекомендованые 300");
        label1.setTranslateX(25);
        label1.setTranslateY(15);

        Label label2 = new Label();
        label2.setText("Кооодинаты цента Y \nРекомендованые 300");
        label2.setTranslateX(200);
        label2.setTranslateY(15);

        Label label3 = new Label();
        label3.setText("Радиус \nРекомендованые 100");
        label3.setTranslateX(450);
        label3.setTranslateY(15);

        Button btn =  new Button();
        btn.setText("Сгенерировать");
        btn.setTranslateX(220);
        btn.setTranslateY(100);
        btn.setPrefSize(70,20);
        btn.setOnAction(event0 -> {

            String stringX = text1.getText();
            String stringY = text2.getText();
            String stringRadius = text3.getText();
            int intX = Integer.parseInt(stringX);
            int intY = Integer.parseInt(stringY);
            int intRadius = Integer.parseInt(stringRadius);

            double c = (intRadius* Math.sin(Math.toRadians(18)))/Math.sin(Math.toRadians(126));
            double h = c*Math.sin(Math.toRadians(36));
            double smallRadius = (h *Math.sin(Math.toRadians(63)))/Math.sin(Math.toRadians(36));

            Line centarRight = new Line();
            centarRight.setStartX(intX);
            centarRight.setStartY(intY-intRadius);
            centarRight.setEndX(intX+h);
            centarRight.setEndY(intY-smallRadius);

            Line centarLight = new Line();
            centarLight.setStartX(intX);
            centarLight.setStartY(intY-intRadius);
            centarLight.setEndX(intX-h);
            centarLight.setEndY(intY-smallRadius);

            Line rightTop = new Line();
            rightTop.setStartX(intX+(intRadius*Math.sin(Math.toRadians(72))));
            rightTop.setStartY(intY-(intRadius*Math.sin(Math.toRadians(18))));
            rightTop.setEndX(intX+h);
            rightTop.setEndY(intY-smallRadius);

            Line rightBot = new Line();
            rightBot.setStartX(intX+(intRadius*Math.sin(Math.toRadians(72))));
            rightBot.setStartY(intY-(intRadius*Math.sin(Math.toRadians(18))));
            rightBot.setEndX(intX+(c*Math.sin(Math.toRadians(72))));
            rightBot.setEndY(intY+(c*Math.sin(Math.toRadians(18))));

            Line botRigthTop = new Line();
            botRigthTop.setStartX(intX+(intRadius*Math.sin(Math.toRadians(38))));
            botRigthTop.setStartY(intY+(intRadius*Math.sin(Math.toRadians(54))));
            botRigthTop.setEndX(intX+(c*Math.sin(Math.toRadians(72))));
            botRigthTop.setEndY(intY+(c*Math.sin(Math.toRadians(18))));

            Line botRigthBot = new Line();
            botRigthBot.setStartX(intX+(intRadius*Math.sin(Math.toRadians(38))));
            botRigthBot.setStartY(intY+(intRadius*Math.sin(Math.toRadians(54))));
            botRigthBot.setEndX(intX);
            botRigthBot.setEndY(intY+c);

            Line botLeftBot = new Line();
            botLeftBot.setStartX(intX-(intRadius*Math.sin(Math.toRadians(38))));
            botLeftBot.setStartY(intY+(intRadius*Math.sin(Math.toRadians(54))));
            botLeftBot.setEndX(intX);
            botLeftBot.setEndY(intY+c);

            Line botLeftTop = new Line();
            botLeftTop.setStartX(intX-(intRadius*Math.sin(Math.toRadians(38))));
            botLeftTop.setStartY(intY+(intRadius*Math.sin(Math.toRadians(54))));
            botLeftTop.setEndX(intX-(c*Math.sin(Math.toRadians(72))));
            botLeftTop.setEndY(intY+(c*Math.sin(Math.toRadians(18))));

            Line leftBot = new Line();
            leftBot.setStartX(intX-(intRadius*Math.sin(Math.toRadians(72))));
            leftBot.setStartY(intY-(intRadius*Math.sin(Math.toRadians(18))));
            leftBot.setEndX(intX-(c*Math.sin(Math.toRadians(72))));
            leftBot.setEndY(intY+(c*Math.sin(Math.toRadians(18))));

            Line leftTop = new Line();
            leftTop.setStartX(intX-(intRadius*Math.sin(Math.toRadians(72))));
            leftTop.setStartY(intY-(intRadius*Math.sin(Math.toRadians(18))));
            leftTop.setEndX(intX-h);
            leftTop.setEndY(intY-smallRadius);

            root.getChildren().addAll(
                    centarRight,
                    centarLight,
                    rightTop,
                    rightBot,
                    botRigthTop,
                    botRigthBot,
                    botLeftBot,
                    botLeftTop,
                    leftBot,
                    leftTop);
        });


        root.getChildren().addAll(text1,text2,text3,label1,label2,label3,btn);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
