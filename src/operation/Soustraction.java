package operation;

import patron.*;
import visiteur.ExpressionVisitor;

public class Soustraction extends OperationBinaire {

	public Soustraction(Expression eGauche, Expression eDroite) {
		super(eGauche, eDroite);
	}
	
	@Override
	public int evaluate(Contexte tds) {
		return this.filsGauche.evaluate(tds) - this.filsDroit.evaluate(tds);
	}

	public String toString() {
		return "(" + this.filsGauche.toString() + " - " + filsDroit.toString() + ")";
	}
	

	@Override
	public Object accept(ExpressionVisitor ev) {
		return ev.visit(this);
	}

}
