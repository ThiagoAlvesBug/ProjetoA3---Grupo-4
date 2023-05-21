import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tela3 extends Fundo{

    /*_______________Criar_______________*/


    JFrame tela3 = new JFrame();
    JTextField txtNome = new JTextField();
    JLabel labelNome = new JLabel();
    JTextField txtAno = new JTextField();
    JLabel labelAno = new JLabel();
    JTextField txtGenero = new JTextField();
    JLabel labelGenero = new JLabel();
    JTextField txtNota = new JTextField();
    JLabel labelNota = new JLabel();
    JLabel fundoT3 = new JLabel(fundo);
    JLabel label4 = new JLabel();
    JButton botaoConfirmar = new JButton();
    JButton botaoAdicionar = new JButton();
    List<Filme> listaFilmes = new ArrayList<>();


    Tela3() {

        /*_______________Sobre_O_Filme_______________*/

        labelNome.setVisible(true);
        labelNome.setText("Nome:");
        labelNome.setForeground(Color.white);
        labelNome.setFont(new Font("Consolas", Font.BOLD,20));
        labelNome.setOpaque(false);
        labelNome.setBounds(450,260,100,40);

        txtNome.setVisible(true);
        txtNome.setName("Nome:");
        txtNome.setBounds(520,250,250,50);

        labelAno.setVisible(true);
        labelAno.setText(" Ano:");
        labelAno.setForeground(Color.white);
        labelAno.setFont(new Font("Consolas", Font.BOLD,20));
        labelAno.setOpaque(false);
        labelAno.setBounds(450,320,100,40);

        txtAno.setVisible(true);
        txtAno.setName("Ano:");
        txtAno.setBounds(520,310,250,50);

        labelGenero.setVisible(true);
        labelGenero.setText("Genero:");
        labelGenero.setForeground(Color.white);
        labelGenero.setFont(new Font("Consolas", Font.BOLD,20));
        labelGenero.setOpaque(false);
        labelGenero.setBounds(430,380,100,40);

        txtGenero.setVisible(true);
        txtGenero.setName("Genero:");
        txtGenero.setBounds(520,370,250,50);

        labelNota.setVisible(true);
        labelNota.setText("Nota:");
        labelNota.setForeground(Color.white);
        labelNota.setFont(new Font("Consolas", Font.BOLD,20));
        labelNota.setOpaque(false);
        labelNota.setBounds(450,440,100,40);
        
        txtNota.setVisible(true);
        txtNota.setName("Nota:");
        txtNota.setBounds(520,430,250,50);


        /*_______________Botão_______________*/


        botaoConfirmar.setVisible(true);
        botaoConfirmar.setOpaque(false);
        botaoConfirmar.setBackground(Color.black);
        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.setForeground(Color.white);
        botaoConfirmar.setFont(new Font("Consolas",Font.BOLD, 36));
        botaoConfirmar.setBounds(520,575,250,50);

        botaoAdicionar.setVisible(true);
        botaoAdicionar.setOpaque(false);
        botaoAdicionar.setBackground(Color.black);
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setForeground(Color.white);
        botaoAdicionar.setFont(new Font("Consolas",Font.BOLD, 36));
        botaoAdicionar.setBounds(520,500,250,50);

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Filme filme = new Filme();
                    filme.ano = Integer.parseInt(txtAno.getText());
                    filme.nome = txtNome.getText();
                    filme.genero = txtGenero.getText();
                    filme.nota = Integer.parseInt(txtNota.getText());

                    txtNome.setText("");
                    txtAno.setText("");
                    txtGenero.setText("");
                    txtNota.setText("");

                    listaFilmes.add(filme);

                    int quantidadeFilmes = listaFilmes.size();
                    JOptionPane.showMessageDialog(null, filme.nome + " Adicionado. Você tem " + quantidadeFilmes + " iten(s) na lista.");
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Os campos 'Ano' e 'Nota' só aceitam números.");

                }

            }
        });

        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    tela3.dispose();
                    new Tela4(listaFilmes);

            }
        });


        /*_______________Título_______________*/


        label4.setVisible(true);
        label4.setOpaque(false);
        label4.setFont(new Font("Colibri",Font.BOLD,36));
        label4.setVerticalTextPosition(JLabel.TOP);
        label4.setHorizontalTextPosition(JLabel.CENTER);
        label4.setVerticalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setText("Sobre o filme:");
        label4.setSize(1280,100);
        label4.setForeground(Color.white);


        /*_______________Tela_______________*/


        tela3.setVisible(true);
        tela3.setResizable(false);
        tela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela3.setSize(1280, 720);
        tela3.add(txtNome);
        tela3.add(txtAno);
        tela3.add(txtGenero);
        tela3.add(txtNota);
        tela3.add(labelNome);
        tela3.add(labelAno);
        tela3.add(labelGenero);
        tela3.add(labelNota);
        tela3.add(botaoConfirmar);
        tela3.add(botaoAdicionar);
        tela3.add(label4);
        tela3.add(fundoT3);






    }

}
