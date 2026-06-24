/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LibraryAPP extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(40));

        gridPane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        Text title = new Text("   ------ Welcome to Library system ------");
        title.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 22));
        title.setFill(Color.BURLYWOOD);
        gridPane.add(title, 0, 0, 2, 1);

        Label titleLabel = new Label("Title:");
        TextField titleTextField = new TextField();
        titleLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
        Label authorLabel = new Label("Author:");
        TextField authorTextField = new TextField();
        authorLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
        Label serialNumLabel = new Label("Serial Number:");
        TextField serialNumTextField = new TextField();
        serialNumLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
        Label pagesLabel = new Label("Pages:");
        TextField pagesTextField = new TextField();
        pagesLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));

        Label basePriceLabel = new Label("Base Price:");
        TextField basePriceTextField = new TextField();
        basePriceLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
        Label copiesLabel = new Label("Copies:");
        TextField copiesTextField = new TextField();

        Label categoryLabel = new Label("Category:");
        copiesLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
        TextField categoryTextField = new TextField();
        categoryLabel.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16));
        gridPane.add(titleLabel, 0, 1);
        gridPane.add(titleTextField, 1, 1);
        gridPane.add(authorLabel, 0, 2);
        gridPane.add(authorTextField, 1, 2);
        gridPane.add(serialNumLabel, 0, 3);
        gridPane.add(serialNumTextField, 1, 3);
        gridPane.add(pagesLabel, 0, 4);
        gridPane.add(pagesTextField, 1, 4);
        gridPane.add(basePriceLabel, 0, 5);
        gridPane.add(basePriceTextField, 1, 5);
        gridPane.add(copiesLabel, 0, 6);
        gridPane.add(copiesTextField, 1, 6);
        gridPane.add(categoryLabel, 0, 7);
        gridPane.add(categoryTextField, 1, 7);

        Button addButton = new Button("Add General Book");
        addButton.setTextFill(Color.BURLYWOOD);
        addButton.setFont(Font.font("FZYaoTi", FontWeight.BOLD, 15));
        gridPane.add(addButton, 1, 8);

        TextArea tArea = new TextArea();
        tArea.setEditable(false);
        gridPane.add(tArea, 0, 10, 2, 10);
        
        Button displayButton = new Button("Display Books");
        displayButton.setFont(Font.font("FZYaoTi", FontWeight.BOLD, 15));
        displayButton.setTextFill(Color.BURLYWOOD);
        gridPane.add(displayButton, 1, 20);

        displayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Available> books = Main.list1;
                String s = "";
                
                for (Available book : books) {
                     if (book instanceof Book) {
             
                    s += book + "\n";
                }}
                tArea.setText(s);
            }
        });

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String title = titleTextField.getText();
                    String author = authorTextField.getText();
                    int serialNum = Integer.parseInt(serialNumTextField.getText());
                    int pages = Integer.parseInt(pagesTextField.getText());
                    double basePrice = Double.parseDouble(basePriceTextField.getText());
                    int copies = Integer.parseInt(copiesTextField.getText());
                    String category = categoryTextField.getText();

                    GeneralBook book = new GeneralBook(title, author, serialNum, pages, basePrice, copies, category);
                    Main.list1.add(book);
                    System.out.println("The Book added successfully");
                } catch (Exception e) {
                    System.out.println("Invalid value");
                }
            }
        });

        Scene scene = new Scene(gridPane, 650, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Library");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
