import javax.swing.JOptionPane;

public class Produto {
    
    private String nome;
    private String dt_validade;
    private int estoque;

    public Produto(){}

    public Produto(String nome, String dt_validade, int estoque){
        this.nome = nome;
        this.dt_validade = dt_validade;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDt_validade() {
        return dt_validade;
    }
    
    public void setDt_validade(String dt_validade) {
        this.dt_validade = dt_validade;
    }
    
    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +", Data de Validade: "+ getDt_validade() +", Estoque: "+getEstoque() +"";
    }
   
    public void removerEstoque(int valor){
        if(valor>estoque){
            JOptionPane.showMessageDialog(null, "Estoque insuficiente("+estoque+")");
        }else{
        estoque= estoque-valor;
        }
        }
    
}
