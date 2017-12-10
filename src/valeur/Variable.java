package valeur;

import patron.Contexte;
import visiteur.ExpressionVisitor;

public class Variable extends Valeur {

	private String nom;

	public Variable(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}

	
	@Override
	public int evaluate(Contexte tds) {
		return tds.getTds().get(this.nom);
	}

	@Override
	public String toString() {
		return this.nom;
	}	 

	@Override
	public Object accept(ExpressionVisitor ev) {
		return ev.visit(this);
	}
	
}