package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operation.Addition;
import patron.Contexte;
import valeur.*;
import visiteur.*;

class AdditionTest {
	
	private Constante opGauche;
	private Variable opDroite;
	private Addition add;
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.opGauche = new Constante(2);
		this.opDroite = new Variable("a");
		this.add = new Addition(this.opGauche, this.opDroite);
		this.tds = new Contexte();
		this.tds.add("a", 5);
	}
	
	@Test
	public void test1_evaluate() {
		assertEquals(7, this.add.evaluate(this.tds));
	}
	
	@Test
	public void test2_toString() {
		assertEquals("(2 + a)", this.add.toString());
	}
	
	@Test
	public void test3_accept_EvaluateVisitor() {
		assertEquals(7, this.add.accept(new EvaluateVisitor(this.tds)));		
	}
	
	@Test
	public void test4_accept_StringPrefixeVisitor() {
		assertEquals("(2 + a)\n2\na", this.add.accept(new StringPrefixeVisitor()));
	}
	
	@Test
	public void test5_accept_StringInfixeVisitor() {
		assertEquals("2\n(2 + a)\na", this.add.accept(new StringInfixeVisitor()));
	}
	
	@Test
	public void test6_accept_StringPostfixeVisitor() {
		assertEquals("2\na\n(2 + a)", this.add.accept(new StringPostfixeVisitor()));
	}

}
