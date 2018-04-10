package Main;

import javax.swing.*;

/**
 * Class Main create object Window.
 */
public class Main {
    static Window win = new Window();

    /**
     * This is punkt of  login to programm.
     * Here is parameters for output window.
     * @param args
     */
    public static void main(String[] args) {
        win.dispositionElement(win.getContentPane());
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(350, 180);
        //win.setResizable(false);
        win.setLocationRelativeTo(null);
    }



}
