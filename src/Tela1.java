
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

public class Tela1 extends Fundo{

    JTextField loginField = new JTextField();

    JPasswordField txtSenha = new JPasswordField();

    JFrame tela1 = new JFrame();

    JButton botaoLogin = new JButton();

    JLabel labelFundo = new JLabel(fundo);

    JButton resetButton = new JButton();

    JLabel messageLabel = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    Tela1(){

/*
        JTextField loginField = new JTextField();

        JPasswordField txtSenha = new JPasswordField();

        JFrame tela1 = new JFrame();

        JButton botaoLogin = new JButton();

        JLabel labelFundo = new JLabel(fundo);

        JButton resetButton = new JButton();

        JLabel messageLabel = new JLabel(); */

        /*_______________Labels_______________*/


        JLabel label1 = new JLabel();

        labelFundo.setLayout(new FlowLayout());
        labelFundo.add(label1);
        labelFundo.add(loginField);
        labelFundo.add(txtSenha);

        label1.setText("MovieTime");
        label1.setSize(200,35);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV Boli", Font.BOLD, 36));
        label1.setIconTextGap(-25);
        label1.setForeground(Color.white);
        label1.setOpaque(false);


        /*_______________TextFields_______________*/


        loginField.setVisible(true);
        loginField.setName("Usuário:");
        loginField.setBackground(Color.white);
        loginField.setPreferredSize(new Dimension(250,50));
        loginField.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));


        txtSenha.setVisible(true);
        txtSenha.setName("Senha:");
        txtSenha.setBackground(Color.white);
        txtSenha.setPreferredSize(new Dimension(250,50));
        txtSenha.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));

        botaoLogin.setPreferredSize(new Dimension(250,50));
        botaoLogin.setVisible(true);
        botaoLogin.setOpaque(false);
        botaoLogin.setText("Login");
        botaoLogin.setForeground(Color.white);
        botaoLogin.setBackground(Color.darkGray);

        labelFundo.add(botaoLogin);


        /*_______________Buttons_______________*/


        resetButton.setPreferredSize(new Dimension(250,50));
        resetButton.setVisible(true);
        resetButton.setOpaque(false);
        resetButton.setText("Reset");
        resetButton.addActionListener((ActionListener) this);


        botaoLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==resetButton) {
                    loginField.setText("");
                    txtSenha.setText("");
                }

                if(e.getSource()==botaoLogin) {

                    String userID = loginField.getText();
                    String password = String.valueOf(txtSenha.getPassword());

                    if(logininfo.containsKey(userID)) {
                        if(logininfo.get(userID).equals(password)) {
                            messageLabel.setForeground(Color.green);
                            messageLabel.setText("Login Confirmado!");
                            Tela2 tela2 = new Tela2(userID);
                        }
                        else {
                            messageLabel.setForeground(Color.red);
                            messageLabel.setText("Senha Incorreta!");
                        }

                    }
                    else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("username not found");
                    }
                }

            }//fim do action perform
        });


        /*_______________TelaLogin_______________*/

        tela1.setVisible(true);
        tela1.setLocationRelativeTo(null);
        tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela1.setResizable(false);
        tela1.setSize(360,450);
        tela1.setTitle("MovieTime");
        tela1.setLayout(new GridLayout());
        tela1.add(resetButton);
        tela1.add(labelFundo);

    }


}
