import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormListaUsuarios {

    JFrame frameListaUsuarios = new JFrame();
    CustomTableModel model = new CustomTableModel();
    JTable tabelaUsuarios = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(tabelaUsuarios);
    JButton btnVoltar = new JButton();

    public FormListaUsuarios() {

        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Idade");
        model.addColumn("Sexo");
        model.addColumn("Administrador");
        model.addColumn("");


        ConexaoBD conexaoBD = new ConexaoBD();

        List<User> listaUsuarios = conexaoBD.listarUsuarios();

        int qtdItensLista = listaUsuarios.size();

        for (User user : listaUsuarios) {
            int idUsuario = user.getId();
            String nome = user.getNome();
            int idade = user.getIdade();
            String sexo = user.getSexo();
            boolean ehAdmin = user.isAdmin();

            String tipoUsuario = "Comum";
            if (ehAdmin) {
                tipoUsuario = "Administrador";
            }


            model.addRow(new Object[]{idUsuario, nome, idade, sexo, tipoUsuario, "Tornar Administrador", "Remover Usuário"});
        }

        tabelaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = tabelaUsuarios.getSelectedRow();
                    int col = tabelaUsuarios.getSelectedColumn();

                    int idUsuario = Integer.parseInt(tabelaUsuarios.getValueAt(row, 0).toString());
                    String nomeUsuario = tabelaUsuarios.getValueAt(row, 1).toString();

                    // Verificar se o clique foi na coluna desejada (ex: "Tornar Administrador")
                    if (col == 5) {
                        // Lógica para lidar com o clique no botão "Tornar Administrador" na linha 'row'
                        boolean sucesso = conexaoBD.tornarAdministrador(idUsuario);

                        if (sucesso) {
                            JOptionPane.showMessageDialog(null, "Usuário " + nomeUsuario + " foi promovido à administrador.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao promover " + nomeUsuario + " à administrador.");
                        }

                    } else if (col == 6) {
                        boolean sucesso2 = conexaoBD.removerUsuario(idUsuario);

                        if (sucesso2) {
                            JOptionPane.showMessageDialog(null, "Usuário " + nomeUsuario + " foi removido.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover " + nomeUsuario + ".");
                        }
                    }
                }
            }
        });



        /*_______________Frame_______________*/

        btnVoltar.setVisible(true);
        btnVoltar.setBackground(Color.darkGray);
        btnVoltar.setText("Voltar");
        btnVoltar.setForeground(Color.white);
        btnVoltar.setFont(new Font("Consolas", Font.BOLD, 20));
        btnVoltar.setBounds(510, 575, 250, 50);


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormWelcome();
                frameListaUsuarios.dispose();
            }
        });


        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        int largura = screenSize.width;
        int altura = screenSize.height;

        int formWidth = 1280;
        int formHeight = 720;

        int formX = (largura - formWidth) / 2;
        int formY = (altura - formHeight) / 2;


        ImageIcon icon = new ImageIcon("C:\\Users\\thiag\\OneDrive\\Área de Trabalho\\Documentos USJT\\MovieIcon.png");

        frameListaUsuarios.setIconImage(icon.getImage());
        frameListaUsuarios.setVisible(true);
        frameListaUsuarios.setLocation(formX, formY);
        frameListaUsuarios.setForeground(new Color(0x44014F));
        frameListaUsuarios.setBackground(new Color(0x44014F));
        frameListaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameListaUsuarios.setResizable(false);
        frameListaUsuarios.setSize(formWidth, formHeight);
        frameListaUsuarios.setTitle("MovieTime");
        frameListaUsuarios.add(btnVoltar);
        frameListaUsuarios.add(scrollPane);
        // tabelaUsuarios.setEnabled(false);

    }
}
