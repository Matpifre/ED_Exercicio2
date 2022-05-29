import javax.swing.JOptionPane;

public class Processo {

    static Lista<Produto> lista = new Lista<Produto>();

    public static void CadastrarProduto() {
        String dt_validade, nome;
        int estoque;

        nome=JOptionPane.showInputDialog("Nome do produto:");
        
        dt_validade=JOptionPane.showInputDialog("Data de validade (YYYY/MM/DD):");
        
        estoque=Integer.parseInt(JOptionPane.showInputDialog("Quantidade no estoque:"));

        if(estoque<=0)
        {
            JOptionPane.showMessageDialog(null, "Numero de estoque obrigatório");
        }
        else
        {
            Produto produto=new Produto(nome, dt_validade, estoque);
            if(lista.pesquisar(produto)!=null)
            {
                JOptionPane.showMessageDialog(null, "Produto já consta no sistema");
            } 
            else 
            {
                lista.inserir(produto);
                JOptionPane.showMessageDialog(null, "Suscesso ao cadastar novo produto!");
            }
        }
    }

    public static void ListarProduto() {
        Lista<Produto> copia= new Lista<Produto>();
        No<Produto> aux= lista.inicio;
        while(aux!=null)
        {
            copia.inserir(aux.dado);
            aux= aux.dir;
        }

        for(int i=0; i<lista.total ;i++)
        {
            aux= copia.inicio; 
            No<Produto> aux2= aux.dir;      
            while(aux2!= null)
            {
                if(aux.dado.getDt_validade().compareTo(aux.dir.dado.getDt_validade())>=0)
                {
                    aux= aux2;
                }      
                aux2= aux2.dir;
            }
        
            JOptionPane.showMessageDialog(null, aux.dado.toString());
            copia.remover(aux.dado);
        }

    }

    public static void VenderProduto() {
        int valor;
        No<Produto> aux=lista.inicio;
        String nome;
        boolean achou=false;

        nome=JOptionPane.showInputDialog("Nome do produto:");
        while(aux!=null)
        {
            if(aux.dado.getNome().equalsIgnoreCase(nome))
            {
                Produto produto=aux.dado;
                valor=Integer.parseInt(JOptionPane.showInputDialog("Quantos produtos foram vendidos:"));
                produto.removerEstoque(valor);
                if(produto.getEstoque()==0)
                {
                    lista.remover(produto);
                }
                achou=true;
                break;
            }
            aux=aux.dir;
        }
        if(achou==false)
        {
            JOptionPane.showMessageDialog(null, "Produto não consta ou esgotou!");
        }

        
    }
         
} 
