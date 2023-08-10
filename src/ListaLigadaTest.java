
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaLigadaTest {
	
	ListaLigada lista;
	
	@BeforeEach
	void criarLista() {
		lista = new ListaLigada();
	}

	@Test
	void testAdicionarNoComecoListaVazia() {
		lista.adicionarElementoNoInicio("Fernando");

		assertEquals(1, lista.getTotalCelulas());
		assertEquals("Fernando", lista.getPrimeiraCelula());
		assertEquals("Fernando", lista.getUltimaCelula());		
	}

	@Test
	void testAdicionarNoInicioComElementos() {
		lista.adicionarElementoNoInicio("Fernando");
		lista.adicionarElementoNoInicio("Maria");
		lista.adicionarElementoNoInicio("Carlos");

		assertEquals(3, lista.getTotalCelulas());
		assertEquals("Carlos", lista.getPrimeiraCelula());
		assertEquals("Fernando", lista.getUltimaCelula());

	}

	@Test
	void testAdicionarNoFinalListaVazia() {
		lista.adicionarElementoNoFinal("Fernando");

		assertEquals(1, lista.getTotalCelulas());
		assertEquals("Fernando", lista.getPrimeiraCelula());
		assertEquals("Fernando", lista.getUltimaCelula());
	}

	@Test
	void testAdicionarNoFinalComElementos() {
		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");

		assertEquals(3, lista.getTotalCelulas());
		assertEquals("Fernando", lista.getPrimeiraCelula());
		assertEquals("Carlos", lista.getUltimaCelula());
	}
	
	@Test
	void testPegarNaPosicaoInvalidaNegativa() {
		lista.adicionarElementoNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.getElementoPosicaoEspecifica(-1));
	}
	
	@Test
	void testPegarNaPosicaoInvalidaQuantidadeElementos() {
		lista.adicionarElementoNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.getElementoPosicaoEspecifica(6));
	}
	
	@Test
	void testPegarNaPosicaoValida() {
		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");

		assertEquals("Fernando", lista.getElementoPosicaoEspecifica(0));
		assertEquals("Maria", lista.getElementoPosicaoEspecifica(1));
		assertEquals("Carlos", lista.getElementoPosicaoEspecifica(2));
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaNegativa() {
		lista.adicionarElementoNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicaoEspecifica("Fernando", -1));
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaQuantidadeElementos() {
		lista.adicionarElementoNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicaoEspecifica("Fernando", 2));
	}
	
	@Test
	void testAdicionarNaPosicaoValida() {
		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");

		lista.adicionarNaPosicaoEspecifica("Rose", 1);
		
		assertEquals("Fernando", lista.getElementoPosicaoEspecifica(0));
		assertEquals("Rose", lista.getElementoPosicaoEspecifica(1));
		assertEquals("Maria", lista.getElementoPosicaoEspecifica(2));
		assertEquals("Carlos", lista.getElementoPosicaoEspecifica(3));
		
	}
	
	@Test
	void testContemListaVazia() {
		assertFalse(lista.contem("Mauro"));
	}
	
	@Test
	void testContemNaoAcharLista() {
		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");
		
		assertFalse(lista.contem("Mauro"));
	}
	
	@Test
	void testContemAcharLista() {
		lista.adicionarElementoNoFinal("Fernando");
		lista.adicionarElementoNoFinal("Maria");
		lista.adicionarElementoNoFinal("Carlos");
		
		assertTrue(lista.contem("Maria"));
	}
	
	/* REMOVER INICIO */
	
	@Test
	void testRemoverCelulaInicialListaVazia() {
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaInicial());
		assertEquals(0, lista.getTotalCelulas());
		assertThrows(IllegalArgumentException.class, () -> lista.getPrimeiraCelula());
		assertThrows(IllegalArgumentException.class, () -> lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverCelulaInicialListaUmElemento() {
		lista.adicionarElementoNoInicio("Gabriel");
		assertEquals(1, lista.getTotalCelulas());
		
		lista.removerCelulaInicial();
		assertEquals(0, lista.getTotalCelulas());
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaInicial());
		assertThrows(IllegalArgumentException.class, () -> lista.getPrimeiraCelula());
		assertThrows(IllegalArgumentException.class, () -> lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverCelulaInicialListaVariosElementos() {
		lista.adicionarElementoNoInicio("Gabriel");
		lista.adicionarElementoNoInicio("Matheus");
		lista.adicionarElementoNoInicio("Paulo");
		assertEquals(3, lista.getTotalCelulas());
		
		lista.removerCelulaInicial();
		assertEquals(2, lista.getTotalCelulas());
		assertEquals("Matheus", lista.getElementoPosicaoEspecifica(0));
		assertEquals("Matheus", lista.getPrimeiraCelula());
		assertEquals("Gabriel", lista.getUltimaCelula());
	}
	
	/* REMOVER FIM */
	
	@Test
	void testRemoverCelulaFinallListaVazia() {
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaFinal());
		assertEquals(0, lista.getTotalCelulas());
		assertThrows(IllegalArgumentException.class, () -> lista.getPrimeiraCelula());
		assertThrows(IllegalArgumentException.class, () -> lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverCelulaFinalListaUmElemento() {
		lista.adicionarElementoNoFinal("Gabriel");
		assertEquals(1, lista.getTotalCelulas());
		
		lista.removerCelulaFinal();
		assertEquals(0, lista.getTotalCelulas());
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaFinal());
		assertThrows(IllegalArgumentException.class, () -> lista.getPrimeiraCelula());
		assertThrows(IllegalArgumentException.class, () -> lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverCelulaFinalListaVariosElementos() {
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		assertEquals(3, lista.getTotalCelulas());
		
		lista.removerCelulaFinal();
		assertEquals(2, lista.getTotalCelulas());
		assertEquals("Matheus", lista.getElementoPosicaoEspecifica(1));
		assertEquals("Gabriel", lista.getPrimeiraCelula());
		assertEquals("Matheus", lista.getUltimaCelula());
	}
	
	/* REMOVER NA POSICAO X */
	
	@Test
	void testRemoverCelulaXlListaVazia() {
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(0));
		assertEquals(0, lista.getTotalCelulas());
		assertThrows(IllegalArgumentException.class, () -> lista.getPrimeiraCelula());
		assertThrows(IllegalArgumentException.class, () -> lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverCelulaXListaUmElemento() {
		lista.adicionarElementoNoFinal("Gabriel");
		assertEquals(1, lista.getTotalCelulas());
		
		lista.removerCelulaPosicaoEspecifica(0);
		assertEquals(0, lista.getTotalCelulas());
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(0));
		assertThrows(IllegalArgumentException.class, () -> lista.getPrimeiraCelula());
		assertThrows(IllegalArgumentException.class, () -> lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverCelulaXListaVariosElementos() {
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		assertEquals(3, lista.getTotalCelulas());
		
		lista.removerCelulaPosicaoEspecifica(1);
		assertEquals(2, lista.getTotalCelulas());
		assertEquals("Paulo", lista.getElementoPosicaoEspecifica(1));
		assertEquals("Gabriel", lista.getPrimeiraCelula());
		assertEquals("Paulo", lista.getUltimaCelula());
	}
	
	@Test
	void testRemoverNegativa() {
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(-2));
	}
	
	@Test
	void testRemoverPosicaoSuperiorAoTotal() {
		lista.adicionarElementoNoFinal("Gabriel");
		lista.adicionarElementoNoFinal("Matheus");
		lista.adicionarElementoNoFinal("Paulo");
		
		assertThrows(IllegalArgumentException.class, () -> lista.removerCelulaPosicaoEspecifica(5));
	}
}