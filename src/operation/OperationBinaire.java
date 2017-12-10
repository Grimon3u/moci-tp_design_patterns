package operation;

import iterateur.*;
import patron.*;

public abstract class OperationBinaire implements Expression {

	protected Expression filsGauche, filsDroit;

	public OperationBinaire(Expression g, Expression d) {
		this.filsGauche = g;
		this.filsDroit = d;
	}

	public Expression getLeftSon() {
		return this.filsGauche;
	}

	public Expression getRightSon() {
		return this.filsDroit;
	}

	@Override
	public ExpressionIterator getPrefixeIterator() {
		return new PrefixeIterator(this);
	}

	@Override
	public ExpressionIterator getInfixeIterator() {
		return new InfixeIterator(this);
	}

	@Override
	public ExpressionIterator getPostfixeIterator() {
		return new PostfixeIterator(this);
	}
}
