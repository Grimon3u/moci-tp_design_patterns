package patron;

import iterateur.ExpressionIterator;
import visiteur.*;

public interface Expression {
	
	// �valuation de l'expression.
	public int evaluate(Contexte tds);
	
	// Parenth�sage de l'expression.
	public String toString();
	
	// Visiteur
	public Object accept(ExpressionVisitor ev);
	
	// R�cup�ration des expressions filles.
	public Expression getLeftSon();
	public Expression getRightSon();
	
	// R�cup�ration des it�rateurs
	public ExpressionIterator getPrefixeIterator();
	public ExpressionIterator getInfixeIterator();
	public ExpressionIterator getPostfixeIterator();

}