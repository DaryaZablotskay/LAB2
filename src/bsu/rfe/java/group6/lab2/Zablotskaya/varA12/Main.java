package bsu.rfe.java.group6.lab2.Zablotskaya.varA12;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
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
            return (Math.sin(y) + (y * y) + Math.pow(Math.E, Math.cos(y))) * (Math.pow((Math.log(z) + Math.sin((x * x) * Math.PI)), 0.25));
        }

        public Double calculate2(Double x, Double y, Double z) {
            return (Math.tan(x * x) + Math.sqrt(y)) / (z * Math.log(x + y));
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

        // Конструктор класса
        public MainFrame() {
            super("Вычисление формулы");
            setSize(WIDTH, HEIGHT);
            Toolkit kit = Toolkit.getDefaultToolkit();
            // Отцентрировать окно приложения на экране
            setLocation((kit.getScreenSize().width - WIDTH) / 2,
                    (kit.getScreenSize().height - HEIGHT) / 2);
            hboxFormulaType.add(Box.createHorizontalGlue());
            addRadioButton("Формула 1", 1);
            addRadioButton("Формула 2", 2);
            radioButtons.setSelected(
                    radioButtons.getElements().nextElement().getModel(), true);
            hboxFormulaType.add(Box.createHorizontalGlue());
            hboxFormulaType.setBorder(
                    BorderFactory.createLineBorder(Color.YELLOW));
// Создать область с полями ввода для X, Y, Z
            JLabel labelForX = new JLabel("X:");
            textFieldX = new JTextField("0", 10);
            textFieldX.setMaximumSize(textFieldX.getPreferredSize());
            JLabel labelForY = new JLabel("Y:");
            textFieldY = new JTextField("0", 10);
            textFieldY.setMaximumSize(textFieldY.getPreferredSize());
            JLabel labelForZ = new JLabel("Z:");
            textFieldZ = new JTextField("0", 10);
            textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
//добавление текстовых полей для переменнных
            Box hboxVariables = Box.createHorizontalBox();
            hboxVariables.setBorder(
                    BorderFactory.createLineBorder(Color.RED));
            hboxVariables.add(Box.createHorizontalGlue());
            hboxVariables.add(labelForX);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldX);
            hboxVariables.add(Box.createHorizontalStrut(100));
            hboxVariables.add(labelForY);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldY);
            hboxVariables.add(Box.createHorizontalStrut(100));
            hboxVariables.add(labelForZ);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldZ);
            hboxVariables.add(Box.createHorizontalGlue());
// Создать область для вывода результата
            JLabel labelForResult = new JLabel("Результат:");
            textFieldResult = new JTextField("0", 15);
            textFieldResult.setMaximumSize(
                    textFieldResult.getPreferredSize());

            Box hboxResult = Box.createHorizontalBox();
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.add(labelForResult);
            hboxResult.add(Box.createHorizontalStrut(10));
            hboxResult.add(textFieldResult);
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

            //создание области для вывода памяти
            JLabel labelForMemory = new JLabel("Память:");
            textFieldMemory = new JTextField("0",15);
            textFieldMemory.setMaximumSize(
                    textFieldMemory.getPreferredSize());

            Box hboxMemory = Box.createHorizontalBox();
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.add(labelForMemory);
            hboxResult.add(Box.createHorizontalStrut(10));
            hboxResult.add(textFieldMemory);
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Создать область для кнопок
//создание кнопки "ВЫЧИСЛИТЬ"
            JButton buttonCalc = new JButton("Вычислить");
            buttonCalc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    try {
                        Double x = Double.parseDouble(textFieldX.getText());
                        Double y = Double.parseDouble(textFieldY.getText());
                        Double z = Double.parseDouble(textFieldZ.getText());
                        if (formulaId == 1) {
                            result = calculate1(x, y, z);
                        }
                        else {
                            result = calculate2(x, y, z);
                        }
                        textFieldResult.setText(result.toString());

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }
}

