import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCadastroUsuario extends Fundo {


    /*_______________Criação_______________*/

    JFrame telaCadastroUsuario = new JFrame();
    JTextField nome2 = new JTextField();
    JLabel labelNome2 = new JLabel();
    JTextField idade2 = new JTextField();
    JLabel labelIdade2 = new JLabel();
    JTextField sexoTxt = new JTextField();
    JLabel labelSexo = new JLabel();
    JTextField genero1 = new JTextField();
    JLabel labelGenero1 = new JLabel();
    JTextField genero2 = new JTextField();
    JLabel labelGenero2 = new JLabel();
    JPasswordField txtSenha = new JPasswordField();
    JLabel labelSenha = new JLabel();
    JLabel fundoTC = new JLabel(fundo);
    JLabel label5 = new JLabel();
    JButton botaoConfirmar2 = new JButton();
    JButton botaoVoltar = new JButton();
    JComboBox<String> sexoBox = new JComboBox<String>();
    JComboBox generoFav1 = new JComboBox();
    JComboBox generoFav2 = new JComboBox();
    JComboBox<Integer> idadeBox = new JComboBox<Integer>();

    TelaCadastroUsuario(JFrame frameVoltar){

        /*_______________Nome_______________*/

        labelNome2.setVisible(true);
        labelNome2.setText("Nome");
        labelNome2.setForeground(Color.white);
        labelNome2.setFont(new Font("Consolas", Font.BOLD,20));
        labelNome2.setOpaque(false);
        labelNome2.setBounds(300,100,100,40);

        nome2.setVisible(true);
        nome2.setName("Nome:");
        nome2.setFont(new Font("Consolas", Font.BOLD, 16));
        nome2.setBounds(300,130,250,50);

        /*_______________Idade_______________*/

        labelSenha.setVisible(true);
        labelSenha.setText("Senha");
        labelSenha.setForeground(Color.white);
        labelSenha.setFont(new Font("Consolas", Font.BOLD,20));
        labelSenha.setOpaque(false);
        labelSenha.setBounds(715,100,100,40);

        idadeBox.setVisible(true);
        idadeBox.setName("Idade");
        idadeBox.setBounds(715,370,250,50);

        int idade;

        for (idade = 1; idade<=100; idade++){
            idadeBox.addItem(idade);
        }
        /*_______________Sexo_______________*/

        labelSexo.setVisible(true);
        labelSexo.setText("Sexo");
        labelSexo.setForeground(Color.white);
        labelSexo.setFont(new Font("Consolas", Font.BOLD,20));
        labelSexo.setOpaque(false);
        labelSexo.setBounds(300,340,220,40);

        sexoBox.setVisible(true);
        sexoBox.addItem("Masculino");
        sexoBox.addItem("Feminino");
        sexoBox.addItem("Outro");
        sexoBox.setBounds(300,370,250,50);


        /*_______________Gênero1_______________*/

        labelGenero1.setVisible(true);
        labelGenero1.setText("Gênero favorito 1");
        labelGenero1.setForeground(Color.white);
        labelGenero1.setFont(new Font("Consolas", Font.BOLD,20));
        labelGenero1.setOpaque(false);
        labelGenero1.setBounds(300,220,220,40);

        generoFav1.setVisible(true);
        generoFav1.setName("Genero");
        generoFav1.addItem("Selecione...");
        generoFav1.addItem("Ação");
        generoFav1.addItem("Aventura");
        generoFav1.addItem("Biográfico");
        generoFav1.addItem("Comédia");
        generoFav1.addItem("Comédia Romântica");
        generoFav1.addItem("Histórico");
        generoFav1.addItem("Drama");
        generoFav1.addItem("Fantasia");
        generoFav1.addItem("Ficção-Científica");
        generoFav1.addItem("Musical");
        generoFav1.addItem("Romance");
        generoFav1.addItem("Terror");
        generoFav1.addItem("Suspense");
        generoFav1.setBounds(300,250,250,50);

        /*_______________Gênero2_______________*/

        labelGenero2.setVisible(true);
        labelGenero2.setText("Gênero favorito 2");
        labelGenero2.setForeground(Color.white);
        labelGenero2.setFont(new Font("Consolas", Font.BOLD,20));
        labelGenero2.setOpaque(false);
        labelGenero2.setBounds(715,220,220,40);

        generoFav2.setVisible(true);
        generoFav2.setName("Genero");
        generoFav2.addItem("Selecione...");
        generoFav2.addItem("");
        generoFav2.addItem("Ação");
        generoFav2.addItem("Aventura");
        generoFav2.addItem("Biográfico");
        generoFav2.addItem("Comédia");
        generoFav2.addItem("Comédia Romântica");
        generoFav2.addItem("Histórico");
        generoFav2.addItem("Drama");
        generoFav2.addItem("Fantasia");
        generoFav2.addItem("Ficção-Científica");
        generoFav2.addItem("Musical");
        generoFav2.addItem("Romance");
        generoFav2.addItem("Terror");
        generoFav2.addItem("Suspense");
        generoFav2.setBounds(715,250,250,50);

        /*_______________Senha_______________*/

        labelIdade2.setVisible(true);
        labelIdade2.setText("Idade");
        labelIdade2.setForeground(Color.white);
        labelIdade2.setFont(new Font("Consolas", Font.BOLD,20));
        labelIdade2.setOpaque(false);
        labelIdade2.setBounds(715,340,220,40);

        txtSenha.setVisible(true);
        txtSenha.setName("Senha");
        txtSenha.setFont(new Font("Consolas", Font.BOLD, 16));
        txtSenha.setBounds(715,130,250,50);

        /*_______________Título_______________*/

        label5.setVisible(true);
        label5.setOpaque(false);
        label5.setFont(new Font("Colibri",Font.BOLD,36));
        label5.setVerticalTextPosition(JLabel.BOTTOM);
        label5.setHorizontalTextPosition(JLabel.CENTER);
        label5.setVerticalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setText("Nova conta");
        label5.setSize(1280,100);
        label5.setForeground(Color.white);

        /*_______________Botão_______________*/

        botaoVoltar.setVisible(true);
        botaoVoltar.setBackground(Color.darkGray);
        botaoVoltar.setText("<");
        botaoVoltar.setForeground(Color.white);
        botaoVoltar.setFont(new Font("Consolas",Font.BOLD, 20));
        botaoVoltar.setBounds(10,10,50,50);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVoltar.setVisible(true);
                telaCadastroUsuario.dispose();
            }
        });


        botaoConfirmar2.setVisible(true);
        botaoConfirmar2.setOpaque(false);
        botaoConfirmar2.setBackground(Color.black);
        botaoConfirmar2.setText("Criar conta");
        botaoConfirmar2.setForeground(Color.white);
        botaoConfirmar2.setFont(new Font("Consolas", Font.BOLD,20));
        botaoConfirmar2.setBounds(505,470,250,50);

        botaoConfirmar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCadastro = nome2.getText();
                int idade  = (int) idadeBox.getSelectedItem();
                String generoFavorito1 = (String) generoFav1.getSelectedItem();
                String generoFavorito2 = (String) generoFav2.getSelectedItem();
                String senha = txtSenha.getText();
                String sexo = (String) sexoBox.getSelectedItem();

                boolean generoEhValido = generoFavorito1.equals("Selecione...") == false;

                if(generoEhValido == false){
                    JOptionPane.showMessageDialog(null, "Esse não é um Gênero válido");
                    return;
                }

                boolean generoEhValido2 = generoFavorito2.equals("Selecione...") == false;

                if(generoEhValido == false){
                    JOptionPane.showMessageDialog(null, "Esse não é um Gênero válido");
                    return;
                }

                User usuario = new User();
                usuario.setNome(nomeCadastro);
                usuario.setIdade(idade);
                usuario.setGenero1(generoFavorito1);
                usuario.setGenero2(generoFavorito2);
                usuario.setSexo(sexo);
                usuario.setSenha(senha);

                ConexaoBD conexaoBD = new ConexaoBD();

                boolean cadastrou = conexaoBD.cadastrarUsuario(usuario);

                if(cadastrou){
                    JOptionPane.showMessageDialog(null,"Cadastro ralizado com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro.");
                }

                //telaCadastroUsuario.dispose();

            }
        });

        /*_______________Tela_______________*/

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX  = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;

        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        telaCadastroUsuario.setIconImage(icon.getImage());
        telaCadastroUsuario.setVisible(true);
        telaCadastroUsuario.setResizable(false);
        telaCadastroUsuario.setTitle("MovieTime!");
        telaCadastroUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCadastroUsuario.setSize(formWidth, formHeight);
        telaCadastroUsuario.setLocation(formX,formY);
        telaCadastroUsuario.add(nome2);
        telaCadastroUsuario.add(idadeBox);
        telaCadastroUsuario.add(generoFav1);
        telaCadastroUsuario.add(generoFav2);
        telaCadastroUsuario.add(sexoBox);
        telaCadastroUsuario.add(txtSenha);
        telaCadastroUsuario.add(labelNome2);
        telaCadastroUsuario.add(labelIdade2);
        telaCadastroUsuario.add(labelGenero1);
        telaCadastroUsuario.add(labelGenero2);
        telaCadastroUsuario.add(labelSexo);
        telaCadastroUsuario.add(labelSenha);
        telaCadastroUsuario.add(label5);
        telaCadastroUsuario.add(botaoConfirmar2);
        telaCadastroUsuario.add(botaoVoltar);
        telaCadastroUsuario.add(fundoTC);

    }

}
