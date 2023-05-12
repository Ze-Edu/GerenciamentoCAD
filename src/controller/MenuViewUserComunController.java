package controller;

import java.sql.Connection;
import controller.Helper.FilmeHelper;
import dao.Conexao;
import dao.FilmeDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;
import view.MenuViewUserComun;

public class MenuViewUserComunController {

    private final MenuViewUserComun view;
    private final FilmeHelper helper;
        
        public MenuViewUserComunController(MenuViewUserComun view){
        
            this.view = view;
            this.helper = new FilmeHelper(view);
        }
        
        public void atualizaTabelaFilmes() throws SQLException{
        //buscar lista com usuarios do banco de dados
        Connection conexao = new Conexao().getConnection();
        FilmeDAO filmeDao = new FilmeDAO(conexao);
        ArrayList<Filme> filmes = filmeDao.selectAll();
        //exibir essa lista na view
        helper.preencherTabelaFilme(filmes);
        }
    }
