package controller;

import java.sql.Connection;
import controller.Helper.UsuarioHelper;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.MenuView;


public class MenuViewController {

    private final MenuView view;
    private final UsuarioHelper helper;

    public MenuViewController(MenuView view) {
        this.view = view;
        this.helper = new UsuarioHelper(view);
    }
    
    public void atualizaTabela() throws SQLException{
        
        //buscar lista com usuarios do banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        ArrayList<Usuario> usuarios = usuarioDao.selectAll();
        //exibir essa lista na view
        helper.preencherTabela(usuarios);
    }
}
