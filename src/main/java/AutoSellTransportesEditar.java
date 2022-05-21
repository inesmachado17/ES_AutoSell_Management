import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellTransportesEditar extends JFrame {
    private JTextField txtMatricula;
    private JTextField txtLocalRecolha;
    private JTextField txtLocalEntrega;
    private JTextField txtDataRecolha;
    private JTextField txtDataEntrega;
    private JCheckBox ckEntregue;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbLocalAtual;
    private JPanel painelTransportesEditar;

    public AutoSellTransportesEditar(JTable table) {

        String[] localAtual = {"Filial","Sede","Evento"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(localAtual);
        cbLocalAtual.setModel(model);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtLocalRecolha.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        txtLocalEntrega.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        if(table.getValueAt(table.getSelectedRow(), 4).toString() != "")
            ckEntregue.setSelected(true);
        txtDataRecolha.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
        txtDataEntrega.setText(table.getValueAt(table.getSelectedRow(), 6).toString());

        setTitle("Editar Transporte");
        setContentPane(painelTransportesEditar);
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
