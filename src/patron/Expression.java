package patron;

import iterateur.ExpressionIterator;
import visiteur.*;

public interface Expression {
	
	// Évaluation de l'expression.
	public int evaluate(Contexte tds);
	
	// Parenthèsage de l'expression.
	public String toString();
	
	// Visiteur
	public Object accept(ExpressionVisitor ev);
	
	// Récupération des expressions filles.
	public Expression getLeftSon();
	public Expression getRightSon();
	
	// Récupération des itérateurs
	public ExpressionIterator getPrefixeIterator();
	public ExpressionIterator getInfixeIterator();
	public ExpressionIterator getPostfixeIterator();

}