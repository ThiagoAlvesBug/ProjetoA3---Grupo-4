import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;

public class FormLogin{

    /*_______________Criação_______________*/

    JFrame frameLogin = new JFrame();
    JTextField txtLogin = new JTextField();
    JPasswordField txtSenha = new JPasswordField();
    JButton botaoLogin = new JButton();
    JLabel labelFundo = new JLabel(Fundo.fundo);
    JButton botaoReset = new JButton();
    JButton botaoVoltar = new JButton();
    JLabel messageLabel = new JLabel();
    JLabel labelTitulo = new JLabel();
    JLabel labelLogin = new JLabel();
    JLabel labelSenha = new JLabel();

        FormLogin(){}


    public FormLogin(JFrame frameVoltar) {

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

        messageLabel.setLocation(500,500);
        messageLabel.setFont(new Font("MV Boli",Font.ITALIC,26));


        /*_______________Login_______________*/


        txtLogin.setVisible(true);
        txtLogin.setName("Usuário:");
        txtLogin.setBackground(Color.white);
        txtLogin.setBounds(520,170,250,50);
        txtLogin.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));

        labelLogin.setVisible(true);
        labelLogin.setText("Login");
        labelLogin.setForeground(Color.white);
        labelLogin.setFont(new Font("Consolas", Font.BOLD,20));
        labelLogin.setOpaque(false);
        labelLogin.setBounds(520,140,100,40);

        /*_______________Senha_______________*/

        txtSenha.setVisible(true);
        txtSenha.setName("Senha:");
        txtSenha.setBackground(Color.white);
        txtSenha.setBounds(520,290,250,50);
        txtSenha.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));

        labelSenha.setVisible(true);
        labelSenha.setText("Senha");
        labelSenha.setForeground(Color.white);
        labelSenha.setFont(new Font("Consolas", Font.BOLD,20));
        labelSenha.setOpaque(false);
        labelSenha.setBounds(520,260,100,40);

        /*_______________Botões_______________*/

        botaoLogin.setBounds(520,370,250,50);
        botaoLogin.setVisible(true);
        botaoLogin.setOpaque(false);
        botaoLogin.setFont(new Font("Consolas", Font.BOLD,20));
        botaoLogin.setText("Login");
        botaoLogin.setForeground(Color.white);
        botaoLogin.setBackground(Color.darkGray);
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==botaoLogin) {

                    String login = txtLogin.getText();
                    String password = String.valueOf(txtSenha.getPassword());

                    ConexaoBD conexaoBD = null;
                    conexaoBD = new ConexaoBD();

                    List<User> listaUsuario = conexaoBD.listarUsuarios();

                    List<User> listaUsuariosEncontrados = listaUsuario.stream()
                            .filter(usuario ->
                                    usuario.getNome().equals(login)
                                    && usuario.getSenha().equals(password))
                            .collect(Collectors.toList());

                    if(listaUsuariosEncontrados.size() == 0){
                        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                        txtLogin.setText("");
                        txtSenha.setText("");
                        return;
                    }

                    Sessao.usuarioLogado = listaUsuariosEncontrados.get(0);

                    frameLogin.dispose();
                    new FormWelcome();



                }

            }
        });//fim do action perform


        /*_______________Buttons_______________*/


        botaoReset.setBounds(520,440,250,50);
        botaoReset.setVisible(true);
        botaoReset.setOpaque(false);
        botaoReset.setText("Reset");
        botaoReset.setFont(new Font("Consolas", Font.BOLD,20));
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

        botaoVoltar.setBounds(10,10,50,50);
        botaoVoltar.setVisible(true);
        botaoVoltar.setOpaque(true);
        botaoVoltar.setFont(new Font("Consolas", Font.BOLD,20));
        botaoVoltar.setText("<");
        botaoVoltar.setForeground(Color.white);
        botaoVoltar.setBackground(Color.DARK_GRAY);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVoltar.setVisible(true);
                frameLogin.dispose();
            }
        });


        /*_______________TelaLogin_______________*/


        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX  = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;

        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        frameLogin.setIconImage(icon.getImage());

        frameLogin.setVisible(true);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setSize(formWidth,formHeight);
        frameLogin.setLocation(formX,formY);
        frameLogin.setTitle("MovieTime");
        frameLogin.add(txtLogin);
        frameLogin.add(txtSenha);
        frameLogin.add(labelLogin);
        frameLogin.add(labelSenha);
        frameLogin.add(messageLabel);
        frameLogin.add(botaoLogin);
        frameLogin.add(botaoReset);
        frameLogin.add(botaoVoltar);
        frameLogin.add(labelTitulo);
        frameLogin.add(labelFundo);



    }
}