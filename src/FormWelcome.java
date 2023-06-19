import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormWelcome extends Fundo{

        JFrame frameWelcome = new JFrame();
        JLabel label2 = new JLabel(fundo);
        JLabel label3 = new JLabel();
        JButton btnGerenciarFilmes = new JButton();
        JButton btnGerenciarUsuarios = new JButton();

        public FormWelcome() {

                /*_______________Botão_______________*/

                boolean ehAdmin = Sessao.usuarioLogado.isAdmin();

                btnGerenciarUsuarios.setVisible(ehAdmin);
                btnGerenciarUsuarios.setText("Gerenciar Usuários");
                btnGerenciarUsuarios.setOpaque(false);
                btnGerenciarUsuarios.setBackground(Color.magenta);
                btnGerenciarUsuarios.setForeground(Color.white);
                btnGerenciarUsuarios.setFont(new Font("Colibri",Font.PLAIN, 24));
                btnGerenciarUsuarios.setBounds(510,510,250,70);
                btnGerenciarUsuarios.setHorizontalAlignment(JLabel.CENTER);
                btnGerenciarUsuarios.setVerticalAlignment(JLabel.BOTTOM);

                btnGerenciarUsuarios.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                new FormListaUsuarios();
                                frameWelcome.dispose();
                        }
                });


                btnGerenciarFilmes.setVisible(true);
                btnGerenciarFilmes.setText("Gerenciar Filmes");
                btnGerenciarFilmes.setOpaque(false);
                btnGerenciarFilmes.setBackground(Color.magenta);
                btnGerenciarFilmes.setForeground(Color.white);
                btnGerenciarFilmes.setFont(new Font("Colibri",Font.PLAIN, 24));
                btnGerenciarFilmes.setBounds(510,420,250,70);
                btnGerenciarFilmes.setHorizontalAlignment(JLabel.CENTER);
                btnGerenciarFilmes.setVerticalAlignment(JLabel.BOTTOM);

                btnGerenciarFilmes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (e.getSource()== btnGerenciarFilmes){
                                        frameWelcome.dispose();
                                        new FormListaFilme();

                                }
                        }
                });


                /*_______________Título_______________*/

                String nomeUsuario = Sessao.usuarioLogado.getNome();

                label2.setSize(1280,720);
                label2.setOpaque(true);
                label2.setVisible(true);

                label3.setVisible(true);
                label3.setBounds(-5,0,1280,720);
                label3.setText("Bem-Vindo, " + nomeUsuario+ "!");
                label3.setFont(new Font("Colibri",Font.BOLD, 70));
                label3.setForeground(Color.white);
                label3.setHorizontalTextPosition(JLabel.CENTER);
                label3.setVerticalTextPosition(JLabel.BOTTOM);
                label3.setHorizontalAlignment(JLabel.CENTER);
                label3.setVerticalAlignment(JLabel.CENTER);

                label3.setOpaque(false);
                label3.add(btnGerenciarFilmes);
                label3.add(btnGerenciarUsuarios);

                label2.add(label3);




                /*_______________Frame_______________*/

                Toolkit toolkit = Toolkit.getDefaultToolkit();

                Dimension screenSize = toolkit.getScreenSize();

                int largura = screenSize.width;
                int altura = screenSize.height;

                int formWidth = 1280;
                int formHeight = 720;

                int formX  = (largura - formWidth) / 2;
                int formY = (altura - formHeight) / 2;


                ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

                frameWelcome.setIconImage(icon.getImage());
                frameWelcome.setVisible(true);
                frameWelcome.setLocation(formX,formY);
                frameWelcome.setForeground(new Color(0x44014F));
                frameWelcome.setBackground(new Color(0x44014F));
                frameWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameWelcome.setResizable(false);
                frameWelcome.setSize(formWidth,formHeight);
                frameWelcome.setTitle("MovieTime");
                frameWelcome.add(label2);
        }

}
