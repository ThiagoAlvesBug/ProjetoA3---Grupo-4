import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tela1 extends Tela2{

    public Tela1() {


        JLabel label2 = new JLabel();

        JTextField loginField = new JTextField();

        JPasswordField senha = new JPasswordField();

        JFrame tela1 = new JFrame();

        JButton botaoLogin = new JButton("Login");



        /*_______________Labels_______________*/



        label2.setVisible(true);
        label2.setLocation(1280,720);
        label2.setBounds(1280,720,1280,720);
        label2.setBackground(new Color(250,250,250));
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        label2.setText("Bem-vindo!");
        label2.setForeground(new Color(250,250,250));
        label2.setFont(new Font("MV Boli", Font.BOLD, 20));


        /*_______________TextFields_______________*/



        loginField.setSize(270,50);
        loginField.setVisible(true);
        loginField.setForeground(Color.white);
        loginField.setBackground(Color.white);
        loginField.setPreferredSize(new Dimension(250,50));
        //loginField.add(botaoLogin);
        loginField.setFont(new Font("Consolas", Font.BOLD, 20));


        senha.setSize(20,50);
        senha.setVisible(true);
        senha.setForeground(Color.white);
        senha.setBackground(Color.white);
        senha.setPreferredSize(new Dimension(250,50));
        senha.add(botaoLogin);
        senha.setFont(new Font("Consolas", Font.BOLD, 20));



        /*_______________Buttons_______________*/

        botaoLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==botaoLogin){
                    System.out.println("YOHOHOHO, welcome " + loginField.getText() + ".");
                    tela2.setVisible(true);
                    tela1.setVisible(false);

                }
            }
        });


        /*_______________Frames_______________*/

        /*_______________TelaLogin_______________*/

        tela1.setVisible(true);
        tela1.setLocationRelativeTo(null);
        tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela1.setResizable(true);
        tela1.setSize(1280,720);
        tela1.setTitle("App de Gerenciamento de Filmes");
        tela1.getContentPane().setBackground(new Color(0x44014F));
        tela1.setLayout(new FlowLayout());
        //tela1.add(label1);
        tela1.add(loginField);
        tela1.add(senha);
        tela1.add(botaoLogin);
        tela1.pack();

        /*_______________BemVindo_______________*/



        tela2.setLocationRelativeTo(null);
        tela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela2.setResizable(true);
        tela2.setSize(1280, 720);
        tela2.getContentPane().setBackground(new Color(0X44014F));
        tela2.add(label2);


    }


}
