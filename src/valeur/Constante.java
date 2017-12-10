package valeur;

import patron.Contexte;
import visiteur.ExpressionVisitor;

public class Constante extends Valeur {
	
	private int valeur;
	
	public Constante(int val) {
		this.valeur = val;
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	@Override
	public int evaluate(Contexte tds) {
		return this.valeur;
	}
	
	public String toString() {
		return "" + this.valeur;
	}
	
	
	@Override
	public Object accept(ExpressionVisitor ev) {
		return ev.visit(this);
	}

}