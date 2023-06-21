import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Fundo {

    public static void main(String[] args){

        JFrame frameMain = new JFrame();

        JButton botaoLogin = new JButton();

        JLabel labelFundo = new JLabel(fundo);

        JButton botaoCadastro = new JButton();

        JLabel label1 = new JLabel();


        /*_______________Título_______________*/

        labelFundo.setLayout(new GridLayout());

        label1.setText("MovieTime");
        label1.setBounds(505, 150, 350, 100);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV Boli", Font.BOLD, 48));
        label1.setIconTextGap(-25);
        label1.setForeground(Color.white);
        label1.setOpaque(false);


        /*_______________Botões_______________*/

        botaoLogin.setBounds(385, 300, 500, 100);
        botaoLogin.setVisible(true);
        botaoLogin.setOpaque(false);
        botaoLogin.setFont(new Font("Consolas", Font.BOLD,28));
        botaoLogin.setText("Fazer Login");
        botaoLogin.setForeground(Color.white);
        botaoLogin.setBackground(Color.darkGray);
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormLogin(frameMain);
                frameMain.setVisible(false);
            }
        });


        botaoCadastro.setBounds(385, 420, 500, 100);
        botaoCadastro.setVisible(true);
        botaoCadastro.setOpaque(false);
        botaoCadastro.setFont(new Font("Consolas", Font.BOLD,28));
        botaoCadastro.setText("Fazer Cadastro");
        botaoCadastro.setForeground(Color.white);
        botaoCadastro.setBackground(Color.darkGray);
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormCadastroUsuario(frameMain);
                frameMain.setVisible(false);
            }
        });


        /*_______________FrameMain_______________*/

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX  = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;

        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        frameMain.setIconImage(icon.getImage());
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setResizable(false);
        frameMain.setSize(formWidth, formHeight);
        frameMain.setTitle("MovieTime");
        frameMain.add(botaoCadastro);
        frameMain.add(botaoLogin);
        frameMain.add(label1);
        frameMain.add(labelFundo);
        frameMain.setLocation(formX,formY);

    }
}