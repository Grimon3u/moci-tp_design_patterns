package iterateur;

import java.util.Iterator;
import java.util.NoSuchElementException;

import operation.OperationBinaire;
import patron.Expression;
import valeur.Valeur;

public abstract class ExpressionIterator implements Iterator<Expression> {
	
	protected Expression expr;
	protected ExpressionIterator parcoursFilsGauche, parcoursFilsDroit;
	protected boolean noeudCourantRenvoye = false;
	
	public ExpressionIterator(OperationBinaire op) {
		this.expr = op;
	}

	public ExpressionIterator(Valeur val) {
		this.expr = val;
	}
	
	public abstract boolean hasNext();	
	public abstract Expression next() throws NoSuchElementException;
}