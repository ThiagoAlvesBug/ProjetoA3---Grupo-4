import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tela4 extends Fundo{

    JFrame telaLista = new JFrame();

    JLabel label2 = new JLabel(fundo);

    Tela4(List<Filme> listaFilmes){

        DefaultListModel<String> listaLinhas = new DefaultListModel<>();

        for (int i = 0; i < listaFilmes.size(); i++) {
            Filme filme = listaFilmes.get(i);

            listaLinhas.addElement("Nome: " + filme.nome);
            listaLinhas.addElement("Ano: " + filme.ano);
            listaLinhas.addElement("Gênero: " + filme.genero);
            listaLinhas.addElement("Nota: " + filme.nota);
            listaLinhas.addElement("___________________");
        }

        JList<String> list = new JList<>(listaLinhas);
        list.setFont(new Font("Consolas", Font.BOLD,16));
        //list.setForeground(new Color(0xF7FFFFFF, true));
        JScrollPane scrollPane = new JScrollPane(list);



        // de 0 até 255 --> 256 = 16²

        /*
        binário:
        0, 1


        decimal:
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9

        00 até 99 // 10 * 10 = 100 opcoes

        18 = 1 * 10 + 8

        hexadecimal:
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F

        00 até FF // 16 * 16 = 256 opcoes

        18 = 1 * 16 + 8 = 24

        FF = F * 16 + F
        FF = 15 * 16 + 15

        0xFFFFFF
        0x --> Sinaliza que o valor é um hexadecimal;
        18 --> Se refere a 100% da cor RED;
        FF --> Se refere a 100% da cor GREEN;
        FF --> Se refere a 100% da cor BLUE;

        * */

        /*_______________Lista_De_Filmes_______________*/


        telaLista.setVisible(true);
        telaLista.setForeground(new Color(0x44014F));
        telaLista.setBackground(new Color(0x44014F));
        telaLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaLista.setResizable(false);
        telaLista.setSize(1280,720);
        telaLista.setTitle("MovieTime");
        telaLista.add(scrollPane);
        //telaLista.add(label2);

    }

}
