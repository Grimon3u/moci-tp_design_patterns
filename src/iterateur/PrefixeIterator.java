package iterateur;

import java.util.NoSuchElementException;

import operation.OperationBinaire;
import patron.Expression;
import valeur.Valeur;

public class PrefixeIterator extends ExpressionIterator {

	public PrefixeIterator(OperationBinaire op) {
		super(op);
		this.parcoursFilsGauche = this.expr.getLeftSon().getPrefixeIterator();
		this.parcoursFilsDroit = this.expr.getRightSon().getPrefixeIterator();
	}

	public PrefixeIterator(Valeur val) {
		super(val);
	}

	@Override
	public boolean hasNext() {
		if (this.parcoursFilsGauche == null) {
			return !this.noeudCourantRenvoye;
		}
		else {
			return this.parcoursFilsDroit.hasNext();
		}
	}

	@Override
	public Expression next() throws NoSuchElementException {
		if (this.hasNext()) {
			if (!noeudCourantRenvoye) {
				this.noeudCourantRenvoye = true; 
				return this.expr;
			}
			if (this.parcoursFilsGauche.hasNext()) return this.parcoursFilsGauche.next();
			return this.parcoursFilsDroit.next();
		}
		throw new NoSuchElementException();
	}

}