import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class FormListaFilme {

    JFrame frameListaFilme = new JFrame();
    DefaultTableModel model;
    JTable table;

    public FormListaFilme() {
        this.model = new DefaultTableModel();

        model.addColumn("Título");
        model.addColumn("Ano");
        model.addColumn("Gênero");
        model.addColumn("Nota");


        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX  = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;

        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        frameListaFilme.setIconImage(icon.getImage());

        frameListaFilme.setVisible(true);
        frameListaFilme.setTitle("Minha Lista");
        frameListaFilme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameListaFilme.setSize(formWidth, formHeight);
        frameListaFilme.setLocation(formX,formY);
        frameListaFilme.setLocationRelativeTo(null);

        ConexaoBD conexaoBD = new ConexaoBD();

        int idLogado = Sessao.usuarioLogado.getId();

        List<Filme> lista = conexaoBD.listarFilmes(idLogado);

        // Filtrando apenas os filmes do usuário logado via Java
        /*
        lista = lista
                .stream()
                .filter(filme -> filme.getIdUsuario() == idLogado)
                .collect(Collectors.toList());
         */

        int qtdItensLista = lista.size();

        for(int indice = 0; indice < qtdItensLista; indice++){

            Filme filme = lista.get(indice);

          String nome = filme.getNome();
          int ano = filme.getAno();
          String genero = filme.getGenero();
          int nota = filme.getNota();

            model.addRow(new Object[]{nome, ano, genero, nota});

        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frameListaFilme.add(scrollPane);

    }


}