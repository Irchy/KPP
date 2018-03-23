package Main;


import javax.swing.*;

public class Main {
    static Window win = new Window();

    public static void main(String[] args) {
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(320, 180);
        win.setResizable(false);
        win.setLocationRelativeTo(null);
    }
    public static void Solution() {
        for(int i=win.startInterval; i<=win.endInterval; i++) {
            if(i==win.sum-win.secondSummand)
                win.result=i;
        }

    }

}
