package controller;

import java.sql.Connection;
import dao.Conexao;
import dao.FilmeDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Filme;
import view.FormDeleteFilme;

public class FormDeleteFilmeController {
   private FormDeleteFilme view; 

    public FormDeleteFilmeController(FormDeleteFilme view) {
        this.view = view;
    }
   
   public void apagaFilme(){
    int id = Integer.parseInt(view.getTxtIdFilme().getText());
    
    Filme fimmeAp = new Filme(id);
    
    try {
        Connection conexao = new Conexao().getConnection();
        FilmeDAO filmeDao = new FilmeDAO(conexao);
        filmeDao.delete(fimmeAp);
        
        JOptionPane.showMessageDialog(null, "Filme apagado com sucesso!");
    }
    catch (SQLException ex) {
            Logger.getLogger(FormDeleteFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   }
}
