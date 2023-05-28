import java.util.HashMap;

public class User {

    private int id;
    private String nome;
    private int idade;
    private String genero1;
    private String genero2;
    private String sexo;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero1() {
        return genero1;
    }

    public void setGenero1(String genero1) {
        this.genero1 = genero1;
    }

    public String getGenero2() {
        return genero2;
    }

    public void setGenero2(String genero2) {
        this.genero2 = genero2;
    }

    public String getSexo() {
        return sexo;
    }

    public String getSexoChar() {

        String sexoChar;
        switch (sexo){
            case "Masculino":
                sexoChar = "M";
                break;

            case "Feminino":
                sexoChar = "F";
                break;

            case "Outro":
            default:
                sexoChar = "O";
                break;

        }

        return sexoChar;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
