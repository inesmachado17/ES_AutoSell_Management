import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AutoSellEventosEditar extends JFrame{
    private JTextField txtNome;
    private JTextField txtLocal;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JList listaVeiculosDisponiveis;
    private JList listaVeiculosEvento;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JButton adicionarVeiculoButton;
    private JButton removerVeiculoButton;
    private JPanel painelEventosEditar;

    public AutoSellEventosEditar(JTable table){

        txtNome.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        txtLocal.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        txtDataInicio.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        txtDataFim.setText(table.getValueAt(table.getSelectedRow(), 3).toString());

        String[] veiculosDisponiveis;
        String[] veiculosEvento;
        DefaultListModel<String> modelVeiculosEvento = new DefaultListModel<>();
        DefaultListModel<String> modelVeiculosDisponiveis = new DefaultListModel<>();

        if(table.getValueAt(table.getSelectedRow(), 0).toString().equals("Feira de Maio de Leiria")){

            veiculosDisponiveis = new String[] {"65-RD-15","52-23-FT", "01-XS-87"};



            for (String item : veiculosDisponiveis) {
                modelVeiculosDisponiveis.addElement(item);
            }
            listaVeiculosDisponiveis.setModel(modelVeiculosDisponiveis);

            veiculosEvento = new String[]{"04-ER-22","50-35-LI"};


            for (String item : veiculosEvento) {
                modelVeiculosEvento.addElement(item);
            }
            listaVeiculosEvento.setModel(modelVeiculosEvento);

        }else{
            veiculosDisponiveis = new String[] {"04-ER-22","50-35-LI"};

            for (String item : veiculosDisponiveis) {
                modelVeiculosDisponiveis.addElement(item);
            }
            listaVeiculosDisponiveis.setModel(modelVeiculosDisponiveis);

            veiculosEvento = new String[]{"65-RD-15","52-23-FT", "01-XS-87"};


            for (String item : veiculosEvento) {
                modelVeiculosEvento.addElement(item);
            }
            listaVeiculosEvento.setModel(modelVeiculosEvento);
        }

        setTitle("Editar Evento");
        setContentPane(painelEventosEditar);
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
        adicionarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selected = listaVeiculosDisponiveis.getSelectedValuesList();
                for (String item : selected) {
                    modelVeiculosDisponiveis.removeElement(item);
                    modelVeiculosEvento.addElement(item);
                }
            }
        });
        removerVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selected = listaVeiculosEvento.getSelectedValuesList();
                for (String item : selected) {
                    modelVeiculosEvento.removeElement(item);
                    modelVeiculosDisponiveis.addElement(item);
                }
            }
        });
    }
}
