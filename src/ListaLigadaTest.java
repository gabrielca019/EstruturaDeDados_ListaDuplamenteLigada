
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaLigadaTest {

	@Test
	void testAdicionarNoComecoListaVazia() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoInicio("Fernando");

		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Fernando", lista.pegaPrimeiro());
		assertEquals("Fernando", lista.pegaUltima());		
	}

	@Test
	void testAdicionarNoComecoComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoInicio("Fernando");
		lista.adicionarElementoNoInicio("Maria");
		lista.adicionarElementoNoInicio("Carlos");

		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Carlos", lista.pegaPrimeiro());
		assertEquals("Fernando", lista.pegaUltima());

	}

	@Test
	void testAdicionarNoFinalListaVazia() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");

		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Fernando", lista.pegaPrimeiro());
		assertEquals("Fernando", lista.pegaUltima());


	}

	@Test
	void testAdicionarNoFinalComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");

		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Fernando", lista.pegaPrimeiro());
		assertEquals("Carlos", lista.pegaUltima());

	}
	
	@Test
	void testPegarNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pega(-1));
		
	}
	
	@Test
	void testPegarNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pega(6));
	}
	
	@Test
	void testPegarNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");

		assertEquals("Fernando", lista.pega(0));
		assertEquals("Maria", lista.pega(1));
		assertEquals("Carlos", lista.pega(2));
		
		
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();
		
		lista.adicionarElementoNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicinaNaPosicao("Fernando", -1));
		
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicinaNaPosicao("Fernando", 2));
		
	}
	
	@Test
	void testAdicionarNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");

		lista.adicinaNaPosicao("Rose", 1);
		
		assertEquals("Fernando", lista.pega(0));
		assertEquals("Rose", lista.pega(1));
		assertEquals("Maria", lista.pega(2));
		assertEquals("Carlos", lista.pega(3));
		
	}
	
	@Test
	void testContemListaVazia() {
		
		ListaLigada lista = new ListaLigada();
		
		assertFalse(lista.contem("Mauro"));
		
	}
	
	@Test
	void testContemNaoAcharLista() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");
		
		assertFalse(lista.contem("Mauro"));
		
	}
	
	@Test
	void testContemAcharLista() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");
		
		assertTrue(lista.contem("Maria"));
		
		
	}
	
	/* REMOVER INICIO */
	
	@Test
	void testRemoverCelulaInicialListaVazia() {
		ListaLigada lista = new ListaLigada();
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaInicial());
		assertEquals(0, lista.pegaTotalElementos());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaPrimeiro());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaUltima());
	}
	
	@Test
	void testRemoverCelulaInicialListaUmElemento() {
		ListaLigada lista = new ListaLigada();
		lista.adicionarElementoNoInicio("Gabriel");
		
		assertEquals(1, lista.pegaTotalElementos());
		
		lista.removerCelulaInicial();
		
		assertEquals(0, lista.pegaTotalElementos());
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaInicial());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaPrimeiro());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaUltima());
	}
	
	@Test
	void testRemoverCelulaInicialListaVariosElementos() {
		ListaLigada lista = new ListaLigada();
		lista.adicionarElementoNoInicio("Gabriel");
		lista.adicionarElementoNoInicio("Matheus");
		lista.adicionarElementoNoInicio("Paulo");
		
		assertEquals(3, lista.pegaTotalElementos());
		
		lista.removerCelulaInicial();
		
		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Matheus", lista.pega(0));
		
		assertEquals("Matheus", lista.pegaPrimeiro());
		assertEquals("Gabriel", lista.pegaUltima());
	}
	
	/* REMOVER FIM */
	
	@Test
	void testRemoverCelulaFinallListaVazia() {
		ListaLigada lista = new ListaLigada();
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaFinal());
		assertEquals(0, lista.pegaTotalElementos());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaPrimeiro());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaUltima());
	}
	
	@Test
	void testRemoverCelulaFinalListaUmElemento() {
		ListaLigada lista = new ListaLigada();
		lista.adicionarElementoNoFinal("Gabriel");
		
		assertEquals(1, lista.pegaTotalElementos());
		
		lista.removerCelulaFinal();
		
		assertEquals(0, lista.pegaTotalElementos());
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaFinal());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaPrimeiro());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaUltima());
	}
	
	@Test
	void testRemoverCelulaFinalListaVariosElementos() {
		ListaLigada lista = new ListaLigada();
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		
		assertEquals(3, lista.pegaTotalElementos());
		
		lista.removerCelulaFinal();
		
		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Matheus", lista.pega(1));
		assertEquals("Gabriel", lista.pegaPrimeiro());
		assertEquals("Matheus", lista.pegaUltima());
	}
	
	/* REMOVER NA POSICAO X */
	
	@Test
	void testRemoverCelulaXlListaVazia() {
		ListaLigada lista = new ListaLigada();
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(0));
		assertEquals(0, lista.pegaTotalElementos());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaPrimeiro());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaUltima());
	}
	
	@Test
	void testRemoverCelulaXListaUmElemento() {
		ListaLigada lista = new ListaLigada();
		lista.adicionarElementoNoFinal("Gabriel");
		
		assertEquals(1, lista.pegaTotalElementos());
		
		lista.removerCelulaPosicaoEspecifica(0);
		
		assertEquals(0, lista.pegaTotalElementos());
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(0));
		assertThrows(IllegalArgumentException.class, () -> lista.pegaPrimeiro());
		assertThrows(IllegalArgumentException.class, () -> lista.pegaUltima());
	}
	
	@Test
	void testRemoverCelulaXListaVariosElementos() {
		ListaLigada lista = new ListaLigada();
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		
		assertEquals(3, lista.pegaTotalElementos());
		
		lista.removerCelulaPosicaoEspecifica(1);
		
		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Paulo", lista.pega(1));
		assertEquals("Gabriel", lista.pegaPrimeiro());
		assertEquals("Paulo", lista.pegaUltima());
	}
	
	@Test
	void testRemoverNegativa() {
		ListaLigada lista = new ListaLigada();
		
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(-2));
	}
	
	@Test
	void testRemoverPosicaoSuperiorAoTotal() {
		ListaLigada lista = new ListaLigada();
		
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(5));
	}
}
