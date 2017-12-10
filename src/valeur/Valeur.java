package valeur;

import iterateur.*;
import patron.*;

public abstract class Valeur implements Expression {

	@Override	
	public Expression getLeftSon() {
		return null;
	}

	@Override
	public Expression getRightSon() {
		return null;
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
