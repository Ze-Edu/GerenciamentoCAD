import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args){
        int op;
        do{
        op = Integer.parseInt(JOptionPane.showInputDialog("Digite\n1 - Cadastrar\n2 - Atualizar" + "\n3 - Apagar\n4 - Listar\n0 - Sair"));
        
        switch (op){
            case 1:{
                String nome = JOptionPane.showInputDialog("Digite o Nome: ");
                String fone = JOptionPane.showInputDialog("Digite o Telefone: ");
                String email = JOptionPane.showInputDialog("Digite o Email: ");
                Pessoa p = new Pessoa();
                p.setNome(nome);
                p.setFone(fone);
                p.setEmail(email);
                p.inserir();
                break;
            }
            case 2:{
                String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
                String fone = JOptionPane.showInputDialog("Digite o novo telefone: ");
                String email = JOptionPane.showInputDialog("Digite o novo email: ");
                int codigo =Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da pessoa: "));
                Pessoa p = new Pessoa(codigo,nome,fone,email);
                p.atualizar();
                break;
            }
                case 3:
                
                break;
            case 4:
                
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"Obrigado!");
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opcao Invalida!");   
            }
        }while (op != 0);   
    }
}

