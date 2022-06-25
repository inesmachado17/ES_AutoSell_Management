import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSellOficinasInserir extends JDialog {

    private JFrame parent;
    private JTextField txtMatricula;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox cbOficina;
    private JPanel painelOficinasInserir;
    private JComboBox cbTipoServico;

    public AutoSellOficinasInserir(JFrame frame, JTable tabelaTrabalhos) {
        this.parent = frame;

        //String[] transacoes = {"Lisboa","Coimbra","Leiria","Porto"};
        String[] oficinas = Gestor.getGestor().getOficinas();

        final DefaultComboBoxModel model = new DefaultComboBoxModel(oficinas);
        cbOficina.setModel(model);

        //String[] tipos = {"Manutenção","Preparação"};
        String[] tipos = Gestor.getGestor().getTiposServico();

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

                if(cbTipoServico.getSelectedItem().toString().equals("")){
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
                try{
                    dataFim = Data.parse(txtDataFim.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Data de Fim Invalida (dd/MM/yyyy).");
                    return;
                }

                if((dataInicio.getData().getTimeInMillis() - dataFim.getData().getTimeInMillis()) > 0){
                    System.out.println(dataInicio.getData().getTimeInMillis() - dataFim.getData().getTimeInMillis());
                    JOptionPane.showMessageDialog(null, "Data inicio tem de ser menor ou igual que data de fim.");
                    return;
                }

                Trabalho trabalho = new Trabalho(cbTipoServico.getSelectedItem().toString(), matricula, cbOficina.getSelectedItem().toString(), dataInicio, dataFim);

                Trabalho t = Gestor.getGestor().getTrabalho(matricula);

                if(t != null){
                    JOptionPane.showMessageDialog(null, "Trabalho criado anteriormente.");
                    return;
                }

                Gestor.getGestor().inserirTrabalho(trabalho);

                System.out.println(trabalho.toString());

                Gestor.getGestor().atualizaTabelaOficinas(tabelaTrabalhos);
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
