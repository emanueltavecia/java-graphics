package View;

import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class IMCWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 500;
    private static final int HEADER_HEIGHT = 68;
    private static final int HEADER_MARGIN_TOP = 8;
    private static final int MARGIN_LEFT = 10;
    private static final int INPUT_WIDTH = 280;
    private static final int INPUT_HEIGHT = 30;
    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 40;
    private static final int LABEL_HEIGHT = 25;
    private static final int BASE_SPACING = 15;
    private static final String EMPTY_PLACEHOLDER = "___________";

    private JButton calculateButton;
    private JTextField weightField, heightField;
    private JLabel resultIMC, resultIdealWeight, resultInterpretation;

    public IMCWindow() {
        setTitle("Calculadora de IMC");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createHeaderComponents();
        createFormComponents();
        setVisible(true);
    }

    public void createHeaderComponents() {
        JPanel headerContainer = new JPanel();
        headerContainer.setBounds(0, 0, WINDOW_WIDTH, HEADER_HEIGHT);
        headerContainer.setBackground(new Color(110000));
        headerContainer.setLayout(null);
        getContentPane().add(headerContainer);

        JLabel headerTitle = new JLabel("Índice de massa corporal (IMC)");
        headerTitle.setBounds(MARGIN_LEFT, HEADER_MARGIN_TOP, WINDOW_WIDTH, LABEL_HEIGHT);
        headerTitle.setForeground(Color.white);
        headerTitle.setFont(new Font(null, Font.PLAIN, 20));
        headerContainer.add(headerTitle);

        JLabel headerSubtitle = new JLabel("Uma medida de gordura corporal em adultos");
        headerSubtitle.setBounds(MARGIN_LEFT, HEADER_MARGIN_TOP + LABEL_HEIGHT, WINDOW_WIDTH, LABEL_HEIGHT);
        headerSubtitle.setForeground(Color.white);
        headerSubtitle.setFont(new Font(null, Font.PLAIN, 12));
        headerContainer.add(headerSubtitle);
    }

    public void createFormComponents() {
        int currentYFormSection = HEADER_HEIGHT + BASE_SPACING;

        JLabel labelWeight = new JLabel("Peso");
        labelWeight.setBounds(MARGIN_LEFT, currentYFormSection, 100, LABEL_HEIGHT);
        getContentPane().add(labelWeight);

        currentYFormSection += LABEL_HEIGHT;
        weightField = new JTextField();
        weightField.setBounds(MARGIN_LEFT, currentYFormSection, INPUT_WIDTH, INPUT_HEIGHT);
        getContentPane().add(weightField);

        JLabel labelWeightUnit = new JLabel("Kg");
        labelWeightUnit.setBounds(MARGIN_LEFT + INPUT_WIDTH, currentYFormSection, 50, INPUT_HEIGHT);
        getContentPane().add(labelWeightUnit);

        currentYFormSection += INPUT_HEIGHT + BASE_SPACING;
        JLabel labelHeight = new JLabel("Altura");
        labelHeight.setBounds(MARGIN_LEFT, currentYFormSection, 100, LABEL_HEIGHT);
        getContentPane().add(labelHeight);

        currentYFormSection += LABEL_HEIGHT;
        heightField = new JTextField();
        heightField.setBounds(MARGIN_LEFT, currentYFormSection, INPUT_WIDTH, INPUT_HEIGHT);
        getContentPane().add(heightField);

        JLabel labelHeightUnit = new JLabel("m");
        labelHeightUnit.setBounds(MARGIN_LEFT + INPUT_WIDTH, currentYFormSection, 50, INPUT_HEIGHT);
        getContentPane().add(labelHeightUnit);

        currentYFormSection += INPUT_HEIGHT + BASE_SPACING;

        calculateButton = new JButton(new AbstractAction("CALCULAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (weightField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(weightField, "Peso é obrigatório");
                    weightField.requestFocus();
                    return;
                }
                if (heightField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(heightField, "Altura é obrigatório");
                    heightField.requestFocus();
                    return;
                }
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());
                    if (weight <= 0 || height <= 0) {
                        JOptionPane.showMessageDialog(calculateButton, "Peso e altura devem ser positivos");
                        return;
                    }
                    double imc = calculateIMC(weight, height);

                    resultIMC.setText(String.format("%.2f", imc));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(calculateButton, "Peso e altura devem ser números válidos");
                }
            }
        });
        calculateButton.setBounds(MARGIN_LEFT, currentYFormSection, BUTTON_WIDTH, BUTTON_HEIGHT);
        getContentPane().add(calculateButton);

        int currentYResultSection = HEADER_HEIGHT + 4 * (INPUT_HEIGHT + BASE_SPACING) + BUTTON_HEIGHT + 2 * BASE_SPACING;

        JLabel resultLabel = new JLabel("Resultado");
        resultLabel.setBounds(MARGIN_LEFT, currentYResultSection, 100, LABEL_HEIGHT);
        getContentPane().add(resultLabel);

        currentYResultSection += LABEL_HEIGHT;
        JLabel labelIdealWeight = new JLabel("Peso ideal");
        labelIdealWeight.setBounds(MARGIN_LEFT, currentYResultSection, 100, LABEL_HEIGHT);
        getContentPane().add(labelIdealWeight);

        resultIdealWeight = new JLabel(EMPTY_PLACEHOLDER);
        resultIdealWeight.setBounds(120, currentYResultSection, 100, LABEL_HEIGHT);
        getContentPane().add(resultIdealWeight);

        JLabel labelIMC = new JLabel("IMC");
        labelIMC.setBounds(200, currentYResultSection, 50, LABEL_HEIGHT);
        getContentPane().add(labelIMC);

        resultIMC = new JLabel(EMPTY_PLACEHOLDER);
        resultIMC.setBounds(250, currentYResultSection, 100, LABEL_HEIGHT);
        getContentPane().add(resultIMC);

        currentYResultSection += LABEL_HEIGHT;
        JLabel labelInterpretation = new JLabel("Interpretação");
        labelInterpretation.setBounds(MARGIN_LEFT, currentYResultSection, 100, LABEL_HEIGHT);
        getContentPane().add(labelInterpretation);

        resultInterpretation = new JLabel(EMPTY_PLACEHOLDER);
        resultInterpretation.setBounds(120, currentYResultSection, 200, LABEL_HEIGHT);
        getContentPane().add(resultInterpretation);

        currentYResultSection += LABEL_HEIGHT + BASE_SPACING;
        JButton clearButton = new JButton(new AbstractAction("LIMPAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightField.setText("");
                heightField.setText("");
                resultIMC.setText(EMPTY_PLACEHOLDER);
                resultIdealWeight.setText(EMPTY_PLACEHOLDER);
                resultInterpretation.setText(EMPTY_PLACEHOLDER);
            }
        });
        clearButton.setBounds(MARGIN_LEFT, currentYResultSection, BUTTON_WIDTH, BUTTON_HEIGHT);
        getContentPane().add(clearButton);
    }

    private double calculateIMC(double weight, double height) {
        return (weight / (height * height));
    }
}
