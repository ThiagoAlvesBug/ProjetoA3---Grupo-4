public class Filme {

    private int idUsuario;
    private String nome;
    private int ano;
    private String genero;
   private int nota;

    public Filme() {
        
        
    }

    public Filme(int idFilme, int idUsuario, String nome, String genero, int ano, int nota) {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Filme(String nome, int ano, String genero, int nota) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.nota = nota;
    }
}
