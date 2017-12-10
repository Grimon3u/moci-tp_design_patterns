package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iterateur.*;
import operation.Addition;
import patron.*;
import valeur.*;

class InfixeIteratorTest {
	
	private Constante opGauche;
	private Variable opDroite;
	private Expression expr;
	private Contexte cont;
	private ExpressionIterator iter;

	@BeforeEach
	public void setUp() throws Exception {
		this.opGauche = new Constante(2);
		this.opDroite = new Variable("a");
		this.expr = new Addition(this.opGauche, this.opDroite);
		this.cont = new Contexte();
		this.cont.add("a", 5);
		this.iter = this.expr.getInfixeIterator();
	}

	@Test
	public void test1_hasNext_true() {
		assertTrue(this.iter.hasNext());
	}

	@Test
	public void test2_hasNext_false() {
		for (int i = 0 ; i<3 ; i++) {
			this.iter.next();
		}
		assertFalse(this.iter.hasNext());
	}

	@Test
	public void test3_next() {
		assertEquals(this.opGauche, this.iter.next());
		assertEquals(this.expr, this.iter.next());
		assertEquals(this.opDroite, this.iter.next());
	}

	@Test
	public void test4_next_exception() {
		while(this.iter.hasNext()) {
			this.iter.next();
		}
		assertThrows(NoSuchElementException.class, ()->{this.iter.next();});
	}

}