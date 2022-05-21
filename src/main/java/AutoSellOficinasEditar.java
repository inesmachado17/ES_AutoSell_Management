import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellOficinasEditar extends JFrame{

    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtMatricula;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JComboBox cbServico;
    private JComboBox cbOficina;
    private JPanel painelServicoOficinaEditar;

    public AutoSellOficinasEditar(JTable table) {

        String[] oficinas = {"Lisboa","Coimbra","Leiria","Porto"};
        final DefaultComboBoxModel modeloficinas = new DefaultComboBoxModel(oficinas);
        cbOficina.setModel(modeloficinas);

        String[] servicos = {"Manutenção", "Preparação"};
        final DefaultComboBoxModel modeloservicos = new DefaultComboBoxModel(servicos);
        cbServico.setModel(modeloservicos);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtDataInicio.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        txtDataFim.setText(table.getValueAt(table.getSelectedRow(), 4).toString());

        setTitle("Editar Serviço Oficina");
        setContentPane(painelServicoOficinaEditar);
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
