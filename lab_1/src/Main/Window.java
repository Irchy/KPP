package Main;

import javax.swing.*;
import java.awt.*;
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
    JLabel labelRoot, labelStartInterval, labelEndInterval;
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

        labelRoot = new JLabel("Корень");
        labelRoot.setOpaque(true);
        //labelRoot.setBackground(Color.orange);
        labelStartInterval = new JLabel("Начало интервала");
        labelStartInterval.setOpaque(true);
        //labelStartInterval.setBackground(Color.orange);
        labelEndInterval = new JLabel("Конец интервала");
        labelEndInterval.setOpaque(true);
        //labelEndInterval.setBackground(Color.orange);
        textFieldSecondSummand = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldSum = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldStartInterval = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldEndInterval = new JFormattedTextField(NumberFormat.getIntegerInstance());
        buttonAssortRoot = new JButton("Подобрать корень");

        buttonAssortRoot.addActionListener(listnerForButton);
    }

    /**
     * This method implements dispositions on the window
     * using HorizontalBox and VerticalBox.
     */

    public void dispositionElement(Container pane) {

        GridBagLayout gridBagLayout = new GridBagLayout();

        pane.setLayout(gridBagLayout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.weightx = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel lbl1 = new JLabel("x +");
        lbl1.setHorizontalAlignment(JLabel.RIGHT);
        pane.add(lbl1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        pane.add(textFieldSecondSummand, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        JLabel lbl2 = new JLabel("=");
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        pane.add(lbl2, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        pane.add(textFieldSum, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        pane.add(labelStartInterval, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        pane.add(textFieldStartInterval, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        pane.add(labelEndInterval, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        pane.add(textFieldEndInterval, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        pane.add(labelRoot, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        buttonAssortRoot.setPreferredSize(new Dimension(75, 20));
        pane.add(buttonAssortRoot, constraints);
    }

    /**
     * This class use for handling  button.
     */

    public class ListenerForButton implements ActionListener {
        /**
         * This method for processing press button.
         *
         * @param e is the action event.
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonAssortRoot) {
                if (textFieldSecondSummand.getValue() == null ||
                        textFieldSum.getValue() == null ||
                        textFieldStartInterval.getValue() == null ||
                        textFieldEndInterval.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Заполните поля",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                } else {
                    secondSummand = Integer.parseInt(textFieldSecondSummand.getValue().toString());
                    sum = Integer.parseInt(textFieldSum.getValue().toString());
                    startInterval = Integer.parseInt(textFieldStartInterval.getValue().toString());
                    endInterval = Integer.parseInt(textFieldEndInterval.getValue().toString());

                    if (startInterval > endInterval) {
                        JOptionPane.showMessageDialog(null, "Недопустимые границы инервала",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }

                    for (int i = startInterval; i <= endInterval; i++) {
                        if (i == sum - secondSummand) {
                            result = i;
                            labelRoot.setBackground(Color.orange);
                            labelStartInterval.setBackground(Color.orange);
                            labelEndInterval.setBackground(Color.orange);
                            String root = "Корень " + result;
                            labelRoot.setText(root);
                            break;
                        } else {
                            labelRoot.setBackground(Color.red);
                            labelStartInterval.setBackground(Color.red);
                            labelEndInterval.setBackground(Color.red);
                            String root = "Корень ";
                            labelRoot.setText(root);
                        }
                    }
                }
            }
        }
    }
}






