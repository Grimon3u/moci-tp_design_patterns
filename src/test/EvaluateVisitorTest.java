package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operation.*;
import patron.Contexte;
import valeur.*;
import visiteur.EvaluateVisitor;

class EvaluateVisitorTest {
	
	private EvaluateVisitor evalV;
	private Constante opGauche;
	private Variable opDroite;
	
	@BeforeEach
	void setUp() throws Exception {
		this.opGauche = new Constante(4);
		this.opDroite = new Variable("a");
		Contexte tds = new Contexte();
		tds.add("a", 2);
		this.evalV = new EvaluateVisitor(tds);
	}

	@Test
	public void test1_visit_constante() {
		assertEquals(4, (int)evalV.visit(this.opGauche));
	}

	@Test
	public void test2_visit_variable() {
		assertEquals(2, (int)evalV.visit(this.opDroite));
	}

	@Test
	public void test3_visit_addition() {
		assertEquals(6, (int)evalV.visit(new Addition(this.opGauche, this.opDroite)));
	}

	@Test
	public void test4_visit_soustraction() {
		assertEquals(2, (int)evalV.visit(new Soustraction(this.opGauche, this.opDroite)));
	}

	@Test
	public void test5_visit_multiplication() {
		assertEquals(8, (int)evalV.visit(new Multiplication(this.opGauche, this.opDroite)));
	}

	@Test
	public void test6_visit_division() {
		assertEquals(2, (int)evalV.visit(new Division(this.opGauche, this.opDroite)));
	}

	@Test
	public void test7_visit_division_par_zero() {
		assertThrows(ArithmeticException.class, ()->{evalV.visit(new Division(this.opGauche, new Constante(0)));});
	}

}
