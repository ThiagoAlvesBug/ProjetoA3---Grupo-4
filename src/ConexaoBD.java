import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBD {

    /*__________Aqui_É_Onde_O_Filho_Chora_E_A_Mãe_Não_Vê__________*/

    String url = "jdbc:mysql://localhost:3306/MovieTime";
    String username = "root";
    String password = "52576";

    public boolean cadastrarUsuario(User usuario) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Estabelecer a conexão com o banco de dados
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexão estabelecida com sucesso!");

            // Executar uma consulta SQL
            String sql = """
                    INSERT INTO Usuario
                        (Nome,
                        Idade,
                        Genero1,
                        Genero2,
                        Sexo,
                        Senha)
                    VALUES
                        (?,
                        ?,
                        ?,
                        ?,
                        ?,
                        ?);
                                
                    """;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getNome());
                statement.setInt(2, usuario.getIdade());
                statement.setString(3, usuario.getGenero1());
                statement.setString(4, usuario.getGenero2());
                statement.setString(5, usuario.getSexoChar());
                statement.setString(6, usuario.getSenha());

                int linhasAfetadas = statement.executeUpdate();

                boolean sucesso;
                if (linhasAfetadas > 0) {
                    sucesso = true;
                } else {
                    sucesso = false;
                }
                return sucesso;
            }


        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return false;
    }

    public List<User> listarUsuarios() {

        List<User> listaUsuarios = new ArrayList<>();


        // Estabelecer a conexão com o banco de dados
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexão estabelecida com sucesso!");

            // Executar uma consulta SQL
            String sql = "SELECT * FROM Usuario";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                // Processar os resultados da consulta
                while (resultSet.next()) {
                    int idUser = resultSet.getInt("id_usuario");
                    String nome = resultSet.getString("Nome");
                    int idade = resultSet.getInt("Idade");
                    String genero1 = resultSet.getString("Genero1");
                    String genero2 = resultSet.getString("Genero2");
                    String senha = resultSet.getString("Senha");
                    String sexoChar = resultSet.getString("Sexo");
                    boolean ehAdmin = resultSet.getBoolean("EhAdmin");

                    String sexo;

                    switch (sexoChar) {
                        case "M":
                            sexo = "Masculino";
                            break;

                        case "F":
                            sexo = "Feminino";
                            break;

                        case "O":
                        default:
                            sexo = "Outro";
                            break;

                    }

                    User user = new User();
                    user.setId(idUser);
                    user.setNome(nome);
                    user.setIdade(idade);
                    user.setGenero1(genero1);
                    user.setGenero2(genero2);
                    user.setSexo(sexo);
                    user.setSenha(senha);
                    user.setAdmin(ehAdmin);

                    listaUsuarios.add(user);
                }
            }


        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return listaUsuarios;
    }


    public boolean adicionarFilme(Filme filme) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com sucesso!");

            String sqlFilme = """
                     INSERT INTO Filme
                         (id_usuario,
                         titulo,
                         genero,
                         ano,
                         nota)
                    VALUES
                         (?,
                         ?,
                         ?,
                         ?,
                         ?);
                     """;

            try (PreparedStatement statement = connection.prepareStatement(sqlFilme)) {
                statement.setInt(1, filme.getIdUsuario());
                statement.setString(2, filme.getNome());
                statement.setString(3, filme.getGenero());
                statement.setInt(4, filme.getAno());
                statement.setInt(5, filme.getNota());

                int linhasAfetadas2 = statement.executeUpdate();

                boolean sucesso2;
                if (linhasAfetadas2 > 0) {
                    sucesso2 = true;
                } else {
                    sucesso2 = false;
                }
                return sucesso2;
            }


        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return false;
    }

    public List<Filme> listarFilmes(int idUsuarioLogado) {

        List<Filme> listaFilmes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexão estabelecida com sucesso!");

            //perguntar como filtrar query via parâmetro
            String sql = "SELECT * FROM Filme WHERE id_usuario = " + idUsuarioLogado;
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    int idUser = resultSet.getInt("id_usuario");
                    String nome = resultSet.getString("titulo");
                    int ano = resultSet.getInt("ano");
                    String genero = resultSet.getString("genero");
                    int nota = resultSet.getInt("nota");


                    Filme filme = new Filme();
                    filme.setIdUsuario(idUser);
                    filme.setNome(nome);
                    filme.setAno(ano);
                    filme.setGenero(genero);
                    filme.setNota(nota);

                    listaFilmes.add(filme);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return listaFilmes;
    }

    public boolean tornarAdministrador(int idUsuario) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com sucesso!");

            String sqlTornarAdmin = """
                    UPDATE
                       Usuario
                    SET
                       EhAdmin = 1
                    WHERE
                       id_usuario = ?
                    """;

            try (PreparedStatement statement = connection.prepareStatement(sqlTornarAdmin)) {
                statement.setInt(1, idUsuario);

                int linhasAfetadas3 = statement.executeUpdate();

                boolean sucesso3;
                if (linhasAfetadas3 > 0) {
                    sucesso3 = true;
                } else {
                    sucesso3 = false;
                }
                return sucesso3;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return false;

    }

    public boolean removerUsuario(int idUsuario) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com sucesso!");

            String sqlRemoverUsuario = """
                    DELETE FROM
                       Usuario
                    WHERE
                       id_usuario = ?
                    """;

            try (PreparedStatement statement = connection.prepareStatement(sqlRemoverUsuario)) {
                statement.setInt(1, idUsuario);

                int linhasAfetadas4 = statement.executeUpdate();

                return linhasAfetadas4 > 0;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return false;

    }

    public boolean removerFilme(String nomeFilme) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com sucesso!");

            String sqlRemoverFilme = """
                    DELETE FROM
                       Filme
                    WHERE
                       titulo = ?
                    """;

            try (PreparedStatement statement = connection.prepareStatement(sqlRemoverFilme)) {
                statement.setString(1, nomeFilme);

                int linhasAfetadas5 = statement.executeUpdate();

                return linhasAfetadas5 > 0;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return false;
    }
}
