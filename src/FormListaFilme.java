import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormListaFilme {

    JFrame frameListaFilme = new JFrame();
    DefaultTableModel model;
    JTable table;

    public FormListaFilme(DefaultTableModel model) {
        this.model = model;

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX  = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;


        frameListaFilme.setVisible(true);
        frameListaFilme.setTitle("Minha Lista");
        frameListaFilme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameListaFilme.setSize(formWidth, formHeight);
        frameListaFilme.setLocation(formX,formY);
        frameListaFilme.setLocationRelativeTo(null);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        frameListaFilme.add(scrollPane);

    }

    public void adicionarNaTabela(String nome, int ano, String genero, int nota) {
        model.addRow(new Object[]{nome, ano, genero, nota});
    }

}