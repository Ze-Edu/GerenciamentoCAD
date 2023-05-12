package model;


public class Filme {
    private int id;
    private int ano;
    private int nota;
    private String nome;
    private String genero;

    public Filme(int id, String nome, int ano, String genero, int nota) {
        this.id = id;
        this.ano = ano;
        this.nota = nota;
        this.nome = nome;
        this.genero = genero;
    }

    public Filme(int id) {
        this.id = id;
    }

    public Filme(String nome, int ano, String genero, int nota) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.nota = nota;    
    }

    public Filme(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public Filme(int id, String nome, String genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
