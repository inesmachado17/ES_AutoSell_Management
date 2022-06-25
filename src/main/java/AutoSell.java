import Model.Gestor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoSell extends JFrame{

    private JTextField adminTextField;
    private JButton OKButton;
    private JButton cancelarButton;
    private JPanel panel1;
    private JPasswordField adminPasswordField;
    private static JFrame loginFrame;

    public AutoSell() {

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("login");
                //loginFrame.setVisible(false);

                AutoSellMainWindow mainWindow = new AutoSellMainWindow();

            }
        });

        Gestor gestor = Gestor.getGestor();
    }

    public static void main(String[] args) {
        loginFrame = new JFrame("Login");
        loginFrame.setContentPane(new AutoSell().panel1);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

    }
}
