import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellVeiculosInserir extends  JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextArea textArea1;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel painelVeiculosInserir;

    public AutoSellVeiculosInserir() {

        String[] marcas = {"Audi","Toyota","Mercedes-Benz","BMW","Honda","Ford","Hyundai","Nissan","Volkswagen","Porsche", "Opel"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(marcas);
        comboBox1.setModel(model);
        setTitle("Inserir Veiculo");
        setContentPane(painelVeiculosInserir);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
