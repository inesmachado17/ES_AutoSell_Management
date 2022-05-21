import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellPecasEditar extends JFrame{
    private JTextField txtRef;
    private JTextField txtQtd;
    private JComboBox cbLocal;
    private JComboBox cbMarca;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel painelPecasEditar;
    private JTextField txtDesignacao;

    public AutoSellPecasEditar(JTable table) {

        String[] locais = {"Lisboa","Coimbra","Leiria","Porto"};
        final DefaultComboBoxModel modelLocais = new DefaultComboBoxModel(locais);
        cbLocal.setModel(modelLocais);

        String[] marcasPecas = {"Bosh","Castrol","Wurth"};
        final DefaultComboBoxModel modelPecas = new DefaultComboBoxModel(marcasPecas);
        cbMarca.setModel(modelPecas);

        txtRef.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtDesignacao.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtQtd.setText(table.getValueAt(table.getSelectedRow(), 4).toString());

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
