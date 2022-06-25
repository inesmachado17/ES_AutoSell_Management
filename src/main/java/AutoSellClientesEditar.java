import Model.Cliente;
import Model.Gestor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellClientesEditar extends JDialog{

    private JFrame parent;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtNome;
    private JTextField txtNIF;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtMorada;
    private JTextField txtCodPostal;
    private JPanel painelClienteEditar;

    public AutoSellClientesEditar(JFrame frame, JTable table) {

        this.parent = frame;

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
                if(txtNome.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nome tem de ser preenchido.");
                    return;
                }

                if(!Gestor.getGestor().isNIFValido(txtNIF.getText())){
                    JOptionPane.showMessageDialog(null, "NIF inválido.");
                    return;
                }

                if(!Gestor.getGestor().isContactoValido(txtTelefone.getText())){
                    JOptionPane.showMessageDialog(null, "Telefone inválido.");
                    return;
                }

                if(!Gestor.getGestor().isEmailValido(txtEmail.getText())){
                    JOptionPane.showMessageDialog(null, "Email inválido.");
                    return;
                }

                if(txtMorada.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Morada tem de ser preenchida.");
                    return;
                }

                if(txtCodPostal.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Codigo Postal tem de ser preenchido.");
                    return;
                }

                Cliente cliente = new Cliente(Integer.parseInt(txtNIF.getText()), txtNome.getText(), Integer.parseInt(txtTelefone.getText()), txtEmail.getText(), txtMorada.getText(), txtCodPostal.getText());

                Cliente c = Gestor.getGestor().getCliente(Integer.parseInt(txtNIF.getText()));

                if(c == null){
                    JOptionPane.showMessageDialog(null, "Cliente não existe na base de dados.");
                    return;
                }

                Gestor.getGestor().atualizarCliente(cliente);

                System.out.println(cliente.toString());

                Gestor.getGestor().atualizaTabelaClientes(table);
                dispose();
            }
        });
    }
}
