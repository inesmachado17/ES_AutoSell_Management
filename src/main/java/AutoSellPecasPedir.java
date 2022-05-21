import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellPecasPedir extends JFrame{

    private JTextField txtRef;
    private JTextField txtQtd;
    private JTextField txtDesignacao;
    private JButton confirmarPedidoButton;
    private JButton cancelarButton;
    private JComboBox cbMarca;
    private JComboBox cbLocal;
    private JPanel painelPecasPedir;

    public AutoSellPecasPedir(JTable table) {

        String[] locais = {"Lisboa","Coimbra","Leiria","Porto"};
        final DefaultComboBoxModel modelLocais = new DefaultComboBoxModel(locais);
        cbLocal.setModel(modelLocais);

        String[] marcasPecas = {"Bosh","Castrol","Wurth"};
        final DefaultComboBoxModel modelPecas = new DefaultComboBoxModel(marcasPecas);
        cbMarca.setModel(modelPecas);

        txtRef.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtDesignacao.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtQtd.setText("1");

        cbLocal.setEnabled(false);
        cbMarca.setEnabled(false);
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
