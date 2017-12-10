package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import patron.Contexte;
import valeur.Constante;
import visiteur.*;

class ConstanteTest {
	private Constante c;
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.c = new Constante(2);
		this.tds = new Contexte();
	}
	
	@Test
	public void test1_evaluate() {
		assertEquals(2, this.c.evaluate(this.tds));
	}
	
	@Test
	public void test2_toString() {
		assertEquals("2", this.c.toString());
	}
	
	@Test
	public void test3_accept_EvaluateVisitor() {
		assertEquals(2, this.c.accept(new EvaluateVisitor(this.tds)));		
	}
	
	@Test
	public void test4_accept_StringPrefixeVisitor() {
		assertEquals("2", this.c.accept(new StringPrefixeVisitor()));
	}
	
	@Test
	public void test5_accept_StringInfixeVisitor() {
		assertEquals("2", this.c.accept(new StringInfixeVisitor()));
	}
	
	@Test
	public void test6_accept_StringPostfixeVisitor() {
		assertEquals("2", this.c.accept(new StringPostfixeVisitor()));
	}

}