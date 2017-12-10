package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import patron.Contexte;
import valeur.Variable;
import visiteur.*;

class VariableTest {
	private Variable var;
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.var = new Variable("a");
		this.tds = new Contexte();
		this.tds.add("a", 5);
	}
	
	@Test
	public void test1_evaluate() {
		assertEquals(5, this.var.evaluate(this.tds));
	}
	
	@Test
	public void test2_toString() {
		assertEquals("a", this.var.toString());
	}
	
	@Test
	public void test3_accept_EvaluateVisitor() {
		assertEquals(5, this.var.accept(new EvaluateVisitor(this.tds)));		
	}
	
	@Test
	public void test4_accept_StringPrefixeVisitor() {
		assertEquals("a", this.var.accept(new StringPrefixeVisitor()));
	}
	
	@Test
	public void test5_accept_StringInfixeVisitor() {
		assertEquals("a", this.var.accept(new StringInfixeVisitor()));
	}
	
	@Test
	public void test6_accept_StringPostfixeVisitor() {
		assertEquals("a", this.var.accept(new StringPostfixeVisitor()));
	}

}
