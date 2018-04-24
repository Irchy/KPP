package tools;
/**
 * Abstract class Tool for create other classes.
 */
abstract public class Tool {
    private int weight;

    /**
     * default constructor
     */
    Tool()
    {
        this.weight = 0;
    }

    Tool(int weight)
    {
        this.weight = weight;
    }

}

