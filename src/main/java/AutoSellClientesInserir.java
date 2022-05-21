import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellClientesInserir extends JFrame{
    private JButton guardarButton;
    private JButton eliminarButton;
    private JTextField txtNome;
    private JTextField txtNIF;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtMorada;
    private JTextField txtCodPostal;
    private JPanel painelClientesInserir;

    public AutoSellClientesInserir() {
        setTitle("Inserir Cliente");
        setContentPane(painelClientesInserir);
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
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
