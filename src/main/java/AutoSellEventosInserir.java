import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AutoSellEventosInserir extends JFrame{
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JList listaVeiculosDisp;
    private JList listaVeiculosEvento;
    private JButton adicionarVeiculoButton;
    private JButton removerVeiculoButton;
    private JPanel painelEventosInserir;

    public AutoSellEventosInserir() {

        String[] veiculosDisponiveis = {"04-ER-22","50-35-LI","65-RD-15","52-23-FT", "01-XS-87"};

        DefaultListModel<String> modelVeiculosDisponiveis = new DefaultListModel<>();

        for (String item : veiculosDisponiveis) {
            modelVeiculosDisponiveis.addElement(item);
        }
        listaVeiculosDisp.setModel(modelVeiculosDisponiveis);

        DefaultListModel<String> modelVeiculosEvento = new DefaultListModel<>();

        listaVeiculosEvento.setModel(modelVeiculosEvento);

        setTitle("Inserir Evento");
        setContentPane(painelEventosInserir);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


        adicionarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selected = listaVeiculosDisp.getSelectedValuesList();
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
