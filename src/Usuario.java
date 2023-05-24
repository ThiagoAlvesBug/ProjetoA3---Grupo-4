public class Usuario {

    String nome;
    int idade;
    String sexo;
    String generoPreferido1;

    String generoPreferido2;

    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGeneroPreferido1() {
        return generoPreferido1;
    }

    public void setGeneroPreferido1(String generoPreferido1) {
        this.generoPreferido1 = generoPreferido1;
    }

    public String getGeneroPreferido2() {
        return generoPreferido2;
    }

    public void setGeneroPreferido2(String generoPreferido2) {
        this.generoPreferido2 = generoPreferido2;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
