package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operation.*;
import valeur.*;
import visiteur.StringInfixeVisitor;

class StringInfixeVisitorTest {
	
	private StringInfixeVisitor sInfV;
	private Constante opGauche;
	private Variable opDroite;

	@BeforeEach
	void setUp() throws Exception {
		this.sInfV = new StringInfixeVisitor();
		this.opGauche = new Constante(4);
		this.opDroite = new Variable("a");
	}

	@Test
	public void test1_visit_constante() {
		assertEquals("4", (String)sInfV.visit(this.opGauche));
	}

	@Test
	public void test2_visit_variable() {
		assertEquals("a", (String)sInfV.visit(this.opDroite));
	}

	@Test
	public void test3_visit_addition() {
		assertEquals("4\n(4 + a)\na", (String)sInfV.visit(new Addition(this.opGauche, this.opDroite)));
	}

	@Test
	public void test4_visit_soustraction() {
		assertEquals("4\n(4 - a)\na", (String)sInfV.visit(new Soustraction(this.opGauche, this.opDroite)));
	}

	@Test
	public void test5_visit_multiplication() {
		assertEquals("4\n(4 * a)\na", (String)sInfV.visit(new Multiplication(this.opGauche, this.opDroite)));
	}

	@Test
	public void test6_visit_division() {
		assertEquals("4\n(4 / a)\na", (String)sInfV.visit(new Division(this.opGauche, this.opDroite)));
	}

}