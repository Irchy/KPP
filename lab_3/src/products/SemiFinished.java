package products;
/**
 * Class has field form. Form can be changed.
 */
public class SemiFinished {
    public double form;
    /**
     * Constructor initialization
     * @param form for definition
     */
    public SemiFinished(double form){
        this.form = form;
    }

    /**
     * Screwdriver can change form.
     * @param text flag for change form
     */
    public void changeForm(String text){
        switch(text){
            case "saw":
                this.form -=1.2;
                break;
            case "tryUp":
                this.form -=3.2;
                break;
        }
    }
}
