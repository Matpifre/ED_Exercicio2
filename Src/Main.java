import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			if(opcao < 1 || opcao > 4) 
            {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			} else {
				switch(opcao) 
                {
					case 1:
						Processo.CadastrarProduto();
						break;
					case 2:
						Processo.ListarProduto();
						break;
					case 3:
						Processo.VenderProduto();
						break;
				}
			}
			
		} while(opcao != 4);
	}
	
	public static String menu() 
    {
		String aux = "Escolha uma opção:\n";
        aux +="1. Cadastrar produto\n";
		aux += "2. Listar produto\n";
		aux += "3. Vender produto\n";
		aux += "4. Encerrar aplicação\n";
		return aux;
	}
}
