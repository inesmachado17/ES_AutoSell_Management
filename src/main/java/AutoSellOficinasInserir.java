import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellOficinasInserir extends JFrame {
    private JTextField txtMatricula;
    private JTextField txtServico;
    private JTextField txtData;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbOficina;
    private JPanel painelOficinasInserir;
    private JComboBox cbTipoServico;

    public AutoSellOficinasInserir() {

        String[] transacoes = {"Lisboa","Coimbra","Leiria","Porto"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(transacoes);
        cbOficina.setModel(model);

        String[] tipos = {"Manutenção","Preparação"};
        final DefaultComboBoxModel modelTipos = new DefaultComboBoxModel(tipos);
        cbTipoServico.setModel(modelTipos);

        setTitle("Inserir Trabalho Oficina");
        setContentPane(painelOficinasInserir);
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
