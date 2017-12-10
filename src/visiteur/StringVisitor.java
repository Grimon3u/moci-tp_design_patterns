package visiteur;

import iterateur.ExpressionIterator;
import operation.*;
import patron.Expression;
import valeur.*;

public abstract class StringVisitor implements ExpressionVisitor{

	protected ExpressionIterator iterator;

	@Override
	public String visit(Constante c) {
		return visit(c, "" + c.getValeur());
	}

	@Override
	public String visit(Variable var) {
		return visit(var, var.getNom());
	}

	@Override
	public String visit(Addition add) {
		return visit(add, "(" + add.getLeftSon().accept(this) + " + " + add.getRightSon().accept(this) + ")");
	}

	@Override
	public String visit(Soustraction sou) {
		return visit(sou, "(" + sou.getLeftSon().accept(this) + " - " + sou.getRightSon().accept(this) + ")");
	}

	@Override
	public String visit(Multiplication mult) {
		return visit(mult, "(" + mult.getLeftSon().accept(this) + " * " + mult.getRightSon().accept(this) + ")");
	}

	@Override
	public String visit(Division div) {
		return visit(div, "(" + div.getLeftSon().accept(this) + " / " + div.getRightSon().accept(this) + ")");
	}

	protected abstract String visit(Expression expr, String concat);
	
}