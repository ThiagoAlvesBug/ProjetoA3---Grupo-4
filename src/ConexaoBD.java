import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBD {

    String url = "jdbc:mysql://localhost:3306/MovieTime";
    String username = "root";
    String password = "52576";

    public boolean cadastrarUsuario(User usuario) {

        //root@127.0.0.1:3306
        //jdbc:mysql://127.0.0.1:3306/?user=root

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
                    statement.setInt(2,usuario.getIdade());
                    statement.setString(3, usuario.getGenero1());
                    statement.setString(4,usuario.getGenero2());
                    statement.setString(5,usuario.getSexoChar());
                    statement.setString(6,usuario.getSenha());

                    int linhasAfetadas = statement.executeUpdate();

                    boolean sucesso;
                    if (linhasAfetadas>0){
                        sucesso = true;
                    }
                    else{
                        sucesso = false;
                    }
                    return sucesso;
            }



        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return false;
    }
    public List<User> listarUsuarios(){

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
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    int idade = resultSet.getInt("Idade");
                    String genero1 = resultSet.getString("Genero1");
                    String genero2 = resultSet.getString("Genero2");
                    String senha = resultSet.getString("Senha");
                    String sexoChar = resultSet.getString("Sexo");

                    String sexo;

                    switch (sexoChar){
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
                    user.setId(id);
                    user.setNome(nome);
                    user.setIdade(idade);
                    user.setGenero1(genero1);
                    user.setGenero2(genero2);
                    user.setSexo(sexo);
                    user.setSenha(senha);

                    listaUsuarios.add(user);
                }
            }


        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return listaUsuarios;
    }

    String sqlFilme =   """
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

    public void adicionarFilme(Filme filme) {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connection.prepareStatement(sqlFilme);
            statement.setInt(1, filme.getIdUsuario());
            statement.setString(2, filme.getNome());
            statement.setString(3, filme.getGenero());
            statement.setInt(4, filme.getAno());
            statement.executeUpdate();


            int idUsuario = 0;{
                List<Filme> filmes = new ArrayList<>();
                try (Connection connection1 = DriverManager.getConnection(url, username, password)) {
                    {
                        statement.setInt(1, idUsuario);
                        try (ResultSet resultSet = statement.executeQuery()) {
                            while (resultSet.next()) {
                                int idFilme = resultSet.getInt("id_filme");
                                String nome = resultSet.getString("titulo");
                                String genero = resultSet.getString("genero");
                                int ano = resultSet.getInt("ano");
                                int nota = resultSet.getInt("nota");

                                filme = new Filme();
                                filme.setIdUsuario(idFilme);
                                filme.setNome(filme.getNome());
                                filme.setAno(filme.getAno());
                                filme.setGenero(filme.getGenero());
                                filme.setNota(filme.getNota());

                                filmes.add(filme);
                            }
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

