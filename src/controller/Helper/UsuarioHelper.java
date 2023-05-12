package controller.Helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.MenuView;

public class UsuarioHelper {
    
    private final MenuView view;

    public UsuarioHelper(MenuView view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Usuario> usuarios) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableUsuarios().getModel();
        tableModel.setNumRows(0);
        
        //percorrer a lista preenchendo o table model
        for (Usuario usuario : usuarios) {
            
            tableModel.addRow(new Object[]{
            
              usuario.getId(),
              usuario.getUsuario(),
              usuario.getSenha(),
              usuario.getIdade(),
              usuario.getSexo()
              
              
                
            });
            
        }
    } 
}
