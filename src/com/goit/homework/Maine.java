package com.goit.homework;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Maine extends Application {
        public static void main(String[] args) {launch(); }

        public void start(Stage myStage){

            myStage.setTitle("Homework 5.1");
            Pane rootNode = new Pane();

            Label response  = new Label("Выберите действие");
            response.setTranslateX(90);
            response.setTranslateY(60);

            ObservableList<String> PlayerTypes = FXCollections.observableArrayList
                    ("Отрисовать снеговика","Отрисовать звезду");

            ListView<String> PlayersList = new ListView<>(PlayerTypes);

            PlayersList.setPrefSize(150,  50);
            PlayersList.setTranslateX(70);
            PlayersList.setTranslateY(80);

            MultipleSelectionModel<String> PlayerSelModel = PlayersList.getSelectionModel();
            PlayerSelModel.setSelectionMode(SelectionMode. SINGLE);

            PlayerSelModel.selectedItemProperty().addListener(
                    new ChangeListener<String>() {

                        public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal){
                            response.setText("Вы выбрали " + newVal);

                            switch(newVal){
                                case "Отрисовать снеговика":
                                    Snowmen snowmen = new Snowmen();
                                    snowmen.show(myStage);
                                    break;
                                case "Отрисовать звезду":
                                    Star star = new Star();
                                    star.show(myStage);
                                    break;
                            }
                        }

                    });

            rootNode.getChildren().addAll(PlayersList,response);

            myStage.setScene(new Scene(rootNode,300,300));

            myStage.show();
        }


}
