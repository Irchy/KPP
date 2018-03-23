package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * The program solution of the equation by selection method.
 * In the window you can input variable for equation and borders of selection.
 *
 * @author  Ira Skiba
 * @since   2018-03-23
 */

public class Window extends JFrame {
    JLabel labelFirstSummand, labelEqually, labelStartInterval, labelEndInterval, labelRoot;
    JFormattedTextField textFieldSecondSummand, textFieldSum, textFieldStartInterval, textFieldEndInterval;
    JButton buttonAssortRoot;
    ListenerForButton listnerForButton = new ListenerForButton();
    int secondSummand, sum, startInterval, endInterval, result;

    /**
     * This is constructor. Here are components declared and
     * is called method of disposition element.
     * Set name of window.
     */
    public Window() {
        super("laba1");

        labelFirstSummand = new JLabel("x +");
        labelEqually = new JLabel(" = ");
        labelStartInterval = new JLabel("Начало интервала");
        labelEndInterval = new JLabel("Конец интервала");
        labelRoot = new JLabel("Корень");
        textFieldSecondSummand = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldSum = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldStartInterval = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldEndInterval = new JFormattedTextField(NumberFormat.getIntegerInstance());
        buttonAssortRoot = new JButton("Подобрать корень");

        buttonAssortRoot.addActionListener(listnerForButton);

        dispositionElement();
    }

    /**
     * This method implements dispositions on the window
     * using HorizontalBox and VerticalBox.
     */

    public void dispositionElement(){
        Box box1 = Box.createHorizontalBox();
        box1.add(Box.createHorizontalStrut(15));
        box1.add(labelFirstSummand);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(textFieldSecondSummand);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(labelEqually);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(textFieldSum);
        box1.add(Box.createHorizontalStrut(15));

        Box box2 = Box.createHorizontalBox();
        box2.add(Box.createHorizontalStrut(15));
        box2.add(labelStartInterval);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(textFieldStartInterval);
        box2.add(Box.createHorizontalStrut(15));

        Box box3 = Box.createHorizontalBox();
        box3.add(Box.createHorizontalStrut(15));
        box3.add(labelEndInterval);
        box3.add(Box.createHorizontalStrut(15));
        box3.add(textFieldEndInterval);
        box3.add(Box.createHorizontalStrut(15));

        Box box4 = Box.createHorizontalBox();
        box4.add(Box.createHorizontalStrut(15));
        box4.add(labelRoot);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(buttonAssortRoot);
        box4.add(Box.createHorizontalStrut(100));

        Box mainBox = Box.createVerticalBox();
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(10));

        setContentPane(mainBox);
    }

    /**
     * 
     */
    /
        public class ListenerForButton implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonAssortRoot) {
                    secondSummand = Integer.parseInt(textFieldSecondSummand.getValue().toString());
                    sum = Integer.parseInt(textFieldSum.getValue().toString());
                    startInterval = Integer.parseInt(textFieldStartInterval.getValue().toString());
                    endInterval = Integer.parseInt(textFieldEndInterval.getValue().toString());
                    Main.Solution();
                    String root = "Корень " + result;
                    labelRoot.setText(root);
                }
            }
        }

    }




