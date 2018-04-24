package tools;

import products.SemiFinished;
/**
 * Class Saw for work with semifinished
 */
public class Saw extends Tool {
    int lenght;
    /**
     * For change form
     * @param semiFinished which semifinished change
     */
    public void saw(SemiFinished semiFinished) {
        semiFinished.changeForm("saw");
    };
}
