public class Lista <T>{
    No<T> inicio, fim;
	int total;
    
    // Inserindo um elemento na Lista
    public void inserir(T dado) {

		No<T> aux = new No<T>(dado);

		if (total == 0) 
        {
			inicio = aux;
		} else 
        {
            fim.dir = aux;
            aux.esq = fim;
         }
		fim = aux;
		total++;

	}

    //Pesquisando um elemento na Lista
    public No<T> pesquisar(T dado) {
		No<T> aux= inicio;
		boolean achou= false;
		while(aux != null && achou == false) 
        {
			if(aux.dado.equals(dado)) 
            {
				achou= true;
				break;
			} 
			aux= aux.dir; 
			
		}
		return aux;
	}

    public void remover(T dado) {
		No<T> aux = pesquisar(dado);
		if (aux != null) {
			if (total == 1) 
            {
				inicio = null;
				fim = null;
			} 
            else if (aux == inicio) 
            {
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} 
            else if (aux == fim) 
            {
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} 
            else 
            {
				aux.esq.dir=aux.dir;
				aux.dir.esq=aux.esq;
				aux.dir=null;
				aux.esq=null;
			}
			total--;
		}

	}


}
