import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Star extends Application {

    double  k =0.20;

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

            Line centarlLeft = new Line();
            centarlLeft.setStartX(intX);
            centarlLeft.setStartY(intY-intRadius);
            centarlLeft.setEndX(intX - intRadius*k);
            centarlLeft.setEndY(intY - intRadius*k);

            Line centarlRight = new Line();
            centarlRight.setStartX(intX);
            centarlRight.setStartY(intY-intRadius);
            centarlRight.setEndX(intX + intRadius*k);
            centarlRight.setEndY(intY - intRadius*k);

            Line leftTop = new Line();
            leftTop.setStartX(intX-intRadius);
            leftTop.setStartY(intY-intRadius*k);
            leftTop.setEndX(intX - intRadius*k);
            leftTop.setEndY(intY - intRadius*k);

            Line leftBot = new Line();
            leftBot.setStartX(intX-intRadius);
            leftBot.setStartY(intY-intRadius*k);
            leftBot.setEndX(intX - intRadius*k);
            leftBot.setEndY(intY + intRadius*k);

            root.getChildren().addAll(centarlLeft,centarlRight,leftTop,leftBot);
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
