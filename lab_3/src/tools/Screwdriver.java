package tools;

import products.Product;
import products.SemiFinished;
import javafx.scene.control.Alert;
/**
 * Class for work with semifinished and product.
 */
public class Screwdriver extends Tool {
    /**
     * Screw in and show message.
     * @param product which semifinished change.
     */
    public void screwIn(Product product) {
        if(product.getAvailabilityStatus() < 5)
            product.setAvailabilityStatus(product.getAvailabilityStatus() + 1);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Закручено.\n" + product.checkAvailabilityStatus());

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
