package app;

/**
 * Class Saw for work with semifinished
 */
public class Saw extends Tool {
    private int lenght;

    /**
     * For change form
     * @param semiFinished which semifinished change
     */
    public void saw(SemiFinished semiFinished) {
        semiFinished.form = semiFinished.form - 4;
    };
}
