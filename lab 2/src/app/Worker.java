package app;

public class Worker {
    String name;
    Saw saw;
    Plane plane;
    Screwdriver screwdriver;

    public void work(String flag, SemiFinished semiFinished){
        switch(flag){
            case "saw":
                saw.saw(semiFinished);
                break;
            case "tryUp":
                plane.tryUp(semiFinished);
                break;
            case "screwIn":
                screwdriver.screwIn(semiFinished);
                break;
            case "untwine":
                screwdriver.untwine(semiFinished);
                break;
        }
    }

    public Saw getSaw() {
        return saw;
    }

    public void setSaw(Saw saw) {
        this.saw = saw;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Screwdriver getScrewdriver() {
        return screwdriver;
    }

    public void setScrewdriver(Screwdriver screwdriver) {
        this.screwdriver = screwdriver;
    }

    Worker() {

    }

    Worker(String inputName) {
        this.name = inputName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
