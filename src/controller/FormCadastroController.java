package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastro;


public class FormCadastroController {
    private FormCadastro view;
    
    public FormCadastroController(FormCadastro view){
        this.view = view;
    }
    
    public void salvaUsuario(){
               
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        String sexo = view.getTxtSexo().getText();
        String idade = view.getTxtIdade().getText();
        
        
        Usuario usuarioP = new Usuario(usuario,senha,sexo,idade);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuarioP);
            
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
