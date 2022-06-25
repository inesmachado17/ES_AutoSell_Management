import Model.Gestor;
import Model.Peca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellPecasEditar extends JDialog{

    private JFrame parent;
    private JTextField txtRef;
    private JTextField txtQtd;
    private JComboBox cbLocal;
    private JComboBox cbMarca;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel painelPecasEditar;
    private JTextField txtDesignacao;

    public AutoSellPecasEditar(JFrame frame, JTable tabelaPecas) {

        this.parent = frame;

        //String[] locais = {"Lisboa","Coimbra","Leiria","Porto"};
        String[] locais = Gestor.getGestor().getOficinas();

        final DefaultComboBoxModel modelLocais = new DefaultComboBoxModel(locais);
        cbLocal.setModel(modelLocais);

        //String[] marcasPecas = {"Bosh","Castrol","Wurth"};
        String[] marcasPecas = Gestor.getGestor().getMarcas();

        final DefaultComboBoxModel modelPecas = new DefaultComboBoxModel(marcasPecas);
        cbMarca.setModel(modelPecas);

        txtRef.setText(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 0).toString());
        cbMarca.setSelectedItem(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 1).toString());
        cbLocal.setSelectedItem(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 2).toString());
        txtDesignacao.setText(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 4).toString());
        txtQtd.setText(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 3).toString());

        setTitle("Editar Peça");
        setContentPane(painelPecasEditar);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtRef.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Referencia Invalida.");
                    return;
                }

                if(cbMarca.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Marca Invalida.");
                    return;
                }

                if(cbLocal.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Localização Invalida.");
                    return;
                }

                if(Integer.parseInt(txtQtd.getText()) <= 0){
                    JOptionPane.showMessageDialog(null, "Quantidade inválida");
                    return;
                }

                if(txtDesignacao.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Designação invalida.");
                    return;
                }

                Peca peca = new Peca(txtRef.getText(), cbMarca.getSelectedItem().toString(), cbLocal.getSelectedItem().toString(), Integer.parseInt(txtQtd.getText()), txtDesignacao.getText());

                Peca p = Gestor.getGestor().getPeca(peca.getReferencia());

                if(p == null){
                    JOptionPane.showMessageDialog(null, "Peça não existe na base de dados.");
                    return;
                }

                Gestor.getGestor().atualizarPeca(peca);

                System.out.println(peca.toString());

                Gestor.getGestor().atualizaTabelaPecas(tabelaPecas);
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
