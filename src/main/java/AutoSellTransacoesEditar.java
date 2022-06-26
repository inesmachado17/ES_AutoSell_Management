import Model.Gestor;
import Model.Matricula;
import Model.Transacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellTransacoesEditar extends JDialog {
    private JFrame parent;
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

    public static final int NIF_AUTOSELL = 600026027;

    public AutoSellTransacoesEditar(JFrame frame, JTable table) {
        this.parent = frame;

        String[] transacoes = {"Venda", "Compra"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(transacoes);
        cbTransacao.setModel(model);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtVendedor.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtComprador.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        if (table.getValueAt(table.getSelectedRow(), 3).toString() == null)
            txtValor.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        else
            txtValor.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        txtData.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
        ckTransacaoConfirmada.setSelected(table.getValueAt(table.getSelectedRow(), 6).toString() != "");

        if (txtVendedor.getText().equals(Integer.toString(NIF_AUTOSELL))) {
            cbTransacao.setSelectedItem(transacoes[0]);
            txtVendedor.setEditable(false);
        } else {
            cbTransacao.setSelectedItem(transacoes[1]);
            txtComprador.setEditable(false);
        }
        cbTransacao.setEnabled(false);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbTransacao.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Defina o tipo de transação.");
                    return;
                }

                if (!Gestor.getGestor().isNIFValido(txtVendedor.getText())) {
                    JOptionPane.showMessageDialog(null, "NIF vendedor inválido.");
                    return;
                }
                int nifVendedor = Integer.parseInt(txtVendedor.getText());

                if (!Gestor.getGestor().isNIFValido(txtComprador.getText())) {
                    JOptionPane.showMessageDialog(null, "NIF comprador inválido.");
                    return;
                }
                int nifComprador = Integer.parseInt(txtComprador.getText());

                Matricula matricula = new Matricula(txtMatricula.getText());

                if (!matricula.isMatriculaValida()) {
                    JOptionPane.showMessageDialog(null, "Matrícula inválida.");
                    return;
                }

                if (txtValor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Insira um valor.");
                    return;
                }

                if (Double.parseDouble(txtValor.getText()) <= 100.00) {
                    JOptionPane.showMessageDialog(null, "Valor inválido.");
                    return;
                }

                Transacao transacao = new Transacao(cbTransacao.getSelectedItem().toString(),
                        nifComprador, nifVendedor,
                        matricula,
                        Double.parseDouble(txtValor.getText()),
                        null);

                //Gestor.getGestor().atualizarTransacao(transacao);

                System.out.println(transacao.toString());

                Gestor.getGestor().atualizaTabelaTransacoes(table);

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
