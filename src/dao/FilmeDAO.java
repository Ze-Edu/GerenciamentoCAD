package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;

public class FilmeDAO {
    private final Connection connection;

    public FilmeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Filme insert(Filme filme) throws SQLException{
    
        String sql = "insert into tb_filme (nome,ano,genero,nota) values (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, filme.getNome());
        statement.setInt(2, filme.getAno());
        statement.setString(3, filme.getGenero());
        statement.setInt(4, filme.getNota());
        statement.execute();
            
        ResultSet resultSet = statement.getGeneratedKeys();
            
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            filme.setId(id);
        }       
       return filme;
    }
    public void delete(Filme filme) throws SQLException{
            String sql = "delete from tb_filme where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, filme.getId());
            statement.execute(); 
        }
    
    public ArrayList<Filme> selectAll() throws SQLException{
            String sql = "select * from tb_filme";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            return pesquisa(statement);
        }
    
    
    private ArrayList<Filme> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            int ano = Integer.parseInt(resultSet.getString("ano"));
            String genero = resultSet.getString("genero");
            int nota = Integer.parseInt(resultSet.getString("nota"));
            
            Filme filmeComDadosBanco = new Filme(id, nome, ano, genero, nota);
            filmes.add(filmeComDadosBanco);
        }
        return filmes;
    }
    
    public Filme selectPorId(Filme filme) throws SQLException{
            String sql = "select * from tb_filme where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, filme.getId());
            
            return pesquisa(statement).get(0);
        }
}
