import Model.Gestor;
import Model.Matricula;
import Model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellVeiculosEditar extends JDialog {

    private JFrame parent;

    private JPanel PainelVeiculosEditar;
    private JTextField txtMatricula;
    private JTextField txtModelo;
    private JTextField txtDonoAnt;
    private JComboBox cbMarca;
    private JTextArea taCaracteristicas;
    private JButton guardarButton;
    private JButton cancelarButton;

    public AutoSellVeiculosEditar(JFrame frame, JTable table) {
        this.parent = frame;

        //String[] marcas = {"Audi","Toyota","Mercedes-Benz","BMW","Honda","Ford","Hyundai","Nissan","Volkswagen","Porsche","Opel"};
        String[] marcas = Gestor.getGestor().getMarcasAuto();

        final DefaultComboBoxModel model = new DefaultComboBoxModel(marcas);
        cbMarca.setModel(model);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtModelo.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        cbMarca.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
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

                Matricula matricula = new Matricula(txtMatricula.getText());

                if(!matricula.isMatriculaValida()){
                    JOptionPane.showMessageDialog(null, "Matricula Invalida.");
                    return;
                }

                if(txtModelo.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Modelo Invalido.");
                    return;
                }

                if(cbMarca.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Marca Invalida.");
                    return;
                }

                if(!Gestor.getGestor().isNIFValido(txtDonoAnt.getText())){
                    JOptionPane.showMessageDialog(null, "Dono Anterior Invalido.");
                    return;
                }

                if(taCaracteristicas.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Caracteristicas Invalidas.");
                    return;
                }

                Veiculo veiculo = new Veiculo(matricula,txtModelo.getText(), cbMarca.getSelectedItem().toString(), Integer.parseInt(txtDonoAnt.getText()), taCaracteristicas.getText());

                Veiculo v = Gestor.getGestor().getVeiculo(matricula);

                if(v == null){
                    JOptionPane.showMessageDialog(null, "Veiculo não existe na base de dados.");
                    return;
                }

                Gestor.getGestor().atualizarVeiculo(veiculo);

                System.out.println(veiculo.toString());

                Gestor.getGestor().atualizaTabelaVeiculos(table);

                dispose();

            }
        });
    }
}
