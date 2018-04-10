package app;

public class Saw extends Tool {
    int lenght;
    public void saw(SemiFinished semiFinished) {
        semiFinished.form = semiFinished.form - 4;
    };
}
