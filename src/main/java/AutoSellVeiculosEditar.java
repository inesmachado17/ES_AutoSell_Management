import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellVeiculosEditar extends JFrame {

    private JPanel PainelVeiculosEditar;
    private JTextField txtMatricula;
    private JTextField txtModelo;
    private JTextField txtDonoAnt;
    private JComboBox cbMarca;
    private JTextArea taCaracteristicas;
    private JButton guardarButton;
    private JButton cancelarButton;

    public AutoSellVeiculosEditar(JTable table) {

        String[] marcas = {"Audi","Toyota","Mercedes-Benz","BMW","Honda","Ford","Hyundai","Nissan","Volkswagen","Porsche","Opel"};
        final DefaultComboBoxModel model = new DefaultComboBoxModel(marcas);
        cbMarca.setModel(model);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtModelo.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        cbMarca.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());
        txtDonoAnt.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        taCaracteristicas.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
        setTitle("Editar Veiculo");
        setContentPane(PainelVeiculosEditar);
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
                dispose();
            }
        });
    }
}
