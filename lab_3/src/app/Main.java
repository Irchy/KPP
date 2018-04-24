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
import products.Product;
import products.SemiFinished;
import tools.Plane;
import tools.Saw;
import tools.Screwdriver;
/**
 * Class Main contains
 *@author Skiba Iryna
 */
public class Main extends Application{
    private Saw saw;
    private Plane plane;
    private Screwdriver screwdriver;
    private SemiFinished semiFinished;
    private Product product;
    private static ObservableList<Worker> listWorker;
    private static TableView<Worker> tableView;
    /**
     * This is punkt of login to programm.
     * Here is parameters for output window.
     * @param args args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    /**
     * start create appearance application.
     * @param primaryStage window of app.
     */
    @Override
    public void start(Stage primaryStage) {
        saw = new Saw();
        plane = new Plane();
        screwdriver = new Screwdriver();
        semiFinished = new SemiFinished(120);
        product = new Product();

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
                tableView.getSelectionModel().getSelectedItem().work(saw, semiFinished);
                reactionLabel.setText(Double.toString(semiFinished.form));
            }
        });

        tryUpButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                tableView.getSelectionModel().getSelectedItem().work(plane, semiFinished);
                reactionLabel.setText(Double.toString(semiFinished.form));
                }
        });

        screwInButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                tableView.getSelectionModel().getSelectedItem().work(screwdriver, product);
            }
        });

        untwineButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                tableView.getSelectionModel().getSelectedItem().work(screwdriver, semiFinished);
            }
        });

        root.setCenter(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
