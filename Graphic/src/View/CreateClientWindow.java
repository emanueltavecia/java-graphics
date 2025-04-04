package View;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateClientWindow extends JFrame {
    private JLabel labelName, labelCPF;
    private JTextField inputName, inputCPF;
    private JButton buttonSave;

    private int WINDOW_HEIGHT = 500;
    private int ITEM_HEIGHT = 25;
    private int PADDING_LEFT = 10;
    private int PADDING_RIGHT = 15;
    private int PADDING_TOP = 10;
    private int LABEL_WIDTH = 50;
    private int INPUT_WIDTH = 300;
    private int GAP_X = 10;
    private int GAP_Y = 15;

    public CreateClientWindow() {
        setTitle("Cadastro de Cliente");
        setSize(PADDING_LEFT + LABEL_WIDTH + INPUT_WIDTH + PADDING_RIGHT + GAP_X, WINDOW_HEIGHT);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        labelName = new JLabel("Nome:");
        labelName.setBounds(PADDING_LEFT, PADDING_TOP, LABEL_WIDTH, ITEM_HEIGHT);
        getContentPane().add(labelName);

        inputName = new JTextField();
        inputName.setBounds(LABEL_WIDTH + GAP_X, PADDING_TOP, INPUT_WIDTH, ITEM_HEIGHT);
        getContentPane().add(inputName);

        labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(PADDING_LEFT, ITEM_HEIGHT + GAP_Y, LABEL_WIDTH, ITEM_HEIGHT);
        getContentPane().add(labelCPF);

        inputCPF = new JTextField();
        inputCPF.setBounds(LABEL_WIDTH + GAP_X, ITEM_HEIGHT + GAP_Y, INPUT_WIDTH, ITEM_HEIGHT);
        getContentPane().add(inputCPF);

        buttonSave = new JButton(new AbstractAction("Salvar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(inputName, "Nome é obrigatório");
                    inputName.requestFocus();
                    return;
                }
                if (inputCPF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(inputCPF, "CPF é obrigatório");
                    inputCPF.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(buttonSave, "Cliente salvo com sucesso");
            }
        });
        buttonSave.setBounds(PADDING_LEFT, (ITEM_HEIGHT + GAP_Y) * 2, LABEL_WIDTH + INPUT_WIDTH, ITEM_HEIGHT);
        getContentPane().add(buttonSave);
    }
}
