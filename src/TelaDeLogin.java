import java.awt.*;
import javax.swing.*;

public class TelaDeLogin {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");

    TelaDeLogin(String userID){

        JButton continuar = new JButton();

        continuar.setVisible(true);
        continuar.setVisible(true);
        continuar.setOpaque(false);
        continuar.setBackground(Color.black);
        continuar.setText("Continuar");
        continuar.setForeground(Color.white);
        continuar.setFont(new Font("Consolas",Font.BOLD, 36));
        continuar.setBounds(520,500,250,50);

        welcomeLabel.setBounds(0,0,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Seja bem-vindo, "+userID);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}