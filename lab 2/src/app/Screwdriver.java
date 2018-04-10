package app;

import javafx.scene.control.Alert;

public class Screwdriver extends Tool {

    public void screwIn(SemiFinished semiFinished){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Закручено");

        alert.showAndWait();
    }

    public void untwine(SemiFinished semiFinished){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Откручено");

        alert.showAndWait();
    }
}
