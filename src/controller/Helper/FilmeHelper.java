package controller.Helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Filme;
import view.MenuViewUserComun;

public class FilmeHelper {

    private final MenuViewUserComun view;
    
    public FilmeHelper(MenuViewUserComun view){
        this.view = view;
    }
    
    public void preencherTabelaFilme(ArrayList<Filme> filmes){
    
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableFilmes().getModel();
        tableModel.setNumRows(0);
        
        //percorrer a lista preenchendo o table model
        for (Filme filme : filmes) {
            
            tableModel.addRow(new Object[]{
            
              filme.getId(),
              filme.getNome(),
              filme.getAno(),
              filme.getGenero(),
              filme.getNota()
              
                
            });
            
        }
    }
}
