import Model.Gestor;
import Model.Matricula;
import Model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellVeiculosInserir extends JDialog{

    private JFrame parent;
    private JTextField txtMatricula;
    private JTextField txtModelo;
    private JComboBox comboMarca;
    private JTextField txtDonoAnterior;
    private JTextArea taCaracteristicas;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel painelVeiculosInserir;

    public AutoSellVeiculosInserir(JFrame frame, JTable tabelaVeiculos) {

        this.parent = frame;

        //String[] marcas = {"Audi","Toyota","Mercedes-Benz","BMW","Honda","Ford","Hyundai","Nissan","Volkswagen","Porsche", "Opel"};
        String[] marcas = Gestor.getGestor().getMarcasAuto();

        final DefaultComboBoxModel model = new DefaultComboBoxModel(marcas);
        comboMarca.setModel(model);
        setTitle("Inserir Veiculo");
        setContentPane(painelVeiculosInserir);
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

                if(comboMarca.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Marca Invalida.");
                    return;
                }

                if(!Gestor.getGestor().isNIFValido(txtDonoAnterior.getText())){
                    JOptionPane.showMessageDialog(null, "Dono Anterior Invalido.");
                    return;
                }

                if(taCaracteristicas.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Caracteristicas Invalidas.");
                    return;
                }

                Veiculo veiculo = new Veiculo(matricula,txtModelo.getText(), comboMarca.getSelectedItem().toString(), Integer.parseInt(txtDonoAnterior.getText()), taCaracteristicas.getText());

                Veiculo v = Gestor.getGestor().getVeiculo(matricula);

                if(v != null){
                    JOptionPane.showMessageDialog(null, "Veiculo já existe.");
                    return;
                }

                Gestor.getGestor().inserirVeiculo(veiculo);

                System.out.println(veiculo.toString());

                Gestor.getGestor().atualizaTabelaVeiculos(tabelaVeiculos);
                dispose();
            }
        });

    }

}
