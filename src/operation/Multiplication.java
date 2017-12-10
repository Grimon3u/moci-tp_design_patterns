package operation;

import patron.Contexte;
import patron.Expression;
import visiteur.ExpressionVisitor;

public class Multiplication extends OperationBinaire {

	public Multiplication(Expression eGauche, Expression eDroite) {
		super(eGauche, eDroite);
	}
	
	@Override
	public int evaluate(Contexte tds) {
		return this.filsGauche.evaluate(tds) * this.filsDroit.evaluate(tds);
	}

	@Override
	public String toString() {
		return "(" + this.filsGauche.toString() + " * " + filsDroit.toString() + ")";
	}

	@Override
	public Object accept(ExpressionVisitor ev) {
		return ev.visit(this);
	}

}