package iterateur;

import java.util.NoSuchElementException;

import operation.OperationBinaire;
import patron.Expression;
import valeur.Valeur;

public class PostfixeIterator extends ExpressionIterator {

	public PostfixeIterator(OperationBinaire op) {
		super(op);
		this.parcoursFilsGauche = this.expr.getLeftSon().getPostfixeIterator();
		this.parcoursFilsDroit = this.expr.getRightSon().getPostfixeIterator();
	}

	public PostfixeIterator(Valeur val) {
		super(val);
	}

	@Override
	public boolean hasNext() {
		return !this.noeudCourantRenvoye;
	}

	@Override
	public Expression next() throws NoSuchElementException {
		if (this.hasNext()) {
			if (this.parcoursFilsGauche != null) {
				if (this.parcoursFilsGauche.hasNext()) return this.parcoursFilsGauche.next();
				if (this.parcoursFilsDroit.hasNext()) return this.parcoursFilsDroit.next();
			}
			this.noeudCourantRenvoye = true; 
			return this.expr;
		}
		throw new NoSuchElementException();
	}

}