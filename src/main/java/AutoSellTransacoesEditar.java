import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellTransacoesEditar extends JFrame{
    private JPanel painelTransacoesEditar;
    private JTextField txtComprador;
    private JTextField txtVendedor;
    private JTextField txtMatricula;
    private JTextField txtValor;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbTransacao;
    private JTextField txtData;
    private JCheckBox ckTransacaoConfirmada;

    public AutoSellTransacoesEditar(JTable table) {

        String[] transacoes = {"Compra","Venda"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(transacoes);
        cbTransacao.setModel(model);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtVendedor.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtComprador.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        if(table.getValueAt(table.getSelectedRow(), 3).toString() == null)
            txtValor.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        else
            txtValor.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        txtData.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
        ckTransacaoConfirmada.setSelected(table.getValueAt(table.getSelectedRow(), 6).toString() != "");
        cbTransacao.setEnabled(false);

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

        setTitle("Editar Transação");
        setContentPane(painelTransacoesEditar);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
