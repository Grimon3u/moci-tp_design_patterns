package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import patron.Contexte;

class ContexteTest {
	
	private Contexte tds;

	@BeforeEach
	void setUp() throws Exception {
		this.tds = new Contexte();
		this.tds.add("a", 5);
	}

	@Test
	void test1_add_nouvelle_variable() {
		assertEquals(5, (int)this.tds.getTds().get("a"));
	}

	@Test
	void test2_add_nouvelle_valeur() {
		this.tds.add("a", 18);
		assertEquals(18, (int)this.tds.getTds().get("a"));
	}

}