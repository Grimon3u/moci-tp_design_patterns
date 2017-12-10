package iterateur;

import java.util.NoSuchElementException;

import operation.OperationBinaire;
import patron.Expression;
import valeur.Valeur;

public class InfixeIterator extends ExpressionIterator {

	/**
	 * Constructeur d'un itérateur infixé pour une opération binaire.
	 * @param op
	 * 		L'opération binaire à itérer.
	 */
	public InfixeIterator(OperationBinaire op) {
		super(op);
		this.parcoursFilsGauche = this.expr.getLeftSon().getInfixeIterator();
		this.parcoursFilsDroit = this.expr.getRightSon().getInfixeIterator();
	}
	
	/**
	 * Constructeur d'un itérateur infixé pour une variable ou une constante.
	 * @param op
	 * 		La variable ou constante à itérer.
	 */
	public InfixeIterator(Valeur val) {
		super(val);
	}

	@Override
	public boolean hasNext() {
		if (this.parcoursFilsGauche == null) return !this.noeudCourantRenvoye;
		return this.parcoursFilsDroit.hasNext();
	}

	@Override
	public Expression next() throws NoSuchElementException {
		if (this.hasNext()) {
			if (this.parcoursFilsGauche != null && this.parcoursFilsGauche.hasNext()) return this.parcoursFilsGauche.next();
			if (!noeudCourantRenvoye) {
				this.noeudCourantRenvoye = true; 
				return this.expr;
			}
			return this.parcoursFilsDroit.next();
		}
		throw new NoSuchElementException();
	}

}