import javax.swing.*;
import java.awt.*;

public class FormListaUsuarios {

    JFrame listaUsuarios = new JFrame();

    public FormListaUsuarios(){



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

                listaUsuarios.setIconImage(icon.getImage());
                listaUsuarios.setVisible(true);
                listaUsuarios.setLocation(formX,formY);
                listaUsuarios.setForeground(new Color(0x44014F));
                listaUsuarios.setBackground(new Color(0x44014F));
                listaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                listaUsuarios.setResizable(false);
                listaUsuarios.setSize(formWidth,formHeight);
                listaUsuarios.setTitle("MovieTime");

    }
}
