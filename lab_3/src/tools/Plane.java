package tools;


import products.SemiFinished;
/**
 * Class Saw for work with semifinished
 */
public class Plane extends Tool {
    /**
     * For change form
     * @param semiFinished which semifinished change
     */
    public void tryUp(SemiFinished semiFinished){
        semiFinished.changeForm("tryUp");
    }
}
