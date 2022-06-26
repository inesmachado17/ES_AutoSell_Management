import Model.Gestor;
import Model.Peca;
import Model.Pedido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class AutoSellPecasPedir extends JDialog{

    private JFrame parent;

    private JTextField txtRef;
    private JTextField txtQtd;
    private JTextField txtDesignacao;
    private JButton confirmarPedidoButton;
    private JButton cancelarButton;
    private JComboBox cbOrigem;
    private JComboBox cbDestino;
    private JPanel painelPecasPedir;

    public AutoSellPecasPedir(JFrame frame, JTable table) {

        this.parent = frame;

        //String[] localOrigem = {"Lisboa","Coimbra","Leiria","Porto"};
        String[] localOrigem = Gestor.getGestor().getOficinas();

        final DefaultComboBoxModel modelLocais = new DefaultComboBoxModel(localOrigem);
        cbDestino.setModel(modelLocais);

        //String[] localDestino = {"Lisboa","Coimbra","Leiria","Porto"};
        String[] localDestino = Gestor.getGestor().getOficinas();

        final DefaultComboBoxModel modelPecas = new DefaultComboBoxModel(localDestino);
        cbOrigem.setModel(modelPecas);

        txtRef.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtDesignacao.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtQtd.setText("1");

        //cbDestino.setEnabled(false);
        cbOrigem.setEnabled(false);
        txtRef.setEditable(false);
        txtDesignacao.setEditable(false);

        setTitle("Pedir Peça");
        setContentPane(painelPecasPedir);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        confirmarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtRef.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Referencia Invalida.");
                    return;
                }

                if(cbOrigem.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Localização Invalida.");
                    return;
                }

                if(cbDestino.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Localização Invalida.");
                    return;
                }

                try{
                    Integer.parseInt(txtQtd.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Quantidade inválida");
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

                Pedido pedido = new Pedido(cbOrigem.getSelectedItem().toString(), cbDestino.getSelectedItem().toString(), Integer.parseInt(txtQtd.getText()));

                Gestor.getGestor().adicionarPedido(txtRef.getText(), pedido);

                Gestor.getGestor().atualizaTabelaPecas(table);

                System.out.println(pedido);

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
