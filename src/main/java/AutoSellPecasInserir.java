import Model.Gestor;
import Model.Matricula;
import Model.Peca;
import Model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellPecasInserir extends JDialog {

    private JFrame parent;
    private JTextField txtRef;
    private JTextField txtQtd;
    private JTextField txtDesc;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbMarca;
    private JComboBox cbLocal;
    private JPanel painelPecasInserir;

    public AutoSellPecasInserir(JFrame frame, JTable tablePecas) {

        this.parent = frame;

        //String[] locais = {"Lisboa","Coimbra","Leiria","Porto"};
        String[] locais = Gestor.getGestor().getOficinas();

        final DefaultComboBoxModel modelLocais = new DefaultComboBoxModel(locais);
        cbLocal.setModel(modelLocais);

        //String[] marcasPecas = {"Bosh","Castrol","Wurth"};
        String[] marcasPecas = Gestor.getGestor().getMarcas();

        final DefaultComboBoxModel modelPecas = new DefaultComboBoxModel(marcasPecas);
        cbMarca.setModel(modelPecas);

        setTitle("Inserir Peça");
        setContentPane(painelPecasInserir);
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

                if(txtDesc.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Designação invalida.");
                    return;
                }

                Peca peca = new Peca(txtRef.getText(), cbMarca.getSelectedItem().toString(), cbLocal.getSelectedItem().toString(), Integer.parseInt(txtQtd.getText()), txtDesc.getText());

                Peca p = Gestor.getGestor().getPeca(peca.getReferencia());

                if(p != null){
                    JOptionPane.showMessageDialog(null, "Peça já existente.");
                    return;
                }

                Gestor.getGestor().inserirPeca(peca);

                System.out.println(peca.toString());

                Gestor.getGestor().atualizaTabelaPecas(tablePecas);
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
