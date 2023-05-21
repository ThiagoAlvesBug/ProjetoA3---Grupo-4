import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastro extends Fundo {

    //Nome
    //Idade
    //Sexo
    //Gêneros de Filme preferidos (até 2)

    /*_______________Criação_______________*/

    JFrame telaCadastro = new JFrame();
    JTextField nome2 = new JTextField();
    JLabel labelNome2 = new JLabel();
    JTextField idade2 = new JTextField();
    JLabel labelIdade2 = new JLabel();
    JLabel labelS = new JLabel();
    JTextField sexoT = new JTextField();
    JTextField genero2 = new JTextField();
    JLabel labelGenero2 = new JLabel();
    JLabel fundoTC = new JLabel(fundo);
    JLabel label5 = new JLabel();
    JButton botaoConfirmar2 = new JButton();

    TelaCadastro(){

        /*_______________Nome_______________*/

        labelNome2.setVisible(true);
        labelNome2.setText("Nome:");
        labelNome2.setForeground(Color.white);
        labelNome2.setFont(new Font("Consolas", Font.BOLD,20));
        labelNome2.setOpaque(false);
        labelNome2.setBounds(450,260,100,40);

        nome2.setVisible(true);
        nome2.setName("Nome:");
        nome2.setFont(new Font("Consolas", Font.BOLD, 16));
        nome2.setBounds(520,250,250,50);

        /*_______________Idade_______________*/

        labelIdade2.setVisible(true);
        labelIdade2.setText(" Idade:");
        labelIdade2.setForeground(Color.white);
        labelIdade2.setFont(new Font("Consolas", Font.BOLD,20));
        labelIdade2.setOpaque(false);
        labelIdade2.setBounds(420,320,100,40);

        idade2.setVisible(true);
        idade2.setName("Idade:");
        idade2.setFont(new Font("Consolas", Font.BOLD, 16));
        idade2.setBounds(520,310,250,50);

        /*_______________Sexo_______________*/

        labelS.setVisible(true);
        labelS.setText("Sexo:");
        labelS.setForeground(Color.white);
        labelS.setFont(new Font("Consolas", Font.BOLD,20));
        labelS.setOpaque(false);
        labelS.setBounds(440,380,100,40);

        sexoT.setVisible(true);
        sexoT.setName("Sexo:");
        sexoT.setFont(new Font("Consolas", Font.BOLD, 16));
        sexoT.setBounds(520,370,250,50);

        /*_______________Gênero_______________*/

        labelGenero2.setVisible(true);
        labelGenero2.setText("Gêneros favoritos:");
        labelGenero2.setForeground(Color.white);
        labelGenero2.setFont(new Font("Consolas", Font.BOLD,20));
        labelGenero2.setOpaque(false);
        labelGenero2.setBounds(300,440,220,40);

        genero2.setVisible(true);
        genero2.setName("Sexo:");
        genero2.setFont(new Font("Consolas", Font.BOLD, 16));
        genero2.setBounds(520,430,250,50);

        /*_______________Título_______________*/

        label5.setVisible(true);
        label5.setOpaque(false);
        label5.setFont(new Font("Colibri",Font.BOLD,36));
        label5.setVerticalTextPosition(JLabel.TOP);
        label5.setHorizontalTextPosition(JLabel.CENTER);
        label5.setVerticalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setText("Cadastro:");
        label5.setSize(1280,100);
        label5.setForeground(Color.white);

        /*_______________Botão_______________*/

        botaoConfirmar2.setVisible(true);
        botaoConfirmar2.setOpaque(false);
        botaoConfirmar2.setBackground(Color.black);
        botaoConfirmar2.setText("Confirmar");
        botaoConfirmar2.setForeground(Color.white);
        botaoConfirmar2.setFont(new Font("Consolas",Font.BOLD, 36));
        botaoConfirmar2.setBounds(520,500,250,50);

        botaoConfirmar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastro.dispose();

            }
        });

        /*_______________Tela_______________*/

        telaCadastro.setVisible(true);
        telaCadastro.setResizable(false);
        telaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCadastro.setSize(1280, 720);
        telaCadastro.add(nome2);
        telaCadastro.add(idade2);
        telaCadastro.add(genero2);
        telaCadastro.add(sexoT);
        telaCadastro.add(labelNome2);
        telaCadastro.add(labelIdade2);
        telaCadastro.add(labelGenero2);
        telaCadastro.add(labelS);
        telaCadastro.add(botaoConfirmar2);
        telaCadastro.add(fundoTC);

    }

}
