package app;

import javafx.scene.control.Alert;

/**
 * Class for work with semifinished.
 */
public class Screwdriver extends Tool {
    /**
     * Screw in and show message.
     * @param semiFinished which semifinished change.
     */
    public void screwIn(SemiFinished semiFinished){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Закручено");

        alert.showAndWait();
    }

    /**
     * Untwine and show message.
     * @param semiFinished which semifinished change.
     */
    public void untwine(SemiFinished semiFinished){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Откручено");

        alert.showAndWait();
    }
}
