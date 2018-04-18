package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
    private SemiFinished semiFinished;
    private static ObservableList<Worker> listWorker;
    private static TableView<Worker> tableView;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        semiFinished = new SemiFinished(120);

        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 340, 250);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        Label label = new Label("Введите имя:");
        gridpane.add(label, 0, 0);
        TextField nameTextField = new TextField();
        gridpane.add(nameTextField, 1, 0,2,1);

        Button addButton = new Button( "Добавить");
        gridpane.add(addButton, 3, 0);

        // TableView
        listWorker = FXCollections.observableArrayList();
        tableView = new TableView<>();
        TableColumn<Worker, String> columnName = new TableColumn<>("Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnName.setMinWidth(190);
        tableView.getColumns().setAll(columnName);
        gridpane.setConstraints(tableView,1,1,3,2);

        Button workButton = new Button( "Работать");
        gridpane.add(workButton, 0, 3);

        Button sawButton = new Button("Пилить");
        sawButton.setDisable(true);
        gridpane.add(sawButton, 0, 4);
        Button tryUpButton = new Button("Стругать");
        tryUpButton.setDisable(true);
        gridpane.add(tryUpButton, 1, 4);
        Button screwInButton = new Button("Закрутить");
        screwInButton.setDisable(true);
        gridpane.add(screwInButton, 3, 4);
        Button untwineButton = new Button("Открутить");
        untwineButton.setDisable(true);
        gridpane.add(untwineButton, 4, 4);
        Label formLabel = new Label("Форма:");
        gridpane.add(formLabel, 0, 5);
        Label  reactionLabel = new Label("");
        gridpane.add(reactionLabel, 1, 5);

        gridpane.getChildren().set(0,tableView);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!nameTextField.getText().isEmpty()) {
                    Worker worker = new Worker();
                    worker.setName(nameTextField.getText());

                    listWorker.add(worker);
                    tableView.setItems(listWorker);
                    nameTextField.clear();
                }
            }
        });

        workButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                if(tableView.getSelectionModel().getSelectedItem() != null) {
                    sawButton.setDisable(false);
                    screwInButton.setDisable(false);
                    untwineButton.setDisable(false);
                    tryUpButton.setDisable(false);
                }
            }
        });

        sawButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                if(tableView.getSelectionModel().getSelectedItem().saw == null)
                    tableView.getSelectionModel().getSelectedItem().setSaw(new Saw());
                tableView.getSelectionModel().getSelectedItem().work("saw", semiFinished);
                //sawButton.setDisable(true);
                reactionLabel.setText(Double.toString(semiFinished.form));
            }
        });

        tryUpButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                if(tableView.getSelectionModel().getSelectedItem().plane == null)
                    tableView.getSelectionModel().getSelectedItem().setPlane(new Plane());
                tableView.getSelectionModel().getSelectedItem().work("tryUp", semiFinished);
               // tryUpButton.setDisable(true);
                reactionLabel.setText(Double.toString(semiFinished.form));
                }
        });

        screwInButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                if(tableView.getSelectionModel().getSelectedItem().screwdriver == null)
                    tableView.getSelectionModel().getSelectedItem().setScrewdriver(new Screwdriver());
                tableView.getSelectionModel().getSelectedItem().work("screwIn", semiFinished);
                //screwInButton.setDisable(true);
            }
        });

        untwineButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                if(tableView.getSelectionModel().getSelectedItem().screwdriver == null)
                    tableView.getSelectionModel().getSelectedItem().setScrewdriver(new Screwdriver());
                tableView.getSelectionModel().getSelectedItem().work("untwine", semiFinished);
                //untwineButton.setDisable(true);

            }
        });

        root.setCenter(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
