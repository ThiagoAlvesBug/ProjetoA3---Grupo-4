import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Main extends Fundo{


    public static void main(String[] args) {


        IDeSenha idandPasswords = new IDeSenha();

        TelaDeLogin loginPage = new TelaDeLogin(IDeSenha.getLoginInfo());

        JFrame tela1 = new JFrame();

        JButton botaoLogin = new JButton();

        JLabel labelFundo = new JLabel(fundo);

        JButton botaoCadastro = new JButton();

        JLabel label1 = new JLabel();


                /*_______________Labels_______________*/


                labelFundo.setLayout(new GridLayout());


                label1.setText("MovieTime");
                label1.setBounds(505,150,350,100);
                label1.setHorizontalTextPosition(JLabel.CENTER);
                label1.setVerticalTextPosition(JLabel.TOP);
                label1.setForeground(Color.white);
                label1.setFont(new Font("MV Boli", Font.BOLD, 48));
                label1.setIconTextGap(-25);
                label1.setForeground(Color.white);
                label1.setOpaque(false);


                /*_______________Buttons_______________*/

            
                botaoLogin.setBounds(385,300,500,100);
                botaoLogin.setVisible(true);
                botaoLogin.setOpaque(false);
                botaoLogin.setText("Fazer Login");
                botaoLogin.setForeground(Color.white);
                botaoLogin.setBackground(Color.darkGray);


                botaoCadastro.setBounds(385,420,500,100);
                botaoCadastro.setVisible(true);
                botaoCadastro.setOpaque(false);
                botaoCadastro.setText("Fazer Cadastro");
                botaoCadastro.setForeground(Color.white);
                botaoCadastro.setBackground(Color.darkGray);


                tela1.setVisible(true);
                tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tela1.setResizable(false);
                tela1.setSize(1280,720);
                tela1.setTitle("MovieTime");
                tela1.add(botaoCadastro);
                tela1.add(botaoLogin);
                tela1.add(label1);
                tela1.add(labelFundo);
                botaoCadastro.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new TelaCadastro();
                        tela1.setVisible(false);
                    }
                });


                botaoLogin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TelaDeLogin telaDeLogin = new TelaDeLogin();
                        tela1.dispose();
                    }
                });

    }
}