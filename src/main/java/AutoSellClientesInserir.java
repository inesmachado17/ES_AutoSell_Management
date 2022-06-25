import Model.Cliente;
import Model.Gestor;
import Model.Matricula;
import Model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellClientesInserir extends JDialog{

    private JFrame parent;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JTextField txtNome;
    private JTextField txtNIF;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtMorada;
    private JTextField txtCodPostal;
    private JPanel painelClientesInserir;

    public AutoSellClientesInserir(JFrame frame, JTable tabelaClientes) {
        this.parent = frame;
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

                if(c != null){
                    JOptionPane.showMessageDialog(null, "Cliente já existe.");
                    return;
                }

                Gestor.getGestor().inserirCliente(cliente);

                System.out.println(cliente.toString());

                Gestor.getGestor().atualizaTabelaClientes(tabelaClientes);
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
