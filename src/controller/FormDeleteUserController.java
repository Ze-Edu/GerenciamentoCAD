package controller;

import dao.Conexao;
import dao.UsuarioDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormDeleteUser;


public class FormDeleteUserController {
    private FormDeleteUser view;

    public FormDeleteUserController(FormDeleteUser view) {
        this.view = view;
    }
    
    public void apagarUsuario(){
    
        int id = Integer.parseInt(view.getTxtIdUser().getText());
        
        Usuario userAp = new Usuario(id);
        
        try{
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.delete(userAp);
            
            JOptionPane.showMessageDialog(null, "Usuario apagado com sucesso!");
        }
        catch (SQLException ex) {
            Logger.getLogger(FormDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
