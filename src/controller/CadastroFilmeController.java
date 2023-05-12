package controller;

import dao.Conexao;
import dao.FilmeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Filme;
import view.CadastroFilme;

public class CadastroFilmeController {
    private CadastroFilme view;

    public CadastroFilmeController(CadastroFilme view) {
        this.view = view;
    }
    
    
    public void salvaFilme(){
        
        String nome = view.getTxtNomeFilme().getText();
        int ano = Integer.parseInt(view.getTxtAnoFilme().getText());
        String genero = view.getTxtGeneroFilme().getText();
        int nota = Integer.parseInt(view.getTxtNotaFilme().getText());
                
        Filme filmep = new Filme(nome,ano,genero,nota);
        
        try{
            Connection conexao = new Conexao().getConnection();
            FilmeDAO filmeDao = new FilmeDAO(conexao);
            filmeDao.insert(filmep);
            
            JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
        }
        catch (SQLException ex) {
            Logger.getLogger(CadastroFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
