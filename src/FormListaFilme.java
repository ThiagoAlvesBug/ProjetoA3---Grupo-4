import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class FormListaFilme {

    JFrame frameListaFilme = new JFrame();
    DefaultTableModel model;
    JTable tabelaFilmes;
    JButton btnVoltar = new JButton();
    JButton btnAdicionar = new JButton();

    public FormListaFilme() {
        this.model = new DefaultTableModel();

        btnVoltar.setVisible(true);
        btnVoltar.setBackground(Color.darkGray);
        btnVoltar.setText("<");
        btnVoltar.setForeground(Color.white);
        btnVoltar.setFont(new Font("Consolas",Font.BOLD, 20));
        btnVoltar.setBounds(450,575,50,50);

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormWelcome();
                frameListaFilme.dispose();
            }
        });

        /*_______________CriandoColunas_______________*/

        model.addColumn("Título");
        model.addColumn("Ano");
        model.addColumn("Gênero");
        model.addColumn("Nota");
        model.addColumn("Remover Filme");


        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;

        frameListaFilme.setVisible(true);
        frameListaFilme.setTitle("Minha Lista");
        frameListaFilme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameListaFilme.setSize(formWidth, formHeight);
        frameListaFilme.setLocation(formX, formY);
        frameListaFilme.setLocationRelativeTo(null);

        /*________PuxandoListaDoBanco________*/

        ConexaoBD conexaoBD = new ConexaoBD();

        int idLogado = Sessao.usuarioLogado.getId();

        List<Filme> lista = conexaoBD.listarFilmes(idLogado);


        /*________Ordenar_os_itens_da_tabela_por_nota________*/

        Collections.sort(lista, new Comparator<Filme>() {
            @Override
            public int compare(Filme filme1, Filme filme2) {
                return Integer.compare(filme2.getNota(), filme1.getNota());
            }
        });

        for (Filme filme : lista) {
            String nome = filme.getNome();
            int ano = filme.getAno();
            String genero = filme.getGenero();
            int nota = filme.getNota();

            model.addRow(new Object[]{nome, ano, genero, nota, "Remover Filme"});
        }


        btnAdicionar.setVisible(true);
        btnAdicionar.setBackground(Color.darkGray);
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setForeground(Color.white);
        btnAdicionar.setFont(new Font("Consolas", Font.BOLD, 20));
        btnAdicionar.setBounds(510, 575, 250, 50);
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormCadastroFilme();
                frameListaFilme.hide();
            }
        });


        tabelaFilmes = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabelaFilmes);


        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        frameListaFilme.setIconImage(icon.getImage());
        frameListaFilme.add(btnAdicionar);
        frameListaFilme.add(btnVoltar);
        frameListaFilme.add(scrollPane);



        tabelaFilmes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int row = tabelaFilmes.getEditingRow();
                int col = tabelaFilmes.getSelectedColumn();

                String nomeFilme = tabelaFilmes.getValueAt(row, 0).toString();

                if (col == 4) {
                    // Lógica para lidar com o clique no botão "Remover Filme" na linha 'row'
                    boolean sucesso = conexaoBD.removerFilme(nomeFilme);

                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "O filme " + nomeFilme + " foi removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover " + nomeFilme + ".");
                    }
                }
            }
        });

    }
}