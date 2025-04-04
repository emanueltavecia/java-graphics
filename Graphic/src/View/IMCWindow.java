package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class IMCWindow extends JFrame {
    private int WINDOW_WIDTH = 350;
    private int WINDOW_HEIGHT = 500;
    private int HEADER_HEIGHT = 68;
    private int HEADER_MARGIN_TOP = 8;
    private int MARGIN_LEFT = 10;
    private int INPUT_WIDTH = 280;
    private int INPUT_HEIGHT = 30;
    private int BUTTON_WIDTH = 300;
    private int BUTTON_HEIGHT = 40;
    private int LABEL_HEIGHT = 25;
    private int BASE_SPACING = 15;

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
        createResultComponents();
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
        int currentY = HEADER_HEIGHT + BASE_SPACING;

        JLabel labelWeight = new JLabel("Peso");
        labelWeight.setBounds(MARGIN_LEFT, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(labelWeight);

        currentY += LABEL_HEIGHT;
        weightField = new JTextField();
        weightField.setBounds(MARGIN_LEFT, currentY, INPUT_WIDTH, INPUT_HEIGHT);
        getContentPane().add(weightField);

        JLabel labelWeightUnit = new JLabel("Kg");
        labelWeightUnit.setBounds(MARGIN_LEFT + INPUT_WIDTH, currentY, 50, INPUT_HEIGHT);
        getContentPane().add(labelWeightUnit);

        currentY += INPUT_HEIGHT + BASE_SPACING;
        JLabel labelHeight = new JLabel("Altura");
        labelHeight.setBounds(MARGIN_LEFT, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(labelHeight);

        currentY += LABEL_HEIGHT;
        heightField = new JTextField();
        heightField.setBounds(MARGIN_LEFT, currentY, INPUT_WIDTH, INPUT_HEIGHT);
        getContentPane().add(heightField);

        JLabel labelHeightUnit = new JLabel("m");
        labelHeightUnit.setBounds(MARGIN_LEFT + INPUT_WIDTH, currentY, 50, INPUT_HEIGHT);
        getContentPane().add(labelHeightUnit);

        currentY += INPUT_HEIGHT + BASE_SPACING;
        JButton calculateButton = new JButton("CALCULAR");
        calculateButton.setBounds(MARGIN_LEFT, currentY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getContentPane().add(calculateButton);
    }

    public void createResultComponents() {
        int currentY = HEADER_HEIGHT + 4 * (INPUT_HEIGHT + BASE_SPACING) + BUTTON_HEIGHT + 2 * BASE_SPACING;

        JLabel resultLabel = new JLabel("Resultado");
        resultLabel.setBounds(MARGIN_LEFT, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(resultLabel);

        currentY += LABEL_HEIGHT;
        JLabel labelIdealWeight = new JLabel("Peso ideal");
        labelIdealWeight.setBounds(MARGIN_LEFT, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(labelIdealWeight);

        resultIdealWeight = new JLabel("_");
        resultIdealWeight.setBounds(120, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(resultIdealWeight);

        JLabel labelIMC = new JLabel("IMC");
        labelIMC.setBounds(200, currentY, 50, LABEL_HEIGHT);
        getContentPane().add(labelIMC);

        resultIMC = new JLabel("_");
        resultIMC.setBounds(250, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(resultIMC);

        currentY += LABEL_HEIGHT;
        JLabel labelInterpretation = new JLabel("Interpretação");
        labelInterpretation.setBounds(MARGIN_LEFT, currentY, 100, LABEL_HEIGHT);
        getContentPane().add(labelInterpretation);

        resultInterpretation = new JLabel("_");
        resultInterpretation.setBounds(120, currentY, 200, LABEL_HEIGHT);
        getContentPane().add(resultInterpretation);

        currentY += LABEL_HEIGHT + BASE_SPACING;
        JButton clearButton = new JButton("LIMPAR");
        clearButton.setBounds(MARGIN_LEFT, currentY, BUTTON_WIDTH, BUTTON_HEIGHT);
        getContentPane().add(clearButton);
    }
}
