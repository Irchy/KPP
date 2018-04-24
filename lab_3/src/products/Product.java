package products;

/**
 * Class has availability status.
 */
public class Product {
    private int availabilityStatus;
    /**
     * Get status.
     * @return availabilityStatus
     */
    public int getAvailabilityStatus() {
        return availabilityStatus;
    }
    /**
     * Set status.
     * @param availabilityStatus status for set.
     */
    public void setAvailabilityStatus(int availabilityStatus) {
        this.availabilityStatus = availabilityStatus;

    }
    /**
     * Check status of availability.
     * @return String for show.
     */
    public String checkAvailabilityStatus(){
    switch (availabilityStatus) {
        case 0:
            return  "Не готово.";
        case 5:
            return "Готово.";
        default:
            return "В процессе.";
        }
    }
    /**
     * Default constructor.
     */
    public Product() {
        availabilityStatus = -1;
    }
}
