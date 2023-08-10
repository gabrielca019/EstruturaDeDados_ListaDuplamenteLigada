
public class ListaLigada {
	
	private Celula primeiraCelula = null;
	private Celula ultimaCelula = null;
	private int totalDeCelulas = 0;
	
	public void adicionarElementoNoInicio(Object novoElemento) {
		if (verificarListaEstaVazia()) {
			Celula novaCelula = new Celula(novoElemento);
			this.primeiraCelula = novaCelula;
			this.ultimaCelula = novaCelula;
		}
		else {
			Celula novaCelula = new Celula(novoElemento, this.primeiraCelula);
			this.primeiraCelula.setAnterior(novaCelula);
			this.primeiraCelula = novaCelula;
		}
		this.totalDeCelulas++;
	}
	
	public void adicionarElementoNoFinal(Object novoElemento) {
		if (verificarListaEstaVazia()) {
			adicionarElementoNoInicio(novoElemento);
		}
		else {
			Celula novaCelula = new Celula(novoElemento);
			this.ultimaCelula.setProximo(novaCelula);
			novaCelula.setAnterior(this.ultimaCelula);
			this.ultimaCelula = novaCelula;
			this.totalDeCelulas++;
		}
		
	}
	
	private boolean verificarPosicaoValidaParaInsercao(int posicao) {
		return (posicao >= 0) && (posicao <= this.totalDeCelulas);
	}
	
	public void adicionarNaPosicaoEspecifica(Object novoElemento, int posicao) {
		if (!verificarPosicaoValidaParaInsercao(posicao)) 
			throw new IllegalArgumentException("Posição Inválida!");
		
		
		if (posicao == 0) {
			adicionarElementoNoInicio(novoElemento);
		}
		else if (posicao == this.totalDeCelulas) {
			adicionarElementoNoFinal(novoElemento);
		}
		else {
			Celula celulaAnterior = getCelulaNaPosicaoEspecifica(posicao - 1);
			Celula celulaSucessora = celulaAnterior.getProximo();
			
			Celula novaCelula = new Celula(novoElemento, celulaSucessora);
			novaCelula.setAnterior(celulaAnterior);
			celulaAnterior.setProximo(novaCelula);
			celulaSucessora.setAnterior(novaCelula);
			this.totalDeCelulas++;
		}
	}
	
	private boolean verificarListaEstaVazia() {
	    return totalDeCelulas == 0;
	}
	
	public int getTotalCelulas() {
		return totalDeCelulas;
	}
	
	public Object getPrimeiraCelula() {
		if(this.primeiraCelula == null) 
			throw new IllegalArgumentException("Primeira posição está vazia!");
		
		return this.primeiraCelula.getElemento();
	}
	
	public Object getUltimaCelula() {
		if(this.ultimaCelula == null) 
			throw new IllegalArgumentException("Ultima posição está vazia!");
		
		return this.ultimaCelula.getElemento();
	}
	
	private boolean posicaoValidaRecuperar(int posicao) {
		return (posicao >= 0) && (posicao < this.totalDeCelulas);
	}
	
	private Celula getCelulaNaPosicaoEspecifica(int posicao) {
		if (!posicaoValidaRecuperar(posicao)) 
			throw new IllegalArgumentException("Posicao Invalida");
		
		Celula celulaAtual = this.primeiraCelula;
		
		for (int i=0; i < posicao; i++) 
			celulaAtual = celulaAtual.getProximo();
		
		return celulaAtual;
			
	}
	
	public Object getElementoPosicaoEspecifica(int posicao) {
		return getCelulaNaPosicaoEspecifica(posicao).getElemento();
	}
	
	public boolean contem (Object elementoBuscado) {
		Celula celulaAtual = this.primeiraCelula;
		
		while (celulaAtual != null) {
			if (celulaAtual.getElemento().equals(elementoBuscado)) 
				return true;
			
			celulaAtual = celulaAtual.getProximo();
		}
		
		return false;
	}

	public void removerCelulaInicial() {
		if(verificarListaEstaVazia()) 
			throw new IllegalArgumentException("Remoção inválida pela lista estar vazia!");
		
		if(this.primeiraCelula == this.ultimaCelula) {
			this.primeiraCelula = null;
			this.ultimaCelula = null;
		} else {
			this.primeiraCelula = this.primeiraCelula.getProximo();
			this.primeiraCelula.setAnterior(null);
		}
		totalDeCelulas--;
	}
	
	public void removerCelulaFinal() {
		if(verificarListaEstaVazia()) 
			throw new IllegalArgumentException("Remoção inválida pela lista estar vazia!");
		
		if(this.primeiraCelula == this.ultimaCelula) {
			removerCelulaInicial();
		} else {
			this.ultimaCelula = this.ultimaCelula.getAnterior();
			this.ultimaCelula.setProximo(null);
			totalDeCelulas--;
		}
	}
	
	public void removerCelulaPosicaoEspecifica(int posicao) {
		if(!this.posicaoValidaRecuperar(posicao)) 
			throw new IllegalArgumentException("Posição inválida!");
		
		if(posicao == 0) {
			removerCelulaInicial();
		} else if(posicao == (totalDeCelulas - 1)) {
			removerCelulaFinal();
		} else {
			Celula celulaRemovida = this.getCelulaNaPosicaoEspecifica(posicao);
			celulaRemovida.getAnterior().setProximo(celulaRemovida.getProximo());
			celulaRemovida.getProximo().setAnterior(celulaRemovida.getAnterior());
			totalDeCelulas--;
		}
	}
}