package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operation.Soustraction;
import patron.Contexte;
import valeur.*;
import visiteur.*;

class SoustractionTest {
	
	private Constante opGauche;
	private Variable opDroite;
	private Soustraction sou;
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.opGauche = new Constante(2);
		this.opDroite = new Variable("a");
		this.sou = new Soustraction(this.opGauche, this.opDroite);
		this.tds = new Contexte();
		this.tds.add("a", 5);
	}
	
	@Test
	public void test1_evaluate() {
		assertEquals(-3, this.sou.evaluate(this.tds));
	}
	
	@Test
	public void test2_toString() {
		assertEquals("(2 - a)", this.sou.toString());
	}
	
	@Test
	public void test3_accept_EvaluateVisitor() {
		assertEquals(-3, this.sou.accept(new EvaluateVisitor(this.tds)));		
	}
	
	@Test
	public void test4_accept_StringPrefixeVisitor() {
		assertEquals("(2 - a)\n2\na", this.sou.accept(new StringPrefixeVisitor()));
	}
	
	@Test
	public void test5_accept_StringInfixeVisitor() {
		assertEquals("2\n(2 - a)\na", this.sou.accept(new StringInfixeVisitor()));
	}
	
	@Test
	public void test6_accept_StringPostfixeVisitor() {
		assertEquals("2\na\n(2 - a)", this.sou.accept(new StringPostfixeVisitor()));
	}

}