import java.sql.Connection;
import java.sql.PreparedStatement;



public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome, String fone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void inserir(){
        String sql = "insert into tb_pessoas (nome, fone, email) values(?, ?, ?);";
        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection c = factory.conexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, fone);
        ps.setString(3, email);
        ps.execute();
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
    
    public void atualizar(){
        String sql = "update tb_pessoas set nome=?, fone=?, email=? where codigo=?;";
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection c = factory.conexao()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
