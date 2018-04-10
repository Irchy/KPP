package app;

public class Plane extends Tool {

    public void tryUp(SemiFinished semiFinished){
        semiFinished.form = semiFinished.form - 1.8;
    }
}
