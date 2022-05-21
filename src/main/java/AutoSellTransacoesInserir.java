import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellTransacoesInserir extends JFrame{
    private JPanel painelTransacoesInserir;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;

    public AutoSellTransacoesInserir() {

        String[] transacoes = {"Compra","Venda"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(transacoes);
        comboBox1.setModel(model);

        setTitle("Inserir Transação");
        setContentPane(painelTransacoesInserir);
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
