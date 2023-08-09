
public class ListaLigada {
	
	private Celula primeira = null;
	private Celula ultima = null;
	private int totalDeElementos = 0;
	
	public void adicionarElementoNoInicio(Object novoElemento) {
		if (verificarListaEstaVazia()) {
			Celula nova = new Celula(novoElemento);
			this.primeira = nova;
			this.ultima = nova;
		}
		else {
			Celula nova = new Celula(novoElemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}
	
	public void adicionarElementoNoFinal(Object novoElemento) {
		if (verificarListaEstaVazia()) {
			adicionarElementoNoInicio(novoElemento);
		}
		else {
			Celula nova = new Celula(novoElemento);
			this.ultima.setProximo(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
		
	}
	
	private boolean posicaoValidaInsercao(int posicao) {
		return (posicao >= 0) && (posicao <= this.totalDeElementos);
	}
	
	public void adicinaNaPosicao(Object novoElemento, int posicao) {
		
		if (!posicaoValidaInsercao(posicao)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		
		if (posicao == 0) {
			adicionarElementoNoInicio(novoElemento);
		}
		else if (posicao == this.totalDeElementos) {
			adicionarElementoNoFinal(novoElemento);
		}
		else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula proxima = anterior.getProximo();
			
			Celula nova = new Celula(novoElemento, proxima);
			nova.setAnterior(anterior);
			anterior.setProximo(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
		
	}
	
	private boolean verificarListaEstaVazia() {
	    return  totalDeElementos == 0;
	
	}
	
	public int pegaTotalElementos() {
		return totalDeElementos;
	}
	
	public Object pegaPrimeiro() {
		if(this.primeira == null) 
			throw new IllegalArgumentException("Primeira posição está vazia!");
		
		return this.primeira.getElemento();
	}
	
	public Object pegaUltima() {
		if(this.ultima == null) 
			throw new IllegalArgumentException("Ultima posição está vazia!");
		
		
		return this.ultima.getElemento();
	}
	
	private boolean posicaoValidaRecuperar(int posicao) {
		return (posicao >= 0) && (posicao < this.totalDeElementos);
	}
	
	private Celula pegaCelula(int posicao) {
		
		if (!posicaoValidaRecuperar(posicao)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		
		Celula atual = this.primeira;
		
		for (int i=0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
			
	}
	
	public Object pega(int posicao) {
		
		return pegaCelula(posicao).getElemento();
		
	}
	
	public boolean contem (Object elementoBuscado) {
		
		Celula atual = this.primeira;
		
		while (atual != null) {
			
			if (atual.getElemento().equals(elementoBuscado)) {
				return true;
			}
			atual = atual.getProximo();
		}
		
		return false;
	}

	public void removerCelulaInicial() {
		if(verificarListaEstaVazia()) 
			throw new IllegalArgumentException("Remoção inválida pela lista estar vazia!");
		
		if(this.primeira == this.ultima) {
			this.primeira = null;
			this.ultima = null;
		} else {
			this.primeira = this.primeira.getProximo();
			this.primeira.setAnterior(null);
		}
		totalDeElementos--;
	}
	
	public void removerCelulaFinal() {
		if(verificarListaEstaVazia()) 
			throw new IllegalArgumentException("Remoção inválida pela lista estar vazia!");
		
		if(this.primeira == this.ultima) {
			removerCelulaInicial();
		} else {
			this.ultima = this.ultima.getAnterior();
			this.ultima.setProximo(null);
			totalDeElementos--;
		}
	}
	
	public void removerCelulaPosicaoEspecifica(int posicao) {
		if(!this.posicaoValidaRecuperar(posicao)) 
			throw new IllegalArgumentException("Posição inválida!");
		
		if(posicao == 0) {
			removerCelulaInicial();
		} else if(posicao == (totalDeElementos - 1)) {
			removerCelulaFinal();
		} else {
			Celula celulaRemovida = this.pegaCelula(posicao);
			celulaRemovida.getAnterior().setProximo(celulaRemovida.getProximo());
			celulaRemovida.getProximo().setAnterior(celulaRemovida.getAnterior());
			totalDeElementos--;
		}
		
	}

}