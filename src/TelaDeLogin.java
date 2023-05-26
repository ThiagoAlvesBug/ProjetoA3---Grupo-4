import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class TelaDeLogin {

    /*_______________Criação_______________*/

    JFrame telaDeLogin = new JFrame();
    JTextField txtLogin = new JTextField();
    JPasswordField txtSenha = new JPasswordField();
    JButton botaoLogin = new JButton();
    JLabel labelFundo = new JLabel(Fundo.fundo);
    JButton botaoReset = new JButton();
    JLabel messageLabel = new JLabel();
    JLabel labelTitulo = new JLabel();
    JLabel labelLogin = new JLabel();
    JLabel labelSenha = new JLabel();
    HashMap<String,String> loginInfo = new HashMap<String,String>();

        TelaDeLogin(){}


    public TelaDeLogin(HashMap<String,String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        /*_______________Título_______________*/

        labelTitulo.setVisible(true);
        labelTitulo.setOpaque(false);
        labelTitulo.setFont(new Font("Colibri",Font.BOLD,36));
        labelTitulo.setVerticalTextPosition(JLabel.BOTTOM);
        labelTitulo.setHorizontalTextPosition(JLabel.CENTER);
        labelTitulo.setVerticalAlignment(JLabel.CENTER);
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        labelTitulo.setText(" Fazer Login:");
        labelTitulo.setSize(1280,100);
        labelTitulo.setForeground(Color.white);

        messageLabel.setBounds(500,500,300,40);
        messageLabel.setFont(new Font("MV Boli",Font.ITALIC,26));


        /*_______________Login_______________*/


        txtLogin.setVisible(true);
        txtLogin.setName("Usuário:");
        txtLogin.setBackground(Color.white);
        txtLogin.setBounds(520,250,250,50);
        txtLogin.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));

        labelLogin.setVisible(true);
        labelLogin.setText("Login:");
        labelLogin.setForeground(Color.white);
        labelLogin.setFont(new Font("Consolas", Font.BOLD,20));
        labelLogin.setOpaque(false);
        labelLogin.setBounds(440,255,100,40);

        /*_______________Senha_______________*/

        txtSenha.setVisible(true);
        txtSenha.setName("Senha:");
        txtSenha.setBackground(Color.white);
        txtSenha.setBounds(520,310,250,50);
        txtSenha.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));

        labelSenha.setVisible(true);
        labelSenha.setText("Senha:");
        labelSenha.setForeground(Color.white);
        labelSenha.setFont(new Font("Consolas", Font.BOLD,20));
        labelSenha.setOpaque(false);
        labelSenha.setBounds(440,315,100,40);

        /*_______________Botões_______________*/

        botaoLogin.setBounds(520,370,250,50);
        botaoLogin.setVisible(true);
        botaoLogin.setOpaque(false);
        botaoLogin.setText("Login");
        botaoLogin.setForeground(Color.white);
        botaoLogin.setBackground(Color.darkGray);
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==botaoLogin) {

                    String userID = txtLogin.getText();
                    String password = String.valueOf(txtSenha.getPassword());

                    if(loginInfo.containsKey(userID)) {
                        if(loginInfo.get(userID).equals(password)) {
                            messageLabel.setForeground(Color.green);
                            messageLabel.setText("Login Confirmado!");
                            telaDeLogin.dispose();
                            new Tela2(userID);
                        }
                        else {
                            messageLabel.setForeground(Color.white);
                            messageLabel.setText("   Senha Incorreta!");
                        }

                    }
                    else {
                        messageLabel.setForeground(Color.white);
                        messageLabel.setText("Usuário não encontrado");
                    }
                }

            }//fim do action perform
        });


        botaoReset.setBounds(520,430,250,50);
        botaoReset.setVisible(true);
        botaoReset.setOpaque(false);
        botaoReset.setText("Reset");
        botaoReset.setForeground(Color.white);
        botaoReset.setBackground(Color.darkGray);
        botaoReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==botaoReset) {
                    txtLogin.setText("");
                    txtSenha.setText("");
                }
            }
        });


        /*_______________TelaLogin_______________*/

        telaDeLogin.setVisible(true);
        telaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaDeLogin.setResizable(false);
        telaDeLogin.setSize(1280,720);
        telaDeLogin.setTitle("MovieTime");
        telaDeLogin.add(txtLogin);
        telaDeLogin.add(txtSenha);
        telaDeLogin.add(labelLogin);
        telaDeLogin.add(labelSenha);
        telaDeLogin.add(messageLabel);
        telaDeLogin.add(botaoLogin);
        telaDeLogin.add(botaoReset);
        telaDeLogin.add(labelTitulo);
        telaDeLogin.add(labelFundo);



    }
}