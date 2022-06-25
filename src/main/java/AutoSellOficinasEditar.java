import Model.Data;
import Model.Gestor;
import Model.Matricula;
import Model.Trabalho;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellOficinasEditar extends JDialog{

    private JFrame parent;

    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtMatricula;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JComboBox cbServico;
    private JComboBox cbOficina;
    private JPanel painelServicoOficinaEditar;

    public AutoSellOficinasEditar(JFrame frame, JTable table) {

        this.parent = frame;

       //String[] oficinas = {"Lisboa","Coimbra","Leiria","Porto"};
        String[] oficinas = Gestor.getGestor().getOficinas();

        final DefaultComboBoxModel modeloficinas = new DefaultComboBoxModel(oficinas);
        cbOficina.setModel(modeloficinas);

        //String[] servicos = {"Manutenção", "Preparação"};
        String[] servicos = Gestor.getGestor().getTiposServico();

        final DefaultComboBoxModel modeloservicos = new DefaultComboBoxModel(servicos);
        cbServico.setModel(modeloservicos);

        txtMatricula.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        if(table.getValueAt(table.getSelectedRow(), 3) != null )
            txtDataInicio.setText(table.getValueAt(table.getSelectedRow(), 3).toString());

        if(table.getValueAt(table.getSelectedRow(), 4) != null )
            txtDataFim.setText(table.getValueAt(table.getSelectedRow(), 4).toString());

        cbServico.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());
        cbOficina.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());

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
                if(cbServico.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Tipo de Serviço Invalido.");
                    return;
                }

                Matricula matricula = new Matricula(txtMatricula.getText());

                if(!matricula.isMatriculaValida()){
                    JOptionPane.showMessageDialog(null, "Matricula Invalida.");
                    return;
                }

                if(cbOficina.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Oficina Invalida.");
                    return;
                }

                Data dataInicio = null;
                try{
                    dataInicio = Data.parse(txtDataInicio.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Data de Inicio Invalida (dd/MM/yyyy).");
                    return;
                }

                Data dataFim = null;
                if(!txtDataFim.getText().equals("")){
                    try{
                        dataFim = Data.parse(txtDataFim.getText());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Data de Fim Invalida (dd/MM/yyyy).");
                        return;
                    }
                }

                if(dataFim != null){
                    if((dataInicio.getData().getTimeInMillis() - dataFim.getData().getTimeInMillis()) > 0){
                        System.out.println(dataInicio.getData().getTimeInMillis() - dataFim.getData().getTimeInMillis());
                        JOptionPane.showMessageDialog(null, "Data inicio tem de ser menor ou igual que data de fim.");
                        return;
                    }
                }

                Trabalho trabalho = new Trabalho(cbServico.getSelectedItem().toString(), matricula, cbOficina.getSelectedItem().toString(), dataInicio, dataFim);

                Trabalho t = Gestor.getGestor().getTrabalho(matricula);

                if(t == null){
                    JOptionPane.showMessageDialog(null, "Trabalho não existe.");
                    return;
                }

                Gestor.getGestor().atualizarTrabalho(trabalho);

                System.out.println(trabalho.toString());

                Gestor.getGestor().atualizaTabelaOficinas(table);
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
