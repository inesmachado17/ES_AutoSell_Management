import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellTransportesInserir extends JFrame{
    private JTextField txtMatricula;
    private JTextField txtLocalEntrega;
    private JTextField txtDataRecolha;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbLocalAtual;
    private JPanel painelTransportesInserir;
    private JTextField txtLocalRecolha;

    public AutoSellTransportesInserir(){

        String[] localAtual = {"Filial","Sede","Evento"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(localAtual);
        cbLocalAtual.setModel(model);

        setTitle("Inserir Transporte");
        setContentPane(painelTransportesInserir);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
