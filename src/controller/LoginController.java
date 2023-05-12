package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;
import view.MenuViewUserComun;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        String usuario = view.getTxtLoginUser().getText();
        String senha = view.getTxtLoginSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(usuario,senha);
            
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDao.existePorUsuarioESenha(usuarioAutenticar);
        
        if(existe){
            if(usuario.equals("José")){
                MenuView telaDeMenu = new MenuView();
                telaDeMenu.setLocationRelativeTo(null);
                telaDeMenu.setVisible(true);
            }else{
                MenuViewUserComun TelaComun = new MenuViewUserComun();
                TelaComun.setLocationRelativeTo(null);
                TelaComun.setVisible(true);           
            }
        }else{
            JOptionPane.showMessageDialog(view, "Usuário ou senha invalidos");
        }
    }
}
