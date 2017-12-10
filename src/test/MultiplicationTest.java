package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operation.Multiplication;
import patron.Contexte;
import valeur.*;
import visiteur.*;

class MultiplicationTest {
	
	private Constante opGauche;
	private Variable opDroite;
	private Multiplication mult;
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.opGauche = new Constante(2);
		this.opDroite = new Variable("a");
		this.mult = new Multiplication(this.opGauche, this.opDroite);
		this.tds = new Contexte();
		this.tds.add("a", 5);
	}
	
	@Test
	public void test1_evaluate() {
		assertEquals(10, this.mult.evaluate(this.tds));
	}
	
	@Test
	public void test2_toString() {
		assertEquals("(2 * a)", this.mult.toString());
	}
	
	@Test
	public void test3_accept_EvaluateVisitor() {
		assertEquals(10, this.mult.accept(new EvaluateVisitor(this.tds)));		
	}
	
	@Test
	public void test4_accept_StringPrefixeVisitor() {
		assertEquals("(2 * a)\n2\na", this.mult.accept(new StringPrefixeVisitor()));
	}
	
	@Test
	public void test5_accept_StringInfixeVisitor() {
		assertEquals("2\n(2 * a)\na", this.mult.accept(new StringInfixeVisitor()));
	}
	
	@Test
	public void test6_accept_StringPostfixeVisitor() {
		assertEquals("2\na\n(2 * a)", this.mult.accept(new StringPostfixeVisitor()));
	}

}