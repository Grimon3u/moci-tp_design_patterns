package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operation.Division;
import patron.Contexte;
import valeur.*;
import visiteur.*;

class DivisionTest {
	
	private Constante opGauche;
	private Variable opDroite;
	private Division div;
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.opGauche = new Constante(4);
		this.opDroite = new Variable("a");
		this.div = new Division(this.opGauche, this.opDroite);
		this.tds = new Contexte();
		this.tds.add("a", 2);
	}
	
	@Test
	public void test1_evaluate() {
		assertEquals(2, this.div.evaluate(this.tds));
	}
	
	@Test
	public void test2_evaluate_division_par_zero() {
		this.tds.add("a", 0);
		assertThrows(ArithmeticException.class, ()->{this.div.evaluate(this.tds);});
	}
	
	@Test
	public void test3_toString() {
		assertEquals("(4 / a)", this.div.toString());
	}
	
	@Test
	public void test4_accept_EvaluateVisitor() {
		assertEquals(2, this.div.accept(new EvaluateVisitor(this.tds)));		
	}
	
	@Test
	public void test5_accept_EvaluateVisitor_division_par_zero() {
		this.tds.add("a", 0);
		assertThrows(ArithmeticException.class, ()->{this.div.accept(new EvaluateVisitor(this.tds));});
	}
	
	@Test
	public void test6_accept_StringPrefixeVisitor() {
		assertEquals("(4 / a)\n4\na", this.div.accept(new StringPrefixeVisitor()));
	}
	
	@Test
	public void test7_accept_StringInfixeVisitor() {
		assertEquals("4\n(4 / a)\na", this.div.accept(new StringInfixeVisitor()));
	}
	
	@Test
	public void test8_accept_StringPostfixeVisitor() {
		assertEquals("4\na\n(4 / a)", this.div.accept(new StringPostfixeVisitor()));
	}

}
