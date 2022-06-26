import Model.Gestor;
import Model.Matricula;
import Model.Transacao;
import Model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AutoSellTransacoesInserir extends JDialog {
    private JFrame parent;
    private JPanel painelTransacoesInserir;
    private JTextField txtNifComprador;
    private JTextField txtNifVendedor;
    private JTextField txtMatricula;
    private JTextField txtValor;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbTipoTransacao;

    public static final int NIF_AUTOSELL = 600026027;

    public AutoSellTransacoesInserir(JFrame frame, JTable tabelaTransacoes) {
        this.parent = frame;

        String[] transacoes = {"Venda", "Compra"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(transacoes);
        cbTipoTransacao.setModel(model);
        txtNifVendedor.setText(Integer.toString(NIF_AUTOSELL));
        txtNifVendedor.setEnabled(false);

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
                if (cbTipoTransacao.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Defina o tipo de transação.");
                    return;
                }

                if (!Gestor.getGestor().isNIFValido(txtNifVendedor.getText())) {
                    JOptionPane.showMessageDialog(null, "NIF vendedor inválido.");
                    return;
                }
                int nifVendedor = Integer.parseInt(txtNifVendedor.getText());

                if (!Gestor.getGestor().isNIFValido(txtNifComprador.getText())) {
                    JOptionPane.showMessageDialog(null, "NIF comprador inválido.");
                    return;
                }
                int nifComprador = Integer.parseInt(txtNifComprador.getText());

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

                Transacao transacao = new Transacao(cbTipoTransacao.getSelectedItem().toString(),
                        nifComprador, nifVendedor,
                        matricula,
                        Double.parseDouble(txtValor.getText()),
                        null);

                if (Gestor.getGestor().existsTransacao(transacao)) {
                    JOptionPane.showMessageDialog(null, "Transação já foi registada.");
                    return;
                }

                Gestor.getGestor().adicionarTransacao(transacao);

                System.out.println(transacao.toString());

                Gestor.getGestor().atualizaTabelaTransacoes(tabelaTransacoes);

                dispose();
            }
        });
        cbTipoTransacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbTipoTransacao.getSelectedItem().toString().equals("Venda")) {
                    txtNifComprador.setText("");
                    txtNifComprador.setEnabled(true);
                    txtNifVendedor.setText(Integer.toString(NIF_AUTOSELL));
                    txtNifVendedor.setEnabled(false);
                } else {
                    txtNifComprador.setText(Integer.toString(NIF_AUTOSELL));
                    txtNifComprador.setEnabled(false);
                    txtNifVendedor.setText("");
                    txtNifVendedor.setEnabled(true);
                }
            }
        });
    }
}
