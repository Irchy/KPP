package app;

/**
 * Worker has field name and override method work.
 */
public class Worker {
    private String name;

    /**
     * method for work with screwdriver
     * @param screwdriver tool
     * @param semiFinished semifinished for work
     * @param flag flag for screwIn or untwine
     */
    public void work(Screwdriver screwdriver, SemiFinished semiFinished, String flag){
        switch(flag){
            case "screwIn":
                screwdriver.screwIn(semiFinished);
                break;
            case "untwine":
                screwdriver.untwine(semiFinished);
                break;
        }
    }

    /**
     * method for work with saw
     * @param saw tool
     * @param semiFinished semifinished for work
     */
    public void work(Saw saw, SemiFinished semiFinished){
        saw.saw(semiFinished);
    }

    /**
     * method for work with plane
     * @param plane tool
     * @param semiFinished semifinished for work
     */
    public void work(Plane plane, SemiFinished semiFinished){
        plane.tryUp(semiFinished);
    }

    /**
     * default constructor
     */
    Worker() {

    }

    /**
     * constructor initialization
     * @param inputName name for initialization
     */
    Worker(String inputName) {
        this.name = inputName;
    }

    /**
     * for get name
     * @return name of worker
     */
    public String getName() {
        return name;
    }

    /**
     * for set name
     * @param name for set
     */
    public void setName(String name) {
        this.name = name;
    }
}
