import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellClientesEditar extends JFrame{
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtNome;
    private JTextField txtNIF;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtMorada;
    private JTextField txtCodPostal;
    private JPanel painelClienteEditar;

    public AutoSellClientesEditar(JTable table) {

        txtNIF.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtTelefone.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        txtEmail.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        txtMorada.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        txtCodPostal.setText(table.getValueAt(table.getSelectedRow(), 5).toString());

        setTitle("Editar Cliente");
        setContentPane(painelClienteEditar);
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
