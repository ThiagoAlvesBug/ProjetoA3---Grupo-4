import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormCadastroFilme extends Fundo{


    /*_______________Criar_______________*/

    DefaultTableModel model;
    JFrame frameCadastroFilme = new JFrame();
    JTextField txtNome = new JTextField();
    JLabel labelNome = new JLabel();
    JTextField txtAno = new JTextField();
    JLabel labelAno = new JLabel();
    JLabel labelGenero = new JLabel();
    JLabel labelNota = new JLabel();
    JLabel fundoT3 = new JLabel(fundo);
    JLabel label4 = new JLabel();
    JButton botaoVoltar = new JButton();
    JButton btnVoltar = new JButton();
    JButton botaoAdicionar = new JButton();
    JButton botaoSair = new JButton();
    JComboBox generoBox = new JComboBox();
    JComboBox notaBox = new JComboBox();


   public FormCadastroFilme(){


        /*_______________Sobre_O_Filme_______________*/

        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Ano");
        model.addColumn("Gênero");
        model.addColumn("Nota");


       /*_______________Nome_______________*/

        labelNome.setVisible(true);
        labelNome.setText("Nome:");
        labelNome.setForeground(Color.white);
        labelNome.setFont(new Font("Consolas", Font.BOLD,20));
        labelNome.setOpaque(false);
        labelNome.setBounds(450,260,100,40);

        txtNome.setVisible(true);
        txtNome.setName("Nome:");
        txtNome.setBounds(520,250,250,50);


       /*_______________Ano_______________*/

        labelAno.setVisible(true);
        labelAno.setText(" Ano:");
        labelAno.setForeground(Color.white);
        labelAno.setFont(new Font("Consolas", Font.BOLD,20));
        labelAno.setOpaque(false);
        labelAno.setBounds(450,320,100,40);

        txtAno.setVisible(true);
        txtAno.setName("Ano:");
        txtAno.setBounds(520,310,250,50);


       /*_______________Gênero_______________*/

        labelGenero.setVisible(true);
        labelGenero.setText("Genero:");
        labelGenero.setForeground(Color.white);
        labelGenero.setFont(new Font("Consolas", Font.BOLD,20));
        labelGenero.setOpaque(false);
        labelGenero.setBounds(430,380,100,40);

        generoBox.setVisible(true);
        generoBox.setName("Genero:");
        generoBox.addItem("Selecione...");
        generoBox.addItem("Ação");
        generoBox.addItem("Aventura");
        generoBox.addItem("Biográfico");
        generoBox.addItem("Comédia");
        generoBox.addItem("Comédia Romântica");
        generoBox.addItem("Histórico");
        generoBox.addItem("Drama");
        generoBox.addItem("Fantasia");
        generoBox.addItem("Ficção-Científica");
        generoBox.addItem("Musical");
        generoBox.addItem("Romance");
        generoBox.addItem("Terror");
        generoBox.addItem("Suspense");

        generoBox.setBounds(520,370,250,50);


       /*_______________Nota_______________*/

        labelNota.setVisible(true);
        labelNota.setText("Nota:");
        labelNota.setForeground(Color.white);
        labelNota.setFont(new Font("Consolas", Font.BOLD,20));
        labelNota.setOpaque(false);
        labelNota.setBounds(450,440,100,40);

        notaBox.setVisible(true);
        notaBox.setName("Nota");
        notaBox.addItem("Selecione...");
        notaBox.setBounds(520,430,250,50);

        int nota;

        for (nota = 1; nota<=10; nota++){
            notaBox.addItem(nota);
        }


        /*_______________Botões_______________*/

        btnVoltar.setVisible(true);
        btnVoltar.setOpaque(false);
        btnVoltar.setBackground(Color.black);
        btnVoltar.setText("Voltar");
        btnVoltar.setForeground(Color.white);
        btnVoltar.setFont(new Font("Consolas",Font.BOLD, 36));
        btnVoltar.setBounds(520,575,250,50);

        botaoAdicionar.setVisible(true);
        botaoAdicionar.setOpaque(false);
        botaoAdicionar.setBackground(Color.black);
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setForeground(Color.white);
        botaoAdicionar.setFont(new Font("Consolas",Font.BOLD, 36));
        botaoAdicionar.setBounds(520,500,250,50);

        botaoSair.setVisible(true);
        botaoSair.setOpaque(false);
        botaoSair.setBackground(Color.black);
        botaoSair.setText("Sair");
        botaoSair.setForeground(Color.white);
        botaoSair.setFont(new Font("Consolas",Font.BOLD, 36));
        botaoSair.setBounds(950,575,150,50);

       /*_______________BotãoADD_______________*/

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean generoEhValido = generoBox.getSelectedItem().toString().equals("Selecione...") == false;

                if (generoEhValido == false){

                    JOptionPane.showMessageDialog(null, "Selecione um gênero válido.");

                    return;
                }

                boolean notaEhValida = notaBox.getSelectedItem().toString().equals("Selecione...") == false;

                if (notaEhValida == false){

                    JOptionPane.showMessageDialog(null, "Selecione uma nota válida.");

                    return;
                }
                String nome = txtNome.getText();
                int ano = Integer.parseInt(txtAno.getText());
                String genero = generoBox.getSelectedItem().toString();
                int nota = Integer.parseInt(notaBox.getSelectedItem().toString());

                txtNome.setText("");
                txtAno.setText("");
                generoBox.setSelectedItem("Selecione...");
                notaBox.setSelectedItem("Selecione...");

                int idUsuario = Sessao.usuarioLogado.getId();

                /*_____________CriandoFilme_____________*/

                Filme filme = new Filme();
                filme.setIdUsuario(idUsuario);
                filme.setNome(nome);
                filme.setAno(ano);
                filme.setGenero(genero);
                filme.setNota(nota);

                /*____________EnviandoProBanco____________*/

                ConexaoBD conexaoBD = new ConexaoBD();

                boolean adicionou = conexaoBD.adicionarFilme(filme);

                if(adicionou){
                    JOptionPane.showMessageDialog(null,"Cadastro de filme ralizado com sucesso!");
                    frameCadastroFilme.dispose();
                    new FormListaFilme();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar o filme.");
                }

            }
        });

       /*_______________VerLista_______________*/

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frameCadastroFilme.dispose();
                    new FormListaFilme();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormLogin();
                frameCadastroFilme.hide();
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

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX  = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;

        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        frameCadastroFilme.setIconImage(icon.getImage());
        frameCadastroFilme.setTitle("MovieTime!");
        frameCadastroFilme.setVisible(true);
        frameCadastroFilme.setResizable(false);
        frameCadastroFilme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCadastroFilme.setSize(formWidth, formHeight);
        frameCadastroFilme.setLocation(formX,formY);
        frameCadastroFilme.add(txtNome);
        frameCadastroFilme.add(txtAno);
        frameCadastroFilme.add(generoBox);
        frameCadastroFilme.add(notaBox);
        frameCadastroFilme.add(labelNome);
        frameCadastroFilme.add(labelAno);
        frameCadastroFilme.add(labelGenero);
        frameCadastroFilme.add(labelNota);
        frameCadastroFilme.add(botaoVoltar);
        frameCadastroFilme.add(btnVoltar);
        frameCadastroFilme.add(botaoAdicionar);
        frameCadastroFilme.add(botaoSair);
        frameCadastroFilme.add(label4);
        frameCadastroFilme.add(fundoT3);

    }
}
