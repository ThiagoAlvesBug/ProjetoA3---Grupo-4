import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tela4{

    JFrame tela4 = new JFrame();
    DefaultTableModel model;
    JTable table;

    /*_______________Tabela_______________*/

    public Tela4(DefaultTableModel model) {
        this.model = model;

        /*_______________Tela_______________*/
        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        tela4.setIconImage(icon.getImage());
        tela4.setVisible(true);
        tela4.setTitle("Minha Lista");
        tela4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela4.setSize(1280, 720);
        tela4.setLocationRelativeTo(null);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        tela4.add(scrollPane);
    }

    /*_______________AdicionarNaTabela_______________*/

    public void adicionarNaTabela(String nome, int ano, String genero, int nota) {
        model.addRow(new Object[]{nome, ano, genero, nota});
    }

}