import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellPecasInserir extends JFrame {
    private JTextField txtRef;
    private JTextField txtQtd;
    private JTextField txtDesc;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbMarca;
    private JComboBox cbLocal;
    private JPanel painelPecasInserir;

    public AutoSellPecasInserir() {

        String[] locais = {"Lisboa","Coimbra","Leiria","Porto"};
        final DefaultComboBoxModel modelLocais = new DefaultComboBoxModel(locais);
        cbLocal.setModel(modelLocais);

        String[] marcasPecas = {"Bosh","Castrol","Wurth"};
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
