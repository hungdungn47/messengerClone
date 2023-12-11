package com.example.messengerclone;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    VBox root = new VBox();
    HBox topBar = new HBox();
    HBox bottomBar = new HBox();
    VBox chatArea = new VBox();

    Label nameLabel = new Label();
    Label label2 = new Label();

    TextField messageInput = new TextField();
    ImageView avatar = new ImageView(new Image("D:\\Coding\\Java\\OOP\\messengerClone\\src\\main\\resources\\image\\GapMatSHHV.jpg"));
    ImageView info = new ImageView(new Image("D:\\Coding\\Java\\OOP\\messengerClone\\src\\main\\resources\\image\\information.png"));
    ImageView audioCall = new ImageView(new Image("D:\\Coding\\Java\\OOP\\messengerClone\\src\\main\\resources\\image\\call.png"));
    ImageView videoCall = new ImageView(new Image("D:\\Coding\\Java\\OOP\\messengerClone\\src\\main\\resources\\image\\zoom.png"));
    ImageView send = new ImageView(new Image("D:\\Coding\\Java\\OOP\\messengerClone\\src\\main\\resources\\image\\send.png"));
    @Override
    public void start(Stage primaryStage) {
        styleTopBar();
        label2.setText("This is chat area");

        bottomBar.setPadding(new Insets(5));
        bottomBar.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        messageInput.setPromptText("Message");
        messageInput.setStyle("-fx-border-color: transparent; -fx-pref-height: 40; "
                + "-fx-pref-width: 350; -fx-background-radius: 15");
        messageInput.setOnAction((event) -> {
            label2 = new Label(messageInput.getText());
            chatArea.getChildren().add(label2);
        });
        bottomBar.getChildren().addAll(messageInput, send);
        HBox.setMargin(messageInput, new Insets(0, 10, 0, 0));

        send.setFitWidth(30);
        send.setFitHeight(30);

        chatArea.getChildren().add(label2);
        chatArea.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        chatArea.setPrefHeight(500);
        bottomBar.setPrefHeight(50);

        chatArea.setAlignment(Pos.CENTER_LEFT);
        bottomBar.setAlignment(Pos.CENTER_LEFT);

        root.getChildren().add(topBar);
        root.getChildren().add(chatArea);
        root.getChildren().add(bottomBar);
        root.setPrefWidth(400);
        root.setPrefHeight(600);
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Messenger App");
        primaryStage.show();
    }

    private void styleTopBar() {
        styleImageView(avatar, 40);
        styleImageView(info, 30);
        styleImageView(audioCall, 30);
        styleImageView(videoCall, 30);
        HBox.setMargin(avatar, new Insets(0, 5, 0, 0));
        HBox.setMargin(nameLabel, new Insets(0, 80, 0, 0));
        HBox.setMargin(audioCall, new Insets(0, 10, 0, 0));
        HBox.setMargin(videoCall, new Insets(0, 10, 0, 0));
        nameLabel.setText("Nguyễn Hùng Dũng");
        nameLabel.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-font-family: 'Cambria'; -fx-font-color: black;");
        topBar.getChildren().addAll(avatar, nameLabel, audioCall, videoCall, info);
        topBar.setPadding(new Insets(5));
        topBar.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        topBar.setPrefHeight(50);
        topBar.setAlignment(Pos.CENTER_LEFT);
    }

    private void styleImageView(ImageView imgView, double size) {
        imgView.setFitWidth(size);
        imgView.setFitHeight(size);
        Circle clip = new Circle();
        clip.setCenterX(size / 2); // Set the center X of the circle
        clip.setCenterY(size / 2); // Set the center Y of the circle
        clip.setRadius(size / 2); // Set the radius to half the image size
        imgView.setClip(clip);
    }

    public static void main(String[] args) {
        launch(args);
    }
}