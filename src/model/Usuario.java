package model;

public class Usuario {
   private int id;
   private String usuario;
   private String senha;
   private String sexo;
   private String idade;

    public Usuario(int id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(int id, String usuario, String senha, String sexo,String idade) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Usuario(String usuario, String senha, String sexo, String idade) {
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo; 
    }
    

   
    public int getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
   
}
