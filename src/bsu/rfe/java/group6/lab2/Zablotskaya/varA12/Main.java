package bsu.rfe.java.group6.lab2.Zablotskaya.varA12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {

    static class MainFrame extends JFrame {
        private static final int WIDTH = 550;
        private static final int HEIGHT = 400;

        private JTextField textFieldX;
        private JTextField textFieldY;
        private JTextField textFieldZ;

        private JTextField textFieldResult;
        private JTextField textFieldMemory;

        private ButtonGroup radioButtons = new ButtonGroup();

        private Box hboxFormulaType = Box.createHorizontalBox();

        private int formulaId = 1;

        private Double result;
        private Double memory = new Double(0);

        public Double calculate1(Double x, Double y, Double z) {
            return (Math.sin(y)+(y*y)+Math.pow(Math.E,Math.cos(y)))*(Math.pow((Math.log(z)+Math.sin((x*x)*Math.PI)),0.25));
        }

        public Double calculate2(Double x, Double y, Double z) {
            return (Math.tan(x*x)+Math.sqrt(y))/(z*Math.log(x+y));
        }
        // метод-помощник для добавления радио-кнопок
        private void addRadioButton(String buttonName, final int formulaId) {
            JRadioButton button = new JRadioButton(buttonName);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    MainFrame.this.formulaId = formulaId;
                }
            });
            radioButtons.add(button);
            hboxFormulaType.add(button);
        }
    }
}

